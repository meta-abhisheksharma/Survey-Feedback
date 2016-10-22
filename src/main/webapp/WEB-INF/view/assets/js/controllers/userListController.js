
angular.module("app").controller("userListController",['$scope','$http',function($scope,$http){
	alert("heeloo");
	
	$http({
	method: 'GET',
	  url: '/surveyfeedback/users/'
	}).then(function successCallback(response) {
	    
		$scope.users=response.data;
		
	  }, function errorCallback(response) {
		  alert("error");
	  });
	
	
	$scope.deleteUser = function(id) {
		console.log("In delete User Controller"+id);	
		// Send data to the server
		$http({
			method: 'DELETE',
			  url: '/users/id'
			}).then(function successCallback(response) {
				alert("message");
		  }, function errorCallback(response) {
			
			  alert("error");
		  });

	};


}]);



