angular.module("myApp").controller("loginController",['$scope','$window','$http',function($scope,$window,$http){
$scope.customLogin = function() {
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
    	   alert("message");
    	   $window.location.href = '/surveyfeedback/dashboard';
    	  }, function errorCallback(response) {
    	    
    		  alert("djjshgjh");
    		  
    	  });
  
  };
  
  $scope.onSignIn = function onSignIn(googleUser) {
		// Useful data for your client-side scripts:
		var profile = googleUser.getBasicProfile();
		console.log("ID: " + profile.getId()); // Don't send this directly to your server!
		console.log("Name: " + profile.getName());
		console.log("Image URL: " + profile.getImageUrl());
		console.log("Email: " + profile.getEmail());

		// The ID token you need to pass to your backend:
		var id_token = googleUser.getAuthResponse().id_token;
		console.log("ID Token: " + id_token);
		//$window.location.href = '/authenticate/google';
	};
}])


