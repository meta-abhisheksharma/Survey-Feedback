package main.java.com.survey.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import org.springframework.stereotype.Repository;

@Repository
@Entity
@Table(name="questions_responses")

public class QuestionResponse {

	private String questionID;
	private String responseID;
	
}