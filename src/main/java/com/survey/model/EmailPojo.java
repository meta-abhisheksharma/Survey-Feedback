package com.survey.model;

import java.util.Arrays;

public class EmailPojo {
	String from;
	String to[];
	String subject;
	String message;
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String[] getTo() {
		return to;
	}
	public void setTo(String[] to) {
		this.to = to;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "EmailPojo [from=" + from + ", to=" + Arrays.toString(to)
				+ ", subject=" + subject + ", message=" + message + "]";
	}
	
	
}
