package com.survey.model;

import java.util.ArrayList;
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
@Table(name = "questions")
public class Question {

	@Id
	@Column(name = "questionID", length = 30)
	@GeneratedValue
	/*@GenericGenerator(name = "sequence_que_id", strategy = "com.survey.service.QuestionIdGenerator")
	@GeneratedValue(generator = "sequence_que_id")*/
	private Integer questionId;
	private String questionType;
	private String questionText;

	/*
	 * @Column(name="createdBy",length=30,nullable=false) private String
	 * CreatedBy;
	 */
	@Temporal(TemporalType.TIMESTAMP)
	private Date CreatedTime;

	/*
	 * @Column(name="updatedBy",length=30) private String UpdatedBy;
	 */
	@Temporal(TemporalType.TIMESTAMP)
	private Date UpdatedTime;

	@OneToMany(mappedBy="question",cascade = CascadeType.ALL)
	private List<Option> optionList=new ArrayList<Option>();

	@ManyToOne()
	@JoinColumn(name="surveyID")
	private Survey survey;


	public List<Option> getOptionList() {
		return optionList;
	}

	public void setOptionList(List<Option> optionList) {
		this.optionList = optionList;
	}

	/*
	 * @OneToOne(cascade = CascadeType.ALL)
	 * 
	 * @JoinTable(name = "questions_responses", joinColumns = @JoinColumn(name =
	 * "questionID"), inverseJoinColumns = @JoinColumn(name = "responseID"))
	 * private Responses responses = new Responses();
	 */
	@ManyToOne
	@JoinColumn(name = "createdBy")
	private User createdBy;

	@ManyToOne
	@JoinColumn(name = "updatedBy")
	private User updatedBy;

	/*
	 * @OneToMany(mappedBy = "question", cascade = CascadeType.ALL) private
	 * Set<Options> questionOptions = new HashSet<Options>();
	 */
	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public String getQuestionType() {
		return questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public Date getCreatedTime() {
		return CreatedTime;
	}

	public void setCreatedTime(Date createdTime) {
		CreatedTime = createdTime;
	}

	public Date getUpdatedTime() {
		return UpdatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		UpdatedTime = updatedTime;
	}

	/*
	 * public Responses getResponses() { return responses; }
	 * 
	 * public void setResponses(Responses responses) { this.responses =
	 * responses; }
	 */
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

	/*
	 * public Set<Options> getQuestionOptions() { return questionOptions; }
	 * 
	 * public void setQuestionOptions(Set<Options> questionOptions) {
	 * this.questionOptions = questionOptions; }
	 */

}
