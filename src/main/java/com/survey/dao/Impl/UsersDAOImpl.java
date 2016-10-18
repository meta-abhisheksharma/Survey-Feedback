package com.survey.dao.Impl;

import java.util.List;





import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.survey.dao.UsersDAO;
import com.survey.model.Survey;
import com.survey.model.User;

@Repository
public class UsersDAOImpl implements UsersDAO{
	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public List<User> getAll(){
		Session session = sessionFactory.getCurrentSession();
		List<User> user = session.createCriteria(User.class).list();	
		return user;
	}
	
	@Transactional
	public User getByID(String userID) {
		Session session = sessionFactory.getCurrentSession();
		return (User)session.get(User.class, userID);
	}

	@Transactional
	public void updateByID(String userID,User user) {
		Session session = sessionFactory.getCurrentSession();
		session.update(user);
	}

	@Transactional
	public void create(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
	}

	@Transactional
	public void deleteByID(String userID) {
		Session session = sessionFactory.getCurrentSession();
		User user = (User)session.get(User.class, userID);
		session.delete(user);
	}

	@Override
	public List<Survey> getSurvey(User user) {
		
		return null;
	}

	@Transactional
	public User getEmailAndPass(User user) {
		Session session = sessionFactory.getCurrentSession();
		Query query =  session.createQuery("from User where email = :email and password = :password");
		query.setParameter("email", user.getEmail());
		query.setParameter("password", user.getPassword());
		return (User) query.uniqueResult();
	}

	@Transactional
	public User getUserById(String userID) {
		Session session = sessionFactory.getCurrentSession();
		Query query =  session.createQuery("from User where userID = :userID");
		query.setParameter("userID", userID);
		
		return (User) query.uniqueResult();
	}
}
