
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
object main extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Html,Html,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(title: Html)(content: Html):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.30*/("""



<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="assets/img/favicon.png">
    <link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
    <title>"""),_display_(Seq[Any](/*15.13*/title)),format.raw/*15.18*/("""</title>

    <!-- Bootstrap core CSS --> 
    <link href="assets/style/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="assets/style/main.css" rel="stylesheet">

    <!-- Fonts from Google Fonts -->
	<link href='http://fonts.googleapis.com/css?family=Lato:300,400,900' rel='stylesheet' type='text/css'>
    
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
    <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src="assets/javascripts/bootstrap.min.js"></script>
  </head>

  <body>

    <!-- Fixed navbar -->
    <div class="navbar navbar-default navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#"><img src="assets/img/bolt2.png"  width="17" vertical-align="text-bottom" alt=""> <b>LIGHTSPEED</b></a>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
          	<li><a href="#app"><b>APP DASHBOARD</b></a>
            <li><a href="#about"><b>ABOUT</b></a></li>
            <li><a href="#team"><b>THE TEAM</b></a></li>
            <li><a href="http://www.github.com/corydobson/LightspeedApp"><b>SOURCE REPO</b></a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>

	<div id="headerwrap">
		<div class="container">
			<div class="row">
				<div class="col-lg-6">
					<h1>Welcome to LightSpeed.</h1>
						<h3>A distributed Key-Value Store powered by the Symas Lightning DB & Akka Clusters</h3>
					<h4>Get started using LightSpeed typing the command below.</h4>
		
					"""),_display_(Seq[Any](/*67.7*/content)),format.raw/*67.14*/("""
				<div class="col-lg-6">
					<img class="img-responsive" src="assets/img/computers.png" alt="">
				</div><!-- /col-lg-6 -->
				
			</div><!-- /row -->
		</div><!-- /container -->
	</div><!-- /headerwrap -->
	
	
	<div class="container" section id="about">
		<div class="row mt centered">
			<div class="col-lg-6 col-lg-offset-3">
				<h1>Your data.<br/> Lightning Fast.</h1>
				<h3>LightSpeed is a Key-Value Store, built with powerful tools to get your data moving fast.</h3>
			</div>
		</div><!-- /row -->
		
		<div class="row mt centered">
			<div class="col-lg-4">
				<a href = "http://symas.com/mdb/" target="_blank"><img src="assets/img/ser01.png" width="200" alt=""> </a>
				<h4>1 - Symas Lightning Database Layer</h4>
				<p>LightSpeed is powered by Symas Corp's <a href = "http://symas.com/mdb/" target="_blank">Lightning Memory Map Database</a>. This ultra-fast, ultra-compact key-value embedded data store <a href = "http://symas.com/mdb/microbench/" target="_blank">outperforms</a> other popular key value software solutions such as BerkeleyDB, Kyoto TreeDB, and even Google's LevelDB.  LightSpeed utilizes Lightning, and sets it up as a distributed database model - increasing performance and allowing for it to solve 'Big Data' problems.</p>
			</div><!--/col-lg-4 -->

			<div class="col-lg-4">
				<a href = "http://spray.io/" target="_blank"> <img src="assets/img/ser02.png"  width="120" alt=""></a>
				<h4>2 - Spray.io RESTful API Routing</h4>
				<p>The <a href = "http://spray.io/" target="_blank">Spray.io RESTful API</a> handles all of LightSpeed's HTTP services - allowing for it to run completely in browser over the web. This simple <a href= "http://codeplanet.io/principles-good-restful-api-design/" target="_blank">RESTful</a> HTTP service comes with a small, embedded and super-fast HTTP server called 'spray-can', which is fully asynchronous and can handle thousands of concurrent connections. This allows for LightSpeed to handle multiple users on any size device at once.</p>

			</div><!--/col-lg-4 -->

			<div class="col-lg-4">
				<a href = "http://akka.io/" target="_blank"> <img src="assets/img/ser03.png" width="86" alt=""></a>
				<h4>3 - Akka Actor System Cluters </h4>
				<p>Akka is a toolkit and runtime for building highly concurrent, distributed, and fault tolerant event-driven applications on the JVM. LightSpeed utilizes Akka by creating Akka 'Clusters' that are virtual CPU's that can communicate with each other using Actor messages. Each cluster runs its own copy of Lightning DB, and has its own subsection of data to manage. </p>
			</div><!--/col-lg-4 -->
		</div><!-- /row -->
	</div><!-- /container -->
	
	<div class="container">
		<hr>
		<hr>
	</div><!-- /container -->
	
	<div class="container">
		<div class="row mt centered">
			<div class="col-lg-6 col-lg-offset-3">
				<h1>LightSpeed in Action.</h1>
				<h3>See how LightSpeed distributes data over multiple clusters below.</h3>
			</div>
		</div><!-- /row -->
	
		<! -- CAROUSEL -->
		<div class="row mt centered">
			<div class="col-lg-6 col-lg-offset-3">
				<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
				  <!-- Indicators -->
				  <ol class="carousel-indicators">
				    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
				    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
				    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
				  </ol>
				  <!-- Wrapper for slides -->
				  <div class="carousel-inner">
				    <div class="item active">
				      <img src="assets/img/p01.png" alt="">
				    </div>
				    <div class="item">
				      <img src="assets/img/p02.png" alt="">
				    </div>
				    <div class="item">
				      <img src="assets/img/p03.png" alt="">
				    </div>
				  </div>
				</div>			
			</div><!-- /col-lg-8 -->
		</div><!-- /row -->
	</div><! --/container -->
	
	<div class="container">
		<hr>
		<hr>
	</div><!-- /container -->

	<div class="container" section id="team">
		<div class="row mt centered">
			<div class="col-lg-6 col-lg-offset-3">
				<h1>Our awesome team of <br/>Computer Science rockstars.</h1>
				<h3>We are a team of West Virginia University Computer Science majors with the best academic advisor around.</h3>
			</div>
		</div><!-- /row -->
		
		<div class="row mt centered">
			<div class="col-lg-4">
				<img class="img-circle" src="assets/img/cory.jpg" width="140" alt="">
				<h3>Cory Dobson</h3>
				<h4>Lead Engineer and Team Lead</h4>
				<p>Cory leads LightSpeed's core development and web integration, along with leading the team and creating the LightSpeed brand graphics and UI.</p>
				<p><a href="mailto:corydobson@me.com" target="_blank"><i class="glyphicon glyphicon-send"></a></i><a href="http://www.corydobson.com" target="_blank"><i class="glyphicon glyphicon-globe"></i></a></p>
			</div><!--/col-lg-4 -->

			<div class="col-lg-4">
				<img class="img-circle" src="assets/img/bryan.jpg" width="140" alt="">
				<h3>Bryan Turek</h3>
				<h4>Full Stack Engineer</h4>
				<p>Bryan focuses on getting LightSpeed onto the web, by integrating the user interface with the back-end cluster manager that controls all of LightSpeed's data.</p>
				<p><a href="mailto:bturek@mix.wvu.edu" target="_blank"><i class="glyphicon glyphicon-send"></a></i>
			</div><!--/col-lg-4 -->
			<div class="col-lg-4">
				<img class="img-circle" src="assets/img/joey.jpg" width="140" alt="">
				<h3>Joey Dicerchio</h3>
				<h4>Integration Testing</h4>
				<p>Joey leads LightSpeed's blackbox testing and QA, writing test cases and testing LightSpeed's core features on multiple machines.</p>
				<p><a href="mailto:jdicerch@mix.wvu.edu" target="_blank"><i class="glyphicon glyphicon-send"></a></i>
			</div>
			</div><!-- /row -->
			<div class="row mt centered">
			<div class="col-lg-4">
				<img class="img-circle" src="assets/img/casey.jpg" width="140" alt="">
				<h3>Casey Hancock</h3>
				<h4>Engineer</h4>
				<p>Casey tackles problems within LightSpeed's core, test suite, and web frameworks.</p>
				<p><a href="mailto:chancoc1@mix.wvu.edu" target="_blank"><i class="glyphicon glyphicon-send"></a></i>
			</div>
			<div class="col-lg-4">
				<img class="img-circle" src="assets/img/chelsea.jpg" width="140" alt="">
				<h3>Chelsea Skotnicki</h3>
				<h4>Testing and Documentation</h4>
				<p>Chelsea leads our project's documentation, along with working with Joey to test LightSpeed's features with unit and blackbox testing.</p>
				<p><a href="mailto:cskotnicki92@gmail.com" target="_blank"><i class="glyphicon glyphicon-send"></a></i>
			</div>
			<div class="col-lg-4">
				<img class="img-circle" src="assets/img/ray.jpg" width="140" alt="">
				<h3>Professor Ray Morehead</h3>
				<h4>Academic Advisor</h4>
				<p>Professor Morehead advises the team, along with teaching multiple classes that laid the groundwork for LightSpeed, including CS440: Database Design, & CS493: Java Concurrency. Without Morehead's classes, this project would not be possible.</p>
				<p><a href="mailto:ray.morehead@gmail.com" target="_blank"><i class="glyphicon glyphicon-send"></a></i><a href="http://www.statler.wvu.edu/faculty/faculty-detail.php?id=380&type=faculty" target="_blank"><i class="glyphicon glyphicon-globe"></i></a></p>
			</div><!--/col-lg-4 -->
		</div><!-- /row -->
	</div><!-- /container -->
	
		
	<div class="container">
		<hr>
		<hr>
		<p class="centered">Site by the LightSpeed Team - 2014</p>
	</div><!-- /container -->
	

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    
    
  </body>
</html>
"""))}
    }
    
    def render(title:Html,content:Html): play.api.templates.HtmlFormat.Appendable = apply(title)(content)
    
    def f:((Html) => (Html) => play.api.templates.HtmlFormat.Appendable) = (title) => (content) => apply(title)(content)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Apr 12 09:21:18 EDT 2014
                    SOURCE: /home/raymond/scala/LightSpeedApp-Akka/app/views/main.scala.html
                    HASH: 715c55261188dc49ac134c96c8d6a670621795a0
                    MATRIX: 558->1|680->29|1173->486|1200->491|3370->2626|3399->2633
                    LINES: 19->1|22->1|36->15|36->15|88->67|88->67
                    -- GENERATED --
                */
            