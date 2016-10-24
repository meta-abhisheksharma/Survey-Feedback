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

import com.survey.configration.MailService;
import com.survey.dto.UserDTO;
import com.survey.facade.UsersFacade;
import com.survey.model.User;

@RestController
@RequestMapping("/users")
public class UsersController {

	@Autowired
	UsersFacade usersFacade;

	/**
	 * This method call the userFacade getAll method which return the list of
	 * the userDTO.
	 * 
	 * @return response object containing user information
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> getAll() {
		List<UserDTO> user = usersFacade.getAll();
		return new ResponseEntity<List<UserDTO>>(user, HttpStatus.OK);
	}

	/**
	 * This method call the userFacade verifyUser which return the userDTO if
	 * userDTO is returned then the session is stored.
	 * 
	 * @param user
	 *            is User Object which is send by client in form of JSON.
	 * @param request
	 *            is HttpServletRequest object from which we get the session
	 *            object
	 * @return responseEntity object in form of JSON to the client containing
	 *         httpStatus code.
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<Void> authentication(@RequestBody User user,
			HttpServletRequest request) {

		HttpSession session = request.getSession();
		if (user != null) {
			UserDTO userDTO = usersFacade.verifyUser(user);
			if (userDTO != null) {
				session.setAttribute("email", user.getEmail());
				return new ResponseEntity<Void>(HttpStatus.OK);
			} else {
				return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
			}

		} else {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);

		}
	}

	/**
	 * This method call the userFacade getUserById method which return the
	 * userDTO if userDTO is returned null the it return the bad request.
	 * 
	 * @param userID
	 *            is String type parameter which represents unique
	 *            identification of the user
	 * @return responseEntity object which contain the UserDTO and httpStatus
	 *         code OK if userDTO is available else return the httpStatus code
	 *         not_found else if userID is not provided by client then it return
	 *         the httpStatus code Bad_request
	 */
	@RequestMapping(value = "{userID}", method = RequestMethod.GET)
	public ResponseEntity<UserDTO> getUser(
			@PathVariable(value = "userID") String userID) {
		if (userID != null) {
			UserDTO userDTO = usersFacade.getUserById(userID);
			if (userDTO != null) {
				return new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK);
			} else {
				return new ResponseEntity<UserDTO>(HttpStatus.NOT_FOUND);
			}

		} else {
			return new ResponseEntity<UserDTO>(HttpStatus.BAD_REQUEST);

		}
	}

	/**
	 * This method is used to create the user by calling the userFacade create
	 * method it will return void after creating the user.
	 * 
	 * @param user
	 *            is object of User Entity which is provided by client in form
	 *            of JSON
	 * @return reponseEntity object containing the httpStatus code if user is
	 *         created then it return the httpStatus code created else
	 *         httpStatus code internal_server_error
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> create(@RequestBody User user) {
		if (user != null) {
			usersFacade.create(user);
			return new ResponseEntity<Void>(HttpStatus.CREATED);

		} else {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}

	/**
	 * This method is used to update the existing user by calling the userFacade
	 * updateByID method
	 * 
	 * @param userID
	 *            is String type parameter which represents unique
	 *            identification of the user
	 * @param user
	 *            is object of User Entity which is provided by client in form
	 *            of JSON to update his/her details.
	 * @return reponseEntity object containing the httpStatus code if user is
	 *         created then it return the httpStatus code ok else httpStatus
	 *         code internal_server_error
	 */
	@RequestMapping(value = "{userID}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(
			@PathVariable(value = "userID") String userID,
			@RequestBody User user) {
		if (user != null) {
			usersFacade.updateByID(userID, user);
			return new ResponseEntity<Void>(HttpStatus.OK);

		} else {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	/**
	 * This method is used to delete the existing user by calling the userFacade
	 * delete method
	 * 
	 * @param userID
	 *            is String type parameter which represents unique
	 *            identification of the user
	 * @return reponseEntity object containing the httpStatus code if user is
	 *         created then it return the httpStatus code ok else httpStatus
	 *         code internal_server_error
	 */
	@RequestMapping(value = "{userID}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(
			@PathVariable(value = "userID") String userID) {
		if (userID != null) {
			usersFacade.delete(userID);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}

	/**
	 * This method is used to change the user password
	 * 
	 * @param user
	 *            is object of User Entity which is provided by client in form
	 *            of JSON to update his/her details.
	 * @param userID
	 *            is String type parameter which represents unique
	 *            identification of the user
	 * @return reponseEntity object containing the httpStatus code if user is
	 *         created then it return the httpStatus code ok else httpStatus
	 *         code internal_server_error
	 */
	@RequestMapping(value = "/password", method = RequestMethod.POST)
    public ResponseEntity<UserDTO> changePassword(@RequestBody User user) {
        if (user != null) {
            UserDTO userDTO = usersFacade.getUserByEmail(user.getEmail());
            if (userDTO != null) {
                String password = usersFacade.getUserPassword(user.getEmail());
                new MailService().sendPasswordEmail(user.getEmail(),password);
                return new ResponseEntity<UserDTO>(userDTO,HttpStatus.OK);
            } else{
                return new ResponseEntity<UserDTO>(userDTO,HttpStatus.OK);
            }
        } else {
            return new ResponseEntity<UserDTO>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
        

    }
	

	/**
	 * This method is used to get userDTO from the email send in form of user
	 * object
	 * 
	 * @param user
	 *            is object of User Entity which is provided by client in form
	 *            of JSON to update his/her details.
	 * @return UserDTO object to the client
	 */
	@RequestMapping(value = "/emailvarify", method = RequestMethod.POST)
	public UserDTO authenticationByEmail(@RequestBody User user) {
		if (user != null) {
			UserDTO userDTO = usersFacade.getUserByEmail(user.getEmail());
			if (userDTO != null) {
				return userDTO;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	/**
	 * This method is used to return the userDTO from the stored session
	 * 
	 * @param request
	 *            is object of HttpServletRequest which store the session.
	 * @note request object should not be provided by client it automatically
	 *       assign its value when this request is called.
	 * @return responseEntity object which contain the UserDTO and httpStatus
	 *         code OK if userDTO is available else return the httpStatus code
	 *         forbidden else if userID is not provided by client then it return
	 *         the httpStatus code Bad_request
	 */
	@RequestMapping(value = "/session", method = RequestMethod.GET)
	public ResponseEntity<UserDTO> getUserBySession(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		if (email != null) {
			User user = new User();
			user.setEmail(email);
			UserDTO userDTO = authenticationByEmail(user);
			if (userDTO != null) {
				return new ResponseEntity<>(userDTO,HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.FORBIDDEN);
			}
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value = "/roles/{userRole}", method = RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> getSurveyor(
			@PathVariable(value = "userRole") String userRole) {
		if (userRole != null) {
			List<UserDTO> userDTO = usersFacade.getUserByRole(userRole);
			if (userDTO != null) {
				return new ResponseEntity<List<UserDTO>>(userDTO, HttpStatus.OK);
			} else {
				return new ResponseEntity<List<UserDTO>>(HttpStatus.NOT_FOUND);
			}

		} else {
			return new ResponseEntity<List<UserDTO>>(HttpStatus.BAD_REQUEST);

		}
	}
	
	
	
}
