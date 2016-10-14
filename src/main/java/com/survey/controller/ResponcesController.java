package java.com.survey.controller;

import java.com.survey.facade.ResponsesFacade;
import java.com.survey.model.Responses;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/response")
public class ResponcesController {
	
	@Autowired
	ResponsesFacade responseFacade;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Responses>> getAll(){
		return new ResponseEntity<List<Responses>>(responseFacade.getAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value="{responseID}",method=RequestMethod.GET)
	public ResponseEntity<Responses> getByID(@PathVariable("responseID") String responseID){
		Responses response = responseFacade.getByID(responseID);
		if(response !=null){
			return new ResponseEntity<Responses>(response  , HttpStatus.OK);
		}else{
			return new ResponseEntity<Responses>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<String> create(@RequestBody Responses response){
		boolean value = responseFacade.create(response);
		if(value){
			return new ResponseEntity<String>("User Created",HttpStatus.OK);
		}else{
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="{responseID}",method=RequestMethod.PUT)
	public ResponseEntity<String> updateByID(@PathVariable("responseID") String responseID){
		boolean value = responseFacade.updateByID(responseID);
		if(value){
			return new ResponseEntity<String>("User Updated",HttpStatus.OK);
		}else{
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="{responseID}",method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteByID(@PathVariable("responseID") String responseID){
		boolean value = responseFacade.deleteByID(responseID);
		if(value){
			return new ResponseEntity<String>("User deleted",HttpStatus.OK);
		}else{
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
