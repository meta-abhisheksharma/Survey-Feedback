package java.com.survey.facade;

import java.com.survey.dao.QuestionsDAO;
import java.com.survey.model.Question;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class QuestionsFacade {
	
	@Autowired
	QuestionsDAO questionsDAO;
	
	public List<Question> getAll() {
		return questionsDAO.getAll();
	}

	public Question getByID(String questionID) {
		return questionsDAO.getByID(questionID);
	}

	public boolean create(Question question) {
		try{
			questionsDAO.create(question);
			return true;
		}catch(Exception e){
			return false;
		}
	}

	public boolean updateByID(String questionID) {
		try{
			questionsDAO.updateByID(questionID);
			return true;
		}catch(Exception e){
			return false;
		}
	}

	public boolean deleteByID(String questionID) {
		try{
			questionsDAO.deleteByID(questionID);
			return true;
		}catch(Exception e){
			return false;
		}
	}

}
