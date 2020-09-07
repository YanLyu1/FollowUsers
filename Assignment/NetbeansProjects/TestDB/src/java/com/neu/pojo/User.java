/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.pojo;

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
    private boolean status;
    //user you followed
    private Set<User> follewdUsers;
    // your fans
    private Set<User> fanList;
    //Your articles
    private Set<Article> articles;
    //articles you like
    private Set<Article> likeList;

    public User() {
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
    
    

    
}
