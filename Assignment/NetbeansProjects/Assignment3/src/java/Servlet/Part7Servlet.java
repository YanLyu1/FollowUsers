/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.MysqlDAO;
import Pojo.Movie;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author root
 */
public class Part7Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String option = request.getParameter("selection");
        String redirectPage = "./index.html";
        if(option != null){
            if(option.equals("bm")){
                redirectPage = "./part7SearchMovie.html";
                response.sendRedirect(redirectPage);
            }else{
                redirectPage = "./part7AddMovie.html";
                response.sendRedirect(redirectPage);
            }
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String redirectPage = "./part7Welcome.html";
        if(action.equals("add")){
            String title = request.getParameter("title");
            String actor = request.getParameter("actor");
            String actress = request.getParameter("actress");
            String genre = request.getParameter("genre");
            int year = Integer.parseInt(request.getParameter("year"));
            Movie movie = new Movie();
            movie.setTitle(title);
            movie.setActor(actor);
            movie.setActress(actress);
            movie.setGenre(genre);
            movie.setYear(year);
            try {
                MysqlDAO dao = new MysqlDAO();
                dao.addMovie(movie);
            } catch (SQLException ex) {
                Logger.getLogger(Part7Servlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            redirectPage = "./success.html";
            response.sendRedirect(redirectPage);
        }else if(action.equals("search")){
            String keyword = request.getParameter("keyword");
            String attribute = request.getParameter("search");
            ArrayList<Movie> list = new ArrayList<>();
            try {
                MysqlDAO dao = new MysqlDAO();
                list = dao.searchMovie(keyword, attribute);
                redirectPage = "./part7SearchResult.jsp";
                request.setAttribute("list", list);
                request.setAttribute("keyword", keyword);
                request.getRequestDispatcher(redirectPage).forward(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(Part7Servlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            redirectPage = "./wrong.html";
            response.sendRedirect(redirectPage);
        }
    }

}
