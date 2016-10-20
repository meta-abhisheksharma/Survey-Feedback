package com.survey.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="surveys")
public class Survey {

	@Id
	@Column(name="surveyID",nullable=false)
	@GeneratedValue
	/*@GenericGenerator(name = "sequence_survey_id", strategy = "com.survey.service.ResponseIdGenerator")
	@GeneratedValue(generator = "sequence_survey_id")
	*/private Integer surveyId;
	
	@Column(name="surveyName",nullable=false,length=40)
	private String surveyName;
	
	@Column(name="surveyType",length=10)
	private String surveyType;
	
	@Column(name="label",length=45)
	private String label;

	@Column(name="status",length=1)
	private String status;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdTime;
	
	@Column(name="updatedBy",length=50)
	private String updatedBy;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedTime;
	
	@OneToMany(mappedBy="survey",cascade=CascadeType.ALL)
	private List<Question> questionList;
	
	@ManyToOne
	@JoinColumn(name = "userID")
	private User user;
	
	
	/*@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name="surveys_questions", joinColumns = @JoinColumn(name="surveyID"),
	inverseJoinColumns = @JoinColumn(name="questionID"))
	private Question question=new Question();
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name="surveys_responses", joinColumns = @JoinColumn(name="surveyID"),
	inverseJoinColumns = @JoinColumn(name="responseID"))
	private Responses response=new Responses();
*/
	
	public List<Question> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(List<Question> questionList) {
		this.questionList = questionList;
	}
	
	public Integer getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(Integer surveyId) {
		this.surveyId = surveyId;
	}

	public String getSurveyName() {
		return surveyName;
	}

	public void setSurveyName(String surveyName) {
		this.surveyName = surveyName;
	}

	public String getSurveyType() {
		return surveyType;
	}

	public void setSurveyType(String surveyType) {
		this.surveyType = surveyType;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/*public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Responses getResponse() {
		return response;
	}

	public void setResponse(Responses response) {
		this.response = response;
	}*/
	
}
