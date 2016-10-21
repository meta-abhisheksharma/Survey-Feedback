package com.survey.configration;

/**
* @author Rohit Singhavi Arpit Pittie
* Class to send email notifications
*/

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import com.survey.controller.UsersController;
import com.survey.dto.UserDTO;
import com.survey.facade.UsersFacade;
import com.survey.model.EmailPojo;
import com.survey.model.User;


@Component
public class MailService {
private Properties javaMailProperties;
/*@Autowired
UsersFacade userFacade;*/

public void sendMail(EmailPojo emailDetail) {

setProperties();
JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
SimpleMailMessage message = new SimpleMailMessage();

// FQDN of SMTP Service
mailSender.setHost("smtp.gmail.com");

// port to access gmail smtp
mailSender.setPort(587);

// authentication of gmail account
mailSender.setUsername("rockavidude@gmail.com");
mailSender.setPassword("nod@123456");

javaMailProperties.setProperty("mail.smtp.auth", "true");
javaMailProperties.setProperty("mail.smtp.starttls.enable", "true");

mailSender.setJavaMailProperties(javaMailProperties);

message.setFrom("rockavidude@gmail.com");
for(int index=0 ; index<emailDetail.getTo().length;index++){
message.setTo(emailDetail.getTo()[index]);
message.setSubject(emailDetail.getSubject());
//UserDTO userDTO = userFacade.getUserByEmail(emailDetail.getTo()[index]);
// MESSAGE BODY
message.setText(String.format("Dear " + emailDetail.getTo()[index] + ",\n\n"+emailDetail.getMessage()));

mailSender.send(message);
}
}

public void sendHTMLMail(EmailPojo emailDetail) throws MessagingException {

setProperties();

Session mailSession = Session.getDefaultInstance(javaMailProperties,
null);
MimeMessage emailMessage = new MimeMessage(mailSession);

String emailHost = "smtp.gmail.com";
String fromUser = "rockavidude";// just the id alone without  @gmail.com

String fromUserEmailPassword = "nod@123456";

Transport transport = mailSession.getTransport("smtp");

transport.connect(emailHost, fromUser, fromUserEmailPassword);
for(int index=0 ; index<emailDetail.getTo().length;index++){
emailMessage.addRecipients(Message.RecipientType.TO,emailDetail.getTo()[index]);
String mailMessage = mailMessage(emailDetail.getTo()[index]);
emailMessage.setSubject(emailDetail.getSubject());
emailMessage.setContent(mailMessage, "text/ html");
transport.sendMessage(emailMessage, emailMessage.getAllRecipients());
transport.close();
}
System.out.println("Email sent successfully.");
}

private void setProperties() {
javaMailProperties = new Properties();

javaMailProperties.setProperty("mail.smtp.auth", "true");
javaMailProperties.setProperty("mail.smtp.starttls.enable", "true");
}

private String mailMessage(String emailAddr){
	String mailMessage =  "<p>Dear <b><i> "
			+ emailAddr
			+ "</i></b></p>"
			+ "<br/><p>you are welcome to <i><b>SurveyFeedback</b></i></p><br/>"
			+ "<div style='display: inline-block; background-color:#5cb85c; padding: 8px 15px; border-radius:5px; margin:8px 15px; border:1px solid white'>"
			+ "<a style='color: white; text-decoration: none;' href='http://localhost:8080/surveyfeedback/'>Accept</a>"
			+ "</div>";
	return mailMessage;
}

}
