/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hw4;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author root
 */
public class Readcsv extends SimpleTagSupport {

    private String file;
    java.sql.Connection connection = null;
    Statement stmt = null;
    ResultSetMetaData rsmd = null;

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    //doTag: For page output
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        try {
            try{
            //TODO
                Class.forName("org.relique.jdbc.csv.CsvDriver");
                connection = DriverManager.getConnection("jdbc:relique:csv:" + "/library");
                stmt = connection.createStatement();
                ResultSet results = stmt.executeQuery("SELECT * FROM " + file);
                rsmd = results.getMetaData();
                int colCount = rsmd.getColumnCount();
                out.write("<table border='1' width='400'>");
                while(results.next()){
                    out.write("<tr>");
                    for (int i = 1 ; i <= colCount ; i++ )
                    {
                        out.write("<td>");
                        out.write(results.getString(i));
                        out.write("</td>");
                    }
                    out.write("</tr>");
                }
                out.write("</table>");
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
            JspFragment f = getJspBody();
            if (f != null) {
                f.invoke(out);
            }
        } catch (java.io.IOException ex) {
            throw new JspException("Error in ReadCSV tag", ex);
        }
    }

    public void setFile(String file) {
        this.file = file;
    }
    
}
