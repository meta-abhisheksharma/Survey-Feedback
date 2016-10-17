package com.survey.dto;

import java.util.List;

import com.survey.model.Question;
import com.survey.model.Survey;

public class SurveyDTO {

	private List<QuestionDTO> questions;
	private String surveyType;
	private String surveyName;
	private String status;
	
	public String getSurveyType() {
		return surveyType;
	}

	public void setSurveyType(String surveyType) {
		this.surveyType = surveyType;
	}

	public String getSurveyName() {
		return surveyName;
	}

	public void setSurveyName(String surveyName) {
		this.surveyName = surveyName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<QuestionDTO> getQuestions() {
		return questions;
	}

	public void setQuestions(List<QuestionDTO> questions) {
		this.questions = questions;
	}	
}
