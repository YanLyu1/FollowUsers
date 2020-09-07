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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author root
 */
public class ResetInformationController extends AbstractController {
    
    public ResetInformationController() {
    }
    
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String reset = request.getParameter("resetInfor");
        User user = (User) request.getSession().getAttribute("user");
        if(user == null)
            return new ModelAndView("login");
        UserDao userDao = new UserDao();
        if(reset != null){
//            String registerAction = request.getParameter("registerAction");
            String userName = request.getParameter("userName");
            String password = request.getParameter("password");
//            String avatarPath = request.getParameter("avatarPath");
            String introduction = request.getParameter("introduction");
            String email = request.getParameter("email");
            String phoneNumber = request.getParameter("phoneNumber");
            user.setUserName(userName);
            user.setPassword(password);
            user.setIntroduction(introduction);
            user.setEmail(email);
            user.setPhoneNumber(phoneNumber);
            userDao.updateInformation(user);
            return new ModelAndView("resetInformation","user",user);
        }else{
            return new ModelAndView("resetInformation","user",user);
        }        
    }
    
}
