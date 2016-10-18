package main.java.com.survey.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import org.springframework.stereotype.Repository;

@Repository
@Entity
@Table(name="questions_options")
public class QuestionOptions {

	@GeneratedValue(generator="gen")
	@GenericGenerator(name="gen", strategy="foreign", parameters=@Parameter(name="property", value=""))

	
	private String optionID;
	private String questionID;
	
}
