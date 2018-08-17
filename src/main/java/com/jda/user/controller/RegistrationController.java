package com.jda.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jda.user.model.User;
import com.jda.user.service.UserService;

@Controller
public class RegistrationController {
 
	@Autowired
  public UserService userService;
 
  @RequestMapping(value = "/register")
  public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView("register");
    mav.addObject("user", new User());
    return mav;
  }
  
  @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
  public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
  @ModelAttribute("user") User user) {
	  userService.register(user);
  return new ModelAndView("welcome", "name", user.getName());
  }
  
  
}
  
  /*
  
  @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
  public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
  @ModelAttribute("user") User user) {
		 // @ModelAttribute("user") User user,BindingResult result) {
	  userService.register(user);
	 
	  validator.validate(user, result);
		 if(result.hasErrors()){
			 return new ModelAndView("register"); 
		 }
		 
  return new ModelAndView("welcome", "name", user.getName());
  }
  */
  
 


