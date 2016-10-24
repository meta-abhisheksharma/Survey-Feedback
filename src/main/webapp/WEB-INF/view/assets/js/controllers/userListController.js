angular.module("app").controller("userListController",
		[ '$scope', '$http', '$rootScope','$window', function($scope, $http, $rootScope,$window) {

			// It makes request to the server to get the all users
			$scope.responderLength = $rootScope.responderLength;
			$scope.surveyorLength = $rootScope.surveyorLength;
			$rootScope.users = {};

			$scope.currentPage = 1;
			$scope.itemsPerPage = 4;

			$scope.getUsers = function() {

				if ($scope.role == 'getAll') {

					$http({
						method : 'GET',
						url : 'users/'
					}).then(function successCallback(response) {

						$scope.users = response.data;
						$scope.totalItems = $scope.users.length;
					}, function errorCallback(response) {
						alert("error");
					});
				}

				if ($scope.role == 'surveyor') {

					$http({
						method : 'GET',
						url : 'users/roles/surveyor'
					}).then(function successCallback(response) {

						$scope.users = response.data;
						$scope.length = $scope.users.length;
						$scope.totalItems = $scope.users.length;
					}, function errorCallback(response) {

					});
				}

				if ($scope.role == 'responder') {

					$http({
						method : 'GET',
						url : 'users/roles/responder'
					}).then(function successCallback(response) {

						$scope.users = response.data;
						$scope.length = $scope.users.length;
						$scope.totalItems = $scope.users.length;
					}, function errorCallback(response) {

					});
				}
			}

			// It makes request to the server to delete user with provided id
			$scope.deleteUser = function(id) {
				$http({
					method : 'DELETE',
					url : 'users/' + id
				}).then(function successCallback(response) {

				}, function errorCallback(response) {

				});

			};

			// It will store the user object in rootScope variable
			$scope.update = function(user) {
				$rootScope.user = user;
				$rootScope.updateUserFlag = true;

			}

			// It makes request to the server to update user with provided id
			// and updated data of user
			$scope.updateUser = function(user) {

				$scope.user = user;

				$http({
					method : 'PUT',
					url : 'users/' + $rootScope.user.id,
					data : $scope.user
				}).then(function successCallback(response) {

				}, function errorCallback(response) {

				});

			}

			$scope.createUser = function() {
				$rootScope.user = {};
				$scope.user = {
					name : $scope.name,
					password : $scope.password,
					email : $scope.email,
					userRole : $scope.userRole,
					blockUser : $scope.blockUser
				}

				console.log($scope.email);
				$http({
					method : 'POST',
					url : 'users',
					data : $scope.user
				}).then(function successCallback(response) {
					
					$window.location.href ="/surveyfeedback/dashboard";
					
				}, function errorCallback(response) {

				});
			}

		} ]);
