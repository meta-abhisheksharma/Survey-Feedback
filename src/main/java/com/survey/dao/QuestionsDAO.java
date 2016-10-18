package com.survey.dao;

import java.util.List;

import com.survey.model.Question;

public interface QuestionsDAO {
	public List<Question> getAll();
	public Question getByID(String questionID);
	public void create(Question questions);
	public void deleteByID(String questionID);
	public void updateByID(String questionID, Question question);
}
