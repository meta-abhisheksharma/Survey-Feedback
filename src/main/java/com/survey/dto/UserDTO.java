package com.survey.dto;

import java.util.List;

import com.survey.model.Survey;

public class UserDTO {
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String i) {
		this.id = i;
	}
	private String email;
	private String userRole;
	private String name;
	//private List<Surveys> surveys;
	
	/*public List<Surveys> getSurveys() {
		return surveys;
	}
	public void setSurveys(List<Surveys> surveys) {
		this.surveys = surveys;
	}*/
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	
	
}
