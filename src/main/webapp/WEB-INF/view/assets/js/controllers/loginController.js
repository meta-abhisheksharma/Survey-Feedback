angular.module("myApp").controller("loginController",['$scope','$http',function($scope,$http){
$scope.submit = function(user) {
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
    	  }, function errorCallback(response) {
    	    
    		  alert("djjshgjh");
    		  
    	  });
  
  };
}])


/*.controller('socialCtrl',function($scope,$http,$window,StoreService) {

	$('#signinButton').click(function() {
		
		auth2.grantOfflineAccess({
			'redirect_uri' : 'postmessage'
		}).then(signInCallback);
	});

	function signInCallback(authResult) {
		if (authResult['code']) {
			$('#signinButton').attr('style', 'display: none');
			// Send data to the server
			$http({
				method : 'POST',
				url : '/social/getDetails',
				headers: {
					'Content-Type': 'application/json'
				},
				processData : false,
				data : authResult['code']
			}).then( function(response) {
				$scope.user = response.data;
				StoreService.set($scope.user);
				$window.location.href="/signUpAfterSocialLogin";
			}, function () {
				alert("Something went wrong");
			});
		}
	}
})*/