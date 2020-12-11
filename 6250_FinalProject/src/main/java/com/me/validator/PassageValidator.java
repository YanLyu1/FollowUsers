package com.me.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.me.pojo.Passage;

public class PassageValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		//This Validator validates *just* User instances
		return Passage.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "empty.title", "Title is Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "discription", "empty.discription", "discription is Required");
		
	}
	
	
}
