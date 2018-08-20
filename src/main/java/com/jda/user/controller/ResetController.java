package com.jda.user.controller;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jda.user.dao.UserDao;
import com.jda.user.model.Login;
import com.jda.user.model.User;
import com.jda.user.service.UserService;

@Controller
public class ResetController {

	@Autowired
	UserDao userDao;
	@RequestMapping(value = "/reset")
	  public ModelAndView showForgot(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("reset");
	   mav.addObject("reset", new Login());
	    return mav;
	  }
	@RequestMapping(value = "/resetProcess", method = RequestMethod.POST)
	  public void loginProcess(HttpServletRequest request, HttpServletResponse response,
			  @ModelAttribute("reset") String username) {
		 ModelAndView mav ;
		 User  emailExist=userDao.validateUserName(username);
		 if(emailExist == null){
			 System.out.println("false");
		 }
		 else{
			 System.out.println("true");
		 }
	 }
	
}






