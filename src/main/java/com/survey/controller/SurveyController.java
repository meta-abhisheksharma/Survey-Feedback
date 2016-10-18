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

import com.survey.dto.SurveyDTO;
import com.survey.facade.SurveyFacade;
import com.survey.model.Survey;

@RestController
@RequestMapping("/surveys")
public class SurveyController {
	
	@Autowired
	SurveyFacade surveyFacade;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<SurveyDTO>> getAll(){
		List<SurveyDTO> survey = surveyFacade.getAll();
		return new ResponseEntity<List<SurveyDTO>>(survey, HttpStatus.OK);
	}
	
	@RequestMapping(value="{surveyID}",method=RequestMethod.GET)
	public ResponseEntity<SurveyDTO> getByID(@PathVariable("surveyID") String surveyID){
		SurveyDTO survey = surveyFacade.getByID(surveyID);
		return new ResponseEntity<SurveyDTO>(survey,HttpStatus.OK);
	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<String> create(@RequestBody SurveyDTO surveyDTO){
		boolean value = surveyFacade.create(surveyDTO);
		if(value){
			return new ResponseEntity<String>("survey Created",HttpStatus.OK);
		}else{
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="{surveyID}",method=RequestMethod.PUT)
	public ResponseEntity<String> updateByID(@PathVariable("surveyID") String surveyID,@RequestBody Survey survey){
		boolean value = surveyFacade.updateByID(surveyID, survey);
		if(value){
			return new ResponseEntity<String>("survey Updated",HttpStatus.OK);
		}else{
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="{surveyID}",method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteByID(@PathVariable("surveyID") String surveyID){
		boolean value = surveyFacade.deleteByID(surveyID);
		if(value){
			return new ResponseEntity<String>("Survey deleted",HttpStatus.OK);
		}else{
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
