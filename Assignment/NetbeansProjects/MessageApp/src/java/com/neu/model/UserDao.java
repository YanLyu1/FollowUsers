/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.model;

import com.neu.pojo.Login;
import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;


/**
 *
 * @author root
 */
public class UserDao extends Dao{
    Connection connection = null;
    QueryRunner queryRunner = new QueryRunner();
    public Login authenticationUser(String username, String password) throws ClassNotFoundException, SQLException{
        connection = super.getConnection();
        String query = "select * from userstable where UserName=? and UserPassword=?";
       
        ResultSetHandler<Login> h = new BeanHandler<>(Login.class);
        Login l = queryRunner.query(connection, query, h, username, password);
        return l;
    }
    
}
