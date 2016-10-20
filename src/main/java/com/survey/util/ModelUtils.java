package com.survey.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.survey.dto.OptionDTO;
import com.survey.dto.QuestionDTO;
import com.survey.dto.SurveyDTO;
import com.survey.model.Option;
import com.survey.model.Question;
import com.survey.model.Survey;

public class ModelUtils {
	
	public static Survey populateSurvey(SurveyDTO surveyDTO){
		Survey survey = null;
		if(surveyDTO!=null){
			survey = new Survey();
			survey.setCreatedTime(new Date());
			survey.setSurveyName(surveyDTO.getSurveyName());
			survey.setStatus(surveyDTO.getStatus());
			survey.setLabel(surveyDTO.getLabel());
		//	survey.setSurveyId(surveyDTO.getSurveyID());
			survey.setSurveyType(surveyDTO.getSurveyType());
//			survey.setUser(surveyDTO.getUser());
			survey.setQuestionList(populateQuestion(surveyDTO.getQuestions()));
		}
		
		return survey;
	}
	
	public static List<Question> populateQuestion(List<QuestionDTO> questionDTOs){
		List<Question> questions = null;
		if(questionDTOs!=null){
			questions = new ArrayList<Question>();
			for (QuestionDTO questionDTO : questionDTOs) {
				Question question = new Question();
				question.setCreatedTime(new Date());
				//question.setQuestionId(questionDTO.getQuestionId());
				question.setQuestionText(questionDTO.getQuestionText());
				question.setQuestionType(questionDTO.getQuestionType());
				question.setOptionList(popuplateOption(questionDTO.getOptions()));
				//question.setCreatedBy();
				questions.add(question);
			}
		}
		return questions;
	}

	private static List<Option> popuplateOption(List<OptionDTO> optionDTOs) {
		List<Option> options = null;
		if(optionDTOs!=null){
			options = new ArrayList<Option>();
			for (OptionDTO optionDTO : optionDTOs) {
				Option option = new Option();
				option.setCreatedTime(new Date());
				/*option.setLinkedQuestion(optionDTO.getLinkedQuestionId());*/
				option.setOptionID(optionDTO.getOptionID());
				option.setOptionText(option.getOptionText());
				options.add(option);
			}
		}
		return options;
	}
}
