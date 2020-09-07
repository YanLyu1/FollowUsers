/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Pojo.Movie;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author root
 */
public class MysqlDAO {
    DAO_Mysql dao;
    Connection connection;
    Statement stmt;
    ResultSet results;
    String sql;
    
    public MysqlDAO() throws SQLException{
        dao = new DAO_Mysql();
        connection = dao.getConnection();
        stmt = connection.createStatement();
    }
    
    public int addMovie(Movie movie) throws SQLException{
        String title = movie.getTitle();
        String actor = movie.getActor();
        String actress = movie.getActress();
        String genre = movie.getGenre();
        int year = movie.getYear();
        int rs;
        sql = "INSERT INTO movies (title,actor,actress,genre,year)"
                    + "VALUES ('" + title + "','" + actor + "','" + actress + "','" + genre + "','" + year + "')";
        rs = stmt.executeUpdate(sql);

        try {
            if (stmt != null){
                stmt.close();
            }
            if (connection != null) {
                dao.close();
            }
        }catch (SQLException ex) {
            System.out.println("SQLException" + ex.getMessage());
        }
        
        return rs;
    }
    
    public ArrayList<Movie> searchMovie(String keyword, String attribute) throws SQLException{
        //Movie movie = new Movie();
        ArrayList<Movie> list = new ArrayList<Movie>();
        sql = "SELECT * FROM movies WHERE " + attribute + " = '" + keyword + "'";
        results = stmt.executeQuery(sql);
        list=convertList(results);
        try {
            if (stmt != null){
                stmt.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {
            System.out.println("SQLException" + ex.getMessage());
        }
        return list;
    }
    
    private ArrayList<Movie> convertList(ResultSet rs) throws SQLException{
        ArrayList<Movie> list = new ArrayList();
        //ResultSetMetaData md = rs.getMetaData();
        //int columnCount = md.getColumnCount();
        while (rs.next()) {
            Movie movie = new Movie();
        //Map rowData = new HashMap();//声明Map
            movie.setTitle((String) rs.getObject(1));
            movie.setActor((String) rs.getObject(2));
            movie.setActress((String) rs.getObject(3));
            movie.setGenre((String) rs.getObject(4));
            movie.setYear((int) rs.getObject(5));
            list.add(movie);
        }
        return list;
    }
}