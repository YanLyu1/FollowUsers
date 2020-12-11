/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hw4.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author root
 */
public class Dao {
    private final String DBDRIVER="com.mysql.jdbc.Driver";
    private final String DBURL="jdbc:mysql://127.0.0.1:3306/moviedb";
    private final String DBUSER="root";
    private final String DBPASSWORD="ly950223";
    private Connection conn=null;

    public Dao() {
    }
    
	
    public Connection getConnection() throws ClassNotFoundException, SQLException{
        try{
            if(conn == null){
            Class.forName(DBDRIVER);
            this.conn=DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
            }
        return this.conn;
    }
    
    public void close(){
        if(this.conn != null){
        try{
            this.conn.close();
        }catch (SQLException e){ 
            e.printStackTrace();
        }
        }
    }
    
}
