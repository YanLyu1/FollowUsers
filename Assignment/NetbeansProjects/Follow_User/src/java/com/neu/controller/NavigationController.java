/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.controller;

import com.neu.dao.ArticleDao;
import com.neu.pojo.Article;
import com.neu.pojo.PageBean;
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
public class NavigationController extends AbstractController {
    
    public NavigationController() {
    }
    
    protected ModelAndView handleRequestInternal(HttpServletRequest request,HttpServletResponse response) throws Exception {
        String navigation = request.getParameter("navigation");
        User user;
        HttpSession session = request.getSession();
        if(navigation.equals("home")){
            if(navigation.equals("home")){
                user = (User) session.getAttribute("user");
                if(user != null){
                    return new ModelAndView("home","user",user);
                }else{
                    return new ModelAndView("login");
                }
            }else{
                
            }
        }else if(navigation.equals("pagination")){
            ArticleDao articleDao = new ArticleDao();
            String pageNum = request.getParameter("pageNum");
            int pageSize = 5;
            if(pageNum == null){
                pageNum="1";
            }
            PageBean<Article> pb =  articleDao.findAllStudentWithPage(Integer.parseInt(pageNum),pageSize);
            ModelAndView model = new ModelAndView("pagination","pb",pb);
            return model;
        }
        return new ModelAndView("break");
    }
    
}
