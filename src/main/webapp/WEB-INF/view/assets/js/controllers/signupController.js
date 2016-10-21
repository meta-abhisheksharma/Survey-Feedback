angular.module("myApp").controller("signUpController",['$scope','$http','$location',function($scope,$http,$location){
	

	$scope.signUp = function($location) {
		console.log("dsl");
		$scope.user = {
				name:$scope.name,
				password:$scope.password,
				email:$scope.email	
		}
	
		console.log($scope.user)
		// Send data to the server
    	$http({
    		method: 'POST',
    		  url: '/surveyfeedback/users',
    		  data:$scope.user
    	}).then(function successCallback(status) {
    		console.log("success");
    		console.log(status);
//    	   alert("message signUp");
    	   debugger;
    	  }, function errorCallback(status) {
    		  $location.path("dashboard");
    	    console.log(status);
    	    debugger;
//    		  alert("error");
    	  });
   
  };
}])



