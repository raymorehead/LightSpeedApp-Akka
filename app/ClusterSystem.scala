package app

import akka.actor._
import akka.kernel.Bootable
import akka.cluster._
import akka.cluster.ClusterEvent._
import com.typesafe.config.ConfigFactory
import play.api.Logger
import play.api.Play.current
import play.api.libs.concurrent.Akka
import java.net.InetAddress

import com.amazonaws.services.opsworks.AWSOpsWorksClient
import com.amazonaws.services.opsworks.model.DescribeInstancesRequest
import com.amazonaws.services.opsworks.model.Instance
import scala.collection.immutable

object ClusterSystem extends Bootable {
  var actorSystem: ActorSystem = _
  var cluster: Cluster = _

  def start() = {
    val listener = actorSystem.actorOf(Props[ClusterListener], "cluster-listener")
    cluster.subscribe(listener, classOf[ClusterDomainEvent])
    Logger.info("Initialized ClusterSystem")
  }

  def stop() = {
    shutdown()
  }

  def startup(): Unit = {
    val stackId = System.getProperty("ops-stack-id")
    val selfHostName = InetAddress.getLocalHost.getHostName
    var conf =
      if (stackId eq null)
        ConfigFactory.load("application.conf")
      else {
        // running in EC2 with OpsWorks deployment
        val instances = opsInstances(stackId).sortBy(_.getHostname)
        val ips = instances.take(5).map {
          i ⇒
            if (i.getPrivateIp eq null) i.getHostname // not started, but should still be in the seed-nodes
            else i.getPrivateIp
        }
        instances.collectFirst {
          case i if (i.getPrivateIp ne null) && (i.getHostname == selfHostName) ⇒ i.getPrivateIp
        } match {
          case None ⇒
            throw new IllegalArgumentException(s"Couldn't find my own [${selfHostName}] private ip in list of instances [${instances}]")
          case Some(selfIp) ⇒
            val seedNodesStr = ips.map("akka.tcp://ClusterSystem@" + _ + ":2552").mkString("\"", "\",\"", "\"")
            //log.info(s"[${selfHostName}/${selfIp}] starting with OpsWorks seed-nodes=[${seedNodesStr}]")
            ConfigFactory.parseString( s"""
                      akka.remote.netty.tcp.hostname="${selfIp}"
                      akka.cluster.seed-nodes=[${seedNodesStr}]
                      """).withFallback(ConfigFactory.load)
        }
      }
    actorSystem = ActorSystem("Cluster", conf)
    cluster = Cluster(actorSystem)
  }

  def opsInstances(stackId: String): immutable.IndexedSeq[Instance] = {
    try {
      import scala.collection.JavaConverters._
      val client = new AWSOpsWorksClient
      val req = (new DescribeInstancesRequest).withStackId(stackId)
      val result = client.describeInstances(req)
      result.getInstances.asScala.toVector
    } catch {
      case e: Exception ⇒
        //log.warn("OpsWorks not available, due to: {}", e.getMessage)
        Vector.empty
    }
  }

  // shutdown the system
  def shutdown(): Unit = {
    if(actorSystem ne null){
      actorSystem.shutdown()
      actorSystem = null
    }
  }

}

class ClusterListener extends Actor {
  def receive = {
    case state: CurrentClusterState =>
    case MemberUp(member) =>
      Logger.info(s"Member is Up: ${member}")
    case UnreachableMember(member) =>
      Logger.warn(s"Member detected as unreachable: ${member}")
    case MemberRemoved(member, previousStatus) =>
      Logger.warn(s"Member is Removed: ${member.address} after ${previousStatus}")
    case _: ClusterDomainEvent => // ignore
  }
}
