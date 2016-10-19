myApp.controller('loginController',function($scope, $rootScope, $location,$http){
	
	$scope.saveUser=function(){
		$http.post('/rest/user/save',{
			params:{
				users:{name:'kuldeep'}
			}
		}).success(function(res){
			alert("ok");
		}).error(function(res){
			alert("not ok");
		});
	}
});