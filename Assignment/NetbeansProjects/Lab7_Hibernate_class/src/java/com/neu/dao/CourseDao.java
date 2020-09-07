/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.metamodel.MetadataSources;

/**
 *
 * @author root
 */
public class CourseDao {
    private SessionFactory sessionFactory;
    private Session session;
    
    protected SessionFactory setup(){
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        StandardServiceRegistry registery = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        this.sessionFactory = new MetadataSources(registery).buildMetadata().buildSessionFactory();
        return sessionFactory;
    }
    
    public Session getSession(){
        this.session = setup().openSession();
        return session;
    }
}
