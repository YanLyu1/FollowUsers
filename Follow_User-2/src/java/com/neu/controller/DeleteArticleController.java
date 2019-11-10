/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.controller;

import com.neu.dao.ArticleDao;
import com.neu.dao.UserDao;
import com.neu.exception.ComparatorImpl;
import com.neu.pojo.Article;
import com.neu.pojo.User;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author root
 */
public class DeleteArticleController extends AbstractController {
    
    public DeleteArticleController() {
    }
    
    protected ModelAndView handleRequestInternal(HttpServletRequest request,HttpServletResponse response) throws Exception {
        ArticleDao articleDao = new ArticleDao();
        UserDao userDao = new UserDao();
        User user = (User) request.getSession().getAttribute("user");
        long articleId = Long.parseLong(request.getParameter("articleId"));
        Article article = articleDao.getArticleById(articleId);
        userDao.deleteArticle(user, article);
        
        Map<String,ArrayList<Article>> articlesMap = new HashMap<>();
        Set<Article> articleList = new TreeSet<>(new ComparatorImpl());
        Set<Article> articleList_like = new TreeSet<>(new ComparatorImpl());
        if(user != null){
            articleList = articleDao.getArticleByUser(user.getUserId());
            articleList_like = user.getLikeList();
        }else{
            return new ModelAndView("login");
        } 
        ArrayList<Article> al = new ArrayList<>();
        ArrayList<Article> al_like = new ArrayList<>();
        if(articleList != null)
            al = this.sortSet(articleList);
                    
        if(articleList_like != null)
            al_like = this.sortSet(articleList_like);
                    
        articlesMap.put("mine", al);
        articlesMap.put("like", al_like);
        
        return new ModelAndView("articleMyList","articlesMap",articlesMap);
    }
    
    private ArrayList<Article> sortSet(Set<Article> set){
        ArrayList<Article> al = new ArrayList<>();
            for(Article article: set){
                al.add(article);
            }
        Collections.sort(al, new ComparatorImpl());
        return al;
    }
    
}
