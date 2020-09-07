/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.dao;

import com.neu.exception.UserException;
import com.neu.pojo.User;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 *
 * @author root
 */
public class AdminDao extends DAO{
    
    //list all user's information for administrator
    public List<User> listAllUser() throws UserException {
        List<User> list = new ArrayList<>();
	try {
            super.begin();
            Query query = getSession().createQuery("from User");
            List<User> list_original = query.list();
            commit();
            
            list.addAll(list_original);
            for(User user: list_original){
                if(user.getUserName().equals("admin"))
                    list.remove(user);
            }
            return list;
//            return list_original;
	} catch (HibernateException e) {
            rollback();
            throw new UserException("Could not list the users", e);
	}
    }
    
    //change user status
    public List<User> changeStatus(String changeStatus, long userid) throws UserException{
        try {
            super.begin();
            Query query = getSession().createQuery("from User where userId= :userId");
            query.setLong("userId", userid);
            User user = (User) query.uniqueResult();
            if(changeStatus.equals("drop"))
                user.setStatus(false);
            if(changeStatus.equals("resume"))
                user.setStatus(true);
            commit();
            List<User> list = this.listAllUser();
            return list;
	} catch (HibernateException e) {
            rollback();
            throw new UserException("Could not cahnge user status", e);
	}
    }
    
}
