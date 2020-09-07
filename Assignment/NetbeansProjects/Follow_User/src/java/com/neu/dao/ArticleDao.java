/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.dao;

import com.neu.exception.UserException;
import com.neu.pojo.Article;
import com.neu.pojo.Comment;
import com.neu.pojo.PageBean;
import com.neu.pojo.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
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
            
//            getSession().flush();
            super.commit();
            getSession().clear();
//            getSession().flush();
        }catch(Exception e){
            super.rollback();
            throw new UserException("addArticle dao error", e.getCause());
       }  
        return article;
    }
    
    //search articles by keywords
    public List<Article> searchArtcile(String keyword) throws UserException{
        List<Article> articles;
        List<Article> al = new ArrayList<>();
        try{
            super.begin();
//            getSession().save(article);
            Criteria criteria = getSession().createCriteria(Article.class);
            Criterion c1 = Restrictions.like("content", keyword, MatchMode.ANYWHERE);
            criteria.add(c1);
            articles = criteria.list();
            for(Article a: articles){
                if(a.isPubpri())
                    al.add(a);
            }
//            getSession().flush();
            super.commit();
//            getSession().flush();
        }catch(HibernateException e){
            super.rollback();
            throw new UserException("searchArtcile dao error", e.getCause());
       }  
        return al;
    }
    
    //search article by id
    public Article getArticleById(long articleId) throws UserException{
        Article article;
        try{
            super.begin();
            article = (Article) getSession().get(Article.class, articleId);
//            getSession().flush();
            super.commit();
//            getSession().flush();
        }catch(Exception e){
            super.rollback();
            throw new UserException("getArticleById dao error", e.getCause());
       }  
        return article;
    }
    
    //edit an existing article
    public boolean editArticle(long articleId, String content, String title, boolean pubpri) throws UserException{
        boolean edit = false;
        try{
            super.begin();
            Article article = (Article) getSession().get(Article.class, articleId);
            article.setContent(content);
            article.setTitle(title);
            article.setPubpri(pubpri);
            getSession().update(article);
            edit = true;
            super.commit();
        }catch(Exception e){
            super.rollback();
            throw new UserException("editArticle dao error", e.getCause());
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
            throw new UserException("addComment dao error", e.getCause());
       }  
        return com;
    }
    
    //like article
    public int likeArticle(Article article, User user) throws UserException{
        int like;
        Set<User> likedBy = article.getLikedBy();
        Set<Article> likedArticles = user.getLikeList();
        try{
            super.begin();
//            like = like + 1;
            //update article's properties
            likedBy.add(user);
            article.setLikedBy(likedBy);
            like = article.getLikedBy().size();
            article.setLikeNumber(like);
            getSession().update(article);
//            article.setUser(author);
            
            //for me
//            likedArticles.add(article);
//            user.setLikeList(likedArticles);
            
//            String hql = "update Article a set a.likeNumber= :likeNumber where a.articleId= :articleId";
//            Query query = getSession().createQuery(hql);
//            query.setInteger("likeNumber", like);
//            query.setLong("articleId", article.getArticleId());
//            getSession().update(article);
//            getSession().update(user);
//            query.executeUpdate();
            super.commit();
        }catch(Exception e){
            super.rollback();
            throw new UserException("like dao error", e.getCause());
       }  
        return like;
    }
    
    public List<Article> getArticles() throws UserException{
        List<Article> articles;
        List<Article> al = null;
        try{
            super.begin();
            getSession().clear();
            String hql = "from Article";
            Query query = getSession().createQuery(hql);
            query.setMaxResults(10);
            articles = query.list();
            super.commit();
//            getSession().flush();
        }catch(Exception e){
            super.rollback();
            throw new UserException("Article dao error", e.getCause());
        }
        
        return articles;
    }
    
    public Set<Article> getArticleByUser(long user) throws UserException{
        Set<Article> articles;
        try{
            super.begin();
            User u = (User) getSession().get(User.class, user);
            articles = u.getArticles();
            super.commit();
        }catch(Exception e){
            super.rollback();
            throw new UserException("Article dao error", e.getCause());
       }  
        return articles;
    }
    
    public PageBean<Article> findAllStudentWithPage(int pageNum, int pageSize) throws UserException{
		List<Article> allArticle = this.searchArtcile("");
		int totalRecord = allArticle.size();
		PageBean<Article> pb = new PageBean<Article>(pageNum, pageSize, totalRecord);
		int startIndex = pb.getStartIndex();
		pb.setList(this.findAll(startIndex,pageSize));
		return pb;
	}
    
    public List<Article> findAll(int startIndex, int pageSize) throws UserException {
        List<Article> list;
        try{
            super.begin();
            //HQL语句在查询时不能使用limit关键字
            Query query = getSession().createQuery("from Article where pubpri= :pubpri").setFirstResult(startIndex).setMaxResults(pageSize);
            query.setBoolean("pubpri", true);
            list = query.list();
            super.commit();
        }catch(Exception e){
            super.rollback();
            throw new UserException("findAll", e.getCause());
       }  
        return list;
    }

}
