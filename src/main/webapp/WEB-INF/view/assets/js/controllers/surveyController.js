
angular.module("app").controller("surveyController",['$scope','$http','$rootScope',function($scope,$http,$rootScope){
	
$http({
	method: 'GET',
	  url: '/surveyfeedback/surveys/'
	}).then(function successCallback(response) {
	    
		$scope.surveys=response.data;
		
	  }, function errorCallback(response) {
		  alert("error");
	  });


$scope.deleteSurvey=function(id){

	console.log($scope.surveys);

	$http({
		method: 'DELETE',
		  url: '/surveyfeedback/surveys/id'
		}).then(function successCallback(response) {
		    
			alert("success");
		  }, function errorCallback(response) {
			  alert("error");
		  });

}



$scope.updateSurvey=function(id){

	
	$http({
		method: 'PUT',
		  url: '/surveyfeedback/surveys/id'
		}).then(function successCallback(response) {
		    
	alert("success");
		  }, function errorCallback(response) {
			  alert("error");
		  });

	
	
}



$scope.displaySurvey=function(id){

	$rootScope.questions=$scope.surveys[id].questions;
	
}



}]);





