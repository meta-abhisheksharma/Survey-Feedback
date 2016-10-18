package com.survey.dao.Impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.survey.dao.QuestionsDAO;
import com.survey.model.Question;
import com.survey.model.Survey;

@Repository
public class QuestionDAOImpl implements QuestionsDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public List<Question> getAll() {
		Session session = sessionFactory.getCurrentSession();
		return (List<Question>)session.createCriteria(Question.class).list();
	}

	public Question getByID(String questionID) {
		// TODO Auto-generated method stub
		return null;
	}

	public void create(Question questions) {
		// TODO Auto-generated method stub
		
	}

	public void deleteByID(String questionID) {
		// TODO Auto-generated method stub
		
	}

	public void updateByID(String questionID, Question question) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Question> getBySurveyID(String surveyID) {
		Session session = sessionFactory.getCurrentSession();
		List<Question> questions =session.createCriteria(Survey.class)
		.add(Restrictions.eq("surveyID", surveyID))
		.list();
		
		return questions;
	}
}
