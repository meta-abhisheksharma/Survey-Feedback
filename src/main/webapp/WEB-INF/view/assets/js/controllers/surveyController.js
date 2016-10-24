angular.module("app").controller("surveyController",
		[ '$scope', '$http', '$rootScope', function($scope, $http, $rootScope) {

			// It makes a request to the server and provide response

			$scope.setRole = function(data) {
				$rootScope.role = data;
			}
			
			$http({
				method : 'GET',
				url : 'surveys'
			}).then(function successCallback(response) {
				$scope.surveys = response.data;
				$scope.length = $scope.surveys.length;
				$scope.totalItems = $scope.length;
			}, function errorCallback(response) {

			});
			
			$http({
				method : 'GET',
				url : 'users/roles/surveyor'
			}).then(function successCallback(response) {
				$rootScope.surveyorLength = response.data.length;
			}, function errorCallback(response) {
			});

			
			$http({
				method : 'GET',
				url : 'users/roles/responder'
			}).then(function successCallback(response) {
				$rootScope.responderLength = response.data.length;
			}, function errorCallback(response) {
			});

			$scope.currentPage = 1;
			$scope.itemsPerPage = 2;
			// It makes request to the server to delete the survey with id 'id'
			$scope.deleteSurvey = function(id) {
				$http({
					method : 'DELETE',
					url : 'surveys/' + id
				}).then(function successCallback(response) {

				}, function errorCallback(response) {

				});

			}

			// It makes request to the server to update the survey with id 'id'
			$scope.updateSurvey = function(id) {
				$http({
					method : 'PUT',
					url : 'surveys/' + id
				}).then(function successCallback(response) {

				}, function errorCallback(response) {

				});
			}

			// It will get the questions from $scope.surveys according to id
			$scope.displaySurvey = function(id) {
				$rootScope.questions = $scope.surveys[id].questions;
			}

		} ]);
