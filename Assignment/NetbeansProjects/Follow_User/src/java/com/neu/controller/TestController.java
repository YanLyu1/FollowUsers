/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.controller;

import com.neu.dao.ArticleDao;
import com.neu.dao.UserDao;
import com.neu.pojo.Article;
import com.neu.pojo.User;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author root
 */
public class TestController extends AbstractController {
    
    public TestController() {
    }
    
    protected ModelAndView handleRequestInternal(HttpServletRequest request,HttpServletResponse response) throws Exception {
        User user = (User) request.getSession().getAttribute("user");
        String q= request.getParameter("q");
        ArticleDao ad= new ArticleDao();
        UserDao ud = new UserDao();
        List<Article> articles = ad.searchArtcile(q);
        List<User> users = ud.getUserByName(q, user);
        response.getWriter().print("<table>");
        
        ArrayList<String> res = new ArrayList<>();
        
                
        for (Article a: articles){
            response.getWriter().print("<tr><td>"+a.getTitle()+"</tr></td>");
        }
        response.getWriter().print("</table>");
	return null;
    }
}
