/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.dao;

import static com.neu.dao.DAO.getSession;
import com.neu.exception.UserException;
import com.neu.pojo.Category;
import com.neu.pojo.User;
import java.util.Set;

/**
 *
 * @author root
 */
public class CategoryDao extends DAO{
    public User addCategory(Category category, User user) throws Exception{
        try{
            boolean duplicate = false;
            Set<Category> categoryList = user.getCategoryList();
            for(Category c:categoryList){
                if(category.getCategory().equals(c.getCategory()))
                    duplicate = true;
            }
            if(!duplicate){
                super.begin();
                getSession().save(category);
                categoryList.add(category);
                user.setCategoryList(categoryList);
                getSession().update(user);
                super.commit();
            }
        }catch(Exception e){
            super.rollback();
            throw new UserException("category dao error", e.getCause());
       }  
        return user;
    }
    
    public Category getCategoryById(long categoryId) throws UserException{
        Category category=null;
        try{
            super.begin();
            category = (Category) getSession().get(Category.class, categoryId);
            super.commit();
        }catch(Exception e){
            super.rollback();
            throw new UserException("category dao error", e.getCause());
       }  
        return category;
    }
}
