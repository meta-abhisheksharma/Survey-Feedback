package com.survey.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.survey.dao.OptionsDAO;
import com.survey.model.Option;

@Component
public class OptionsFacade {

	@Autowired
	OptionsDAO optionsDAO;

	public boolean create(Option option) {
		try {
			optionsDAO.create(option);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	
	public boolean updateByID(String optionID,Option option) {
		try {
			optionsDAO.updateByID(optionID,option);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List<Option> getAll() {
		return optionsDAO.getAll(); 
	}

	public Option getByID(String optionID) {
		return optionsDAO.getByID(optionID);
	}

	public boolean deleteByID(String optionID) {
		try {
			optionsDAO.deleteByID(optionID);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
