package com.survey.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import org.springframework.stereotype.Repository;

@Repository
@Entity
@Table(name="surveys_responses")
public class SurveyResponses {

	
	private String responseID;
	private String surveyID;
}
