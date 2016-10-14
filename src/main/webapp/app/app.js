var myApp = angular.module("myApp",["ngRoute"]);

myApp.config(function( $routeProvider) {
	$routeProvider
	.when('/home', {
		templateUrl: 'app/templates/home.html',
		controller: 'loginController'
	})
	.when('/login', {
		templateUrl: 'app/templates/login.html',
		controller: 'loginController'
	})
	.otherwise({
		redirectTo: '/home'
	});
});

myApp.controller('AppCtrl',function($scope, $rootScope, $location){
	
});