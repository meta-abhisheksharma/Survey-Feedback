angular.module("app").controller("sideBarController",['$scope','$http',function($scope,$http){	 
			console.log("In sidebar Controller");
			// Send data to the server
		$http({
			method: 'GET',
			  url: 'users/session'
			}).then(function successCallback(response) {
				$scope.user=response.data;
				console.log($scope.users)
				alert("message iiioo");
		  }, function errorCallback(response) {
			
			  alert("error");
		  });
}]);