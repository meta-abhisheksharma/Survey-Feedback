package com.survey.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.survey.dao.QuestionsDAO;
import com.survey.dto.SurveyDTO;
import com.survey.model.Question;
import com.survey.model.Survey;
import com.survey.util.DTOUtils;

@Component
public class QuestionsFacade {

	@Autowired
	QuestionsDAO questionsDAO;

	@Transactional
	public SurveyDTO getAll() {
		SurveyDTO surveyDTO = new SurveyDTO();
		List<Question> questions = null;
		questions = questionsDAO.getAll();
		surveyDTO.setQuestions(DTOUtils.populateQuestionDTO(questions));
		return surveyDTO;
	}

	public Question getByID(String questionID) {
		return questionsDAO.getByID(questionID);
	}

	public boolean create(Question question) {
		try {
			questionsDAO.create(question);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean updateByID(String questionID, Question question) {
		try {
			questionsDAO.updateByID(questionID, question);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean deleteByID(String questionID) {
		try {
			questionsDAO.deleteByID(questionID);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public List<Question> getBySurveyID(String surveyID){
		return questionsDAO.getBySurveyID(surveyID);
	}

}
