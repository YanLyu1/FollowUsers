/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hw4;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sun.misc.BASE64Decoder;

/**
 *
 * @author root
 */
public class Authentication extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //HttpSession session = request.getSession();
        String file = request.getParameter("file");
        String authorization = request.getHeader("Authorization");
        String url = "welcome.jsp";
        if(file.equals("")){
            request.getRequestDispatcher(url).forward(request, response);
        }else{
            if(authorization == null){
                askForPassword(response);
            }else{
                //authorization headers looks like "Basic mmmm", mmmm is the base64 encoded username and password.
                //we want the part after Basic .
                String userInfo = authorization.substring(6).trim();
                BASE64Decoder decoder = new BASE64Decoder();
                String nameAndPassword = new String(decoder.decodeBuffer(userInfo));
                //decode part looks loke "username:password"
                int index = nameAndPassword.indexOf(":");
                String user = nameAndPassword.substring(0,index);
                String password = nameAndPassword.substring(index+1);
                if(areEqualReversed(user,password)){
                    request.setAttribute("file", file);
                    url = "Display.jsp";
                    request.getRequestDispatcher(url).forward(request, response);
                }else{
                    askForPassword(response);
                }
            }
        }  
    }
    
    //when not authenticated
    private void askForPassword(HttpServletResponse response){
        //send to 401
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setHeader("WWW-Authenticate", "BASIC realm=\"Insider-Trading\"");
    }
    
    //if s1 is the reverse of s2, return true
    private boolean areEqualReversed(String s1, String s2){
        s2 = (new StringBuffer(s2)).reverse().toString();
        return ((s1.length() > 0) && s1.equals(s2));
    }
}
