
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
object dashboard extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.1*/("""<!doctype html>
<!--[if lt IE 7]>      <html data-ng-app='angular-client-side-auth' class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html data-ng-app='angular-client-side-auth' class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html data-ng-app='angular-client-side-auth' class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html data-ng-app='angular-client-side-auth' class="no-js"> <!--<![endif]-->
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>LightSpeed Dasboard</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">
    <!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
    <!-- build:css styles/vendor.css -->
    <!-- bower:css -->
    <link rel="stylesheet" href="../assets/bower_components/bootstrap/dist/css/bootstrap.min.css">
    <!-- endbower -->
    <!-- endbuild -->
    <!-- build:css(.tmp) styles/main.css -->
    <link rel="stylesheet" href="../assets/style/dashboard.css">
    <!-- endbuild -->

    <script src="../assets/bower_components/modernizr/modernizr.js"></script>

    <base href="/dashboard/"/>
</head>
<body data-ng-cloak data-ng-controller="AdminCtrl">
<!--[if lt IE 10]>
<p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
<![endif]-->


<div class="container-fluid">
    <!-- Header section -->
    <div class="header navbar navbar-fixed-top" data-ng-controller="NavCtrl">
        <ul class="nav nav-pills pull-right" data-access-level='accessLevels.admin'>
            <li>
                <a class="dropdown-toggle" data-toggle="dropdown" href="">
                    <span class="glyphicon glyphicon-user"></span> """),format.raw/*38.68*/("""{"""),format.raw/*38.69*/("""{"""),format.raw/*38.70*/(""" user.name """),format.raw/*38.81*/("""}"""),format.raw/*38.82*/("""}"""),format.raw/*38.83*/(""" <span class="caret"></span>
                </a>
                <ul class="dropdown-menu">
                    <li><a ui-sref="settings">Settings</a></li>
                    <li><a href="" data-ng-click="logout()">Logout</a></li>
                </ul>
            </li>
        </ul>
        <h3 class="text-muted">Dashboard</h3></h3>
    </div>

    <!-- Angular view section -->
    <div ui-view class="content"></div>

</div>


<!-- build:js javascripts/vendor.js -->
<!-- bower:js -->
<script src="../assets/bower_components/jquery/jquery.js"></script>
<!-- endbower -->
<!-- endbuild -->

<!-- Google Analytics: change UA-XXXXX-X to be your site's ID. -->
<script>
            (function(b,o,i,l,e,r)"""),format.raw/*63.35*/("""{"""),format.raw/*63.36*/("""b.GoogleAnalyticsObject=l;b[l]||(b[l]=
            function()"""),format.raw/*64.23*/("""{"""),format.raw/*64.24*/("""(b[l].q=b[l].q||[]).push(arguments)"""),format.raw/*64.59*/("""}"""),format.raw/*64.60*/(""");b[l].l=+new Date;
            e=o.createElement(i);r=o.getElementsByTagName(i)[0];
            e.src='//www.google-analytics.com/analytics.js';
            r.parentNode.insertBefore(e,r)"""),format.raw/*67.43*/("""}"""),format.raw/*67.44*/("""(window,document,'script','ga'));
            ga('create','UA-XXXXX-X');ga('send','pageview');
        </script>

<!-- build:js javascripts/application.js -->
<script src="../assets/bower_components/angular/angular.js"></script>
<script src="../assets/bower_components/angular-resource/angular-resource.min.js"></script>
<script src="../assets/bower_components/angular-cookies/angular-cookies.min.js"></script>
<script src="../assets/bower_components/angular-route/angular-route.min.js"></script>
<script src="../assets/bower_components/angular-ui-router/release/angular-ui-router.min.js"></script>
<script src="../assets/bower_components/underscore/underscore-min.js"></script>
<script src="../assets/javascripts/app.js"></script>
<script src="../assets/javascripts/controllers.js"></script>
<script src="../assets/javascripts/directives.js"></script>
<script src="../assets/javascripts/filters.js"></script>
<script src="../assets/javascripts/routingConfig.js"></script>
<script src="../assets/javascripts/services.js"></script>
<!-- endbuild -->

<!-- build:js javascripts/plugins.js -->
<script src="../assets/bower_components/bootstrap/js/affix.js"></script>
<script src="../assets/bower_components/bootstrap/js/alert.js"></script>
<script src="../assets/bower_components/bootstrap/js/dropdown.js"></script>
<script src="../assets/bower_components/bootstrap/js/tooltip.js"></script>
<script src="../assets/bower_components/bootstrap/js/modal.js"></script>
<script src="../assets/bower_components/bootstrap/js/transition.js"></script>
<script src="../assets/bower_components/bootstrap/js/button.js"></script>
<script src="../assets/bower_components/bootstrap/js/popover.js"></script>
<script src="../assets/bower_components/bootstrap/js/carousel.js"></script>
<script src="../assets/bower_components/bootstrap/js/scrollspy.js"></script>
<script src="../assets/bower_components/bootstrap/js/collapse.js"></script>
<script src="../assets/bower_components/bootstrap/js/tab.js"></script>
<!-- endbuild -->

</body>
</html>
"""))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Apr 14 17:35:37 EDT 2014
                    SOURCE: /home/bryan/Projects/LightSpeedApp-Akka/app/views/dashboard.scala.html
                    HASH: 3bdb8f6704f1c1cceecdeedc4bf28fa8881d38e8
                    MATRIX: 641->0|2518->1849|2547->1850|2576->1851|2615->1862|2644->1863|2673->1864|3408->2571|3437->2572|3526->2633|3555->2634|3618->2669|3647->2670|3863->2858|3892->2859
                    LINES: 22->1|59->38|59->38|59->38|59->38|59->38|59->38|84->63|84->63|85->64|85->64|85->64|85->64|88->67|88->67
                    -- GENERATED --
                */
            