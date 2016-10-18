package com.survey.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "options")
public class Option {

	@Id
	@GenericGenerator(name = "sequence_opt_id", strategy = "com.survey.service.OptionIdGenerator")
	@GeneratedValue(generator = "sequence_opt_id")
	@Column(name="optionID")
	private String optionID;
	
	private String optionText;
	private Date CreatedTime;
	private Date Updatedtime;

	@OneToOne
	@JoinColumn(name="linked_question_id")
	private Question linkedQuestion;
	
	@ManyToOne
	@JoinColumn(name = "createdBy")
	private User createdBy;

	@ManyToOne
	@JoinColumn(name = "updatedBy")
	private User updatedBy;

	@ManyToOne
	@JoinColumn(name="question_id")
	private Question question;

	public String getOptionID() {
		return optionID;
	}

	public void setOptionID(String optionID) {
		this.optionID = optionID;
	}

	public String getOptionText() {
		return optionText;
	}

	public void setOptionText(String optionText) {
		this.optionText = optionText;
	}

	public Date getCreatedTime() {
		return CreatedTime;
	}

	public void setCreatedTime(Date createdTime) {
		CreatedTime = createdTime;
	}

	public Date getUpdatedtime() {
		return Updatedtime;
	}

	public void setUpdatedtime(Date updatedtime) {
		Updatedtime = updatedtime;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public User getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(User updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Question getLinkedQuestion() {
		return linkedQuestion;
	}

	public void setLinkedQuestion(Question linkedQuestion) {
		this.linkedQuestion = linkedQuestion;
	}

	
}
