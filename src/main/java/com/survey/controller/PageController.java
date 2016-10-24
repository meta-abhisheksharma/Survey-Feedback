package com.survey.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * This class is used to redirect the pages to proper location according to the
 * sessions and the URL hit.
 * 
 * @author Ajinkya pande
 *
 */
@Controller
public class PageController {
	
	/**
	 * This method redirect the client to index page when URL:"/" or "/login" is
	 * hit.It also checks the session if session is present then it will
	 * redirect to dashboard page.
	 * 
	 * @param request
	 *            is HttpServletRequest object from which we get the session
	 *            object
	 * @return String type that which page it should redirect
	 */
	@RequestMapping(value={"/","/login"},method=RequestMethod.GET)
	public String getPageView(){
		System.out.println("jsgh");
		return "index";
	}
	
	
	/**
	 * This method redirect the client to dashboard page when URL:"/dashboard"
	 * or "/dashboard/**" is hit.It also checks the session if session is
	 * present then it will redirect to dashboard page else redirect to
	 * URL:"/login".
	 * 
	 * @param request
	 *            is HttpServletRequest object from which we get the session
	 *            object
	 * @return String type that which page it should redirect
	 */
	@RequestMapping(value={"/dashboard","/dashboard/*"},method=RequestMethod.GET)
	public String getDashboard(HttpServletRequest request){
		System.out.println("Dashboard");
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		if (email == null || request == null) {
			System.out.println(email + " " + request);
			return "redirect:/login";
		}
		return "dashboard";
	}
	
	/**
	 * This method is used to invalidate the session stored and redirect the
	 * client to index page when URL:"/logout" is hit.
	 * 
	 * @param request
	 *            is HttpServletRequest object from which we get the session
	 *            object
	 * @return  String type that which page it should redirect
	 */
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(HttpServletRequest request){
		HttpSession session = request.getSession();
		session.invalidate();
		return "index";
	}
	
	
	@RequestMapping(value={"/responses/{surveyID}/user/{email}"},method=RequestMethod.GET)
	public String getResponse(@PathVariable(value= "surveyID") String surveyID ,@PathVariable(value= "email") String email, HttpServletRequest request){
		
		HttpSession session = request.getSession();
		session.setAttribute("surveyID", surveyID);
		session.setAttribute("email", email);
		if (surveyID == null || email == null || request == null) {
			System.out.println(email + " " + request);
			return "redirect:/login";
		}System.out.println("rss");
		return "responses";
	}
}
