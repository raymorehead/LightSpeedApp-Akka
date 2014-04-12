package controllers

import scala.concurrent.duration._

import akka.actor.Actor
import akka.actor.Props
import akka.pattern._
import akka.util.Timeout
import play.api._
import play.api.Play.current
import play.api.data.Forms._
import play.api.libs.concurrent.Akka
import play.api.mvc._
import play.api.libs.concurrent.Execution.Implicits._

object Application extends Controller {
  
  val myActor = Akka.system.actorOf(Props[MyActor], name = "myactor")
  implicit val timeout = Timeout(5 seconds) 
  def index = Action {
    Ok( views.html.index("Message" ))
  }

  def userGet(key : String) = Action.async { 
    val result = "The answer is " + key
    val value = myActor ? Key(key)
    value.map(v =>   	Ok( views.html.ajax_result(v.toString)))
    
  }
   


  
      
  def javascriptRoutes = Action { implicit request ⇒
    import routes.javascript._
    Ok(
      Routes.javascriptRouter( "jsRoutes" )(
        routes.javascript.Application.userGet
      )
    ).as( "text/javascript" )
  }
}

case class Key(key : String)

class MyActor extends Actor {
  def receive = {
    case Key(key) => {
      Thread.sleep(1000)
      sender ! "Some value"
    }
  }
}
