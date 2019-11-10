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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
        String keyword = request.getParameter("keyword");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        List<User> userList;
        Map<String, List> searchMap = new HashMap<>();
        if(user != null){
            ArticleDao articleDao = new ArticleDao();
            List<Article> articleList = articleDao.searchArtcile(keyword);
            searchMap.put("articles", articleList);
            UserDao userDao = new UserDao();
            userList = userDao.getUserByName(keyword, user);
            searchMap.put("users", userList);
            return new ModelAndView("searchResult","searchMap",searchMap);
        }else{
            return new ModelAndView("login");
        }
    }
}
