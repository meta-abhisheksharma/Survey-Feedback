var myApp = angular.module('myApp', []);

myApp.controller('MainController', function($scope, $http) {
	$http.get("http://localhost:8080/carbechospring/car/carlist").success(
			function(response) {
				$scope.carlist = response;
			});

	$http.get("http://localhost:8080/carbechospring/car/carvolist").success(
			function(response) {
				$scope.carvolist = response;
			});

	$http.get("http://localhost:8080/carbechospring/car/vehiclevolist")
			.success(function(response) {
				$scope.vehiclevolist = response;
				// $scope.myCars = [ $scope.carlist , $scope.carvolist,
				// $scope.vehiclevolist ];
			});

	$scope.view = "col-sm-6 col-md-4 col-lg-3";

	$scope.listView = function() {
		$scope.view = "col-xs-12";
	}

	$scope.cardView = function() {
		$scope.view = "col-sm-6 col-md-4 col-lg-3";
	}

	$scope.indexNum = 0;
	$scope.vehiclevoDetail = {};
	$scope.carvoDetail = {};
	$scope.carDetail = {};

	$scope.showData = function($index) {
		$scope.$index = $index;
		angular.copy($scope.vehiclevolist[$index], $scope.vehiclevoDetail);
		angular.copy($scope.carvolist[$index], $scope.carvoDetail);
		angular.copy($scope.carlist[$index], $scope.carDetail);
		
		$scope.indexNum = $index;

	}

	$scope.updateView = function($index) {
		$scope.vehiclevolist[$index] = $scope.vehiclevoDetail;
		$scope.carvolist[$index] = $scope.carvoDetail;
		$scope.carlist[$index] = $scope.carDetail;
	}

	$scope.deleteCar = function($index) {
		$scope.vehiclevolist.splice($index, 1);
		$scope.carvolist.splice($index, 1);
		$scope.carlist.splice($index, 1);
	}

	$scope.updateCar = function($index) {
		
		
		$http.put("http://localhost:8080/carbechospring/car/updatecar/"+$scope.vehiclevolist[$index].vehicleVO_ID, $scope.carlist[$index]).success(
				function (data, status, headers, config) {
					alert("car updated");
				}).error(
						function (data, status, headers, config) {
							alert("An error occurred during the car AJAX request"); });
		
		$http.put("http://localhost:8080/carbechospring/car/updatecarvo/"+$scope.vehiclevolist[$index].vehicleVO_ID, $scope.carvolist[$index]).success(
				function (data, status, headers, config) {
					alert("car vo updated");
				}).error(
						function (data, status, headers, config) {
							alert("An error occurred during the car vo AJAX request"); });
		
		$http.put("http://localhost:8080/carbechospring/car/updatevehiclevo/"+$scope.vehiclevolist[$index].vehicleVO_ID,  $scope.vehiclevolist[$index]).success(
				function (data, status, headers, config) {
					alert("vehicle vo updated");
				}).error(
						function (data, status, headers, config) {
							alert("An error occurred during the vehicle vo AJAX request"); });

	}
	
/*$scope.addCar = function($index) {
		
	var car ={};

		$http.post("http://localhost:8080/carbechospring/car/addcar/", $scope.carlist[$index]).success(
				function (data, status, headers, config) {
					alert("car added");
				}).error(
						function (data, status, headers, config) {
							alert("An error occurred during the car AJAX request"); });
		
		$http.post("http://localhost:8080/carbechospring/car/addcarvo/", $scope.carvolist[$index]).success(
				function (data, status, headers, config) {
					alert("car vo added");
				}).error(
						function (data, status, headers, config) {
							alert("An error occurred during the car vo AJAX request"); });
		
		$http.post("http://localhost:8080/carbechospring/car/addvehiclevo/",  $scope.vehiclevolist[$index]).success(
				function (data, status, headers, config) {
					alert("vehicle vo added");
				}).error(
						function (data, status, headers, config) {
							alert("An error occurred during the vehicle vo AJAX request"); });

	}*/
});
