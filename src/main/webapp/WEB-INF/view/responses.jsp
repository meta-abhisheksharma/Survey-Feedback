<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<title>Survey Feedback</title>
<!-- Bootstrap core CSS -->
<link href="/surveyfeedback/assets/css/bootstrap.css" rel="stylesheet">
<!--external css-->
<link href="/surveyfeedback/assets/font-awesome/css/font-awesome.css"
	rel="stylesheet" />

<!-- Custom styles for this template -->
<link href="/surveyfeedback/assets/css/style.css" rel="stylesheet" />

<link href="/surveyfeedback/assets/css/style-responsive.css"
	rel="stylesheet">
</head>
<body ng-app="appResponse" ng-controller="responseController">

	<section id="container"> <!--header start--> <header
		class="header black-bg">
	<div class="sidebar-toggle-box">
		<div class="fa fa-bars tooltips" data-placement="right"
			data-original-title="Toggle Navigation"></div>
	</div>
	<!--logo start--> <a href="index.jsp" class="logo"><b>Survey
			Feeedback</b></a> <!--logo end--> </header>
	<div>

		<section id="main-content" class="site-margin-bottom"> <section
			class="wrapper site-min-height ">
			<!-- Question Per Page :<input type="text" ng-model="itemsPerPage"> -->
		<div
			data-ng-repeat="question in questions.slice(((currentPage-1)*itemsPerPage), ((currentPage)*itemsPerPage))  | orderBy:'rank' ">
			<h2>{{question.questionText}}</h2>
			<div>
				<ul ng-if="question.questionType == 'checkbox'">
					<li data-ng-repeat="option in question.options"><input
						type="checkbox" name={{option.optionText}} ng-change="setAttribute(currentPage-1,{{question.questionId}})"
						value={{option.optionText}}
						ng-model="answer[currentPage-1].answers[$index].responseText">{{option.optionText}}
					</li>
				</ul>

				<ul ng-if="question.questionType == 'radio'">
					<li data-ng-repeat="option in question.options"><input
						type="radio" name={{question.questionId}}
						value={{option.optionText}}   ng-change="setAttribute(currentPage-1,{{question.questionId}})"
						ng-model="answer[currentPage-1].answers[0].responseText">{{option.optionText}}
					</li>
				</ul>

				<ul ng-if="question.questionType == 'text'">
					<li><input type="text" name={{question.questionId}}  ng-change="setAttribute(currentPage-1,{{question.questionId}})"
						placeholder="please enter text"
						ng-model="answer[currentPage-1].answers[0].responseText"></li>
				</ul>
				<p>{{answer}}</p>
			</div>
		</div>
		<div>
			<ul uib-pagination total-items="totalItems" ng-model="currentPage"
				max-size="maxSize" class="pagination-sm" boundary-links="true"
				num-pages="numPages" items-per-page="itemsPerPage"
				ng-click=showCardNumber()></ul>
			<h5>Showing {{(currentPage-1)*itemsPerPage+1}}-{{maxCard}} of
				{{totalItems}} Total Questions</h5>
		</div>
	</div>
	</section>
	</section>
	<div ng-include="'/surveyfeedback/assets/contentView/footer.htm'"></div>
	</section>
	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-route.js"></script>

	<!-- js placed at the end of the document so the pages load faster -->
	<script src="/surveyfeedback/assets/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript"
		src="/surveyfeedback/assets/js/app2.js"></script>
	<script type="text/javascript"
		src="/surveyfeedback/assets/js/controllers/responseController.js"></script>
	
	<script src="/surveyfeedback/assets/js/bootstrap.min.js"></script>
	<script class="include" type="text/javascript"
		src="/surveyfeedback/assets/js/jquery.dcjqaccordion.2.7.js"></script>
	<!--BACKSTRETCH-->
	<script type="text/javascript"
		src="/surveyfeedback/assets/js/jquery.backstretch.min.js"></script>
	<!--common script for all pages-->
	<script src="/surveyfeedback/assets/js/common-scripts.js"></script>
	
	<script src="/surveyfeedback/assets/js/ui-bootstrap-tpls-2.1.4.min.js" charset="utf-8"></script>




</body>
</html>