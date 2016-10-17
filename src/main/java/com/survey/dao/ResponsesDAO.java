package com.survey.dao;

import java.util.List;

import com.survey.model.Response;



public interface ResponsesDAO {

	public List<Response> getAll();
	public Response getByID(String responseID);
	public void updateByID(String responseID, Response response);
	public void create(Response response);
	public void deleteByID(String responseID);
	
}
