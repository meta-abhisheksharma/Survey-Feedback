package com.survey.model;

public class GoogleAuthenticationPojo {

	private String picture;

	private String id;

	private String email;

	private String link;

	private String name;

	private String gender;

	private String family_name;

	private String given_name;

	private String verified_email;

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getFamily_name() {
		return family_name;
	}

	public void setFamily_name(String family_name) {
		this.family_name = family_name;
	}

	public String getGiven_name() {
		return given_name;
	}

	public void setGiven_name(String given_name) {
		this.given_name = given_name;
	}

	public String getVerified_email() {
		return verified_email;
	}

	public void setVerified_email(String verified_email) {
		this.verified_email = verified_email;
	}

	@Override
	public String toString() {
		return "ClassPojo [picture = " + picture + ", id = " + id
				+ ", email = " + email + ", link = " + link + ", name = "
				+ name + ", gender = " + gender + ", family_name = "
				+ family_name + ", given_name = " + given_name
				+ ", verified_email = " + verified_email + "]";
	}
}
