 angular.module('app').controller('emailController', function($scope,$http) {
	$scope.sendInvitation = function() {
		console.log("dsl");
		$scope.data = {
				to:$scope.name,
				from:$scope.from,
				message:$scope.message	
		}
	
		console.log($scope.data)
		// Send data to the server
    	$http({
    		method: 'POST',
    		  url: '/surveyfeedback/email',
    		  data:$scope.data
    	}).then(function successCallback(status) {
    		console.log("success");
    	
    	  }, function errorCallback(status) {
    		  console.log("error");
    	    	
//    		  
    	  });
   
  };
	
	
	
	
});