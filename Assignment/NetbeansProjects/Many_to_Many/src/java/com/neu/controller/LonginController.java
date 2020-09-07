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
public class LonginController extends AbstractController {
    
    public LonginController() {
    }
    
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //get action from page
        String loginAction = request.getParameter("loginAction");
        HttpSession session = request.getSession();
//        UserDao userDao = (UserDao) getApplicationContext().getBean("userDao");
        UserDao userDao = new UserDao();
        if(loginAction != null){
            //get login information from page
            String userName = request.getParameter("userName");
            String password = request.getParameter("password");
            User user = userDao.login(userName, password);
            //check whrther username match password
            if(user != null){
                //if admin 
                if(user.getUserName().equals("admin")){
                    session.setAttribute("user", user);
                    return new ModelAndView("home_admin","user",user);
                }else{
                    session.setAttribute("user", user);
                    return new ModelAndView("home","user",user);
                }
            }else{
                return new ModelAndView("login","error","none");
            }
        }else{
            return new ModelAndView("login");
        }
    }
    
}
