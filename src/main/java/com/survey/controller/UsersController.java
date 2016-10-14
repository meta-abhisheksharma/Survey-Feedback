package com.survey.controller;



import com.survey.facade.UsersFacade;
import com.survey.model.Users;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
@RequestMapping("/user")
public class UsersController  {
	
	@Autowired
	private UsersFacade usersFacade;
	
	public UsersFacade getUsersFacade() {
		return usersFacade;
	}

	public void setUsersFacade(UsersFacade usersFacade) {
		this.usersFacade = usersFacade;
	}

	@RequestMapping(value="/user/getUser",method=RequestMethod.GET)
	public ResponseEntity<Users> getByID(@PathVariable("userID") String userID){
		Users users = usersFacade.getByID(userID);
		if(users!=null){
			return new ResponseEntity<Users>(users , HttpStatus.OK);
		}else{
			return new ResponseEntity<Users>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> create(@RequestBody Users users,HttpServletRequest request){
		System.out.println("in  save");
		boolean value = usersFacade.create(users);
		if(value){
			return new ResponseEntity<String>("User Created",HttpStatus.OK);
		}else{
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	
}
