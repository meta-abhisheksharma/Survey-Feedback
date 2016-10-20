angular.module("app").controller("surveyController",['$scope','$rootScope','$http',function($scope,$rootScope,$http){
	

	$scope.getSurvey = function() {
		console.log("In survey Controller");
		// Send data to the server
    	$http({
    		method: 'GET',
    		  url: '/getSurvey'
    		}).then(function successCallback(response) {
    			
    			alert(response.data);
    			$scope.surveys=response.data;
    			alert("message");
    	  }, function errorCallback(response) {
    	    
    		  alert("error");
    	  });
   
  };
  
  $rootScope.survey={};
  $rootScope.survey.questions=[];
  //$rootScope.survey.userID=$rootScope.user.userID;
  $scope.createSurvey = function() {
		console.log("In  create survey Controller");				
		console.log($rootScope.survey);
		
  /*	$http({
  		method: 'POST',
  		  url: '/add',
  		  data:$scope.survey
  		}).then(function successCallback(response) {
  			
  			alert(response.data);
  			$scope.surveys=response.data;
  			alert("message");
  	  }, function errorCallback(response) {  	    
  		  alert("error");
  	  });*/
 
};

  
}])



