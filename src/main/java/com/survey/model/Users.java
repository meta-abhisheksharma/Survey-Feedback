package main.java.com.survey.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Repository;

@Repository
@Entity
@Table(name = "users")
public class Users {

	@Id
	@Column(name = "userID", length = 30, nullable = false)
	private String userId;
	@Column(name = "name", nullable = false, length = 45)
	private String name;
	@Column(name = "email", nullable = false, length = 90)
	private String email;

	@Column(name = "password", nullable = false, length = 45)
	private String password;

	@Column(name = "userRole", nullable = false, length = 15)
	private String userRole;

	@Column(name = "blockUser", length = 1)
	private String blockUser;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdTime;
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedTime;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "users_surveys", joinColumns = @JoinColumn(name = "userID"), inverseJoinColumns = @JoinColumn(name = "surveyID"))
	private Surveys survey = new Surveys();

	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "users_responses", joinColumns = @JoinColumn(name = "userID"), inverseJoinColumns = @JoinColumn(name = "responseID"))
	private Responses responses = new Responses();

	@OneToMany(mappedBy = "createdBy")
	private Set<Options> createOption = new HashSet<Options>();

	@OneToMany(mappedBy = "updatedBy")
	private Set<Options> updateOption = new HashSet<Options>();

	@OneToMany(mappedBy = "createdBy")
	private Set<Question> createQuestion = new HashSet<Question>();

	@OneToMany(mappedBy = "updatedBy")
	private Set<Question> updateQuestion = new HashSet<Question>();

	@OneToMany(mappedBy = "createdBy")
	private Set<UsersUsers> createdByUserList = new HashSet<UsersUsers>();

	@OneToMany(mappedBy = "createdTo")
	private Set<UsersUsers> createdToUserList = new HashSet<UsersUsers>();

}
