// @SOURCE:/home/bryan/Projects/LightSpeedApp-Akka/conf/routes
// @HASH:7731fefceb36b11682b8f272ccc5962ba56383b8
// @DATE:Mon Apr 14 17:43:27 EDT 2014

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._


import Router.queryString


// @LINE:16
// @LINE:13
// @LINE:12
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers {

// @LINE:13
class ReverseDatabase {
    

// @LINE:13
def create(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "database")
}
                                                
    
}
                          

// @LINE:16
class ReverseAssets {
    

// @LINE:16
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          

// @LINE:12
class ReverseUser {
    

// @LINE:12
def login(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "user/login")
}
                                                
    
}
                          

// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {
    

// @LINE:7
def dashboard(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "dashboard")
}
                                                

// @LINE:9
def userGet(key:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "userGet/" + implicitly[PathBindable[String]].unbind("key", dynamicString(key)))
}
                                                

// @LINE:6
def index(): Call = {
   Call("GET", _prefix)
}
                                                

// @LINE:8
def javascriptRoutes(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "javascriptRoutes")
}
                                                
    
}
                          
}
                  


// @LINE:16
// @LINE:13
// @LINE:12
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.javascript {

// @LINE:13
class ReverseDatabase {
    

// @LINE:13
def create : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Database.create",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "database"})
      }
   """
)
                        
    
}
              

// @LINE:16
class ReverseAssets {
    

// @LINE:16
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              

// @LINE:12
class ReverseUser {
    

// @LINE:12
def login : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.User.login",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "user/login"})
      }
   """
)
                        
    
}
              

// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {
    

// @LINE:7
def dashboard : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.dashboard",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "dashboard"})
      }
   """
)
                        

// @LINE:9
def userGet : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.userGet",
   """
      function(key) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "userGet/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("key", encodeURIComponent(key))})
      }
   """
)
                        

// @LINE:6
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        

// @LINE:8
def javascriptRoutes : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.javascriptRoutes",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "javascriptRoutes"})
      }
   """
)
                        
    
}
              
}
        


// @LINE:16
// @LINE:13
// @LINE:12
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.ref {


// @LINE:13
class ReverseDatabase {
    

// @LINE:13
def create(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Database.create(), HandlerDef(this, "controllers.Database", "create", Seq(), "POST", """""", _prefix + """database""")
)
                      
    
}
                          

// @LINE:16
class ReverseAssets {
    

// @LINE:16
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          

// @LINE:12
class ReverseUser {
    

// @LINE:12
def login(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.User.login(), HandlerDef(this, "controllers.User", "login", Seq(), "POST", """ Database routes""", _prefix + """user/login""")
)
                      
    
}
                          

// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {
    

// @LINE:7
def dashboard(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.dashboard(), HandlerDef(this, "controllers.Application", "dashboard", Seq(), "GET", """""", _prefix + """dashboard""")
)
                      

// @LINE:9
def userGet(key:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.userGet(key), HandlerDef(this, "controllers.Application", "userGet", Seq(classOf[String]), "GET", """""", _prefix + """userGet/$key<[^/]+>""")
)
                      

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      

// @LINE:8
def javascriptRoutes(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.javascriptRoutes(), HandlerDef(this, "controllers.Application", "javascriptRoutes", Seq(), "GET", """""", _prefix + """javascriptRoutes""")
)
                      
    
}
                          
}
        
    