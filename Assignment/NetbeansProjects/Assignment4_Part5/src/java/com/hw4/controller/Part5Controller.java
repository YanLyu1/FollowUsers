/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hw4.controller;

import com.hw4.model.MovieDao;
import com.hw4.pojo.Movie;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author root
 */
public class Part5Controller extends AbstractController {
    
    public Part5Controller() {
    }
    
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = null;
        String option = request.getParameter("selection");
        String hide = request.getParameter("hide");
        HttpSession session = request.getSession();
        if(request.getParameter("hide") != null){
            if(hide.equals("welcome")){
                if(option.equals("bm")){
                    mv = new ModelAndView("Part5SearchMovie");
                }else{
                    mv = new ModelAndView("Part5AddMovie");
                }
                return mv;
        }else if(hide.equals("add")){
            MovieDao dao = new MovieDao();
            String title = request.getParameter("title");
            String actor = request.getParameter("actor");
            String actress = request.getParameter("actress");
            String genre = request.getParameter("genre");
            int year = 0;
            try{
                year = Integer.parseInt(request.getParameter("year"));
            }catch(NumberFormatException e){
                mv = new ModelAndView("error");
                return mv;
            }
            // int year = Integer.parseInt(request.getParameter("year"));
            Movie movie = new Movie();
            movie.setTitle(title);
            movie.setActor(actor);
            movie.setActress(actress);
            movie.setGenre(genre);
            movie.setYear(year);
            dao.addMovie(movie);
            mv = new ModelAndView("successful");
            return mv;
        }else{
            String keyword = request.getParameter("keyword");
            String attribute = request.getParameter("search");
            ArrayList<Movie> list = new ArrayList<>();
            MovieDao dao = new MovieDao();
            list = dao.searchMovie(keyword, attribute);
            session.setAttribute("list", list);
            session.setAttribute("keyword", keyword);
            mv = new ModelAndView("Part5SearchResult");
            return mv;
        }
        }else{
            mv = new  ModelAndView("Part5Welcome");
            return mv;
        }
    }
}
