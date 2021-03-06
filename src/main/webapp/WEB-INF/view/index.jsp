<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">


<meta name="viewport" content="width=device-width, initial-scale=1.0">

<meta name="google-signin-client_id"
	content="1009741184185-l3bbvlk84qcfjnf49j03mgi5tc3mq5gm.apps.googleusercontent.com">

<title>Survey Feedback</title>
<!-- Bootstrap core CSS -->
<link href="assets/css/bootstrap.css" rel="stylesheet">
<!--external css-->
<link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />

<!-- Custom styles for this template -->
<link href="assets/css/style.css" rel="stylesheet" />

<link href="assets/css/style-responsive.css" rel="stylesheet">

</head>

<body ng-app="myApp">
	<section id="container">
		<!--header start-->
		<header class="header black-bg">
			<div class="sidebar-toggle-box">
				<div class="fa fa-bars tooltips" data-placement="right"
					data-original-title="Toggle Navigation"></div>
			</div>
			<!--logo start-->
			<a href="index.jsp" class="logo"><b>Survey Feeedback</b></a>
			<!--logo end-->
		</header>
		

		<!--header end-->
		<!-- **********************************************************************************************************************************************************
     MAIN SIDEBAR MENU &   MAIN CONTENT
   *********************************************************************************************************************************************************** -->
		<div ng-view></div>
		<!--ngview -->


		<!-- **********************************************************************************************************************************************************
             FOOTER START
  *********************************************************************************************************************************************************** -->

		<div ng-include="'assets/contentView/footer.htm'"></div>
	</section>
	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-route.js"></script>
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/angular-ui-router/0.3.1/angular-ui-router.min.js"></script>
	<script type="text/javascript" src="assets/js/main.js"></script>
	<script type="text/javascript" src="assets/js/route.js"></script>
	<script type="text/javascript"
		src="assets/js/controllers/loginController.js"></script>
	<script type="text/javascript"
		src="assets/js/controllers/signupController.js"></script>



	<!-- js placed at the end of the document so the pages load faster -->
	<script src="assets/js/jquery-1.8.3.min.js"></script>
	<script src="assets/js/bootstrap.min.js"></script>
	<script class="include" type="text/javascript"
		src="assets/js/jquery.dcjqaccordion.2.7.js"></script>
	<!--BACKSTRETCH-->
	<script type="text/javascript"
		src="assets/js/jquery.backstretch.min.js"></script>
	<!--common script for all pages-->
	<script src="assets/js/common-scripts.js"></script>
	<script src="https://apis.google.com/js/platform.js" async defer></script>
	<script>
		$.backstretch("assets/img/login-images.jpg", {
			speed : 500
		});
	</script>

</body>
</html>