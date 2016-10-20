/*package com.survey.controller;

import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.filter.GenericFilterBean;

import com.survey.dto.UserDTO;


@WebFilter({"/dashboard"})
public class LoginController extends GenericFilterBean{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) {
		
		final HttpServletRequest httpRequest = (HttpServletRequest) request;
		final HttpServletResponse httpResponse = (HttpServletResponse) response;

		HttpSession session = httpRequest.getSession(false);
		
		try {
			UserDTO userDTO = (UserDTO)session.getAttribute("email");
			if (session == null || userDTO == null) {
				httpResponse.sendRedirect("login");
			}
		}catch(Exception e){
			e.printStackTrace();
		}

	}
	
	
	
}
*/