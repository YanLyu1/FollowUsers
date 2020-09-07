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
import VO.Movie;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;

public class Part7Servelet_search extends  HttpServlet {
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String redirectPage = "index.html";
        if(!(request.getParameter("keyword").equals("") || request.getParameter("search") == null)){
            //get information
            String keyword = request.getParameter("keyword");
            String search = request.getParameter("search");
            String sqlQuery = "SELECT * FROM movies";
            ArrayList<Movie> resultList = null;
            //HttpSession session = request.getSession();

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

            //search from db
            if(search.equals("title")){
                sqlQuery = "SELECT * FROM movies WHERE title = '" + keyword + "'";
            }else if(search.equals("actor")){
                sqlQuery = "SELECT * FROM movies WHERE actor = '" + keyword + "'";
            }else if(search.equals("actress")){
                sqlQuery = "SELECT * FROM movies WHERE actress = '" + keyword + "'";
            }

            try{
                ResultSet rs = stmt.executeQuery(sqlQuery);
                resultList=convertList(rs);
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
            request.setAttribute("list", resultList);
            request.setAttribute("keyword", keyword);
            redirectPage = "./part7SearchResult.jsp";
            request.getRequestDispatcher(redirectPage).forward(request,response);
        }else{
            redirectPage = "./wrong.html";
            response.sendRedirect(redirectPage);
        }
    }
    
    private ArrayList<Movie> convertList(ResultSet rs) throws SQLException{
        ArrayList<Movie> list = new ArrayList();
        //ResultSetMetaData md = rs.getMetaData();
        //int columnCount = md.getColumnCount();
        while (rs.next()) {
            Movie movie = new Movie();
        //Map rowData = new HashMap();//声明Map
            movie.setTitle((String) rs.getObject(1));
            movie.setActor((String) rs.getObject(2));
            movie.setActress((String) rs.getObject(3));
            movie.setGenre((String) rs.getObject(4));
            movie.setYear((int) rs.getObject(5));
            list.add(movie);
        }
        return list;
    }
}

