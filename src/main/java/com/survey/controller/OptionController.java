package com.survey.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.survey.facade.OptionsFacade;
import com.survey.model.Option;

@RestController
@RequestMapping("/options")
public class OptionController {
	@Autowired
	OptionsFacade optionsFacade;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Option>> getAll(){
		List<Option> option = optionsFacade.getAll();
		return new ResponseEntity<List<Option>>(option, HttpStatus.OK);
	}
	
	@RequestMapping(value="{optionID}",method=RequestMethod.GET)
	public ResponseEntity<Option> getByID(@PathVariable("optionID") String optionID){
		Option option = optionsFacade.getByID(optionID);
		if(option !=null){
			return new ResponseEntity<Option>(option  , HttpStatus.OK);
		}else{
			return new ResponseEntity<Option>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<String> create(@RequestBody Option option){
		boolean value = optionsFacade.create(option);
		if(value){
			return new ResponseEntity<String>("Option Created",HttpStatus.OK);
		}else{
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="{optionID}",method=RequestMethod.PUT)
	public ResponseEntity<String> updateByID(@PathVariable("optionID") String optionID,@RequestBody Option option){
		boolean value = optionsFacade.updateByID(optionID, option);
		if(value){
			return new ResponseEntity<String>("option Updated",HttpStatus.OK);
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
