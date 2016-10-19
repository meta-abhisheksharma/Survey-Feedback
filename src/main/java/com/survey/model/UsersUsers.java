package com.survey.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Repository;


@Repository
@Entity
@Table(name=" ")

public class UsersUsers {

	private String createdBy;
	private String createdTo;
	@Temporal(TemporalType.DATE)
	private Date createdTime;
	
}
