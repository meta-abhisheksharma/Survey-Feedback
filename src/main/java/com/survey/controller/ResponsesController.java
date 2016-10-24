package com.survey.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.survey.dto.ResponseDTO;
import com.survey.dto.SurveyDTO;
import com.survey.facade.ResponsesFacade;
import com.survey.facade.SurveyFacade;
import com.survey.model.Response;

@RestController
@RequestMapping("/responses")
public class ResponsesController {
	
	@Autowired
	ResponsesFacade responseFacade;
	@Autowired
	SurveyFacade surveyFacade;
	
	/**
	 * This method call the responseFacade getAll method to return  the response
	 * list
	 * 
	 * @return responseEntity Object which contain the list of response and
	 *         httpStatus code if response list is present else it will return the
	 *         httpStatus code
	 */
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Response>> getAll(){
		return new ResponseEntity<List<Response>>(responseFacade.getAll(), HttpStatus.OK);
	}
	
	
	/**
	 * This method call the responseFacade getByID method to get the responseDTO
	 * 
	 * @param responseID
	 *            is String type parameter which represents unique
	 *            identification of the response
	 * @return responseEntity Object which contain the list of responseDTO and
	 *         httpStatus code if response list is present else it will return the
	 *         httpStatus code
	 */
	
	@RequestMapping(value="{responseID}",method=RequestMethod.GET)
	public ResponseEntity<Response> getByID(@PathVariable("responseID") String responseID){
		Response response = responseFacade.getByID(responseID);
		if(response !=null){
			return new ResponseEntity<Response>(response  , HttpStatus.OK);
		}else{
			return new ResponseEntity<Response>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * This method is used to create the response by calling the responseFacade
	 * create method
	 * 
	 * @param respons
	 *            is object which contains the information of response like
	 *           surveyID,questionID etc
	 * @return responseEntity object which contain the httpStatus code ok if
	 *         response is successfully created else return the internal_server_error if it
	 *         is not created.
	 */
	
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<String> create(@RequestBody Response response){
		boolean value = responseFacade.create(response);
		if(value){
			return new ResponseEntity<String>("Response Created",HttpStatus.OK);
		}else{
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	/**
	 * This method is used to update the response by calling the responseFacade
	 * updateByID method
	 * 
	 * @param responseID
	 *            is String type parameter which represents unique
	 *            identification of the response
	 * @param response
	 *            is object of Response which is updated into database
	 * @return responseEntity object which contain the httpStatus code ok if
	 *         response is updated else return the internal_server_error 
	 */
		
	@RequestMapping(value="{responseID}",method=RequestMethod.PUT)
	public ResponseEntity<String> updateByID(@PathVariable("responseID") String responseID,@RequestBody Response response){
		boolean value = responseFacade.updateByID(responseID, response);
		if(value){
			return new ResponseEntity<String>("Response Updated",HttpStatus.OK);
		}else{
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * This method is used to delete the response by calling the responseFacade
	 * deleteByID method.
	 * 
	 * @param responseID
	 *            is String type parameter which represents unique
	 *            identification of the response
	 * @return responseEntity object which contain the httpStatus code ok if
	 *         response is deleted else return the internal_server_error if it
	 *         is not deleted.
	 */
	
	
	@RequestMapping(value="{responseID}",method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteByID(@PathVariable("responseID") String responseID){
		boolean value = responseFacade.deleteByID(responseID);
		if(value){
			return new ResponseEntity<String>("Response deleted",HttpStatus.OK);
		}else{
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	/**
	 * This method is used to get Survey For Response by calling the responseFacade
	 * getResponseDTO.
	 * 
	 * @param request
	 *            is HttpServletRequest object 
	 * @return responseEntity object which contain the httpStatus code ok if
	 *         responseDTO is present else return the internal_server_error if it
	 *         is not deleted.
	 */
	
	
	
	@RequestMapping(value="/response",method=RequestMethod.GET)
	public ResponseEntity<ResponseDTO> getSurveyForResponse(HttpServletRequest request){
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		String surveyID = (String) session.getAttribute("surveyID"); 
		SurveyDTO surveyDTO = surveyFacade.getByID(surveyID);
		ResponseDTO responseDTO = responseFacade.getResposeDTO(surveyDTO, email);
		if(responseDTO != null){
			return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
		}
		else{
			return new ResponseEntity<ResponseDTO>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
