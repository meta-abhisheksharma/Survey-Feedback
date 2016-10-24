angular.module("app").controller("questionController",
		[ '$scope', '$rootScope', function($scope, $rootScope) {

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

				$scope.question.options.push($scope.options);
				$rootScope.survey.question.push($scope.question);


			};
		
		} ])
