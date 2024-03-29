/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hw5.validator;

import com.hw5.pojo.Movie;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Wenqing
 */
public class MovieValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return type.isAssignableFrom(Movie.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "missing-info", "title cannot be blank");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "actor", "missing-info", "leadactor cannot be blank");   
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "actress", "missing-info", "leadactress cannot be blank"); 
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "genre", "missing-info", "genre cannot be blank"); 
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "year", "missing-info", "year cannot be blank"); 
    }
    
}
