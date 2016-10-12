package main.java.com.survey.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.stereotype.Repository;


@Repository
@Entity
@Table(name="users")
public class Users {
	
	@Id
	@Column(name="userID",length=30)
	private String userId;
	@Column(name="name",nullable=false,length=45)
	private	String name;
	@Column(name="email",nullable=false,length=90)
	private String email;
	
	@Column(name="password",nullable=false,length=45)
	private String password;
	
	@Column(name="userRole",nullable=false,length=15)
	private String userRole;
	
	@Column(name="blockUser",length=1)
	private String blockUser;
	@Temporal(TemporalType.DATE)
	private Date createdTime;
	@Temporal(TemporalType.DATE)
	private Date updatedTime;
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
	

}
