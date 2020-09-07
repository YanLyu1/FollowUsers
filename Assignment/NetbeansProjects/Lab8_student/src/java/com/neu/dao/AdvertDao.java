/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.dao;

import com.neu.pojo.Advert;

/**
 *
 * @author root
 */
public class AdvertDao extends DAO{
    public Advert create(Advert adv) throws Exception{
        try{
            super.begin();
            getSession().save(adv);
            super.commit();
        }catch(Exception e){
            super.rollback();
        }
        return adv;
    }
    
}
