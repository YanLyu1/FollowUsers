/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author root
 */
public class Dao {
    private Connection connection = null;
    static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
    private final String DBURL="jdbc:mysql://newton.neu.edu:3306/usersdb";
    private final String DBUSER="student";
    private final String DBPASSWORD="p@sswOrd";
    private Connection conn=null;
	
    public Connection getConnection() throws ClassNotFoundException{
        try{
            if(connection != null){
            Class.forName(JDBC_DRIVER);
            this.conn=DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
            }
        return this.conn;
    }
    
    public void close(){
        if(this.connection != null){
        try{
            this.conn.close();
        }catch (SQLException e){ 
            e.printStackTrace();
        }
        }
    }
    
}
