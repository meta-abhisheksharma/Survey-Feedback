package java.com.survey.controller;

import java.com.survey.facade.OptionsFacade;
import java.com.survey.model.Options;
import java.com.survey.model.Question;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class OptionsController {
	
	@Autowired
	OptionsFacade optionsFacade;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Options>> getAll(){
		return new ResponseEntity<List<Options>>(optionsFacade.getAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value="{optionID}",method=RequestMethod.GET)
	public ResponseEntity<Options> getByID(@PathVariable("optionID") String optionID){
		Options options = optionsFacade.getByID(optionID);
		if(options !=null){
			return new ResponseEntity<Options>(options  , HttpStatus.OK);
		}else{
			return new ResponseEntity<Options>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<String> create(@RequestBody Question question){
		boolean value = optionsFacade.create(question);
		if(value){
			return new ResponseEntity<String>("User Created",HttpStatus.OK);
		}else{
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="{optionID}",method=RequestMethod.PUT)
	public ResponseEntity<String> updateByID(@PathVariable("optionID") String optionID){
		boolean value = optionsFacade.updateByID(optionID);
		if(value){
			return new ResponseEntity<String>("User Updated",HttpStatus.OK);
		}else{
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="{optionID}",method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteByID(@PathVariable("optionID") String optionID){
		boolean value = optionsFacade.deleteByID(optionID);
		if(value){
			return new ResponseEntity<String>("User deleted",HttpStatus.OK);
		}else{
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
