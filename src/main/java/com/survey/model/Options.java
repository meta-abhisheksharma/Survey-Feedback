package main.java.com.survey.model;

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

}
