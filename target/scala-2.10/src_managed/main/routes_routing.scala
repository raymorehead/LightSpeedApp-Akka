// @SOURCE:/home/bryan/Projects/LightSpeedApp-Akka/conf/routes
// @HASH:7731fefceb36b11682b8f272ccc5962ba56383b8
// @DATE:Mon Apr 14 17:43:27 EDT 2014


import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._


import Router.queryString

object Routes extends Router.Routes {

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_Application_index0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:7
private[this] lazy val controllers_Application_dashboard1 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("dashboard"))))
        

// @LINE:8
private[this] lazy val controllers_Application_javascriptRoutes2 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("javascriptRoutes"))))
        

// @LINE:9
private[this] lazy val controllers_Application_userGet3 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("userGet/"),DynamicPart("key", """[^/]+""",true))))
        

// @LINE:12
private[this] lazy val controllers_User_login4 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/login"))))
        

// @LINE:13
private[this] lazy val controllers_Database_create5 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("database"))))
        

// @LINE:16
private[this] lazy val controllers_Assets_at6 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """dashboard""","""controllers.Application.dashboard"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """javascriptRoutes""","""controllers.Application.javascriptRoutes"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """userGet/$key<[^/]+>""","""controllers.Application.userGet(key:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/login""","""controllers.User.login"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """database""","""controllers.Database.create"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Application_index0(params) => {
   call { 
        invokeHandler(controllers.Application.index, HandlerDef(this, "controllers.Application", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
   }
}
        

// @LINE:7
case controllers_Application_dashboard1(params) => {
   call { 
        invokeHandler(controllers.Application.dashboard, HandlerDef(this, "controllers.Application", "dashboard", Nil,"GET", """""", Routes.prefix + """dashboard"""))
   }
}
        

// @LINE:8
case controllers_Application_javascriptRoutes2(params) => {
   call { 
        invokeHandler(controllers.Application.javascriptRoutes, HandlerDef(this, "controllers.Application", "javascriptRoutes", Nil,"GET", """""", Routes.prefix + """javascriptRoutes"""))
   }
}
        

// @LINE:9
case controllers_Application_userGet3(params) => {
   call(params.fromPath[String]("key", None)) { (key) =>
        invokeHandler(controllers.Application.userGet(key), HandlerDef(this, "controllers.Application", "userGet", Seq(classOf[String]),"GET", """""", Routes.prefix + """userGet/$key<[^/]+>"""))
   }
}
        

// @LINE:12
case controllers_User_login4(params) => {
   call { 
        invokeHandler(controllers.User.login, HandlerDef(this, "controllers.User", "login", Nil,"POST", """ Database routes""", Routes.prefix + """user/login"""))
   }
}
        

// @LINE:13
case controllers_Database_create5(params) => {
   call { 
        invokeHandler(controllers.Database.create, HandlerDef(this, "controllers.Database", "create", Nil,"POST", """""", Routes.prefix + """database"""))
   }
}
        

// @LINE:16
case controllers_Assets_at6(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        
}

}
     