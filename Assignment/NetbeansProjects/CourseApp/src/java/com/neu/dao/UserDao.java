/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.dao;

import com.neu.pojo.User;
import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

/**
 *
 * @author root
 */
public class UserDao {
    //in bean, it called conn
    private BasicDataSource conn;

    public BasicDataSource getConn() {
        return conn;
    }

    public void setConn(BasicDataSource conn) {
        this.conn = conn;
    }
    
    public User autentication(String username, String password) throws SQLException{
        Connection conneciton = null;
        //get connection pool, and get a single connection
        try{
            conneciton = conn.getConnection();
            String query= "select * from userstable where UserName=? AND UserPassword=?";
            QueryRunner queryRunner = new QueryRunner();
            ResultSetHandler<User> h= new BeanHandler<>(User.class);
            User u = queryRunner.query(conneciton, query, h, username, password);
            return u;
        }catch(Exception e){
            
        }finally{
            conneciton.close(); 
        }
        return null;
    }
}
