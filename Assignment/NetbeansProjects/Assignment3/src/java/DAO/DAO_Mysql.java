/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author root
 */
public class DAO_Mysql {
    private final String DBDRIVER="com.mysql.jdbc.Driver";
    private final String DBURL="jdbc:mysql://127.0.0.1:3306/moviedb";
    private final String DBUSER="root";
    private final String DBPASSWORD="ly950223";
    private Connection conn=null;
	
    public DAO_Mysql(){
        try{
            Class.forName(DBDRIVER);
            this.conn=DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
        }catch(Exception e){
            System.out.println(e.getMessage());
            }
    }
    public Connection getConnection(){
        return this.conn;
    }
    public void close(){
        try{
            this.conn.close();
        }catch (Exception e){ 
        
            }
    }
}
