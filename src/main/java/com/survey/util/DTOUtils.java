package com.survey.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.survey.dto.OptionDTO;
import com.survey.dto.QuestionDTO;
import com.survey.dto.SurveyDTO;
import com.survey.dto.UserDTO;
import com.survey.model.Option;
import com.survey.model.Question;
import com.survey.model.Survey;
import com.survey.model.User;

public class DTOUtils {
	
	public static List<SurveyDTO> populateSurveyDTO(List<Survey> surveys){
		List<SurveyDTO> surveyDTOs = null;
		SurveyDTO surveyDTO = null;
		if(surveys!=null){
			surveyDTOs = new ArrayList<SurveyDTO>(surveys.size());
			for (Survey survey : surveys) {
				surveyDTO = new SurveyDTO();
				surveyDTO.setStatus(survey.getStatus());
				surveyDTO.setSurveyName(survey.getSurveyName());
				surveyDTO.setSurveyID(survey.getSurveyId());
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
			List<Option> optionList) {
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

	public static List<UserDTO> populateUserDTO(List<User> userList) {
		List<UserDTO> userDTOs = null;
		UserDTO userDTO = null;
		if(userList!=null){
			userDTOs = new ArrayList<UserDTO>(userList.size());
			for (User user : userList) {
				userDTO = new UserDTO();
				userDTO.setId(user.getId());
				userDTO.setName(user.getName());
				userDTO.setEmail(user.getEmail());
				userDTO.setUserRole(user.getUserRole());
				userDTO.setBlockUser(user.getBlockUser());	
				userDTO.setPicture(user.getPicture());
				userDTOs.add(userDTO);
			}
		}
		return userDTOs;	
	}
}
