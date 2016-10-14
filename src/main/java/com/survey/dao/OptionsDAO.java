package java.com.survey.dao;

import java.com.survey.model.Options;
import java.util.List;

public interface OptionsDAO {
	public List<Options> getAll();
	public Options getByID(String optionID);
	public void updateByID(String optionID);
	public void create(Options options);
	public void deleteByID(String optionID);
}
