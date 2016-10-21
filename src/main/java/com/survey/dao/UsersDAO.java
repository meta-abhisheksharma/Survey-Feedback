package com.survey.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.survey.model.Survey;
import com.survey.model.User;

public interface UsersDAO {
	
	public List<User> getAll();
	public User getByID(String userID);
	public void updateByID(String userID, User user);
	public void create(User user);
	public void deleteByID(String userID);
	public List<Survey> getSurvey(User user);
	public User getEmailAndPass(User user);
	public User getUserById(String id);
	public User getUserByEmail(String email);
	public List<String> getUserRoleSet();
}
