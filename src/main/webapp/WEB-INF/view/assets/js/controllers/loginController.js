angular.module("myApp").controller("loginController",['$scope','$window','$http','SweetAlert',function($scope,$window,$http,SweetAlert){

//CUSTOM LOGIN
//It will take user filled data and pass it server(/surveyfeedback/users/login)
$scope.submit = function() {
	$scope.loginDetails = {
			name:null,
			password:$scope.password,
			email:$scope.email,
			userRole:null,
			blockUser:null
	}
//$http service makes a request to the server, and returns a response
		$http({
    		method: 'POST',
    		  url: 'users/login',
    		  data:$scope.loginDetails
    	}).then(function successCallback(response) {	//If user exist
    		    	
    		    	
    	   $window.location.href = '/surveyfeedback/dashboard';
    	  }, function errorCallback(response) {			//If user does not exist
    		   var myEl = angular.element( document.querySelector( '#error' ) );
			   myEl.css('display','inline');
			  
    		  
    	  });
    };

	//SOCIAL LOGIN	
   $scope.onSignIn = function onSignIn(googleUser) {		
 		// Useful data for your client-side scripts:		
 		var profile = googleUser.getBasicProfile();		
 		console.log("ID: " + profile.getId()); // It should not be directly to your server		
 		console.log("Name: " + profile.getName());		
 		console.log("Image URL: " + profile.getImageUrl());		
 		console.log("Email: " + profile.getEmail());		
 		
 		// The ID token you need to pass to your backend:		
 		var id_token = googleUser.getAuthResponse().id_token;		
 		//$window.location.href = '/authenticate/google';		
 	};
}]);

