var myApp = angular.module("MyApp", [ 'ui.bootstrap', 'ngRoute' ]);
$('header').hide();

myApp.config(function($routeProvider) {
	$routeProvider.when("/", {
		templateUrl : "views/carListView.htm",
		controller : "customerListControl"
	})

	.when("/delete", {
		controller : "js/controller/deleteCar",
	})

	.when("/update", {
		controller : "js/controller/updateCar",
		templateUrl : "views/updateModalView.htm"
	})

	.when("/add", {
		controller : "js/controller/addCars",
		templateUrl : "views/addModalView.htm"
	})
});

myApp.controller('customerListControl',['$scope','$http',function($scope, $http) {
	// Some constants for pagination
	$scope.currentPage = 1;
	$scope.itemsPerPage = 12;

	// Getting Cars JSON Object from REST Service
	$scope.getCars = function() {
		$http
		.get('/TFSession01/cars')
		.success(
				function(data) {
					$scope.cars = data;
					$scope.totalItems = $scope.cars.length;
				}).error(function() {
					console.log("error");
				});
	}
	$scope.getCars();

	// Setting pagination showing cards
	$scope.showCardNumber = function() {
		$scope.maxCard = $scope.maxCards();
	}

	$scope.maxCards = function() {
		console.log("maxCards log");
		if (($scope.currentPage * $scope.itemsPerPage) > $scope.totalItems) {
			return $scope.totalItems;
		} else {
			return $scope.currentPage
			* $scope.itemsPerPage;
		}
	}

	// Setting max cards size
	$scope.maxCard = $scope.maxCards();



	$scope.addItem = {
			"id" : -1,
			"updateTime" : "2016-10-03 11:31:02",
			"updatedBy" : "admin",
			"make" : "",
			"model" : "",
			"engineInCC" : "",
			"fuelCapacity" : "",
			"milage" : "",
			"price" : "",
			"roadTax" : "",
			"ac" : "",
			"powerSteering" : "",
			"accessoryKit" : ""
	}

	$scope.editedItem = {
			"id" : "",
			"updateTime" : "2016-10-03 11:31:02",
			"updatedBy" : "admin",
			"make" : "",
			"model" : "",
			"engineInCC" : "",
			"fuelCapacity" : "",
			"milage" : "",
			"price" : "",
			"roadTax" : "",
			"ac" : "",
			"powerSteering" : "",
			"accessoryKit" : ""
	}

} ]);
