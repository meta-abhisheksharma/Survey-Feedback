package com.survey.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.survey.dao.ResponsesDAO;
import com.survey.model.Response;

@Component
public class ResponsesFacade {
	
	@Autowired
	ResponsesDAO responsesDAO;

	public List<Response> getAll() {
		return responsesDAO.getAll();
	}

	public Response getByID(String responseID) {
		return responsesDAO.getByID(responseID);
	}

	
	public boolean create(Response response) {
		try{
			responsesDAO.create(response);
			return true;
		}catch(Exception e){
			return false;
		}
	}

	public boolean updateByID(String responseID, Response response) {
		try{
			responsesDAO.updateByID(responseID,response);
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
