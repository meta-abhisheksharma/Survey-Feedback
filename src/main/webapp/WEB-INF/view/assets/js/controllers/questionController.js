 
angular.module("app").controller("questionController",['$scope','$rootScope',function($scope, $rootScope) {

							console.log("In  create question");
							$scope.question = {};
							$scope.questions = [];
							$scope.options = [{optionText :null},{optionText :null}];
							
							
							$scope.addNewOption = function() {
								$scope.options.push({});
							};

							$scope.removeOption = function() {
								var lastItem = $scope.options.length - 1;
								$scope.options.splice(lastItem);
							};
							
							$scope.addNewQuestion = function() {
								if($scope.question.questionType == "radio" || $scope.question.questionType == "checkbox"){
								$scope.question.options = $scope.options;
								}
								else{
									$scope.question.options=null;
								}
								$scope.questions.push(angular.copy($scope.question));
								$rootScope.survey.questions = $scope.questions;
								console.log($rootScope.survey);
							};
							
						} ])
