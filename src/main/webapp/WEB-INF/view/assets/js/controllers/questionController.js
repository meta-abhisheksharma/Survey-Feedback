angular.module("myApp").controller("questionController",['$scope','$http',function($scope,$http){
	

	$scope.getQuestion = function() {
		console.log("In Question Controller");
		// Send data to the server
    	$http({
    		method: 'GET',
    		  url: '/getQuestion'
    		}).then(function successCallback(response) {
    			
    			alert(response.data);
    			$scope.questions=response.data;
    			alert("message");
    	  }, function errorCallback(response) {
    	    
    		  alert("error");
    	  });
   
  };
}])



