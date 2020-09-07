/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.controller;

import com.neu.dao.AdvertDao;
import com.neu.dao.CategoryDao;
import com.neu.dao.UserDao;
import com.neu.pojo.Advert;
import com.neu.pojo.Category;
import com.neu.pojo.Phone;
import com.neu.pojo.User;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author Adi
 */
public class UserController extends AbstractController {

    UserDao userdao;
    CategoryDao categorydao;
    AdvertDao advertdao;
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        //get instances from application context
        userdao = (UserDao) getApplicationContext().getBean("userdao");
        User u = (User) getApplicationContext().getBean("user");
        categorydao = (CategoryDao) getApplicationContext().getBean("categorydao");
        advertdao = (AdvertDao) getApplicationContext().getBean("advertdao");
        
        //set1 is used to store phone numbers
        Set set1 = new HashSet<>();
        // set2 is used to store advert informations
        Set set2 = new HashSet<>();
        
        //create 2 adverts
        Advert ad1 = new Advert("Advert Title 1", "Advert message 1");
        ad1.setUser(u);
        Advert ad2 = new Advert("Advert Title 2", "Advert message 2");
        ad2.setUser(u);
        
        //store adverts in db
        advertdao.create(ad1);
        advertdao.create(ad2);
         
        //put ad information in set
        set2.add(ad1);
        set2.add(ad2);
        
        Category cat = new Category("Category Title" , set2);
        cat.setAdverts(set2);
        
        Phone ph1 = new Phone(987);
        Phone ph2 = new Phone(33121);
        
        set1.add(ph1);
        set1.add(ph2);
        //it is biderectional, you must set user for phone as well
        ph1.setUser(u);
        ph2.setUser(u);
        
        u.setFname("Jon");
        u.setLname("Deo");
        u.setPhoneNos(set1);
        
        userdao.add(u);
        
        return new ModelAndView("user");
    }

}
