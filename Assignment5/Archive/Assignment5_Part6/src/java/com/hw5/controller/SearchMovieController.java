/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hw5.controller;

import com.hw5.dao.MovieDao;
import com.hw5.pojo.Movie;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author root
 */
public class SearchMovieController extends AbstractController {

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse hsr1) throws Exception {
        ModelAndView mv = null;
        ArrayList<Movie> movieList = new ArrayList<>();
        //get information from page
        
        String keyword = request.getParameter("keyword");
        String type = request.getParameter("search");
        String hide = request.getParameter("hide");
        if(hide != null){
            //search from db
            MovieDao movieDao = new MovieDao();
            if(type.equals("id")){
                long id = Integer.parseInt(keyword);
                movieList = movieDao.searchMoviesByID(id);
//                mv = new ModelAndView("success_search","movieList",movie);
            }else{
                movieList = movieDao.searchMovies(keyword, type);  
            }
            mv = new ModelAndView("success_search","movieList",movieList);
            
            return mv;
        }else{
            mv = new ModelAndView("searchMovie");
            return mv;
        }
    }
}
