/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.dao;

import com.neu.exception.UserException;
import com.neu.pojo.Article;
import com.neu.pojo.Comment;
import com.neu.pojo.User;
import java.util.List;
import java.util.Set;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author root
 */
public class ArticleDao extends DAO{
    
    //add article to database
    public Article addArticle(Article article) throws Exception{
        try{
            super.begin();
            getSession().save(article);
            super.commit();
        }catch(Exception e){
            super.rollback();
            throw new UserException("Article dao error", e.getCause());
       }  
        return article;
    }
    
    //search articles by keywords
    public List<Article> searchArtcile(String keyword) throws UserException{
        List<Article> articles;
        try{
            super.begin();
//            getSession().save(article);
            Criteria criteria = getSession().createCriteria(Article.class);
            Criterion c1 = Restrictions.like("content", keyword, MatchMode.ANYWHERE);
            criteria.add(c1);
            articles = criteria.list();
            super.commit();
        }catch(Exception e){
            super.rollback();
            throw new UserException("Article dao error", e.getCause());
       }  
        return articles;
    }
    
    //search article by id
    public Article getArticleById(long articleId) throws UserException{
        Article article;
        try{
            super.begin();
            article = (Article) getSession().get(Article.class, articleId);
            super.commit();
        }catch(Exception e){
            super.rollback();
            throw new UserException("Article dao error", e.getCause());
       }  
        return article;
    }
    
    //edit an existing article
    public boolean editArticle(long articleId, String content) throws UserException{
        boolean edit = false;
        try{
            super.begin();
            Article article = (Article) getSession().get(Article.class, articleId);
            article.setContent(content);
            getSession().update(article);
            edit = true;
            super.commit();
        }catch(Exception e){
            super.rollback();
            throw new UserException("Article dao error", e.getCause());
       }  
        return edit;
    }
    
    //add comment to an article
    public boolean addComment(Article article, String comment, User user) throws UserException{
        boolean com = false;
        try{
            super.begin();
            Set<Comment> commentList = article.getCommentList();
            Comment comments = new Comment();
            comments.setContent(comment);
            comments.setArticle(article);
            comments.setCommentBy(user);
            commentList.add(comments);
            getSession().save(comments);
            com = true;
            super.commit();
        }catch(Exception e){
            super.rollback();
            throw new UserException("Article dao error", e.getCause());
       }  
        return com;
    }
    
    //like article
    public int likeArticle(Article article, User user) throws UserException{
        int like = article.getLikeNumber();
        Set<User> likedBy = article.getLikedBy();
        try{
            super.begin();
            like = like + 1;
            article.setLikeNumber(like);
            likedBy.add(user);
            article.setLikedBy(likedBy);
            getSession().update(article);
            super.commit();
        }catch(Exception e){
            super.rollback();
            throw new UserException("Article dao error", e.getCause());
       }  
        return like;
    }
}
