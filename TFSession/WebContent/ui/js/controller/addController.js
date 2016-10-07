myApp.controller('addCar', function($scope,$http,$routeParams) {

	$scope.addDetails =function(){
	$http({
		method : 'POST',
		url : '/TFSession01/cars',
		data : $scope.addItem
	}).then(function(data) {
		$scope.getCars();
		$scope.maxCard = $scope.maxCard + 1;
		$('header').show();
		$scope.message = "Car Added Sucessfully !!!!";
		setTimeout(function() {
			$("header").fadeOut(1500);
		}, 1500)
	}, function(data) {
		$('header').show();
		$scope.message = "Something went wrong sorry for inconvenience !!!!";
		setTimeout(function() {
			$("header").fadeOut(1500);
		}, 1500)
	});
	}
});