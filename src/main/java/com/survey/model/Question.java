package java.com.survey.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Repository;

@Repository
@Entity
@Table(name = "questions")
public class Question {

	@Id
	@Column(name = "questionID", length = 30)
	private String questionId;

	@Column(name = "questionType", length = 1)
	private String questionType;

	@Column(name = "questionText", length = 200, nullable = false)
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

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "questions_options", joinColumns = { @JoinColumn(name = "questionID", referencedColumnName = "questionId") }, inverseJoinColumns = { @JoinColumn(name = "optionID", referencedColumnName = "optionId") })
	private Set<Options> optionList = new HashSet<Options>();

	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "questions_responses", joinColumns = @JoinColumn(name = "questionID"), inverseJoinColumns = @JoinColumn(name = "responseID"))
	private Responses responses = new Responses();

	@ManyToOne
	@JoinColumn(name = "createdBy")
	private Users createdBy;

	@ManyToOne
	@JoinColumn(name = "updatedBy")
	private Users updatedBy;

	@OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
	private Set<Options> questionOptions = new HashSet<Options>();

	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
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

	public Set<Options> getOptionList() {
		return optionList;
	}

	public void setOptionList(Set<Options> optionList) {
		this.optionList = optionList;
	}

	public Responses getResponses() {
		return responses;
	}

	public void setResponses(Responses responses) {
		this.responses = responses;
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

	public Set<Options> getQuestionOptions() {
		return questionOptions;
	}

	public void setQuestionOptions(Set<Options> questionOptions) {
		this.questionOptions = questionOptions;
	}

}
