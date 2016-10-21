angular.module("app").controller("questionListController",['$scope','$rootScope',function($scope,$rootScope){
	$scope.questions=$rootScope.questions;
}]);