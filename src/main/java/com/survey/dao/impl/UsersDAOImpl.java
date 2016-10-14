package java.com.survey.dao.impl;

import java.com.survey.dao.UsersDAO;
import java.com.survey.model.Users;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("usersDAOImpl")
public class UsersDAOImpl implements UsersDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Users> getAll() {
		return null;
	}

	@Override
	public Users getByID(String userID) {
		return null;
	}

	@Override
	public void updateByID(String userID) {

	}

	@Override
	public void create(Users users) {

	}

	@Override
	public void deleteByID(String userID) {

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

}
