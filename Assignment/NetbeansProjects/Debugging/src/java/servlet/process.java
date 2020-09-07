/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author lijin
 */
/**
 *
 * @author lijin
 */
public class process extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        HttpSession session=req.getSession();
        Statement stmt = null;
        java.sql.Connection conn = null;
        ArrayList<String> list = new ArrayList<>();

        try{
            Class.forName("org.relique.jdbc.csv.CsvDriver");
            conn = DriverManager.getConnection("jdbc:relique:csv:" + "/library");
            stmt = conn.createStatement();
            String Sales = req.getParameter("file");
            String data = "select * from "+ Sales;
            ResultSet results = stmt.executeQuery(data);
            
            ResultSetMetaData metadata= results.getMetaData();
            int cols=metadata.getColumnCount();
            //list = new ArrayList();
            while(results.next()){
                String row=" ";
                for(int i=1;i<=cols;i++){
                    row += results.getString(i);
                    row += ",";
                }
                list.add(row);
            }
        }catch(ClassNotFoundException cnfe) {
            System.err.println("Error loading driver: " + cnfe);}
             catch(SQLException sqle) {
            System.err.println("Error connecting: " + sqle);
            } catch(Exception ex) {
            System.err.println("Error with input: " + ex);
            }finally{
            try{
                if(stmt != null){
                    stmt.close();
                }
                if(conn != null){
                    conn.close();
                }
            }catch(SQLException ex){
                System.out.println("SQLException");
            }
        }
        //req.setAttribute("list", list);
        session.setAttribute("list", list);
        res.sendRedirect("./showResults.jsp");  
        //req.getRequestDispatcher("./showResults.jsp").forward(request, res);
                
               
    }

}
