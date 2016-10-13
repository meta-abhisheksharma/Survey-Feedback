package java.com.survey.model;

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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getBlockUser() {
		return blockUser;
	}

	public void setBlockUser(String blockUser) {
		this.blockUser = blockUser;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	public Surveys getSurvey() {
		return survey;
	}

	public void setSurvey(Surveys survey) {
		this.survey = survey;
	}

	public Responses getResponses() {
		return responses;
	}

	public void setResponses(Responses responses) {
		this.responses = responses;
	}

	public Set<Options> getCreateOption() {
		return createOption;
	}

	public void setCreateOption(Set<Options> createOption) {
		this.createOption = createOption;
	}

	public Set<Options> getUpdateOption() {
		return updateOption;
	}

	public void setUpdateOption(Set<Options> updateOption) {
		this.updateOption = updateOption;
	}

	public Set<Question> getCreateQuestion() {
		return createQuestion;
	}

	public void setCreateQuestion(Set<Question> createQuestion) {
		this.createQuestion = createQuestion;
	}

	public Set<Question> getUpdateQuestion() {
		return updateQuestion;
	}

	public void setUpdateQuestion(Set<Question> updateQuestion) {
		this.updateQuestion = updateQuestion;
	}

	public Set<UsersUsers> getCreatedByUserList() {
		return createdByUserList;
	}

	public void setCreatedByUserList(Set<UsersUsers> createdByUserList) {
		this.createdByUserList = createdByUserList;
	}

	public Set<UsersUsers> getCreatedToUserList() {
		return createdToUserList;
	}

	public void setCreatedToUserList(Set<UsersUsers> createdToUserList) {
		this.createdToUserList = createdToUserList;
	}

}
