/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author root
 */
public class Dao {

    public Dao() {
    }
    
    private static final SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    private Session session = null;
    
    public Session getSession(){
        try{
            this.session = sf.openSession();
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return session;
//        if (session == null || !session.isOpen()){
//            session = sf.openSession();
//        }
//        return session;
    }
}
