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
	
	
	/**
	 * This method call the surveyFacade getAll method to return all the survey
	 * list
	 * 
	 * @return responseEntity Object which contain the list of surveyDTO and
	 *         httpStatus code if survey list is present else it will return the
	 *         httpStatus code
	 */
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<SurveyDTO>> getAll(){
		List<SurveyDTO> survey = surveyFacade.getAll();
		return new ResponseEntity<List<SurveyDTO>>(survey, HttpStatus.OK);
	}
	
	
	/**
	 * This method call the surveyFacade getByID method to get the surveyDTO
	 * 
	 * @param surveyID
	 *            is String type parameter which represents unique
	 *            identification of the survey
	 * @return responseEntity Object which contain the list of surveyDTO and
	 *         httpStatus code if survey list is present else it will return the
	 *         httpStatus code
	 */
	@RequestMapping(value="{surveyID}",method=RequestMethod.GET)
	public ResponseEntity<SurveyDTO> getByID(@PathVariable("surveyID") String surveyID){
		SurveyDTO survey = surveyFacade.getByID(surveyID);
		return new ResponseEntity<SurveyDTO>(survey,HttpStatus.OK);
	}
	
	/**
	 * This method is used to create the survey by calling the surveyFacade
	 * create method
	 * 
	 * @param surveyDTO
	 *            is object which contains the information of survey like
	 *            question list,option list and name of survey etc.
	 * @return responseEntity object which contain the httpStatus code ok if
	 *         surveyDTO is created else return the internal_server_error if it
	 *         is not created.
	 */
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> create(@RequestBody SurveyDTO surveyDTO){
		boolean value = surveyFacade.create(surveyDTO);
		if(value){
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else{
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * This method is used to update the survey by calling the surveyFacade
	 * updateByID method
	 * 
	 * @param surveyID
	 *            is String type parameter which represents unique
	 *            identification of the survey
	 * @param survey
	 *            is object of Survey which is updated into database
	 * @return responseEntity object which contain the httpStatus code ok if
	 *         surveyDTO is updated else return the internal_server_error if it
	 *         is not updated.
	 */
	@RequestMapping(value="{surveyID}",method=RequestMethod.PUT)
	public ResponseEntity<Void> updateByID(@PathVariable("surveyID") String surveyID,@RequestBody Survey survey){
		boolean value = surveyFacade.updateByID(surveyID, survey);
		if(value){
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else{
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * This method is used to delete the survey by calling the surveyFacade
	 * deleteByID method.
	 * 
	 * @param surveyID
	 *            is String type parameter which represents unique
	 *            identification of the survey
	 * @return responseEntity object which contain the httpStatus code ok if
	 *         surveyDTO is deleted else return the internal_server_error if it
	 *         is not deleted.
	 */
	@RequestMapping(value="{surveyID}",method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteByID(@PathVariable("surveyID") String surveyID){
		boolean value = surveyFacade.deleteByID(surveyID);
		if(value){
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else{
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
