
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import play.api.i18n._
import play.api.mvc._
import play.api.data._
import views.html._
/**/
object ajax_result extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(value: String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.17*/("""
"""),_display_(Seq[Any](/*2.2*/value)))}
    }
    
    def render(value:String): play.api.templates.HtmlFormat.Appendable = apply(value)
    
    def f:((String) => play.api.templates.HtmlFormat.Appendable) = (value) => apply(value)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Apr 14 15:28:15 EDT 2014
                    SOURCE: /home/bryan/Projects/LightSpeedApp-Akka/app/views/ajax_result.scala.html
                    HASH: cd96aa17c191573ed03da4f9b308d6e6bea90bce
                    MATRIX: 562->1|671->16|707->18
                    LINES: 19->1|22->1|23->2
                    -- GENERATED --
                */
            