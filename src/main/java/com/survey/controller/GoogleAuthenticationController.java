/**
 * 
 */
package com.survey.controller;

import java.io.BufferedReader;
import java.io.Console;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.survey.dto.UserDTO;
import com.survey.facade.UsersFacade;
import com.survey.model.GoogleAuthenticationPojo;
import com.survey.model.User;

/**
 * @author admin
 *
 */
@Controller
@RequestMapping(value = "/google")
public class GoogleAuthenticationController {
	@Autowired
	UsersController userController;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.survey.controller.impl.AuthenticationController#googleOauthLogin
	 * (javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@RequestMapping(value = "/authenticate")
	public @ResponseBody void googleOauthLogin(HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("hii hello ");

		HttpSession httpSession = request.getSession(true);
		try {

			// code will hold the data returned from google OAuth
			String code = request.getParameter("code");

			/*
			 * If code is null i.e. user has clicked on deny button, then again
			 * redirect to index page
			 */
			if (code == null) {
				response.sendRedirect("/surveyfeedback/");
			}

			// format parameters to post
			String urlParameters = "code="
					+ code
					+ "&client_id=1009741184185-l3bbvlk84qcfjnf49j03mgi5tc3mq5gm.apps.googleusercontent.com"
					+ "&client_secret=fEVEyKq1KO6ZVp4TxC0IIz4O"
					+ "&redirect_uri=http://localhost:8080/surveyfeedback/google/authenticate"
					+ "&grant_type=authorization_code";

			// posting parameters
			URL url = new URL("https://accounts.google.com/o/oauth2/token");

			// opening a connection with the given URL
			URLConnection urlConn = url.openConnection();
			urlConn.setDoOutput(true);
			OutputStreamWriter writer = new OutputStreamWriter(
					urlConn.getOutputStream());
			writer.write(urlParameters);
			writer.flush();

			String line, outputString = "";
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					urlConn.getInputStream()));

			// Reading the output in outputString
			while ((line = reader.readLine()) != null) {
				outputString += line;
			}

			// getting Access Token
			JsonObject json = (JsonObject) new JsonParser().parse(outputString);
			String access_token = json.get("access_token").getAsString();

			// getting User Info from that access token
			url = new URL(
					"https://www.googleapis.com/oauth2/v1/userinfo?access_token="
							+ access_token);
			urlConn = url.openConnection();
			outputString = "";
			reader = new BufferedReader(new InputStreamReader(
					urlConn.getInputStream()));

			// getting user data in output string as JSON
			while ((line = reader.readLine()) != null) {
				outputString += line;
			}
			System.out.println("JSON OUTPUT > " + outputString);
			// Convert JSON response into User class Object
			GoogleAuthenticationPojo authenticationPojo = new Gson().fromJson(
					outputString, GoogleAuthenticationPojo.class);
			System.out.println(authenticationPojo);

			// retrieving email from the created user object
			String email = authenticationPojo.getEmail();

			User user = new User();
			user.setEmail(email);
			user.setName(authenticationPojo.getName());
			user.setBlockUser("unblock");
			user.setPassword("12345678A");
			user.setCreatedTime(new Date());
			user.setPicture(authenticationPojo.getPicture());
			httpSession.setAttribute("email", user.getEmail());

			// saving to database

			/*
			 * Settings up extra account detailing for account activation
			 * AndFileFilter profile completion
			 */
			if (userController.authenticationByEmail(user) == null) {
				System.out.println("google picture created");
				userController.create(user);
			}
			response.sendRedirect("/surveyfeedback/dashboard");
		} catch (Exception e) {
			// ApplicationLogger.DebugLog(e.getMessage());
		}
	}
}
