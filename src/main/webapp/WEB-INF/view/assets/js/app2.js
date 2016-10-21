var app = angular.module('app', ['ui.router']);

app.config(function($stateProvider, $urlRouterProvider) {
    
    $urlRouterProvider.otherwise('/home');
    
    $stateProvider
        
        // HOME STATES AND NESTED VIEWS ========================================
        .state('dashboard', {
            url: '/dashboard',
            templateUrl: 'assets/contentView/dashboardAdmin.htm'
        })
        
        // ABOUT PAGE AND MULTIPLE NAMED VIEWS =================================
        .state('addsurvey', {
        	url: '/addsurvey',
            templateUrl: 'assets/contentView/addSurvey.htm'      
        })
        
        .state('editsurvey', {
        	url: '/editsurvey',
            templateUrl: 'assets/contentView/addSurvey.html'      
        })
        
        .state('addquestion', {
        	url: '/addquestion',
            templateUrl: 'assets/contentView/addQuestions.htm'      
        })
        
         .state('surveylist', {
        	url: '/surveylist',
            templateUrl: 'assets/contentView/surveyList.htm'      
        }).state('userlist', {
        	url: '/admin/userlist',
            templateUrl: 'assets/contentView/userList.htm'      
        }).state('adduser', {
        	url: '/adduser',
            templateUrl: 'assets/contentView/addUser.htm'      
        });;
    
        
});
