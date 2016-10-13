var myApp = angular.module("myApp",["ui.router","ngRoute"]);

app.config(function($sceDelegateProvider) {
    $sceDelegateProvider.resourceUrlWhitelist([
        'http://localhost:8080/survey/**'
    ]);
});