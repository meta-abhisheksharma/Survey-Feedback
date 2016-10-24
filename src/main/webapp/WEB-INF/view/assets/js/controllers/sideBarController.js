angular.module("app").controller("sideBarController",
		[ '$scope', '$http', '$rootScope', function($scope, $http, $rootScope) {

			// Send data to the server

			$http({
				method : 'GET',
				url : 'users/session'
			}).then(function successCallback(response) {
				$rootScope.loginUser = response.data;
				$scope.user = response.data;
			}, function errorCallback(response) {
				alert("error");
			});
/*
			
*/
			$scope.setEmail = function() {
				$rootScope.user = {};

			}

		} ]);