package com.survey.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "users_users")
public class UserUser {

	/* private String createdBy; */
	/* private String createdTo; */
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdTime;

	@ManyToOne
	@JoinColumn(name = "createdBy")
	private User createdBy;

	@ManyToOne
	@JoinColumn(name = "createdTo")
	private User createdTo;

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public User getCreatedTo() {
		return createdTo;
	}

	public void setCreatedTo(User createdTo) {
		this.createdTo = createdTo;
	}

}
