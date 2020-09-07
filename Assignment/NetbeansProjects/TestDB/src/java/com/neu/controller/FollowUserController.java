/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.controller;

import com.neu.dao.UserDao;
import com.neu.pojo.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author root
 */
public class FollowUserController extends AbstractController {
    
    public FollowUserController() {
    }
    
    protected ModelAndView handleRequestInternal(HttpServletRequest request,HttpServletResponse response) throws Exception {
        //get user information from page and get the user object
//        long userId = Long.parseLong(request.getParameter("follow"));
//        UserDao userDao = new UserDao();
//        User user_follow = userDao.getUserById(userId);
//        
//        //get my information
//        HttpSession session = request.getSession();
//        User user = (User) session.getAttribute("user");
        
        return new ModelAndView("break");
        
    }
    
}
