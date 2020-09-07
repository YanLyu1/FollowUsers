/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.dao;

import com.neu.exception.UserException;
import com.neu.pojo.Image;

/**
 *
 * @author root
 */
public class ImageDao extends DAO{
    public Image add(Image image) throws Exception{
        try{
            super.begin();
            getSession().save(image);
            super.commit();
        }catch(Exception e){
            super.rollback();
//            e.printStackTrace();
            throw new UserException("User dao error", e.getCause());
       }  
        return image;
    }
}
