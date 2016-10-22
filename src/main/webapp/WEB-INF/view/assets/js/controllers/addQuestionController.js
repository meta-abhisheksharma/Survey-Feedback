angular.module("app").controller("addQuestionController",['$scope','$rootScope',function($scope, $rootScope) {

							console.log("In  create question");
							$scope.question = {};
							
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
		
								$rootScope.survey.questions.push(angular.copy($scope.question))
								console.log($rootScope.survey);
							};
							
						} ])