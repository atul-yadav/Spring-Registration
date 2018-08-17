package com.jda.user.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.jda.user.model.User;

public class UserValidation {
	
	 boolean supports(Class<?> clazz) {
       return User.class.isAssignableFrom(clazz);
   }
	 
	 public void validate(Object target, Errors errors) {
		 
		
		 User user = (User) target;
		 String name = user.getName();
		 String username  = user.getUsername();
		 String password = user.getPassword();
		 String mobile = user.getMobile();
		 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "user.name.empty", "name field required");
		 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "user.username.empty", "username field required");
		 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "user.password.empty", "password  field required");
		 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mobile", "user.mobile.empty", "mobile no  field required");
		 
		 /*
		 
		 ValidationUtils.rejectIfEmpty(errors, "name", user.getName().isEmpty());
		 ValidationUtils.rejectIfEmpty(errors, "username", user.getUsername().isEmpty());
		 ValidationUtils.rejectIfEmpty(errors, "password", user.getPassword().isEmpty());
		 ValidationUtils.rejectIfEmpty(errors, "mobile", user.getMobile().isEmpty());
		 
		 */
	 }

}
