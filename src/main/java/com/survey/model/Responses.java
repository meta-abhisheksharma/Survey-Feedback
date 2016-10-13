package java.com.survey.model;

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
@Table(name = "responses")
public class Responses {

	@Id
	@Column(name = "responseID", length = 30, nullable = false)
	private String responseID;

	@Column(name = "updatedTime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedTime;

	@Column(name = "createdTime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdTime;

	@Column(name = "responseText", length = 100, nullable = false)
	private String responseText;
	

	public String getResponseID() {
		return responseID;
	}

	public void setResponseID(String responseID) {
		this.responseID = responseID;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public String getResponseText() {
		return responseText;
	}

	public void setResponseText(String responseText) {
		this.responseText = responseText;
	}

}
