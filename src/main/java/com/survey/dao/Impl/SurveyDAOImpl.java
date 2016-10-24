package com.survey.dao.Impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.survey.dao.SurveyDAO;
import com.survey.model.Survey;

@Repository
public class SurveyDAOImpl implements SurveyDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	public List<Survey> getAll() {
		Session session = sessionFactory.getCurrentSession();
		List<Survey> survey = session.createCriteria(Survey.class).list();	
		return survey;
	}

	public Survey getByID(String surveyID) {
		Session session = sessionFactory.getCurrentSession();
		return (Survey)session.get(Survey.class, surveyID);
	}

	public void deleteByID(String surveyID) {
		Session session = sessionFactory.getCurrentSession();
		Survey survey = (Survey)session.get(Survey.class, surveyID);
		session.delete(survey);
	}

	public void updateByID(String surveyID, Survey survey) {
		Session session = sessionFactory.getCurrentSession();
		session.update(survey);
	}

	public void create(Survey survey) {
		Session session = sessionFactory.getCurrentSession();
		session.save(survey);
	}

}
