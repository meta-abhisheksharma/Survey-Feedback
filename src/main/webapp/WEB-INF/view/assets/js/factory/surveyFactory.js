angular.module("app").factory('SharedService',function($scope){
	var survey = {}; 
	survey.questions = [];
	alert("hii");
	return {
	    setSurvey: function (surveyData) {
	        survey = surveyData;
	    },
	    getSurvey: function () {
	        return survey;
	    }
	}
	
});