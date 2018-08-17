package com.jda.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {

@RequestMapping(value = "/welcome")
public ModelAndView showWelcome(HttpServletRequest request, HttpServletResponse response) {
	HttpSession session = request.getSession();
	String name=(String) session.getAttribute("name");
	String username = (String) session.getAttribute("username");
	System.out.println(username);
	System.out.println(name);
	return new ModelAndView("welcome","name",name);
}
}
