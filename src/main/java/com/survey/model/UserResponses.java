package main.java.com.survey.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.stereotype.Repository;


@Repository
@Entity
@Table(name=" ")
public class UserResponses {


	private String userID;
	private String responseID;
	
}
