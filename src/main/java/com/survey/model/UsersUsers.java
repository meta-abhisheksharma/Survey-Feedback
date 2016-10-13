package java.com.survey.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Repository;

@Repository
@Entity
@Table(name = " ")
public class UsersUsers {

	/* private String createdBy; */
	/* private String createdTo; */
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdTime;

	@ManyToOne
	@JoinColumn(name = "createdBy")
	private Users createdBy;

	@ManyToOne
	@JoinColumn(name = "createdTo")
	private Users createdTo;

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Users getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Users createdBy) {
		this.createdBy = createdBy;
	}

	public Users getCreatedTo() {
		return createdTo;
	}

	public void setCreatedTo(Users createdTo) {
		this.createdTo = createdTo;
	}

}
