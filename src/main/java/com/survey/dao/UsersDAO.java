package java.com.survey.dao;

import java.com.survey.model.Users;
import java.util.List;

public interface UsersDAO {
	public List<Users> getAll();
	public Users getByID(String userID);
	public void updateByID(String userID);
	public void create(Users users);
	public void deleteByID(String userID);
}
