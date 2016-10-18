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

import com.survey.facade.UsersFacade;
import com.survey.model.User;

@RestController
@RequestMapping("/users")
public class UsersController {
	
	@Autowired
	UsersFacade usersFacade;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<User>> getAll(){
		List<User> user = usersFacade.getAll();
		return new ResponseEntity<List<User>>(user, HttpStatus.OK);
	}
	

	@RequestMapping(value="{userID}",method=RequestMethod.GET)
	public ResponseEntity<User> getByID(@PathVariable("userID") String userID){
		User user = usersFacade.getByID(userID);
		if(user!=null){
			return new ResponseEntity<User>(user , HttpStatus.OK);
		}else{
			return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<String> create(@RequestBody User user){
		boolean value = usersFacade.create(user);
		if(value){
			return new ResponseEntity<String>("User Created",HttpStatus.OK);
		}else{
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="{userID}",method=RequestMethod.PUT)
	public ResponseEntity<String> updateByID(@PathVariable("userID") String userID,@RequestBody User user){
		boolean value = usersFacade.updateByID(userID,user);
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
