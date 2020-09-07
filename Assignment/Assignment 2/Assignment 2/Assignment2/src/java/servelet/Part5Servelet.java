package servelet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author root
 */
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;

public class Part5Servelet extends  HttpServlet {
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String redirectPage = "./wrong.html";
        
        if(!request.getParameter("fileName").equals("")){
            //PrintWriter out = response.getWriter();
            response.setContentType("text/html");
            ArrayList<StringBuffer> list = new ArrayList();
            //ArrayList<ArrayList<String>> list = new ArrayList();
            //HttpSession session = request.getSession();
            java.sql.Connection connection = null;
            Statement stmt = null;

            String fileName = request.getParameter("fileName");
            try{
            //TODO
            Class.forName("org.relique.jdbc.csv.CsvDriver");
            connection = DriverManager.getConnection("jdbc:relique:csv:" + "/library");
            stmt = connection.createStatement();
            ResultSet results = stmt.executeQuery("SELECT * FROM " + fileName);
            if(results != null){
                redirectPage = "./contents.jsp";
            }
            ResultSetMetaData rsmd = results.getMetaData();
            int colCount = rsmd.getColumnCount();
            while(results.next()){
                StringBuffer sb = new StringBuffer();
                //ArrayList<String> sb = new ArrayList<>();
                for(int j = 1; j <= colCount; j++){
                    //sb.add(results.getString(j));
                    sb.append(results.getString(j));
                    sb.append(" ");
                }

                list.add(sb);
            }
            request.setAttribute("list", list);
            
            } catch(ClassNotFoundException cnfe) {
            System.err.println("Error loading driver: " + cnfe);}
             catch(SQLException sqle) {
            System.err.println("Error connecting: " + sqle);
            } catch(Exception ex) {
            System.err.println("Error with input: " + ex);
            }
            finally {
                try {
                    if (stmt != null) {
                        stmt.close();
                    }
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException ex) {
                    System.out.println("SQLException" + ex.getMessage());
                }
            }
        request.getRequestDispatcher(redirectPage).forward(request,response);
        }else{
            response.sendRedirect(redirectPage);
        }
    }
}
