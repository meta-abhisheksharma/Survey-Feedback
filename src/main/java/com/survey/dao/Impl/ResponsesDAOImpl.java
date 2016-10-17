package com.survey.dao.Impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.survey.dao.ResponsesDAO;
import com.survey.model.Option;
import com.survey.model.Response;

@Repository
public class ResponsesDAOImpl implements ResponsesDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	public List<Response> getAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Response.class).list();
	}

	public Response getByID(String responseID) {
		Session session = sessionFactory.getCurrentSession();
		return (Response)session.get(Response.class, responseID);
	}

	public void updateByID(String responseID, Response response) {
		// TODO Auto-generated method stub
		
	}

	public void create(Response response) {
		// TODO Auto-generated method stub
		
	}

	public void deleteByID(String responseID) {
		// TODO Auto-generated method stub
		
	}
	
}
