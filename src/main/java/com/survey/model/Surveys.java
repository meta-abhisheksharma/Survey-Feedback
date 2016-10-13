package java.com.survey.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Repository;


@Repository
@Entity
@Table(name="surveys")
public class Surveys {

	@Id
	@Column(name="surveyID",length=30,nullable=false)
	private String surveyId;
	
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
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name="surveys_questions", joinColumns = @JoinColumn(name="surveyID"),
	inverseJoinColumns = @JoinColumn(name="questionID"))
	private Question question=new Question();
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name="surveys_responses", joinColumns = @JoinColumn(name="surveyID"),
	inverseJoinColumns = @JoinColumn(name="responseID"))
	private Responses response=new Responses();

	public String getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(String surveyId) {
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

	public Question getQuestion() {
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
	}
	
}
