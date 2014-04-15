package app

import akka.actor._
import akka.kernel.Bootable
import akka.cluster._
import akka.cluster.ClusterEvent._
import com.typesafe.config.ConfigFactory
import play.api.Logger
import play.api.Play.current
import play.api.libs.concurrent.Akka

object ClusterSystem extends Bootable {
  //val cfg = ConfigFactory.load("application.conf")
  val actorSystem = Akka.system
  val cluster = Cluster(actorSystem)

  def start() = {
    val listener = actorSystem.actorOf(Props[ClusterListener], "cluster-listener")
    cluster.subscribe(listener, classOf[ClusterDomainEvent])
    Logger.info("Initialized ClusterSystem")
  }

  def stop() = {
    actorSystem.shutdown()
  }

  def startup(){}
  def shutdown(){}

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
