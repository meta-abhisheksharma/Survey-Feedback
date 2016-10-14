<<<<<<< HEAD
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
@Table(name="surveys")
public class Surveys {

	@Id
	@Column(name="surveyID",length=30)
	private String surveyId;
	
	@Column(name="surveyName",nullable=false,length=40)
	private String surveyName;
	
	@Column(name="surveyType",length=10)
	private String surveyType;
	
	@Column(name="label",length=45)
	private String label;

	@Column(name="status",length=1)
	private String status;
	
	@Temporal(TemporalType.DATE)
	private Date createdTime;
	
	@Column(name="updatedBy",length=50)
	private String updatedBy;
	
	@Temporal(TemporalType.DATE)
	private Date updatedTime;
	
	
}
=======
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
@Table(name="surveys")
public class Surveys {

	@Id
	@Column(name="surveyID",length=30)
	private String surveyId;
	
	@Column(name="surveyName",nullable=false,length=40)
	private String surveyName;
	
	@Column(name="surveyType",length=10)
	private String surveyType;
	
	@Column(name="label",length=45)
	private String label;

	@Column(name="status",length=1)
	private String status;
	
	@Temporal(TemporalType.DATE)
	private Date createdTime;
	
	@Column(name="updatedBy",length=50)
	private String updatedBy;
	
	@Temporal(TemporalType.DATE)
	private Date updatedTime;
	
	
}
>>>>>>> a451c3793d78e7be25bd1abca38486b359fcf01d
