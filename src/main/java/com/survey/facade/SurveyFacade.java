package com.survey.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.survey.dao.SurveyDAO;
import com.survey.dto.SurveyDTO;
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
		SurveyDTO surveyDTO = new SurveyDTO();
		Survey survey = surveyDAO.getByID(surveyID);
		surveyDTO.setQuestions(DTOUtils.populateQuestionDTO(survey.getQuestionList()));
		return surveyDTO;
	}

	
	public boolean create(SurveyDTO surveyDTO) {
		try {
			Survey survey = ModelUtils.populateSurvey(surveyDTO);
			surveyDAO.create(survey);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteByID(String surveyID) {
		try {
			surveyDAO.deleteByID(surveyID);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean updateByID(String surveyID, Survey survey) {
		try {
			surveyDAO.updateByID(surveyID,survey);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
