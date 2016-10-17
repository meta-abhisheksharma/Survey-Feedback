package com.survey.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.survey.dao.UsersDAO;
import com.survey.model.User;

@Component
public class UsersFacade {
	
	@Autowired
	UsersDAO userDAO;
	
	
	public List<User> getAll(){
		List<User>user = userDAO.getAll();
		return user;
	}

	public User getByID(String email) {
		return userDAO.getByID(email);
	}

	public boolean updateByID(String userID, User user) {
		try{
			userDAO.updateByID(userID,user);
			return true;
		}catch(Exception e){
			return false;
		}
	}


	public boolean create(User user) {
		try{
			userDAO.create(user);
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
