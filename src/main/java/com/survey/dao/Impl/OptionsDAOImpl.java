package com.survey.dao.Impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.survey.dao.OptionsDAO;
import com.survey.model.Option;

@Repository
public class OptionsDAOImpl implements OptionsDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public List<Option> getAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Option.class).list();
	}

	@Transactional
	public Option getByID(String optionID) {
		Session session = sessionFactory.getCurrentSession();
		return (Option)session.get(Option.class, optionID);
	}

	@Transactional
	public void updateByID(String optionID, Option option) {
		Session session = sessionFactory.getCurrentSession();
		session.update(option);
	}

	@Transactional
	public void create(Option option) {
		Session session = sessionFactory.getCurrentSession();
		session.save(option);
	}

	@Transactional
	public void deleteByID(String optionID) {
		Session session = sessionFactory.getCurrentSession();
		Option option = (Option)session.get(Option.class, optionID);
		session.delete(option);
	}

}
