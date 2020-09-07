/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author root
 */
public class User {
    private long userId;
    private String userName;
    private String password;
    private String avatarPath;
    private String introduction;
    private String email;
    private String phoneNumber;
    private boolean status;
    //user you followed
    private Set<User> follewdUsers;
    // your fans
    private Set<User> fanList;
    //Your articles
    private Set<Article> articles;
    //articles you like
    private Set<Article> likeList;
    //all catogory list for this user
    private Set<Category> categoryList;

    public User() {
        articles  = new HashSet<>();
        likeList = new HashSet<>();
        follewdUsers = new HashSet<>();
        fanList = new HashSet<>();
        categoryList = new HashSet<>();
    }

    public Set<User> getFanList() {
        return fanList;
    }

    public void setFanList(Set<User> fanList) {
        this.fanList = fanList;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatarPath() {
        return avatarPath;
    }

    public void setAvatarPath(String avatarPath) {
        this.avatarPath = avatarPath;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Set<Article> getArticles() {
//        Set<Article> list = new HashSet<Article>();
//        list.addAll(articles);
//        for(Article article: articles){
//            if(article.getUser().getUserName() != userName)
//                list.remove(article);
//        }
//        return list;
        return articles;
    }

    public void setArticles(Set<Article> articles) {
        this.articles = articles;
    }

    public Set<Article> getLikeList() {
        return likeList;
    }

    public void setLikeList(Set<Article> likeList) {
        this.likeList = likeList;
    }

    public Set<User> getFollewdUsers() {
        return follewdUsers;
    }

    public void setFollewdUsers(Set<User> follewdUsers) {
        this.follewdUsers = follewdUsers;
    }
    
    public Set<Article> getMyArticles() {
        Set<Article> list = new HashSet<Article>();
        list.addAll(articles);
        for(Article article: articles){
            if(article.getUser().getUserName() != userName)
                list.remove(article);
        }
        return list;
    }
    
    public Set<Article> getLikedArticles() {
        Set<Article> list = new HashSet<Article>();
        list.addAll(articles);
        for(Article article: articles){
            if(article.getUser().getUserName() == userName)
                list.remove(article);
        }
        return list;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(Set<Category> categoryList) {
        this.categoryList = categoryList;
    }
    
}