package com.survey.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.stereotype.Repository;


@Repository
@Entity
@Table(name="questions")
public class Question {
	
	@Id
	@Column(name="questionID",length=30)
	private String questionId;
	
	@Column(name="questionType",length=1)
	private String questionType;
	
	@Column(name="questionText",length=200,nullable=false)
	private String questionText;
	
	@Column(name="createdBy",length=30,nullable=false)
	private String CreatedBy;
	
	@Temporal(TemporalType.DATE)
	private Date CreatedTime;
	
	@Column(name="updatedBy",length=30)
	private String UpdatedBy;
	
	@Temporal(TemporalType.DATE)
	private Date UpdatedTime;
	
	
}
