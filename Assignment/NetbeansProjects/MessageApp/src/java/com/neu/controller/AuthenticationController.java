/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.controller;

import com.neu.model.UserDao;
import com.neu.pojo.Login;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author root
 */
public class AuthenticationController extends AbstractController {
    
    public AuthenticationController() {
    }
    
    protected ModelAndView handleRequestInternal(
        HttpServletRequest request,
        HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String option = request.getParameter("option");
        ModelAndView mv = null;
        
        if(username != null && password != null && option != null){
            if(option.equals("login")){
                UserDao user = new UserDao();
                Login l = user.authenticationUser(username, password);
                if(l == null){
                    mv = new ModelAndView("login");
                }else{
                    session.setAttribute("USER", l.getUsername());
                    mv = new ModelAndView("user");
                    
                }
            }
        }else{
            return new ModelAndView("login");
        }
        return mv;
    }
    
}
