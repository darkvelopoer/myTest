package com.yyh.practice;

import java.io.IOException;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.myapps.examples.dto.UserObj;

public class ValidationTest {
	public static void main(String args[]) throws IOException {
		UserObj user = new UserObj();
		user.setWorking(true);
		user.setAboutMe("Its all about me!");
		user.setAge(151);
		user.setEmail("sp.com");
		user.setName("peoe");
		//user.setName2("  ");
		
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<UserObj>> violations = validator.validate(user);
		
		for (ConstraintViolation<UserObj> violation : violations) {
		    System.out.println(violation.getMessage()); 
		}
	}
	
	
}
