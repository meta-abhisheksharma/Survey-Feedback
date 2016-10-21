
angular.module("app").controller("surveyController",['$scope','$http',function($scope,$http){
$http({
	method: 'GET',
	  url: '/surveyfeedback/surveys/'
	}).then(function successCallback(response) {
	    
		$scope.surveys=response.data;
		
	  }, function errorCallback(response) {
		  alert("error");
	  });


$scope.deleteSurvey=function(id){

	alert("hiufi"+id);
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
	
	alert("dfo"+id);
	
	$http({
		method: 'PUT',
		  url: '/surveyfeedback/surveys/id'
		}).then(function successCallback(response) {
		    
	alert("success");
		  }, function errorCallback(response) {
			  alert("error");
		  });

	
	
}



}]);





