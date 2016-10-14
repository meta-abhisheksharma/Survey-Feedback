package com.survey.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import org.springframework.stereotype.Repository;

@Repository
@Entity
@Table(name="surveys_questions")
public class SurveyQuestions {

	private String surveyID;
	private String questionID;
	
}
