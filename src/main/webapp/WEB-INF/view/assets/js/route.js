angular.module("myApp").config(function($routeProvider) {
   $routeProvider
   .when("/", {
       templateUrl : "assets/contentView/login.htm"
   })
   .when("/login", {
       templateUrl : "assets/contentView/login.htm"
   })
   .when("/signup", {
       templateUrl : "assets/contentView/signup.htm",
    /*   controller:"signupController.js"*/
   })

   .otherwise({
      redirectTo: "assets/contentView/login.htm"
   });
});
