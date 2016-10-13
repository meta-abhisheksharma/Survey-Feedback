myApp.controller('deleteCar', function($scope,$http,$routeParams) {

// Delete Car
$scope.deleteDetails = function($index) {
	console.log("delete details called");
	$http(
			{
				method : 'DELETE',
				url : '/TFSession01/cars/'
					+ $scope.cars[$index].id,
					headers : {
						'Content-Type' : 'application/json'
					}
			})
			.then(
					function(responses) {
						$scope.getCars();
						$scope.maxCard = $scope.maxCard - 1;
						$scope.cars.splice($index,1);
						$('header').show();
						$scope.message = "Car deleted Sucessfully";
						console
						.log("delete success message called");
						setTimeout(function() {
							$("header").fadeOut(
									1500);
						}, 1500);
					},
					function(responses) {
						console
						.log("Error function called");
						console.log(responses);
						$('header').show();
						$scope.message = "Something went wrong sorry for inconvenience !!!!";
						setTimeout(function() {
							$("header").fadeOut(
									1500);
						}, 1500)
					});
}
});