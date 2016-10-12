package main.java.com.survey.facade;

import java.util.List;

import main.java.com.survey.dao.UsersDAO;
import main.java.com.survey.model.Users;

import org.springframework.beans.factory.annotation.Autowired;

public class UsersFacade {
	
	@Autowired
	UsersDAO userDAO;
	
	public List<Users> getAll(){
		return userDAO.getAll();
	}
	
	public Users getByID(String userID){
		return userDAO.getByID(userID);
	}

	public boolean updateByID(String userID) {
		try{
			userDAO.updateByID(userID);
			return true;
		}catch(Exception e){
			return false;
		}
	}

	public boolean create(Users users) {
		try{
			userDAO.create(users);
			return true;
		}catch(Exception e){
			return false;
		}
	}

	public boolean deleteByID(String userID) {
		try{
			userDAO.deleteByID(userID);
			return true;
		}catch(Exception e){
			return false;
		}
	}
}
