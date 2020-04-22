package com.sarish.login.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.sarish.login.model.User;



@Component
public class LoginValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User login = (User)target;
		ValidationUtils.rejectIfEmpty(errors, "userName", "User.userName.empty");
		ValidationUtils.rejectIfEmpty(errors, "password", "User.password.empty");
		if (login.getUserName().length()<5)
			errors.rejectValue("userName","", "UserName length is less than 5");
		String x="^(?=.*[0-9]).{8,15}$";
		if(login.getPassword().matches(x)==false) {
			errors.rejectValue("password","","Invalid Format");
		}
	}
	

}