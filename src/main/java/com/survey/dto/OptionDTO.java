package com.survey.dto;

public class OptionDTO {
	private String optionID;
	private String optionText;
	private String linkedQuestionId;

	public String getOptionID() {
		return optionID;
	}

	public void setOptionID(String optionID) {
		this.optionID = optionID;
	}

	public String getOptionText() {
		return optionText;
	}

	public void setOptionText(String optionText) {
		this.optionText = optionText;
	}

	public String getLinkedQuestionId() {
		return linkedQuestionId;
	}

	public void setLinkedQuestionId(String linkedQuestionId) {
		this.linkedQuestionId = linkedQuestionId;
	}

}
