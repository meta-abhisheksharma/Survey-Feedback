angular.module("myApp").controller("signUpController",['$scope','$http',function($scope,$http){
	

	$scope.signUp = function(user) {
		console.log("dsl");
		$scope.user = {
				name:$scope.name,
				password:$scope.password,
				email:$scope.email,
				userRole:null,
				blockUser:null,
			//	createdTime=" ",
			//	updatedTime=""
		
		}
	
		console.log($scope.user)
		// Send data to the server
    	$http({
    		method: 'POST',
    		  url: '/surveyfeedback/users',
    		  params:$scope.user
    	}).then(function successCallback(response) {
    	   alert("message");
    	  }, function errorCallback(response) {
    	    
    		  alert("error");
    	  });
   
  };
}])



