/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.pojo;

import java.util.ArrayList;

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
    private boolean status;
    //你关注的人
    private ArrayList<User> follewdUsers;
    // your fans
    private ArrayList<User> fanList;
    //你写的文章
    private ArrayList<Article> articles;
    //你点赞的文章
    private ArrayList<Article> likes;
    private ArrayList<Comment> commentList;

    public User() {
    }

    public ArrayList<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(ArrayList<Comment> commentList) {
        this.commentList = commentList;
    }

    public ArrayList<User> getFanList() {
        return fanList;
    }

    public void setFanList(ArrayList<User> fanList) {
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

    public ArrayList<User> getFollewdUsers() {
        return follewdUsers;
    }

    public void setFollewdUsers(ArrayList<User> follewdUsers) {
        this.follewdUsers = follewdUsers;
    }

    public ArrayList<Article> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<Article> articles) {
        this.articles = articles;
    }

    public ArrayList<Article> getLikes() {
        return likes;
    }

    public void setLikes(ArrayList<Article> likes) {
        this.likes = likes;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
