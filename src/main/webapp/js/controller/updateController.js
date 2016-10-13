myApp.controller('updateCar', function($scope,$http,$routeParams) {
 
$scope.editDetails = function($index) {
	$scope.$index = $index;
	angular.copy($scope.cars[$index], $scope.editedItem);
};
// Update Car
$scope.updateDetails = function() {
	$http({
		method : 'PUT',
		url : '/TFSession01/cars/' + $scope.editedItem.id,
		data : $scope.editedItem
	}).then(function(data) {
		$scope.getCars();
		$scope.message = "Car Updated Sucessfully !!!!";
		$('header').show(1000);
		setTimeout(function() {
			$("header").fadeOut(1500);
		}, 1500)
	}, function(data) {
		$scope.message = "Something went wrong sorry for inconvenience !!!!";
		$('header').show();
		setTimeout(function() {
			$("header").fadeOut(1500);
		}, 1500)
	});
}
});