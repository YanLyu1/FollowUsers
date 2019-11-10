/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.CartDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author root
 */
public class Part5Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String[] products = request.getParameterValues("products");
        addToCart(session,response,products); 
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String[] deleteProducts = request.getParameterValues("product");
        deleteInCart(session,response,deleteProducts);
    }
    
    public void addToCart(HttpSession session, HttpServletResponse response,String[] products) throws IOException{
        String redirectPage = "./wrong.html";
        CartDAO dao = new CartDAO();
        session = dao.getOriInfo_session(session);
        if(products != null){
            dao.addCart(session, products);
        }
        redirectPage = "./part5Cart.jsp";
        response.sendRedirect(redirectPage);
    }

    public void deleteInCart(HttpSession session, HttpServletResponse response, String[] deleteProducts) throws IOException{
        String redirectPage = "./wrong.html";
        CartDAO dao = new CartDAO();
        session = dao.getOriInfo_session(session);
        dao.deleteItems(session, deleteProducts);
        redirectPage = "./part5Cart.jsp";
        response.sendRedirect(redirectPage);
    }
}
