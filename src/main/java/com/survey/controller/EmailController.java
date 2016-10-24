package com.survey.controller;

import javax.mail.MessagingException;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.survey.configration.MailService;
import com.survey.model.EmailPojo;

@RestController
@RequestMapping("/email")
public class EmailController {

	
    @RequestMapping(method = RequestMethod.POST)
    public String doSendEmail(@RequestBody EmailPojo emailDetail) throws MessagingException {System.out.println("email aa gya");
    	 MailService mailService = new MailService();
    	mailService.sendMail(emailDetail);
    	mailService.sendHTMLMail(emailDetail);
    	return "dashboard";
    	
    }
    
    @RequestMapping(value="/html",method = RequestMethod.POST)
    public String doHtmlSendEmail(@RequestBody EmailPojo emailDetail) throws MessagingException {System.out.println("email aa gya button wala");
    	MailService mailService = new MailService();
    	mailService.sendHTMLMail(emailDetail);
    	return "dashboard";
    	
    }
}
