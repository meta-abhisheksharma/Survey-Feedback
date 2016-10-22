<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Survey Feedback</title>
        <!-- Bootstrap core CSS -->
        <link href="assets/css/bootstrap.css" rel="stylesheet">
        <!--external css-->
        <!-- <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet"/> -->
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" rel="stylesheet"/>

        <!-- Custom styles for this template -->
        <link href="assets/css/style.css" rel="stylesheet"/>
        <link href="assets/css/style-responsive.css" rel="stylesheet">
    </head>

    <!-- <body ng-app="myApp"> -->
    <body ng-app="app">
        <section id="container">
            <!-- <div ng-include="'assets/contentView/header.htm'">

						</div> -->
            <!--header start-->
            <header class="header black-bg">
                <div class="sidebar-toggle-box">
                    <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
                </div>
                <!--logo start-->
                <a href="index.jsp" class="logo">
                    <b>Survey Feeedback</b>
                </a>
                <!--logo end-->
                <!-- Logout Section start -->
                <div class="top-menu">
                    <ul class="nav pull-right top-menu">
                        <li>
                            <a class="logout" href="index.jsp">Logout</a>
                        </li>
                    </ul>
                </div>
                <!-- Logout Section ends -->
            </header>
            <!--header end-->

            <!-- **********************************************************************************************************************************************************
							MAIN SIDEBAR MENU
							*********************************************************************************************************************************************************** -->
            <!-- <div ng-include="'assets/contentView/dashboardView.htm'">
						</div> -->
            <aside>
                <div id="sidebar" class="nav-collapse ">
                    <!-- sidebar menu start-->
                    <ul class="sidebar-menu" id="nav-accordion">
                        <p class="centered">
                            <a href="dashboard.jsp"><img src="assets/img/ui-sam.jpg" class="img-circle" width="100" height="100"></a>
                        </p>
                        <h5 class="centered">Nikhil Srivastava</h5>
                        <li class="mt">
                            <a href="dashboard.jsp">
                                <i class="fa fa-dashboard"></i>
                                <span>Dashboard</span>
                            </a>
                        </li>
                        <li class="sub-menu">
                            <a href="javascript:;">
                                <i class="fa fa-desktop"></i>
                                <span>Surveys</span>
                            </a>
                            <ul class="sub">
                                <li>
                                    <a href="">Add Survey</a>
                                </li>
                                <li>
                                    <a href="">Edit Survey</a>
                                </li>
                                <li>
                                    <a href="">Survey List</a>
                                </li>
                            </ul>
                        </li>

                        <li class="sub-menu">
                            <a href="javascript:;">
                                <i class="fa fa-user"></i>
                                <span>Users</span>
                            </a>
                            <ul class="sub">
                                <li>
                                    <a href="">Add User</a>
                                </li>
                                <li>
                                    <a href="">User List</a>
                                </li>
                            </ul>
                        </li>
                        <li class="sub-menu">
                            <a href="javascript:;">
                                <i class="fa fa-bar-chart-o"></i>
                                <span>View Report</span>
                            </a>
                        </li>
                    </ul>
                    <!-- sidebar menu end-->
                </div>
            </aside>
            <!--sidebar end-->

            <!-- **********************************************************************************************************************************************************
							MAIN CONTENT
							*********************************************************************************************************************************************************** -->

            <!-- <div ng-view>
						</div> -->
            <!-- ngview -->
            <!--Admin's Dashboard view-->
<section id="main-content">
 <section class="wrapper mt">
   <h3 class="mt mb">
       <i class="fa fa-angle-right"></i>
      Dashboard
     </h3>
       <div class="mt mb">
         <div class="row mt">
           <a href="#">
             <div class="col-lg-4">
               <div id="totalSurveyPanel" class="panel panel-size">
                 <div class="panel-heading">
                   <div class="row">
                     <div class="col-xs-3">
                       <i class="fa fa-spinner fa-spin fa-5x fa-fw" aria-hidden="true"></i>
                     </div>
                     <div class="col-xs-9 text-right">
                       <div class="huge">26</div>
                       <div class="label-font">Total Surveys</div>
                     </div>
                   </div>
                 </div>
               </div>
             </div>
           </a>
           <a href="#">
             <div class="col-lg-4">
               <div id="membersPanel" class="panel panel-size">
                 <div class="panel-heading">
                   <div class="row">
                     <div class="col-xs-3">
                       <i class="fa fa-users fa-flip-horizontal fa-5x" aria-hidden="true"></i>
                     </div>
                     <div class="col-xs-9 text-right">
                       <div class="huge">27</div>
                       <div class="label-font">Total Surveyor</div>
                     </div>
                   </div>
                 </div>
               </div>
             </div>
           </a>
           <a href="#">
             <div class="col-lg-4">
               <div id="responderPanel" class="panel panel-size">
                 <div class="panel-heading">
                   <div class="row">
                     <div class="col-xs-3">
                       <i class="fa fa-user-plus fa-5x" aria-hidden="true"></i>
                     </div>
                     <div class="col-xs-9 text-right">
                       <div class="huge">74</div>
                       <div class="label-font">Total Responders</div>
                     </div>
                   </div>
                 </div>
               </div>
             </div>
           </a>
         </div>
         <!-- /.row -->
					<div class="row mt">
						<div class="col-lg-4 mb">
							<div class="pn grey-panel message-box ">
								<div class="grey-header">
									<h5>
										<i class="fa fa-pencil-square-o" /></i> Design your Survey
									</h5>
								</div>
								<div class="row">
									<div class="col-sm-6 col-xs-6 goleft">
										<p>
											 70%
										</p>
									</div>
								</div>
							</div>
							<!--/grey-panel -->
						</div>
						<div class="col-lg-4 mb">
							<div class="pn grey-panel message-box ">
								<div class="grey-header">
									<h5>
										<i class="fa fa-pencil-square-o" /></i> Design your Survey
									</h5>
								</div>
								<div class="row">
									<div class="col-sm-6 col-xs-6 goleft">
										<p class="label-font">
											 70%
										</p>
									</div>
								</div>
							</div>
							<!--/grey-panel -->
						</div>
						<div class="col-lg-4 mb">
							<div class=" pn grey-panel message-box ">
								<div class="grey-header">
									<h5>
										<i class="fa fa-pencil-square-o" /></i>Analyze your Survey
									</h5>
								</div>
								<div class="row">
									<div class="col-sm-12 col-xs-12 goleft">
										<p class="text-font">
											We help to gather and analyze the crucial facts and figures with a precision that no other can provide  
										</p>
									</div>
								</div>
							</div>
							<!--/grey-panel -->
						</div>
						
					</div>
					
					
				</div>
         
       </div><!-- mb mt -->
       
       
       
       
      
 </section>
</section>
            






            <!-- **********************************************************************************************************************************************************
												FOOTER START
							*********************************************************************************************************************************************************** -->
            <div ng-include="'assets/contentView/footer.htm'"></div>

        </section>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-route.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/angular-ui-router/0.3.1/angular-ui-router.min.js"></script>
        <script type="text/javascript" src="assets/js/main.js"></script>
        <script type="text/javascript" src="assets/js/route.js"></script>

        <!-- js placed at the end of the document so the pages load faster -->
        <script src="assets/js/jquery-1.8.3.min.js"></script>
        <script src="assets/js/bootstrap.min.js"></script>
        <script class="include" type="text/javascript" src="assets/js/jquery.dcjqaccordion.2.7.js"></script>
        <script src="assets/js/jquery.scrollTo.min.js"></script>
        <!--common script for all pages-->
        <script src="assets/js/common-scripts.js"></script>
        <!--Image croping Script-->
        <script src="https://cdn.rawgit.com/alexk111/ngImgCrop/master/compile/minified/ng-img-crop.js"></script>
        <script type="text/javascript" src="assets/js/controllers/profilePictureController.js"></script>
    </body>
</html>
