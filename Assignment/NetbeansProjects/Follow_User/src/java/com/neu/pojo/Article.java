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
public class Article{
    private long articleId;
    private int likeNumber;
    private String content;
    private String title;
    private boolean pubpri;
    //who post it
    private User user;
    private Category category;
    private Set<Image> imageList;
    private Set<Comment> commentList;
    private Set<User> likedBy;

    public Article() {
    }

    public long getArticleId() {
        return articleId;
    }

    public void setArticleId(long articleId) {
        this.articleId = articleId;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getLikeNumber() {
        return likeNumber;
    }

    public void setLikeNumber(int likeNumber) {
        this.likeNumber = likeNumber;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Set<Image> getImageList() {
        return imageList;
    }

    public void setImageList(Set<Image> imageList) {
        this.imageList = imageList;
    }

    public Set<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(Set<Comment> commentList) {
        this.commentList = commentList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<User> getLikedBy() {
        return likedBy;
    }

    public void setLikedBy(Set<User> likedBy) {
        this.likedBy = likedBy;
    }

//    @Override
//    public int compareTo(Article o) {
//        return (int) (o.articleId - articleId);
//    }

    public boolean isPubpri() {
        return pubpri;
    }

    public void setPubpri(boolean pubpri) {
        this.pubpri = pubpri;
    }

}
