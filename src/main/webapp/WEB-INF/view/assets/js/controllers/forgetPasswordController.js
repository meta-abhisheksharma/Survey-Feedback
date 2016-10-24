angular.module("myApp").controller("forgetPasswordController" ,['$http','$scope','$window',function($http,$scope,$window){
    $scope.user={};
    
    
    $scope.getPassword = function(){
    //$http service makes a request to the server, and returns a response
    $http({
        method: 'POST',
          url: 'users/password',
          data:$scope.user
    }).then(function successCallback(response) {    //If user exist
                alert("success");
                $window.location.href = '/surveyfeedback/login';
      }, function errorCallback(response) {        //If user does not exist
          
          alert("fail");
          
          
      });
}

}])