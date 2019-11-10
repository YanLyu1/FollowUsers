/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.controller;

import com.neu.dao.AdminDao;
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
public class StatusController extends AbstractController {
    
    public StatusController() {
    }
    
    protected ModelAndView handleRequestInternal(HttpServletRequest request,HttpServletResponse response) throws Exception {
        //get action type
        String changeStatus = request.getParameter("changeStatus");
        long userId = 0;
        if(request.getParameter("userId") != null)
            userId= Long.parseLong(request.getParameter("userId"));
        AdminDao adminDao = new AdminDao();
        List<User> userList = adminDao.listAllUser();
        //change user status
        if(changeStatus != null){
            userList = adminDao.changeStatus(changeStatus, userId);
        }
        return new ModelAndView("changeUserStatus_Admin","userList", userList);
    }
    
}
