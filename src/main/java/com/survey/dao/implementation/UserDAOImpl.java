package java.com.survey.dao.implementation;

import java.com.survey.dao.UsersDAO;
import java.com.survey.model.Users;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

public class UserDAOImpl implements UsersDAO {

	@Autowired
	SessionFactory factory;

	@Override
	public List<Users> getAll() {
		Session session = factory.openSession();
		Transaction t = null;
		try {
			t = session.beginTransaction();
			Criteria criteria = session.createCriteria(Users.class); // criteria
																		// Query
			List<Users> listOfUsers = criteria.list();
			t.commit();// transaction is committed
			return listOfUsers;
		} catch (HibernateException e) {
			if (t != null)
				t.rollback();
			return null;
		} finally {
			session.close();

		}

	}

	@Override
	public Users getByID(String userID) {
		
		Session session = factory.openSession();
		Users user = null;
		Transaction t = null;
		try {
			t = session.beginTransaction();
			Criteria criteria = session.createCriteria(Users.class); 
			 criteria.add(Restrictions.eq("userID", userID));
			List<Users> userList= criteria.list();
			Iterator iterator=userList.iterator();
			while(iterator.hasNext()){
				
				 user=(Users) iterator.next();
			
			}
			
			 t.commit();
			 return user;
		}catch (HibernateException e) {
			if (t != null)
				t.rollback();
			return null;
		} finally {
			session.close();

		}
		
	}

	@Override
	public void updateByID(String userID) {
		
		// TODO Auto-generated method stub

	}

	@Override
	public void create(Users users) {
		
		//creating session object  
	    Session session=factory.openSession();  
	    Transaction t=null;
	    //creating transaction object  
	    try{
	   t=session.beginTransaction();  
	    Criteria criteria = session.createCriteria(Users.class);
	    session.save(users);
	    t.commit();//transaction is committed  
	    }catch(HibernateException e){
	    	 if (t!=null) t.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	   
	

	}

	@Override
	public void deleteByID(String userID) {
		// TODO Auto-generated method stub

	}

}
