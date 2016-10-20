angular.module("myApp").controller("loginController",['$scope','$window','$http',function($scope,$window,$http){
$scope.submit = function() {
	console.log("jii");
	
	$scope.loginDetails = {
			name:null,
			password:$scope.password,
			email:$scope.email,
			userRole:null,
			blockUser:null,
		//	createdTime=" ",
		//	updatedTime=""
	
	}
	console.log($scope.loginDetails)
	
    	$http({
    		method: 'POST',
    		  url: '/surveyfeedback/users/login',
    		  data:$scope.loginDetails
    	}).then(function successCallback(response) {
    	   alert("message login");
    	   $window.location.href = '/surveyfeedback/';
    	  }, function errorCallback(response) {
    	    
    		  alert("djjshgjh");
    		  
    	  });
  
  };
}])

