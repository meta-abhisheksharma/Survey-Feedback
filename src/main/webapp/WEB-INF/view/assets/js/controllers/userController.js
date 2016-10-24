	angular.module("app").controller("userController",['$scope','$http',function($scope,$http){

//It makes request to the server to get user with provided id  
	  $scope.getUserById = function(id) {
		$http({
			method: 'GET',
			  url: 'users/'+id
			}).then(function successCallback(response) {
				$scope.users=response.data;
		  }, function errorCallback(response) { 
		  });
	};


//It makes request to the server to create user   
	$scope.createUser = function() {
		$scope.user = {
				name:$scope.name,
				password:$scope.password,
				email:$scope.email,
				userRole:$scope.userRole,
				blockUser:$scope.blockUser
			//	createdTime=" ",
			//	updatedTime=""
		
				
		}
		
		$http({
			method: 'POST',
			  url: '/users'
			}).then(function successCallback(response) {
				$scope.users=response.data;
		  }, function errorCallback(response) {
			
			 
		  });

	};

}])



