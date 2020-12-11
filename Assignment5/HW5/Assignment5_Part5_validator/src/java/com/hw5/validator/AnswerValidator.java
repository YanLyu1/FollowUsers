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
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "answer", "missing-info", "select an answer");
    }
    
    public void validateAnswer(Errors errors, int page){
        if(page==0) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "answer1", "error.answer.required", "select an answer");
            if(errors.hasErrors())
                return;
        } 
        if(page==1) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "answer2", "error.answer.required", "select an answer");
            if(errors.hasErrors())
                return;
        } 
        if(page==2){
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "answer3", "error.answer.required", "select an answer");
        }
        if(page==3){
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "answer4", "error.answer.required", "select an answer");
        }
        if(page==4){
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "answer5", "error.answer.required", "select an answer");
        }
        if(page==5){
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "answer6", "error.answer.required", "select an answer");
        }
        if(page==6){
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "answer7", "error.answer.required", "select an answer");
        }
        if(page==7){
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "answer8", "error.answer.required", "select an answer");
        }
        if(page==8){
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "answer9", "error.answer.required", "select an answer");
        }
        if(page==9){
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "answer10", "error.answer.required", "select an answer");
        }
        
        
	

    }

}
