package com.survey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String getPageView(){
		System.out.println("jsgh");
		return "index";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String getDashboard(){
		System.out.println("Dashboard");
		return "dashboard";
	}
	
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String getMainPage(){
		System.out.println("logout");
		return "index";
	}
	
	@RequestMapping(value="/addsurvey",method=RequestMethod.GET)
	public String addSurvey(){
		System.out.println("addSurvey");
		return "addSurvey.htm";
	}
	
}
