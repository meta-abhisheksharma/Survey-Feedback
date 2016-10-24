angular.module("myApp").controller("signUpController",['$scope','$http','$window','SweetAlert',function($scope,$http,$window,SweetAlert){

//It will take user filled data and pass it server(/surveyfeedback/users)	
	$scope.signUp = function($location) {
	
	/*	$scope.$watch('password' ,function() {
	        $scope.password = md5.createHash($scope.password || '');
	        console.log($scope.password);
	        
	      });
	 */
		
		
		
		$scope.user = {
				name:$scope.name,
				password:$scope.password,
				email:$scope.email	
		}
	
// Send data to the server
    	$http({
    		method: 'POST',
    		  url: 'users',
    		  data:$scope.user
    	}).then(function successCallback(status) {
    		//console.log("success");
    		 $window.location.href="login";
    	  }, function errorCallback(status) {
    		 SweetAlert.swal("something went wrong");
      	  });
   
  };
}])

.directive('validPasswordC', function () {
    return {
        require: 'ngModel',
        link: function (scope, elm, attrs, ctrl) {
            ctrl.$parsers.unshift(function (viewValue, $scope) {
                var noMatch = viewValue != scope.myForm.password.$viewValue
                ctrl.$setValidity('noMatch', !noMatch)
            })
        }
    }
})



