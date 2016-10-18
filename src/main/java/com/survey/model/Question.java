package main.java.com.survey.model;

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


	@Temporal(TemporalType.TIMESTAMP)
	private Date CreatedTime;

	
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

}
