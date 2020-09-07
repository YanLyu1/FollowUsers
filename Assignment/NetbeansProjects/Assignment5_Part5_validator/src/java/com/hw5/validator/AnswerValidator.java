/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hw5.validator;

import com.hw5.pojo.Answer;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author root
 */
public class AnswerValidator implements Validator{

    @Override
    public boolean supports(Class clazz) {
	return Answer.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "answer", "error.answer.required", "select an answer");
    }
    
    public void validateAnswer(String ans,Errors errors, String answer){
        if(ans==null||ans.equals("")){
            errors.rejectValue(answer, "not null",null, "select a answer");
        }
    }

}
