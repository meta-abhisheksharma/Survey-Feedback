package com.survey.controller;

import static org.junit.Assert.assertEquals;

import javax.mail.MessagingException;

import org.junit.Test;

import com.survey.model.EmailPojo;

public class EmailControllerTest {

	@Test
	public void sendEmailTest() throws MessagingException {
		String to[]={"astha.gupta@metacube.com"};
		EmailPojo email  = new EmailPojo();
		email.setTo(to);
		email.setSubject("welcome to survey feedback");
		email.setMessage("hi,,,you are welcome to survey feedback");
		
		assertEquals("dashboard", new EmailController().doSendEmail(email));
		
	}
	
	@Test
	public void sendHTMLEmailTest() throws MessagingException {
		String to[]={"astha.gupta@metacube.com"};
		EmailPojo email  = new EmailPojo();
		email.setTo(to);
		email.setSubject("welcome to survey feedback");
		email.setMessage("hi,,,you are welcome to survey feedback");
		
		assertEquals("dashboard", new EmailController().doHtmlSendEmail(email));
	}

}
