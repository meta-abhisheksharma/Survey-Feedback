package java.com.survey.facade;

import java.com.survey.dao.ResponsesDAO;
import java.com.survey.model.Responses;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class ResponsesFacade {
	
	@Autowired
	ResponsesDAO responsesDAO;

	public List<Responses> getAll() {
		return responsesDAO.getAll();
	}

	public Responses getByID(String responseID) {
		return responsesDAO.getByID(responseID);
	}

	public boolean create(Responses response) {
		try{
			responsesDAO.create(response);
			return true;
		}catch(Exception e){
			return false;
		}
	}

	public boolean updateByID(String responseID) {
		try{
			responsesDAO.updateByID(responseID);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	public boolean deleteByID(String responseID) {
		try{
			responsesDAO.deleteByID(responseID);
			return true;
		}catch(Exception e){
			return false;
		}
	}

}
