package main.java.com.survey.controller;

import java.util.List;

import main.java.com.survey.facade.UsersFacade;
import main.java.com.survey.model.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsersController {
	
	@Autowired
	UsersFacade usersFacade;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Users>> getAll(){
		return new ResponseEntity<List<Users>>(usersFacade.getAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value="{userID}",method=RequestMethod.GET)
	public ResponseEntity<Users> getByID(@PathVariable("userID") String userID){
		Users users = usersFacade.getByID(userID);
		if(users!=null){
			return new ResponseEntity<Users>(users , HttpStatus.OK);
		}else{
			return new ResponseEntity<Users>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<String> create(@RequestBody Users users){
		boolean value = usersFacade.create(users);
		if(value){
			return new ResponseEntity<String>("User Created",HttpStatus.OK);
		}else{
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="{userID}",method=RequestMethod.PUT)
	public ResponseEntity<String> updateByID(@PathVariable("userID") String userID){
		boolean value = usersFacade.updateByID(userID);
		if(value){
			return new ResponseEntity<String>("User Updated",HttpStatus.OK);
		}else{
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="{userID}",method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteByID(@PathVariable("userID") String userID){
		boolean value = usersFacade.deleteByID(userID);
		if(value){
			return new ResponseEntity<String>("User deleted",HttpStatus.OK);
		}else{
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
