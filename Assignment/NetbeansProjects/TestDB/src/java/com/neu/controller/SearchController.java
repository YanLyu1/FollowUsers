/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.controller;

import com.neu.dao.ArticleDao;
import com.neu.dao.UserDao;
import com.neu.pojo.Article;
import com.neu.pojo.User;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author root
 */
public class SearchController extends AbstractController {
    
    public SearchController() {
    }
    
    protected ModelAndView handleRequestInternal(HttpServletRequest request,HttpServletResponse response) throws Exception {
        //article OR user
        String searchType = request.getParameter("searchType");
        //get keyword
        String keyword = request.getParameter("keyword");
        if(searchType.equals("article")){
            ArticleDao articleDao = new ArticleDao();
            List<Article> articleList = articleDao.searchArtcile(keyword);
            return new ModelAndView("articleSearchResult","articleList",articleList);
        }else if(searchType.equals("user")){
            UserDao userDao = new UserDao();
            List<User> userList = userDao.getUserByName(keyword);
            return new ModelAndView("friendSearchResult","userList",userList);
        }else{
            return new ModelAndView("home");
        }
    }
    
}
