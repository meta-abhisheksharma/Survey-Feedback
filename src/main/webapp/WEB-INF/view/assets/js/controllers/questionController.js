angular.module("app").controller("questionController",
		[ '$scope', '$rootScope', function($scope, $rootScope) {

			console.log("In  create question");
			$scope.question = {};
			$scope.question.options = [];
			$scope.options = [ {
				id : 1
			}, {
				id : 2
			} ];

			$scope.addNewOption = function() {
				var newItemNo = $scope.options + 1;
				$scope.options.push({
					'id' : '' + newItemNo
				});
			};

			$scope.removeOption = function() {
				var lastItem = $scope.question.options.length - 1;
				$scope.question.options.splice(lastItem);
			};

			$scope.addNewQuestion = function() {
				alert("hii");

				$scope.question.options.push($scope.options);
				console.log($rootScope.survey.question.length);
				$rootScope.survey.question.push($scope.question);

				console.log($rootScope.survey);
			};
			console.log($rootScope.survey);
			/*
			 * $scope.removeQuestion = function() { var lastQuestion =
			 * $scope.survey.question.length-1;
			 * $scope.survey.question.splice(lastItem); };
			 */

		} ])
