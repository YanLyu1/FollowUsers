/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hw5.controller;

import com.hw5.dao.MovieDao;
import com.hw5.pojo.Movie;
import com.hw5.validator.MovieValidator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 *
 * @author root
 */
public class AddMovieController extends SimpleFormController {
    
    public AddMovieController() {
        //Initialize controller properties here or 
        //in the Web Application Context

        setCommandClass(Movie.class);
        setCommandName("movie");
        setValidator(new MovieValidator());
        setSuccessView("success-view");
        setFormView("form-view");
    }
    
    @Override
    protected void doSubmitAction(Object command) throws Exception {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    //Use onSubmit instead of doSubmitAction 
    //when you need access to the Request, Response, or BindException objects
    
    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
        ModelAndView mv = null;
        int success;
        //add a new movie to db
        Movie movie = (Movie) command;
//        String tile = movie.getTitle();
//        String actor = movie.getActor();
//        String actress = movie.getActress();
//        String genre = movie.getGenre();
//        int year = movie.getYear();
        MovieDao movieDao = new MovieDao();
//        success = movieDao.addMovie(tile, actor, actress, genre, year);
        success = movieDao.addMovie(movie);
        //to success page or error page
        if(success == 1){
            mv = new ModelAndView(getSuccessView());
        }else{
            mv = new ModelAndView("error");
        }
        return mv;
    }
     
}
