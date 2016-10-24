package com.survey.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;

import org.junit.Test;

import com.survey.model.EmailPojo;
import com.survey.model.To;

public class EmailControllerTest {

	@Test
	public void sendEmailTest() throws MessagingException {
		List<To> to= new ArrayList<To>();
		To to1 = new To();
		to1.setText("astha.gupta@metacube.com");
		To to2 = new To();
		to2.setText("ajinkya.pande@metacube.com");
		
		to.add(to1);
		to.add(to2);
		
		EmailPojo email  = new EmailPojo();
		email.setTo(to);
	
		email.setSubject("welcome to survey feedback");
		email.setMessage("hi,,,you are welcome to survey feedback");
		
		assertEquals("dashboard", new EmailController().doSendEmail(email));
		
	}
	
	@Test
	public void sendHTMLEmailTest() throws MessagingException {
		List<To> to= new ArrayList<To>();
		To to1 = new To();
		to1.setText("astha.gupta@metacube.com");
		To to2 = new To();
		to2.setText("ajinkya.pande@metacube.com");
		
		to.add(to1);
		to.add(to2);
		
		EmailPojo email  = new EmailPojo();
		email.setTo(to);
		email.setSubject("welcome to survey feedback");
		email.setMessage("hi,,,you are welcome to survey feedback");
		
		assertEquals("dashboard", new EmailController().doHtmlSendEmail(email));
	}

}
