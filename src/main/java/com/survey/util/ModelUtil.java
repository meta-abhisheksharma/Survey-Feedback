package com.survey.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.survey.dto.QuestionDTO;
import com.survey.dto.SurveyDTO;
import com.survey.model.Question;
import com.survey.model.Survey;

public class ModelUtil {
	
	public static Survey populateSurvey(SurveyDTO surveyDTO){
		Survey survey = null;
		if(surveyDTO!=null){
			survey = new Survey();
			survey.setCreatedTime(new Date());
			survey.setLabel("sad");
			survey.setStatus("N");
			survey.setQuestionList(populateQuestion(surveyDTO.getQuestions()));
		}
		
		return survey;
	}
	
	public static List<Question> populateQuestion(List<QuestionDTO> questionDTO){
		
		List<Question> questions = null;
		if(questionDTO!=null){
			questions = new ArrayList<Question>();
			for (QuestionDTO questiondto : questionDTO) {
				Question question = new Question();
				//question.setCreatedBy();
			}
		}
		return null;
		
	}
}
