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
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Part7Servelet_add extends  HttpServlet {
    
    public void init(ServletConfig config) throws ServletException {
        // Store the ServletConfig object and log the initialization
        super.init(config);
        System.out.println("init run");
        // Load the database to prepare for requests
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String redirectPage = "./wrong.html";
        
        if(!(request.getParameter("title").equals("") || request.getParameter("actor").equals("") || request.getParameter("actress").equals("") || request.getParameter("genre").equals("") || request.getParameter("year").equals(""))){
            //get information
            String title = request.getParameter("title");
            String actor = request.getParameter("actor");
            String actress = request.getParameter("actress");
            String genre = request.getParameter("genre");
            int year = 0;
            try{
                year = Integer.parseInt(request.getParameter("year"));
            }catch(NumberFormatException e){
                response.sendRedirect(redirectPage);
                return;
            }
            
            

            //connect db
            java.sql.Connection connection = null;
            Statement stmt = null;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/moviedb", "root", "ly950223");
                stmt = connection.createStatement();
            } catch (ClassNotFoundException ex) {
                System.out.println("ClassNotFoundException" + ex.getMessage());
            } catch (SQLException ex) {
                System.out.println("SQLException" + ex.getMessage());
            }

            //insert into db
            String sqlQuery = "INSERT INTO movies (title,actor,actress,genre,year)"
                    + "VALUES ('" + title + "','" + actor + "','" + actress + "','" + genre + "','" + year + "')";
            try{
                int rs = stmt.executeUpdate(sqlQuery);
                /*
                if (rs != 0) {
                        System.out.println(rs);
                        session.setAttribute("userName", userName);
                        redirectPage = "/Lab3_Student/message";
                    }
    */
            }catch (SQLException ex){
                System.out.println(ex);
            }finally{
                try {
                    if (stmt != null){
                        stmt.close();
                    }
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException ex) {
                    System.out.println("SQLException" + ex.getMessage());
                }
            }

            redirectPage = "./success_part7.html";
            response.sendRedirect(redirectPage);
        }else{
            redirectPage = "./wrong.html";
            response.sendRedirect(redirectPage);
        }
        
    }
}
