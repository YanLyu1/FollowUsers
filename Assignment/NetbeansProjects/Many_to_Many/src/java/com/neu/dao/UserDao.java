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
import java.util.Set;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author root
 */
public class UserDao extends DAO{
    
    //add a new user's information into database
    public User add(User user) throws Exception{
        try{
            super.begin();
            getSession().save(user);
            super.commit();
        }catch(Exception e){
            super.rollback();
            throw new UserException("User dao error", e.getCause());
        }
        return user;
    }
    
    //if username is duplicated, return true, else return false;
    public boolean isDuplicated(String username) throws UserException{
        boolean duplicated = false;
        String hql = "from User where userName= :username";
        try{
            super.begin();
            Query query = getSession().createQuery(hql);
            query.setString("username", username);
            User user = (User) query.uniqueResult();
            super.commit();
            if(user != null)
                duplicated = true;
        }catch(Exception e){
            super.rollback();
            throw new UserException("check duplication error", e.getCause());
        }  
        return duplicated;
    }
    
    //if userName match password, return user, else return null
    //check userName if exist in database
    public User login(String userName, String password) throws UserException{
        String hql = "from User where userName= :username";
        User user = null;
        if(!this.isExist(userName))
                return user;
        try{
            super.begin();
            Query query = getSession().createQuery(hql);
            query.setString("username", userName);
            user = (User) query.uniqueResult();
            super.commit();
            if(!user.getPassword().equals(password) || !user.isStatus())
                user = null;
        }catch(Exception e){
            super.rollback();
            throw new UserException("log in error", e.getCause());
        }
        return user;
    }
    
    //get user by id
    public User getUserById(long userId) throws UserException{
        User user = null;
        try{
            super.begin();
            user = (User) getSession().get(User.class, userId);
            super.commit();
        }catch(Exception e){
            super.rollback();
            throw new UserException("get user by id error", e.getCause());
        } 
        return user;
    }
    
    //get user by name
    public List<User> getUserByName(String userName) throws UserException{
        List<User> userList = new ArrayList<>();
        List<User> list = new ArrayList<>();
        try{
            super.begin();
//            user = (User) getSession().get(User.class, userId);
            Criteria criteria = getSession().createCriteria(User.class);
            Criterion c1 = Restrictions.like("userName", userName, MatchMode.ANYWHERE);
            criteria.add(c1);
            userList = criteria.list();
            list = this.removeAdmin(userList);
            super.commit();
        }catch(Exception e){
            super.rollback();
            throw new UserException("get user by id error", e.getCause());
        } 
        return list;
    }
    
    //follow another user
    public boolean follow(User user, User followed) throws UserException{
        //user:I; followed: my friend
        boolean success = false;
        Set<User> fanList = user.getFollewdUsers();
        fanList.add(followed);
        user.setFanList(fanList);
        try{
            super.begin();
//            getSession().update(user);

//            String hql = "update User u set u.fanList= :fanList where u.userId= :userId";
//            Query query = getSession().createQuery(hql);
//            query.setEntity("fanList", fanList);
//            query.setLong("userId", user.getUserId());
            
            super.commit();
            success = true;
        }catch(Exception e){
            super.rollback();
            throw new UserException("follow user error", e.getCause());
        }
        return success;
    }
    
    //remove admin from result sets
    public List<User> removeAdmin(List<User> resultSet){
        List<User> list = new ArrayList();
        list.addAll(resultSet);
        for(User user:resultSet)
            if(user.getUserName().equals("admin"))
                list.remove(user);
        return list;
    }
    
    //check if userName exist
    public boolean isExist(String userName) throws UserException{
        boolean exist = false;
        try{
            super.begin();
            String hql = "from User";
            Query query = getSession().createQuery(hql);
            List<User> allUsers = query.list();
            super.commit();
            for(User user: allUsers){
                if(userName.equals(user.getUserName()))
                    exist=true;
            }
        }catch(Exception e){
            super.rollback();
            throw new UserException("get user by id error", e.getCause());
        }
        return exist;
    }
}
