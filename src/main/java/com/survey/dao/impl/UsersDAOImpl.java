package com.survey.dao.impl;



import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.survey.dao.UsersDAO;
import com.survey.model.Users;

@Component("usersDAO")
@Transactional
public class UsersDAOImpl implements UsersDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
	    return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
	    this.sessionFactory = sessionFactory;
	}

	@Override
	public void create(Users users) {
			String created=null;
			Transaction trans=null;
			try {
				Session session = this.sessionFactory.getCurrentSession();
				//session.beginTransaction();
				trans=session.beginTransaction();
				 created=  (String) session.save(users);
				trans.commit();
			} catch (Exception ex) {
				ex.printStackTrace();
				trans.commit();
			}

			
		
	}

	

	public void getByEmailAndPassword(String email, String password) {
		Session session = this.sessionFactory.openSession();
		try {
			session.beginTransaction();
			String hql = "from Users where email = :email and password = :password";

			Query query = session.createQuery(hql);
			query.setParameter(email, email);
			query.setParameter(password, password);
			List<Users> result = query.list();

			System.out.println("resultset:" + result);

			Iterator<Users> iterator = result.iterator();
			while (iterator.hasNext()) {
				System.out.println(iterator.next().getName());
			}
		} catch (HibernateException e) {
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
		} finally {
			session.close();
		}
	}



	@Override
	public List<Users> getAll() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Users getByID(String userID) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void updateByID(String userID) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void deleteByID(String userID) {
		// TODO Auto-generated method stub
		
	}

}
