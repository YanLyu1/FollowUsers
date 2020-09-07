/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.controller;

import com.neu.dao.UserDao;
import com.neu.pojo.User;
import java.net.BindException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 *
 * @author root
 */
public class UserController extends SimpleFormController {
    
    public UserController() {
        //Initialize controller properties here or 
        //in the Web Application Context

        
        //if set values in dispatcher-servlet in the bean ,you don't need to write these four lines
//        setCommandClass(User.class);
//        //to form view
//        setCommandName("user");
//        setSuccessView("form-success");
//        setFormView("LoginForm");
    }
    
    @Override
    protected void doSubmitAction(Object command) throws Exception {
//        onSubmit(request, response, command, errors);
    }

    //Use onSubmit instead of doSubmitAction 
    //when you need access to the Request, Response, or BindException objects
    
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
        ModelAndView mv = null;
        //Do something...
        HttpSession session = request.getSession();
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
        User u = (User)command;
        //denpendency injection
        UserDao userdao = (UserDao) getApplicationContext().getBean("userdao");
        User login = userdao.autentication(u.getUsename(), u.getPassword());
        System.out.println(login);
        if(login == null){
            // user not exist, cannot go to form directly, must to a error page
            mv = new ModelAndView("error");
            return mv;
        }else{
            session.setAttribute("USER", login.getUsename());
            mv = new ModelAndView("form-success");
            return mv;
        }
        
    }
     
}
