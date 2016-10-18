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

import com.survey.facade.ResponsesFacade;
import com.survey.model.Response;

@RestController
@RequestMapping("/responses")
public class ResponsesController {
	
	@Autowired
	ResponsesFacade responseFacade;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Response>> getAll(){
		return new ResponseEntity<List<Response>>(responseFacade.getAll(), HttpStatus.OK);
	}
	
	
	@RequestMapping(value="{responseID}",method=RequestMethod.GET)
	public ResponseEntity<Response> getByID(@PathVariable("responseID") String responseID){
		Response response = responseFacade.getByID(responseID);
		if(response !=null){
			return new ResponseEntity<Response>(response  , HttpStatus.OK);
		}else{
			return new ResponseEntity<Response>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<String> create(@RequestBody Response response){
		boolean value = responseFacade.create(response);
		if(value){
			return new ResponseEntity<String>("Response Created",HttpStatus.OK);
		}else{
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="{responseID}",method=RequestMethod.PUT)
	public ResponseEntity<String> updateByID(@PathVariable("responseID") String responseID,@RequestBody Response response){
		boolean value = responseFacade.updateByID(responseID, response);
		if(value){
			return new ResponseEntity<String>("Response Updated",HttpStatus.OK);
		}else{
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="{responseID}",method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteByID(@PathVariable("responseID") String responseID){
		boolean value = responseFacade.deleteByID(responseID);
		if(value){
			return new ResponseEntity<String>("Response deleted",HttpStatus.OK);
		}else{
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
