/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.controller;

import com.neu.dao.ArticleDao;
import com.neu.dao.CategoryDao;
import com.neu.exception.ComparatorImpl;
import com.neu.pojo.Article;
import com.neu.pojo.Category;
import com.neu.pojo.Image;
import com.neu.pojo.User;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author root
 */
public class ArticleController extends AbstractController {
    
    public ArticleController() {
    }
    
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request,HttpServletResponse response) throws Exception {
        //distingush action for articles: write OR browse OR edit
        String writeArticle = request.getParameter("articleAction");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        CategoryDao categoryDao = new CategoryDao();
        ArticleDao articleDao = new ArticleDao();
        if(writeArticle != null){
            switch (writeArticle) {
                case "write":
                {
                    String title = request.getParameter("title");
                    String content = request.getParameter("content");
                    String file = request.getParameter("image");
                    String c = request.getParameter("category");
                    boolean pubpri = Boolean.parseBoolean(request.getParameter("pubpri"));
                    Long categoryId = Long.parseLong(request.getParameter("category"));
                    Category category = categoryDao.getCategoryById(categoryId);
                    //set images
                    Image image = new Image();
                    image.setPath(file);
                    Set<Image> imageList = new HashSet<>();
                    imageList.add(image);
                    //set aritcle
                    Article article = new Article();
                    article.setContent(content);
                    article.setPubpri(pubpri);
                    article.setImageList(imageList);
                    article.setTitle(title);
                    article.setCategory(category);
                    Set<Article> articleList_like = new TreeSet<>();
                    //ensure user is validate
                    if(user != null){
                        article.setUser(user);
                        articleList_like = user.getLikeList();
                    }else{
                        return new ModelAndView("login");
                    }  
                    article.setLikeNumber(0);
                    //add article to database
                    articleDao.addArticle(article);
                    request.setAttribute("writeArticle", writeArticle);
                    Set<Article> articleList = articleDao.getArticleByUser(user.getUserId());
                    Map<String,ArrayList<Article>> articlesMap = new HashMap<>();
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
                case "edit":
                    //editArticle OR listOld
                    String step = request.getParameter("step");
                    request.setAttribute("writeArticle", writeArticle);
                    if(step.equals("listOld")){
                        long articleId = Long.parseLong(request.getParameter("articleId"));
                        Article oldArticle = articleDao.getArticleById(articleId);
                        request.setAttribute("ifNull", oldArticle==null);
                        request.setAttribute("writeArticle", writeArticle);
                        return new ModelAndView("writeArticle","article",oldArticle);
                    }else{ 
                        long articleId = Long.parseLong(request.getParameter("articleId"));
                        String content = request.getParameter("conten1");
                        String title = request.getParameter("title");
                        boolean pubpri = Boolean.parseBoolean(request.getParameter("pubpri"));
                        Set<Article> articleList = null;
                        Set<Article> articleList_like = null;
                        if(articleDao.editArticle(articleId, content, title, pubpri)){
                            if(user != null){
                                articleList_like = user.getLikeList();
                                articleList = articleDao.getArticleByUser(user.getUserId());
                            }
                            else{
                                return new ModelAndView("login");
                            }  
                        }
                        Map<String,ArrayList<Article>> articlesMap = new HashMap<>();
                        ArrayList<Article> al = new ArrayList<>();
                        ArrayList<Article> al_like = new ArrayList<>();
                    
                        if(articleList != null)
                            al = this.sortSet(articleList);
                    
                        if(articleList_like != null)
                            al_like = this.sortSet(articleList_like);
                        
                        articlesMap.put("mine", al);
                        articlesMap.put("like", al_like);
                        return new ModelAndView("articleMyList","articlesMap",articlesMap);
                        //return new ModelAndView("success");
                    }
                case "details":
                {
                    long articleId = Long.parseLong(request.getParameter("articleId"));
                    Article article = articleDao.getArticleById(articleId);
                    return new ModelAndView("viewArticleDetails","article",article);
                }
                case "comment":
                {
                    long articleId = Long.parseLong(request.getParameter("articleId"));
                    String comment = request.getParameter("comment");
                    Article article = articleDao.getArticleById(articleId);
                    if(user != null)
                        articleDao.addComment(article, comment, user);
                    else
                        return new ModelAndView("login");
                    
                    return new ModelAndView("viewArticleDetails","article",article);
                }
                case "like":
                {
                    long articleId = Long.parseLong(request.getParameter("articleId"));
                    Article article = articleDao.getArticleById(articleId);
                    if(user != null)
                        articleDao.likeArticle(article, user);
                    else
                        return new ModelAndView("login");
                    return new ModelAndView("viewArticleDetails","article",article);
                }
                case "browseLiked":
                {
                    Set<Article> articleList;
                    //ensure user is validate
                    if(user != null)
//                    articleList = user.getLikedArticles();
                        articleList = user.getLikeList();
                    else
                        return new ModelAndView("login");
                    return new ModelAndView("articleMyList","articleList",articleList);
                }
                case "all":
                {
                    ArrayList<Article> articleList = (ArrayList<Article>) articleDao.getArticles();
                    Set<Article> articleList_like = user.getLikeList();
                    ArrayList<Article> al_like = new ArrayList<>();
                    Collections.sort(articleList, new ComparatorImpl());
                    Map<String,ArrayList<Article>> articlesMap = new HashMap<>();
                    
                    if(articleList_like != null)
                        al_like = this.sortSet(articleList_like);
                    
                    articlesMap.put("like", al_like);
                    articlesMap.put("mine", articleList);
                    return new ModelAndView("articleMyList","articlesMap",articlesMap);
                }
                default:
                {
                    Map<String,ArrayList<Article>> articlesMap = new HashMap<>();
                    Set<Article> articleList = new TreeSet<>(new ComparatorImpl());
                    Set<Article> articleList_like = new TreeSet<>(new ComparatorImpl());
                    if(user != null){
                        articleList = articleDao.getArticleByUser(user.getUserId());
                        articleList_like = user.getLikeList();
                    }   
                    else{
                        return new ModelAndView("login");
                    } 
                    ArrayList<Article> al = new ArrayList<>();
                    ArrayList<Article> al_like = new ArrayList<>();
                    
//                    for(Article article: articleList){
//                        al.add(article);
//                    }
                    
//                    for(Article article: articleList_like){
//                        al_like.add(article);
//                    }
                    
                    if(articleList != null)
                        al = this.sortSet(articleList);
                    
                    if(articleList_like != null)
                        al_like = this.sortSet(articleList_like);
                    
                    articlesMap.put("mine", al);
                    articlesMap.put("like", al_like);
                    
                    return new ModelAndView("articleMyList","articlesMap",articlesMap);
                }
            }
        }else{
            request.setAttribute("writeArticle", writeArticle);
            return new ModelAndView("writeArticle");
        }
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
