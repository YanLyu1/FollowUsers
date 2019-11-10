package Servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import DAO.CSVDisplayDAO;
import Pojo.FileObject;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author root
 */
public class Part6Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get information
        String fileName = request.getParameter("fileName");
        //process information
        displayCSV(fileName,request,response);
    }
    
    public void displayCSV(String fileName, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        CSVDisplayDAO cDao = null;
        String redirectPage = "./wrong.html";
        ArrayList<FileObject> list = new ArrayList();
        if(!fileName.equals("")){
            try {
                cDao = new CSVDisplayDAO();
                //String fileName = request.getParameter("fileName");
                list = cDao.query(fileName);
            } catch (SQLException ex) {
                Logger.getLogger(Part6Servlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(list != null){
                request.setAttribute("list", list);
                redirectPage = "./part6Result.jsp";
                request.getRequestDispatcher(redirectPage).forward(request,response);
            }else{
                response.sendRedirect(redirectPage);
            }
        }else{
            response.sendRedirect(redirectPage);
        }
    }
}
