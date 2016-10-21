angular.module("myApp").controller("signUpController",['$scope','$http','$location',function($scope,$http,$location){
	

	$scope.signUp = function($location) {
		
		$scope.user = {
				name:$scope.name,
				password:$scope.password,
				email:$scope.email	
		}
	
		
		// Send data to the server
    	$http({
    		method: 'POST',
    		  url: '/surveyfeedback/users',
    		  data:$scope.user
    	}).then(function successCallback(status) {
    		console.log("success");
    		console.log(status);
//    	   alert("message signUp");
    	
    	  }, function errorCallback(status) {
    		  $location.path("dashboard");
    	    console.log(status);
    	   
//    		  alert("error");
    	  });
   
  };
}])



