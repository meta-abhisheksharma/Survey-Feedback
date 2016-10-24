var appResponse = angular.module('appResponse', [ 'ui.bootstrap' ]);

angular.module("appResponse").controller("responseController",['$scope','$http','$filter',function($scope,$http,$filter){	
	console.log("In sidebar Controller");
	
	$scope.responses=[];
	$scope.response={};
	$scope.questions=[];
	var count = 0;
	var userID= "";
	var survey="";
	$http({
	method: 'GET',
	 url: '/surveyfeedback/responses/response'
	}).then(function successCallback(response) {
	user=response.data.email;
	$scope.surveyDTO = response.data.surveyDTO;
	$scope.questions = response.data.surveyDTO.questions;
	$scope.totalItems = $scope.questions.length;
	$scope.questions = makeRandom($scope.questions);
	$scope.totalItems = $scope.questions.length;
	$scope.currentPage = 1;
	$scope.itemsPerPage = 1;
    
	
	 }, function errorCallback(response) {

	 alert("error");
	 });
	
	
	$scope.answer = [];
	$scope.answer.questionId ;
		
	function makeRandom(inputArray){
        angular.forEach(inputArray, function(value){
          value.rank = Math.random();
        });
        return inputArray; 
      }
	
	$scope.setAttribute = function(currentPage,questionId){
		$scope.answer[currentPage].questionId=questionId;
		$scope.answer[currentPage].surveyID = $scope.surveyDTO.surveyID;
		$scope.answer[currentPage].userID = user;
	
	}
	
	
	
}]);