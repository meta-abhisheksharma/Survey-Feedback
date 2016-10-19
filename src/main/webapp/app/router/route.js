angular.module("myApp").config(function($routeProvider) {
    $routeProvider
    .when("/", {
        templateUrl : "templates/home.html"
    })
    .when("/signin", {
        templateUrl : "templates/login.html"
    })
    .when("/signup", {
        templateUrl : "templates/signup.html"
    })
    .otherwise({
       redirectTo: "templates/home.html"
    });
});




/*config(function($stateProvider,$urlRouterProvider){
	$urlRouterProvider.otherwise('/index.html');
	$stateProvider
	.state('signin',{
		url:'/signin',
		templateUrl:'templates/login.html'
	})
	.state('signup',{
		url:'/signup',
		templateUrl:'templates/signup.html'
	})
});*/