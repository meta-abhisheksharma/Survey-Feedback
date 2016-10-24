package com.survey.facade;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.survey.dao.UsersDAO;
import com.survey.dto.UserDTO;
import com.survey.model.User;
import com.survey.util.DTOUtils;

@Component
public class UsersFacade {

	@Autowired
	UsersDAO userDAO;

	@Transactional
	public List<UserDTO> getAll() {
		List<User> user = userDAO.getAll();
		return DTOUtils.populateUserDTO(user);
	}

	@Transactional
	public UserDTO verifyUser(User user) {
		User userReturn = userDAO.getEmailAndPass(user);
		if (userReturn != null) {
			UserDTO userDTO = new UserDTO();
			userDTO.setId(userReturn.getId());
			userDTO.setEmail(userReturn.getEmail());
			userDTO.setName(userDTO.getName());
			userDTO.setUserRole(userDTO.getUserRole());
			return userDTO;
		} else {
			return null;
		}

	}

	@Transactional
	public UserDTO getUserById(String id) {
		User userReturn = userDAO.getUserById(id);
		if (userReturn != null) {
			UserDTO userDTO = new UserDTO();
			userDTO.setId(userReturn.getId());
			userDTO.setEmail(userReturn.getEmail());
			userDTO.setName(userDTO.getName());
			userDTO.setUserRole(userDTO.getUserRole());
			userDTO.setBlockUser(userDTO.getBlockUser());
			System.out.println(userDTO.getBlockUser());
			return userDTO;
		} else {
			return null;
		}
	}

	public UserDTO getUserByEmail(String email) {
		User userReturn = userDAO.getUserByEmail(email);
		if (userReturn != null) {
			UserDTO userDTO = new UserDTO();
			userDTO.setId(userReturn.getId());
			userDTO.setEmail(userReturn.getEmail());
			userDTO.setName(userReturn.getName());
			userDTO.setUserRole(userReturn.getUserRole());
			userDTO.setPicture(userReturn.getPicture());
			return userDTO;
		} else {
			return null;
		}
	}

	@Transactional
	public void create(User user) {
		user.setCreatedTime(new Date());
		userDAO.create(user);
	}

	@Transactional
	public void updateByID(String id, User user) {
		User oldUser = this.getUserByIdForCreated(id);
		oldUser.setEmail(user.getEmail());
		oldUser.setName(user.getName());
		oldUser.setUpdatedTime(new Date());
		userDAO.updateByID(id, oldUser);

	}

	@Transactional
	public void delete(String id) {
		userDAO.deleteByID(id);

	}

	@Transactional
	public User getUserByIdForCreated(String id) {
		return userDAO.getUserById(id);
	}

	public void changePassword(String password, String id) {
		User oldUser = this.getUserByIdForCreated(id);
		oldUser.setPassword(password);
		oldUser.setUpdatedTime(new Date());
		userDAO.updateByID(id, oldUser);

	}

	@Transactional
	public List<UserDTO> getUserByRole(String userRole) {
		try{
		List<User> listOfUserReturn = userDAO.getUserByRole(userRole);
		if (listOfUserReturn != null) {
			return DTOUtils.populateUserDTO(listOfUserReturn);
		} else {
			return null;
		}
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	
	@Transactional
    public String getUserPassword(String email) {
        User user = userDAO.getUserByEmail(email);
        return user.getPassword();
    }
}
