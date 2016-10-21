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

import com.survey.dto.UserDTO;
import com.survey.facade.UsersFacade;
import com.survey.model.User;

@RestController
@RequestMapping("/users")
public class UsersController {

	@Autowired
	UsersFacade usersFacade;

	
	//get All user
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> getAll() {
		List<UserDTO> user = usersFacade.getAll();
		return new ResponseEntity<List<UserDTO>>(user, HttpStatus.OK);
	}

	
	//user verification logic
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<UserDTO> authentication(@RequestBody User user , HttpServletRequest request) {
	
		HttpSession session = request.getSession();
		if (user != null) {
			UserDTO userDTO = usersFacade.verifyUser(user);
			if (userDTO != null) {
				session.setAttribute("email", user.getEmail());
				return new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK);
			} else {
				return new ResponseEntity<UserDTO>(HttpStatus.NOT_FOUND);
			}

		} else {
			return new ResponseEntity<UserDTO>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	
	//get User by id
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ResponseEntity<UserDTO> getUser(@PathVariable(value = "id") String id) {
		if (id != null) {
			UserDTO userDTO = usersFacade.getUserById(id);
			if (userDTO != null) {
				return new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK);
			} else {
				return new ResponseEntity<UserDTO>(HttpStatus.NOT_FOUND);
			}

		} else {
			return new ResponseEntity<UserDTO>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	
	//create user
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<User> create(@RequestBody User user) {
		
		
		if (user != null) {
			usersFacade.create(user);
			return new ResponseEntity<User>(user,HttpStatus.OK);

		} else {
			return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}

	
	//update user 
	@RequestMapping(value ="{id}", method = RequestMethod.PUT)
	public ResponseEntity<String> update(@PathVariable(value = "id") String id,@RequestBody User user) {
		if (user != null) {
			usersFacade.updateByID(id, user);
			return new ResponseEntity<String>("Updated successfully",
					HttpStatus.OK);

		} else {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}


	//delete user 
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable(value = "id") String id) {
		if (id != null) {
			usersFacade.delete(id);
			return new ResponseEntity<String>("delete successfully",
					HttpStatus.OK);

		} else {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}
	
	//change password
	@RequestMapping(value = "/password/{id}", method = RequestMethod.POST)
	public ResponseEntity<String> changePassword(@RequestBody User user ,@PathVariable(value="id") String id) {
		if(id != null){
			usersFacade.changePassword(user.getPassword(),id);
			return new ResponseEntity<String>("change password successfully",
					HttpStatus.OK);
		}else {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
		
	}

	@RequestMapping(value = "/emailvarify", method = RequestMethod.POST)		
 	public ResponseEntity<UserDTO> authenticationByEmail(@RequestBody User user) {		
 				
 				
 		if (user != null) {		
 					
 			UserDTO userDTO = usersFacade.getUserByEmail(user.getEmail());		
 			if (userDTO != null) {		
 				return new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK);		
 			} else {		
 				return new ResponseEntity<UserDTO>(HttpStatus.NOT_FOUND);		
 			}		
 		
 		} else {		
 			return new ResponseEntity<UserDTO>(HttpStatus.INTERNAL_SERVER_ERROR);		
 		
 		}		
 	}
}
