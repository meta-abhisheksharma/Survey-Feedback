package com.survey.dto;

import java.util.List;

public class SurveyDTO {

	private List<QuestionDTO> questions;
	private String surveyType;
	private String surveyName;
	private String status;
	private String surveyID;
	
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

	/**
	 * @return the surveyID
	 */
	public String getSurveyID() {
		return surveyID;
	}

	/**
	 * @param surveyID the surveyID to set
	 */
	public void setSurveyID(String surveyID) {
		this.surveyID = surveyID;
	}	
}
