/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw4.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import sun.misc.BASE64Decoder;

/**
 *
 * @author root
 */
public class AuthenticationController extends AbstractController {
    
    public AuthenticationController() {
    }
    
    protected ModelAndView handleRequestInternal( HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = null;
        String file = request.getParameter("file");
        String hide = request.getParameter("welcome");
        String authorization = request.getHeader("Authorization");
        //String url = "welcome.jsp";
        if(hide!=null){
            if(file.equals("")){
                mv = new ModelAndView("welcome");
                return mv;
            }else{
                if(authorization == null){
                    askForPassword(response);
                    mv = new ModelAndView("welcome");
                    return mv;
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
    //                    url = "Display.jsp";
    //                    request.getRequestDispatcher(url).forward(request, response);
                        mv = new ModelAndView("Display");
                        return mv;
                    }else{
                        askForPassword(response);
                        mv = new ModelAndView("welcome");
                        return mv;
                    }
                }
            } 
        }else{
            mv = new ModelAndView("welcome");
            return mv;
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
