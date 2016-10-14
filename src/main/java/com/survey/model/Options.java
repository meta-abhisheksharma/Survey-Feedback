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
@Table(name="options")
public class Options {
	
	
	@Id
	@Column(name="optionID",length=30)
	private String optionID;
	
	@Column(name="optionText",length=100,nullable=false)
	private String optionText;
	
	@Column(name="nextQuestionID",length=30)
	private String nextQuestionId;
	
	@Column(name="createdBy",length=30,nullable=false)
	private String CreatedBy;
	
	@Column(name="createdTime",nullable=false)
	@Temporal(TemporalType.DATE)
	private Date CreatedTime;
	
	@Column(name="updatedBy",length=30)
	private String UpdatedBy;
	
	@Column(name="updatedTime")
	@Temporal(TemporalType.DATE)
	private Date Updatedtime;
	
	
	
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
@Table(name="options")
public class Options {
	
	
	@Id
	@Column(name="optionID",length=30)
	private String optionID;
	
	@Column(name="optionText",length=100,nullable=false)
	private String optionText;
	
	@Column(name="nextQuestionID",length=30)
	private String nextQuestionId;
	
	@Column(name="createdBy",length=30,nullable=false)
	private String CreatedBy;
	
	@Column(name="createdTime",nullable=false)
	@Temporal(TemporalType.DATE)
	private Date CreatedTime;
	
	@Column(name="updatedBy",length=30)
	private String UpdatedBy;
	
	@Column(name="updatedTime")
	@Temporal(TemporalType.DATE)
	private Date Updatedtime;
	
	
	
}
>>>>>>> a451c3793d78e7be25bd1abca38486b359fcf01d
