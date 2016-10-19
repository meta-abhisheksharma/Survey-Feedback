	angular.module("myApp").controller("userController",['$scope','$http',function($scope,$http){
		
	//Get all users  from the database 
		$scope.getAllUser = function() {
			console.log("In User Controller");
			// Send data to the server
			$http({
				method: 'GET',
				  url: '/users'
				}).then(function successCallback(response) {
					
					alert(response.data);
					$scope.users=response.data;
					console.log($scope.users)
					alert("message");
			  }, function errorCallback(response) {
				
				  alert("error");
			  });
	   
	  };


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
				alert("message");
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
				userRole:$scope.userRole,
				blockUser:$scope.blockUser,
			//	createdTime=" ",
			//	updatedTime=""
		
		}
		
		$http({
			method: 'POST',
			  url: '/users'
			}).then(function successCallback(response) {
				
				alert(response.data);
				$scope.users=response.data;
				console.log($scope.users)
				alert("message");
		  }, function errorCallback(response) {
			
			  alert("error");
		  });

	};


	//It will update user in database
	$scope.updateUser = function() {
		console.log("In create User Controller");
		$scope.user = {
				name:$scope.name,
				password:$scope.password,
				email:$scope.email,
				userRole:$scope.userRole,
				blockUser:$scope.blockUser,
				//	createdTime=" ",
				//	updatedTime=""
		
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



