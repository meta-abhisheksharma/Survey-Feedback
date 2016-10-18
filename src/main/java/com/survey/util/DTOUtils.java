package com.survey.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.survey.dto.OptionDTO;
import com.survey.dto.QuestionDTO;
import com.survey.dto.SurveyDTO;
import com.survey.model.Option;
import com.survey.model.Question;
import com.survey.model.Survey;

public class DTOUtils {

	public static List<SurveyDTO> populateSurveyDTO(List<Survey> listOfSurvey){
		List<SurveyDTO> surveyDTOs = null;
		SurveyDTO surveyDTO = null;
		if(listOfSurvey!=null){
			surveyDTOs = new ArrayList<SurveyDTO>(listOfSurvey.size());
			for (Survey survey : listOfSurvey) {
				surveyDTO = new SurveyDTO();
				surveyDTO.setStatus(survey.getStatus());
				surveyDTO.setSurveyName(survey.getSurveyName());
				surveyDTO.setQuestions(populateQuestionDTO(survey.getQuestionList()));
				surveyDTOs.add(surveyDTO);
			}
		}
		return surveyDTOs;
	}
	
	public static List<QuestionDTO> populateQuestionDTO(List<Question> questions) {
		List<QuestionDTO> questionDTOs = null;
		QuestionDTO questionDTO = null;
		if (questions != null) {
			questionDTOs = new ArrayList<QuestionDTO>(questions.size());
			for (Question question : questions) {
				questionDTO = new QuestionDTO();
				questionDTO.setQuestionId(question.getQuestionId());
				questionDTO.setQuestionText(question.getQuestionText());
				questionDTO.setOptions(populateQuestionOptionDTO(question
						.getOptionList()));
				questionDTOs.add(questionDTO);
			}
		}
		return questionDTOs;
	}

	private static List<OptionDTO> populateQuestionOptionDTO(
			Set<Option> optionList) {
		List<OptionDTO> optionDTOs = null;
		OptionDTO optionDTO = null;
		if (optionList != null) {
			optionDTOs = new ArrayList<OptionDTO>(optionList.size());
			for (Option option : optionList) {
				optionDTO = new OptionDTO();
				optionDTO.setOptionID(option.getOptionID());
				optionDTO.setOptionText(option.getOptionText());
				optionDTO.setLinkedQuestionId(option.getLinkedQuestion()!=null?option.getLinkedQuestion().getQuestionId():null);
				optionDTOs.add(optionDTO);
			}
		}
		return optionDTOs;
	}
}
