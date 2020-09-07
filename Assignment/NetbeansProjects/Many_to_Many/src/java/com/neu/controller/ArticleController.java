/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.controller;

import com.neu.dao.ArticleDao;
import com.neu.pojo.Article;
import com.neu.pojo.Image;
import com.neu.pojo.User;
import java.util.HashSet;
import java.util.Set;
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
        ArticleDao articleDao = new ArticleDao();
        if(writeArticle != null){
            if(writeArticle.equals("write")){
                String content = request.getParameter("content");
                String file = request.getParameter("image");
                //set images
                Image image = new Image();
                image.setPath(file);
                Set<Image> imageList = new HashSet<>();
                imageList.add(image);
                //set aritcle
                Article article = new Article();
                article.setContent(content);
                article.setImageList(imageList);
                //ensure user is validate
                if(user != null)
                    article.setUser(user);
                else
                    return new ModelAndView("login");
                article.setLikeNumber(0);
                //add article to database
                articleDao.addArticle(article);
                return new ModelAndView("success");

            }else if(writeArticle.equals("edit")){
                //editArticle OR listOld
                String step = request.getParameter("step");
                request.setAttribute("writeArticle", writeArticle);
                if(step.equals("listOld")){
                    long articleId = Long.parseLong(request.getParameter("articleId"));
                    Article oldArticle = articleDao.getArticleById(articleId);
                    request.setAttribute("ifNull", oldArticle==null);
                    return new ModelAndView("writeArticle","article",oldArticle);
                }else{
                    long articleId = Long.parseLong(request.getParameter("articleId"));
                    String content = request.getParameter("content");
                    Set<Article> articleList = null;
                    if(articleDao.editArticle(articleId, content)){
                        if(user != null)
                            articleList = user.getArticles();
                        else
                            return new ModelAndView("login"); 
                    }  
                    return new ModelAndView("articleMyList","articleList",articleList);
                } 
//            }else if(writeArticle.equals("browse")){
            }else if(writeArticle.equals("details")){
                long articleId = Long.parseLong(request.getParameter("articleId"));
                Article article = articleDao.getArticleById(articleId);
                return new ModelAndView("viewArticleDetails","article",article);
            }else if(writeArticle.equals("comment")){
                long articleId = Long.parseLong(request.getParameter("articleId"));
                String comment = request.getParameter("comment");
                Article article = articleDao.getArticleById(articleId);
                if(user != null)
                    articleDao.addComment(article, comment, user);
                else
                    return new ModelAndView("login");
                        
                return new ModelAndView("viewArticleDetails","article",article);
            }else if(writeArticle.equals("like")){
                long articleId = Long.parseLong(request.getParameter("articleId"));
                Article article = articleDao.getArticleById(articleId);
                if(user != null)
                    articleDao.likeArticle(article, user);
                else
                    return new ModelAndView("login");
                return new ModelAndView("viewArticleDetails","article",article);
            }else if(writeArticle.equals("browseLiked")){
                Set<Article> articleList;
                //ensure user is validate
                if(user != null)
//                    articleList = user.getLikedArticles();
                articleList = user.getLikeList();
                else
                    return new ModelAndView("login");
                return new ModelAndView("articleMyList","articleList",articleList);
            }
            else{
                Set<Article> articleList;
                //ensure user is validate
                if(user != null)
                    articleList = user.getMyArticles();
                else
                    return new ModelAndView("login");
                return new ModelAndView("articleMyList","articleList",articleList);
            }
        }else{
            return new ModelAndView("writeArticle");
        }
    }
    
}
