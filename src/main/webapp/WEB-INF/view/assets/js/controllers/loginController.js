angular.module("myApp").controller("loginController",['$scope','$http',function(){alert("hi ajinku");
$scope.submit = function() {
    if ($scope.text) {
    	$http({
    		method: 'GET',
    		  url: '/login'
    	}).then(function successCallback(response) {
    	   alert("message");
    	  }, function errorCallback(response) {
    	    
    	  });
    }
  };
}])