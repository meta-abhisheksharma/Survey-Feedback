
//It will take questions JSON from $rootScope.questions
angular.module("app").controller("questionListController",['$scope','$rootScope',function($scope,$rootScope){
	$scope.questions=$rootScope.questions;

	
}]);