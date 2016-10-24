angular.module("app").controller("addQuestionController",['$scope','$rootScope','$http',function($scope, $rootScope,$http) {

							
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
									$scope.question.options=[{}];
								}
		
								$rootScope.survey.questions.push(angular.copy($scope.question));
								$scope.question = {};
								
								$scope.options = [{optionText :null},{optionText :null}];
							
								
							};
							
							
							
							$scope.createSurvey=function(){
								
								$scope.tempSurvey = {
										surveyID:"",
										surveyName:$rootScope.survey.name,
										surveyType:"simple",
										label:$rootScope.survey.label,
										status:$rootScope.survey.status,
										questions:$rootScope.survey.questions
								}
								
								
								$http({
						    		method: 'POST',
						    		  url: 'surveys',
						    		  data:$scope.tempSurvey
						    	}).then(function successCallback(response) {
						    	   
						    	
						    	   
						    	  }, function errorCallback(response) {
						    	    
						    		  

						    		  
						    	  });
								
							}
							
							
						} ])