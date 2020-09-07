/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servelet;

/**
 *
 * @author root
 */
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Part7Servelet_welcome extends  HttpServlet {
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String option = request.getParameter("selection");
        String redirectPage = "./index.html";
        if(option != null){
            if(option.equals("bm")){
                redirectPage = "./part7SearchMovie.html";
                response.sendRedirect(redirectPage);
            }else{
                redirectPage = "./part7AddMovie.html";
                response.sendRedirect(redirectPage);
            }
        }
    }
}
