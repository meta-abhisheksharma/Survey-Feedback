myApp.controller('loginController',function($scope, $rootScope, $location,$http){
	
	$scope.saveUser=function(){
		var obj={
				userId:new Date(),name:'kuldeep',password:'pass'
		};
		$http.post('/rest/user/save',obj).success(function(res){
			alert("ok");
		}).error(function(res){
			alert("not ok");
		});
	}
	
	$http.post('/rest/user/getAll').success(function(res){
		alert("ok");
	}).error(function(res){
		alert("not ok");
	});
});