	angular.module("app").controller("userController",['$scope','$http',function($scope,$http){
		

	//Get particular user object from database
	  $scope.getUserById = function(id) {
			console.log("In User Controller");
			// Send data to the server
		$http({
			method: 'GET',
			  url: '/users/id'
			}).then(function successCallback(response) {
				
				alert(response.data);
				$scope.users=response.data;
				console.log($scope.users)
				alert("message iiioo");
		  }, function errorCallback(response) {
			
			  alert("error");
		  });
	 
	};


	//It will add new user in database
	$scope.createUser = function() {
		console.log("In create User Controller");
		
		$scope.user = {
				name:$scope.name,
				password:$scope.password,
				email:$scope.email,
				role:$scope.role,
				blockUser:$scope.blockuser
		}
		console.log($scope.user);
		
		$http({
			method: 'POST',
			  url: '/surveyfeedback/users',
				data:$scope.user
			}).then(function successCallback(response) {
				$scope.users=response.data;
		  }, function errorCallback(response) {
			  alert("create user error");
		  });

	};


	//It will update user in database
	$scope.updateUser = function() {
		console.log("In create User Controller");
		$scope.user = {
				name:$scope.name,
				blockuser:$scope.blockuser,
				email:$scope.email,
				role:$scope.role,
				blockUser:$scope.blockUser,
				
		}
		$http({
			method: 'PUT',
			  url: '/users/id',
			  data:$scope.user
			}).then(function successCallback(response) {
				
				alert("message");
		  }, function errorCallback(response) {
			
			  alert("error");
		  });

	};


	$scope.Delete = function(id) {
		console.log("In delete User Controller");	
		// Send data to the server
		$http({
			method: 'DELETE',
			  url: '/users/id',
			  data:$scope.user
			}).then(function successCallback(response) {
				
				alert("message");
		  }, function errorCallback(response) {
			
			  alert("error");
		  });

	};


	}])



