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
public class DAO_CSV {
    private final String DBDRIVER="org.relique.jdbc.csv.CsvDriver";
    private final String DBURL="jdbc:relique:csv:" + "/library";
    private Connection conn=null;
	
    public DAO_CSV(){
        try{
            Class.forName(DBDRIVER);
            this.conn=DriverManager.getConnection(DBURL);
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
