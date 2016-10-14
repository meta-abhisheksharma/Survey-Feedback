package java.com.survey.dao;

import java.com.survey.model.Question;
import java.util.List;

public interface QuestionsDAO {
	public List<Question> getAll();
	public Question getByID(String questionID);
	public void create(Question questions);
	public void deleteByID(String questionID);
	public void updateByID(String questionID);
}
