package com.survey.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.survey.dto.UserDTO;

@Controller
public class PageController {
	
	@RequestMapping(value={"/","/login"},method=RequestMethod.GET)
	public String getPageView(){
		System.out.println("home");
		return "index";
	}
	
	@RequestMapping(value="/dashboard",method=RequestMethod.GET)
	public String getDashboard(HttpServletRequest request,HttpServletResponse response){
		System.out.println("Dashboard");
		HttpSession session = request.getSession();
		UserDTO userDTO = (UserDTO) session.getAttribute("email");
		if(userDTO == null || request == null){
			System.out.println(userDTO + " "+ request);
			//try {
				//response.sendRedirect("login");
				return "redirect:/login";
			//} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			//}
		}
		return "dashboard";
	}
	
	@RequestMapping(value = "/logout",method=RequestMethod.GET)
	public String logout(HttpSession session){
		System.out.println("logout");
		session.invalidate();
		return "index";
	}
}
