/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.controller;

import com.neu.dao.DAO;
import com.neu.dao.UserDao;
import com.neu.pojo.Image;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author root
 */
public class TestController extends AbstractController {
    
    public TestController() {
    }
    
    protected ModelAndView handleRequestInternal(HttpServletRequest request,HttpServletResponse response) throws Exception {
//        UserDao imageDao= (UserDao) getApplicationContext().getBean("imageDao");
//        Image image = (Image)getApplicationContext().getBean("image");
//        UserDao imageDao = new UserDao();
//        Image image = new Image();
        ModelAndView mv = null;
        DAO dao = new DAO();
//        image.setPath("1234455");
//        imageDao.add(image);
        mv = new ModelAndView("success");
//        Image image = new Image();
        return mv;
    }
    
}