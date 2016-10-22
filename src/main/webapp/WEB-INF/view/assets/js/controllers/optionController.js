var app = angular.module('app').controller('optionController','$rootScope', function($scope,$rootScope) {

  $scope.choices = [{id: 1}, {id: 2}];
  
  $scope.addNewChoice = function() {
    var newItemNo = $scope.choices.length+1;
    $scope.choices.push({'id': ''+newItemNo});
  };
    
  $scope.removeChoice = function() {
    var lastItem = $scope.choices.length-1;
    $scope.choices.splice(lastItem);
  };
  
});