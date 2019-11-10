/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.controller;

import com.neu.dao.UserDao;
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
public class FollowUserController extends AbstractController {
    
    public FollowUserController() {
    }
    
    protected ModelAndView handleRequestInternal(HttpServletRequest request,HttpServletResponse response) throws Exception {
        UserDao userDao = new UserDao();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String browseAction = request.getParameter("browseAction");
        if(user != null){
            if(browseAction.equals("friends")){
                Set<User> userList = user.getFollewdUsers();
                return new ModelAndView("friendSearchResult","userList",userList);
            }else if(browseAction.equals("fans")){
                Set<User> userList = user.getFanList();
                return new ModelAndView("friendSearchResult","userList",userList);
            }else if(browseAction.equals("notFollow")){
                long userId = Long.parseLong(request.getParameter("follow"));
                if(user != null){
                    if(userDao.notFollow(user, userId)){
                        Set<User> userList = user.getFollewdUsers();
                        return new ModelAndView("friendSearchResult","userList",userList);
                    }    
                }else{
                    return new ModelAndView("login");
                }
                return new ModelAndView("break");
            }
            else{
                //get user information from page and get the user object
                long userId = Long.parseLong(request.getParameter("follow"));
        //        User user_follow = userDao.getUserById(userId);  
                //get my information
                if(user != null){
                    if(userDao.follow(user, userId)){
                        Set<User> userList = user.getFollewdUsers();
                        return new ModelAndView("friendSearchResult","userList",userList);
                    }    
                }else{
                    return new ModelAndView("login");
                }
                return new ModelAndView("break");
            }
        }else{
            return new ModelAndView("login");
        }
        
    }
    
}
