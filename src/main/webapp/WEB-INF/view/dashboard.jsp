<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>Survey Feedback </title>
      <!-- Bootstrap core CSS -->
    <link href="assets/css/bootstrap.css" rel="stylesheet">
    <!--external css-->
    <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />

    <!-- Custom styles for this template -->
    <link href="assets/css/style.css" rel="stylesheet" />
    <link href="assets/css/style-responsive.css" rel="stylesheet">
  </head>

<body ng-app="myApp">
<section id="container" >
   <!-- <div ng-include="'assets/contentView/header.htm'">

   </div> -->
   <!--header start-->
    <header class="header black-bg">
        <div class="sidebar-toggle-box">
          <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
        </div>
      <!--logo start-->
      <a href="index.jsp" class="logo"><b>Survey Feeedback</b></a>
      <!--logo end-->
      <!-- Logout Section start -->
            <div class="top-menu">
              <ul class="nav pull-right top-menu">
                    <li><a class="logout" href="index.jsp">Logout</a></li>
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
         <div id="sidebar"  class="nav-collapse ">
             <!-- sidebar menu start-->
             <ul class="sidebar-menu" id="nav-accordion">
                 <p class="centered"><a href="dashboard.jsp"><img src="assets/img/ui-sam.jpg" class="img-circle" width="100" height="100"></a></p>
                 <h5 class="centered">Nikhil Srivastava</h5>
                 <li class="mt">
                     <a href="dashboard.jsp">
                         <i class="fa fa-dashboard"></i>
                         <span>Dashboard</span>
                     </a>
                 </li>
                 <li class="sub-menu">
                     <a href="javascript:;" >
                         <i class="fa fa-desktop"></i>
                         <span>Surveys</span>
                     </a>
                     <ul class="sub">
                         <li><a  href="">Add Survey</a></li>
                         <li><a  href="">Edit Survey</a></li>
                         <li><a  href="">Survey List</a></li>
                     </ul>
                 </li>

                 <li class="sub-menu">
                     <a href="javascript:;" >
                         <i class="fa fa-user"></i>
                         <span>Users</span>
                     </a>
                     <ul class="sub">
                         <li><a  href="">Add User</a></li>
                         <li><a  href="">User List</a></li>
                     </ul>
                 </li>
                 <li class="sub-menu">
                     <a href="javascript:;" >
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
   <section id="main-content">
    <section class="wrapper">
      <h3><i class="fa fa-angle-right"></i> Add Survey</h3>
      <div class="row mt">
          		<div class="col-lg-11">
                  <div class="form-panel">
                  	  <h4 class="mb"><i class="fa fa-angle-right"></i> Survey details</h4>

                      <form class="form-horizontal style-form" method="get">
                         <div class="form-group">
                             <label class="col-sm-2 col-sm-2 control-label">Survey Name</label>
                             <div class="col-sm-10 col-lg-8">
                                 <input type="text" class="form-control">
                             </div>
                         </div>
                         <div class="form-group">
                             <label class="col-sm-2 col-sm-2 control-label">Survey Status</label>
                             <div class="col-sm-10 col-md-3 col-lg-3">
                               <select class="form-control">
                                 <option>Publish</option>
                                 <option>Unpublish</option>
                               </select>
                             </div>
                         </div>
                      </form>

                  </div>

              </div>

      </div>
      <div class="pull-right">
        <button type="button" class="btn btn-theme03 ">Theme 03</button>
      </div>
    </section>
</section>



   <!-- **********************************************************************************************************************************************************
              FOOTER START
   *********************************************************************************************************************************************************** -->
   <div ng-include="'assets/contentView/footer.htm'">

   </div>

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
    <script>
      //custom select box

     $(function(){
          $('select.styled').customSelect();
      });

  </script>

  </body>
</html>
