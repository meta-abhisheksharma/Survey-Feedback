package com.survey.dto;

import java.util.List;

import com.survey.model.Survey;

public class UserDTO {
	private String id;
	private String email;
	private String userRole;
	private String name;
	private String blockUser;
	private String picture;
	
	//private List<Surveys> surveys;
	
	/*public List<Surveys> getSurveys() {
		return surveys;
	}
	public void setSurveys(List<Surveys> surveys) {
		this.surveys = surveys;
	}*/
	
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getId() {
		return id;
	}
	public void setId(String i) {
		this.id = i;
	}
	
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
	public String getBlockUser() {
		return blockUser;
	}
	public void setBlockUser(String blockUser) {
		this.blockUser = blockUser;
	}
	
	
}
