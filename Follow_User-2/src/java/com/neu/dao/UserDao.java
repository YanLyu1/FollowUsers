/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.dao;

import com.neu.exception.UserException;
import com.neu.pojo.Article;
import com.neu.pojo.User;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
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
    public List<User> getUserByName(String userName, User user) throws UserException{
        List<User> userList = new ArrayList<>();
        List<User> list = new ArrayList<>();
        try{
            super.begin();
//            user = (User) getSession().get(User.class, userId);
            Criteria criteria = getSession().createCriteria(User.class);
            Criterion c1 = Restrictions.like("userName", userName, MatchMode.ANYWHERE);
            criteria.add(c1);
            userList = criteria.list();
            list = this.removeAdmin(userList,user);
            super.commit();
        }catch(Exception e){
            super.rollback();
            throw new UserException("get user by id error", e.getCause());
        } 
        return list;
    }
    
    //follow another user
    public boolean follow(User user, long followedId) throws UserException{
        //user:I; followed: my friend
        boolean success = false;
        if(user.getUserId() == followedId)
            return success;
        String error;
        Set<User> followedUsers = user.getFollewdUsers();
        User followed = this.getUserById(followedId);
        followedUsers.add(followed);
        user.setFollewdUsers(followedUsers);
        
        Set<User> fanList = followed.getFanList();
        fanList.add(user);
        error="fanList.add(user);";
        //set fanList error
        followed.setFanList(fanList);
        error="followed.setFanList(fanList);";
        
        
        try{
            super.begin();
            // way 1
            getSession().update(user);
            getSession().update(followed);
            error="getSession().update(followed);";
            
            // way 2
//            String sql = "INSERT INTO i_followed VALUES ('" + user.getUserId()+"','" + followedId+"')";
//            getSession().createSQLQuery(sql);
            super.commit();
            error="super.commit();";
            success = true;
            error="success = true;";
        }catch(Exception e){
            super.rollback();
            throw new UserException(error, e.getCause());
//            throw new UserException("follow user error", e.getCause());
        }
        return success;
    }
    
    //remove admin from result sets
    public List<User> removeAdmin(List<User> resultSet, User u){
        List<User> list = new ArrayList();
        list.addAll(resultSet);
        for(User user:resultSet)
            if(user.getUserName().equals("admin") || user.getUserName().equals(u.getUserName()))
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
    
    public boolean notFollow(User user, long followedId) throws UserException{
        //user:I; followed: my friend
        boolean success = false;
        String error;
        Set<User> followedUsers = user.getFollewdUsers();
        User followed = this.getUserById(followedId);
        followedUsers.remove(followed);
        user.setFollewdUsers(followedUsers);
        
        Set<User> fanList = followed.getFanList();
        fanList.remove(user);
        error="fanList.add(user);";
        //set fanList error
        followed.setFanList(fanList);
        error="followed.setFanList(fanList);";

        try{
            super.begin();
            // way 1
            getSession().update(user);
            getSession().update(followed);
            error="getSession().update(followed);";
            
            // way 2
//            String sql = "INSERT INTO i_followed VALUES ('" + user.getUserId()+"','" + followedId+"')";
//            getSession().createSQLQuery(sql);
            super.commit();
            error="super.commit();";
            success = true;
            error="success = true;";
        }catch(Exception e){
            super.rollback();
            throw new UserException(error, e.getCause());
//            throw new UserException("follow user error", e.getCause());
        }
        return success;
    }
    
    public boolean logout(HttpServletRequest request){
        boolean success = false;
        request.getSession().invalidate();
        return success;
    }
    
    public Set<Article> getFriendArticle(Long friendId) throws UserException{
        Set<Article> al = new HashSet<>();
        User friend = this.getUserById(friendId);
        Set<Article> friendArticle = friend.getArticles();
        for(Article a: friendArticle){
            if(a.isPubpri())
                al.add(a);
        }
        return al;
    }
    
    public User getUserByEmail(String email){
        Criteria criteria = getSession().createCriteria(User.class);
        Criterion c1 = Restrictions.eq("email", email);
        criteria.add(c1);
        User user = (User) criteria.uniqueResult();
        return user;
    }
    
    public User getAdmin(){
        Criteria criteria = getSession().createCriteria(User.class);
        Criterion c1 = Restrictions.eq("userName", "admin");
        criteria.add(c1);
        User user = (User) criteria.uniqueResult();
        return user;
    }
    
    public boolean isDuplicatedEmail(String email) throws UserException{
        boolean duplicated = false;
        String hql = "from User where email= :email";
        try{
            super.begin();
            Query query = getSession().createQuery(hql);
            query.setString("email", email);
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
    
    public User updateInformation(User user) throws UserException{
        try{
            super.begin();
            getSession().update(user);
            super.commit();
        }catch(Exception e){
            super.rollback();
            throw new UserException("update error", e.getCause());
        }  
        return user;
    }
    
    public boolean deleteArticle(User user, Article article) throws UserException{
//        ArticleDao aritcleDao = new ArticleDao();
//        Article article = aritcleDao.getArticleById(articleId);
        article.setUser(null);
        Set<Article> articleList = user.getArticles();
        articleList.remove(article);
        user.setArticles(articleList);
        boolean delete = false;
         try{
            super.begin();
            getSession().update(user);
            getSession().delete(article);
            super.commit();
            delete = true;
        }catch(Exception e){
            super.rollback();
            throw new UserException("deleteArticle error", e.getCause());
        }  
        return delete;
    }
}
