/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.dao;

import com.neu.pojo.Category;

/**
 *
 * @author root
 */
public class CategoryDao extends DAO{
    public Category create(Category cat) throws Exception{
        try{
            super.begin();
            getSession().save(cat);
            super.commit();
        }catch(Exception e){
            super.rollback();
        }
        
        return cat;
    }
}
