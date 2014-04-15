
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
object index extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(message:String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import controllers.routes.javascript._

def /*5.2*/title/*5.7*/:play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*5.11*/("""
    Light Speed
""")))};
Seq[Any](format.raw/*1.18*/("""
"""),format.raw/*4.1*/("""
"""),format.raw/*7.2*/("""

"""),_display_(Seq[Any](/*9.2*/main(title)/*9.13*/ {_display_(Seq[Any](format.raw/*9.15*/("""

<script type="text/javascript" src=""""),_display_(Seq[Any](/*11.38*/routes/*11.44*/.Application.javascriptRoutes)),format.raw/*11.73*/(""""></script>
       
        
        <fieldset>
        <div id="value" > </div>
            <input type='text' id='key'/>
          	<input type='button' value='Submit' id='submitBtn' />
        </fieldset>
        
         <script type="text/javascript" charset="utf-8">
    		var submit = function() """),format.raw/*21.31*/("""{"""),format.raw/*21.32*/("""
      				var key = $('#key').val();
      				jsRoutes.controllers.Application.userGet(key).ajax("""),format.raw/*23.62*/("""{"""),format.raw/*23.63*/("""
        				success: function(data) """),format.raw/*24.37*/("""{"""),format.raw/*24.38*/("""
          				$("#value").html(data);
        			"""),format.raw/*26.12*/("""}"""),format.raw/*26.13*/(""",
        			error: function() """),format.raw/*27.30*/("""{"""),format.raw/*27.31*/("""
          				$("#value").html("Error!")
        			"""),format.raw/*29.12*/("""}"""),format.raw/*29.13*/("""
      			"""),format.raw/*30.10*/("""}"""),format.raw/*30.11*/(""")
    		"""),format.raw/*31.7*/("""}"""),format.raw/*31.8*/(""";     
       
        $('#submitBtn').click(submit);
        </script>
   
    """)))})),format.raw/*36.6*/("""

    """))}
    }
    
    def render(message:String): play.api.templates.HtmlFormat.Appendable = apply(message)
    
    def f:((String) => play.api.templates.HtmlFormat.Appendable) = (message) => apply(message)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Apr 14 15:28:15 EDT 2014
                    SOURCE: /home/bryan/Projects/LightSpeedApp-Akka/app/views/index.scala.html
                    HASH: 815c7ec945fe66b1bb3030fa6a8a9d7068f8628a
                    MATRIX: 556->1|705->77|717->82|801->86|858->17|885->75|912->104|949->107|968->118|1007->120|1082->159|1097->165|1148->194|1480->498|1509->499|1636->598|1665->599|1730->636|1759->637|1837->687|1866->688|1925->719|1954->720|2035->773|2064->774|2102->784|2131->785|2166->793|2194->794|2306->875
                    LINES: 19->1|24->5|24->5|26->5|29->1|30->4|31->7|33->9|33->9|33->9|35->11|35->11|35->11|45->21|45->21|47->23|47->23|48->24|48->24|50->26|50->26|51->27|51->27|53->29|53->29|54->30|54->30|55->31|55->31|60->36
                    -- GENERATED --
                */
            