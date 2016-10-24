angular.module("myApp").config(function($routeProvider) {
	$routeProvider.when("/", {
		templateUrl : "assets/contentView/login.htm"
	}).when("/login", {
		templateUrl : "assets/contentView/login.htm"
	}).when("/signup", {
		templateUrl : "assets/contentView/signup.htm",
	/* controller:"signupController.js" */
	}).when("/aboutUs", {
		templateUrl : "assets/contentView/aboutUs.htm",
	/* controller:"signupController.js" */
	}).when("/contactUs", {
		templateUrl : "assets/contentView/contactUs.htm",
	/* controller:"signupController.js" */
	})

	.otherwise({
		redirectTo : "/"
	});
});
