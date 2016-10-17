package com.survey.dao;

import java.util.List;

import com.survey.model.Survey;

public interface SurveyDAO {

	public List<Survey> getAll();
	public Survey getByID(String surveyID);
	public void deleteByID(String surveyID);
	public void updateByID(String surveyID, Survey survey);
	public void create(Survey survey);

}
