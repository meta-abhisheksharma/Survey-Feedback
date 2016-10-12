package main.java.com.survey.dao;

import java.util.List;

import main.java.com.survey.model.Users;

public interface UsersDAO {
	public List<Users> getAll();
	public Users getByID(String userID);
	public void updateByID(String userID);
	public void create(Users users);
	public void deleteByID(String userID);
}
