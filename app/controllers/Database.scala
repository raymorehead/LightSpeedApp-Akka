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
import play.api.data.Form

object Database extends Controller {

  val database = Form(
    "name" -> nonEmptyText
  )

  def create = Action(parse.json) { implicit request =>
    database.bindFromRequest.fold(
      errors => BadRequest("Error " + errors.toString()),
      name => {
        Ok("new database" + name);
      }
    )
  }

}
