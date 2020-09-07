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
public class RegisterController extends AbstractController {
    
    public RegisterController() {
    }
    
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //get information from page
        String registerAction = request.getParameter("registerAction");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String avatarPath = request.getParameter("avatarPath");
        String introduction = request.getParameter("introduction");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        boolean status = true;
        if(registerAction != null){
//            UserDao userDao = (UserDao) getApplicationContext().getBean("userDao");
            UserDao userDao = new UserDao();
//            if(!userName.equals("admin")){
            if(!userDao.isDuplicated(userName) && !userDao.isDuplicatedEmail(email)){
//                User user = (User) getApplicationContext().getBean("user");
                User user = new User();
                user.setUserName(userName);
                user.setPassword(password);
                user.setAvatarPath(avatarPath);
                user.setIntroduction(introduction);
                user.setStatus(status);
                user.setPhoneNumber(phoneNumber);
                user.setEmail(email);
                userDao.add(user);
                return new ModelAndView("login","username",userName);
            }else{
                return new ModelAndView("registerUserAccount","error",userName);
            }
        }else{
            return new ModelAndView("registerUserAccount");
        } 
    } 
}
