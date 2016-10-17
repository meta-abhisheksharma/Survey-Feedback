package com.survey.dao;

import java.util.List;

import com.survey.model.User;

public interface UsersDAO {
	
	public List<User> getAll();
	public User getByID(String userID);
	public void updateByID(String userID, User user);
	public void create(User user);
	public void deleteByID(String userID);
	
}
