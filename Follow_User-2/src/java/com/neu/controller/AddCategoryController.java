/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.controller;

import com.neu.dao.CategoryDao;
import com.neu.pojo.Category;
import com.neu.pojo.User;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author root
 */
public class AddCategoryController extends AbstractController {
    
    public AddCategoryController() {
    }
    
    protected ModelAndView handleRequestInternal(HttpServletRequest request,HttpServletResponse response) throws Exception {
        User user = (User) request.getSession().getAttribute("user");
        if(user != null){
            String cat = request.getParameter("ac");
            Category category = new Category();
            category.setCategory(cat);
            category.setUser(user);
            CategoryDao categoryDao = new CategoryDao();
            user = categoryDao.addCategory(category, user);
            return new ModelAndView("writeArticle","user",user);
        }else{
            return new ModelAndView("login");
        }
    }
}
