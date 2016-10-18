package com.survey.dao;

import java.util.List;

import com.survey.model.Option;

public interface OptionsDAO {
	public List<Option> getAll();
	public Option getByID(String optionID);
	public void updateByID(String optionID, Option option);
	public void create(Option option);
	public void deleteByID(String optionID);
}
