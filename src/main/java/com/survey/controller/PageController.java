package com.survey.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {
	
	@RequestMapping(value={"/","/login"},method=RequestMethod.GET)
	public String getPageView(HttpServletRequest request){
		System.out.println("index page");
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		if (email == null || request == null) {
			return "index";
		}
		return "dashboard";
	}
	
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
	
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(HttpServletRequest request){
		HttpSession session = request.getSession();
		session.invalidate();
		return "index";
	}
}
