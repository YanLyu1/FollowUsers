/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.controller;

import com.neu.dao.UserDao;
import com.neu.pojo.Article;
import com.neu.pojo.User;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author root
 */
public class FriendArticleController extends AbstractController {
    
    public FriendArticleController() {
    }
    
    protected ModelAndView handleRequestInternal(HttpServletRequest request,HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        UserDao userDao = new UserDao();
        User user = (User) session.getAttribute("user");
        long friendId = Long.parseLong(request.getParameter("friendId"));
        Set<Article> friendArticle = userDao.getFriendArticle(friendId);
        return new ModelAndView("articleSearchResult","articleList",friendArticle);
    }
}
