package java.com.survey.controller;

import java.com.survey.facade.QuestionsFacade;
import java.com.survey.model.Question;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class QuestionsController {
	
	@Autowired
	QuestionsFacade questionsFacade;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Question>> getAll(){
		return new ResponseEntity<List<Question>>(questionsFacade.getAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value="{questionID}",method=RequestMethod.GET)
	public ResponseEntity<Question> getByID(@PathVariable("questionID") String questionID){
		Question question = questionsFacade.getByID(questionID);
		if(question!=null){
			return new ResponseEntity<Question>(question , HttpStatus.OK);
		}else{
			return new ResponseEntity<Question>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<String> create(@RequestBody Question question){
		boolean value = questionsFacade.create(question);
		if(value){
			return new ResponseEntity<String>("User Created",HttpStatus.OK);
		}else{
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="{questionID}",method=RequestMethod.PUT)
	public ResponseEntity<String> updateByID(@PathVariable("questionID") String questionID){
		boolean value = questionsFacade.updateByID(questionID);
		if(value){
			return new ResponseEntity<String>("User Updated",HttpStatus.OK);
		}else{
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="{questionID}",method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteByID(@PathVariable("questionID") String questionID){
		boolean value = questionsFacade.deleteByID(questionID);
		if(value){
			return new ResponseEntity<String>("User deleted",HttpStatus.OK);
		}else{
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
