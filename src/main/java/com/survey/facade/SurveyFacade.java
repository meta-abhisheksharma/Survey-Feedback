package com.survey.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.survey.dao.SurveyDAO;
import com.survey.dto.SurveyDTO;
import com.survey.model.Option;
import com.survey.model.Question;
import com.survey.model.Survey;
import com.survey.util.DTOUtils;
import com.survey.util.ModelUtils;

@Service
public class SurveyFacade {

	@Autowired
	SurveyDAO surveyDAO;
	
	@Transactional
	public List<SurveyDTO> getAll() {
		List<Survey> surveys = surveyDAO.getAll();
		return DTOUtils.populateSurveyDTO(surveys);
	}

	@Transactional
	public SurveyDTO getByID(String surveyID) {
		Survey survey = surveyDAO.getByID(surveyID);
		List<Survey> surveys = new ArrayList<Survey>(1);
		surveys.add(survey);
		SurveyDTO surveyDTO = DTOUtils.populateSurveyDTO(surveys).get(0);
		return surveyDTO;
	}

	@Transactional
	public boolean create(SurveyDTO surveyDTO) {
		try {
		
			Survey survey = ModelUtils.populateSurvey(surveyDTO);
			List<Question> questionList=survey.getQuestionList();
			for (Question question : questionList) {
				
				question.setSurvey(survey);
				List<Option> optionList=question.getOptionList();
				for (Option option : optionList) {
					
					option.setQuestion(question);
				}
			}
			surveyDAO.create(survey);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean deleteByID(String surveyID) {
		try {
			surveyDAO.deleteByID(surveyID);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean updateByID(String surveyID, Survey survey) {
		try {
			surveyDAO.updateByID(surveyID,survey);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
