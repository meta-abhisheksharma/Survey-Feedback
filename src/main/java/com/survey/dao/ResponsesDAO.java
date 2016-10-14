package java.com.survey.dao;

import java.com.survey.model.Responses;
import java.util.List;

public interface ResponsesDAO {

	public List<Responses> getAll();
	public Responses getByID(String responseID);
	public void updateByID(String responseID);
	public void create(Responses response);
	public void deleteByID(String responseID);
	
}
