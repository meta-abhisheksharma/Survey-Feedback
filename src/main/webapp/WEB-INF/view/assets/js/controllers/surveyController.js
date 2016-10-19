angular.module("myApp").controller("surveyController",['$scope','$http',function($scope,$http){
	

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
  
  
  $scope.create = function() {
		console.log("In  create survey Controller");
		// Send data to the server
		
		$scope.survey={
				name:name,
				type:type,
				label:label,
				id:null,
				status:null,
		/*		createdBy:,
				createdTime:,
				updatedTime:
		*/
				
		}
		console.log($scope.survey);
		
  	$http({
  		method: 'POST',
  		  url: '/add',
  		  data:survey
  		}).then(function successCallback(response) {
  			
  			alert(response.data);
  			$scope.surveys=response.data;
  			alert("message");
  	  }, function errorCallback(response) {  	    
  		  alert("error");
  	  });
 
};

  
  
}])



