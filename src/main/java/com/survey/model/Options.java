package java.com.survey.model;

import java.com.survey.model.Question;
import java.com.survey.model.Users;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Repository;

@Repository
@Entity
@Table(name = "options")
public class Options {

	@Id
	@Column(name = "optionID", length = 30)
	private String optionID;

	@Column(name = "optionText", length = 100, nullable = false)
	private String optionText;

	@Column(name = "createdTime", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date CreatedTime;

	@Column(name = "updatedTime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date Updatedtime;

	@ManyToOne
	@JoinColumn(name = "createdBy")
	private Users createdBy;

	@ManyToOne
	@JoinColumn(name = "updatedBy")
	private Users updatedBy;

	@ManyToOne
	@JoinColumn(name = "nextQuestionID")
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

	public Users getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Users createdBy) {
		this.createdBy = createdBy;
	}

	public Users getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Users updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

}
