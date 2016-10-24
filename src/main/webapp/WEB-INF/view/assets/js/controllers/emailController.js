 angular.module('app').controller('emailController',['$scope','$http', function($scope,$http) {
	$scope.sendInvitation = function() {
		$scope.data = {
				from:$scope.from,
				to:$scope.tags,
				subject:$scope.subject,
				message:$scope.message	
		}
	
		// Send data to the server
    	$http({
    		method: 'POST',
    		  url: 'email',
    		  data:$scope.data
    	}).then(function successCallback(status) {
    		
    	
    	  }, function errorCallback(status) {
    		  
    	    	
    		  
    	  });
   
  };
	
	
	
	
}]);