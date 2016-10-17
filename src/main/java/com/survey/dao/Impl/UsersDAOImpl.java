package com.survey.dao.Impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.survey.dao.UsersDAO;
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
	public User getByID(String email) {
		Session session = sessionFactory.getCurrentSession();
		User user = (User)session.createCriteria(User.class)
				.add(Restrictions.eq("email", email))
				.setMaxResults(1)
				.uniqueResult();
		System.out.println(user.getEmail());
		return user;
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
}
