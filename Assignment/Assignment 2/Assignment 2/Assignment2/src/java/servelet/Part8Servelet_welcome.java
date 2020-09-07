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
import VO.Book;
import java.io.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;

public class Part8Servelet_welcome extends  HttpServlet {
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String redirectPage = "index.html";
        if(!request.getParameter("number").equals("")){
            int number = 0;
            try{
                number = Integer.parseInt(request.getParameter("number"));
            }catch(NumberFormatException e){
                redirectPage = "./wrong.html";
                response.sendRedirect(redirectPage);
                return;
            }
            //HttpSession session = request.getSession();
            request.setAttribute("number", number);
            redirectPage = "./part8Add.jsp";
            request.getRequestDispatcher(redirectPage).forward(request,response);
            //response.sendRedirect(redirectPage);
        }else{
            redirectPage = "./wrong.html";
            response.sendRedirect(redirectPage);
        }
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String redirectPage = "./wrong.html";
        //if()
        //get information
        String[] ISBNs = request.getParameterValues("isbn");
        String[] titles = request.getParameterValues("title");
        String[] authors = request.getParameterValues("author");
        String[] prices = request.getParameterValues("price");
        
        ArrayList<Book> bookList = new ArrayList<Book>();
        int number = ISBNs.length;
        //HttpSession session = request.getSession();
        
        java.sql.Connection connection = null;
        PreparedStatement pstmt = null;
        
        //sql statement
        //String sqlQuery = "INSERT INTO 'books'('isbn','title','author','price') VALUES (?,?,?,?)";
        String sqlQuery = "INSERT INTO books (isbn, title, author, price) VALUES (?,?,?,?)";

        for(int i = 0; i<number; i++){
            Book book = new Book();
            book.setISBN(ISBNs[i]);
            book.setTitle(titles[i]);
            book.setAuthor(authors[i]);
            try{
                book.setPrice(Integer.parseInt(prices[i]));
            }catch(NumberFormatException e){
                response.sendRedirect(redirectPage);
                return;
            }
            
            bookList.add(book);
        }
        
        //connect db
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/booksdb", "root", "ly950223");
            //connection = JdbcUtils.getConnection("jdbc:mysql://127.0.0.1:3306/booksdb", "root", "ly950223");
            connection.setAutoCommit(false);
            pstmt = connection.prepareStatement(sqlQuery);
            for(int j = 0; j < number; j++){
                pstmt.setString(1, bookList.get(j).getISBN());
                pstmt.setString(2, bookList.get(j).getTitle());
                pstmt.setString(3, bookList.get(j).getAuthor());
                pstmt.setFloat(4, bookList.get(j).getPrice());
                pstmt.addBatch();
                if(j>0 && j%number==0){
                    pstmt.executeBatch();
                    connection.commit();
                }
            }
            pstmt.executeBatch();
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException" + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("SQLException" + ex.getMessage());
        }finally{
            try {
                if (pstmt != null){
                    pstmt.close();
                }
                if (connection != null) {
                    connection.commit();
                    connection.setAutoCommit(true);
                    connection.close();
                }
            } catch (SQLException ex) {
                System.out.println("SQLException" + ex.getMessage());
            }
        }
        //session.setAttribute("number", number);
        request.setAttribute("number", number);
        request.setAttribute("value", bookList);
        redirectPage = "./success_part8.jsp";
        request.getRequestDispatcher(redirectPage).forward(request,response);
        //response.sendRedirect(redirectPage);
    }
}
