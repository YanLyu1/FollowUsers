/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hw5.dao;

import com.hw5.pojo.Movie;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
/**
 *
 * @author rahulzore
 */
public class MovieDao{
    //get SessionFactory from configuration file
    private static final SessionFactory sf = new  Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    private Session session = null;
    
    
    private Session getSession(){
        if (session == null || !session.isOpen()){
            session = sf.openSession();
        }
        return session;
    }

    private void beginTransaction(){
        getSession().beginTransaction();
    }
    
    private void commit(){
        getSession().getTransaction().commit();;
    }
    
    
    private void close(){
        if (session !=null)
        {
            getSession().close();
        }
    }
    
    private void rollbackTransaction(){
        getSession().getTransaction().rollback();
    }
    
    public int addMovie(Movie movie) throws Exception{
        int result = 0;
        Session session = getSession();
        try {
            beginTransaction();
            session.save(movie);
            commit();
            close();
            result = 1;
        } catch (HibernateException e) {
            e.printStackTrace();
            try {
                rollbackTransaction();
            } catch (Exception ex) {
                Logger.getLogger(MovieDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (Exception ex) {
            Logger.getLogger(MovieDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                //close();
            } catch (Exception ex) {
                Logger.getLogger(MovieDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }
    
    public ArrayList<Movie> searchMovies(String keyword, String type) {
        ArrayList<Movie> movieList = new ArrayList<>();
        try {
            beginTransaction();
            Query q= getSession().createQuery("from Movie where "+type+" = :keyword");
            q.setString("keyword", keyword);
            movieList = (ArrayList<Movie>) q.list();
            commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            rollbackTransaction();
        } 
        finally {
            close();
        }
        return movieList;
    }
    
    public ArrayList<Movie> searchMoviesByID(long id) {
        ArrayList<Movie> movie = new ArrayList<>();
        Movie m = new Movie();
        try {
            session = sf.openSession();
            Transaction trans = session.beginTransaction();
            m = (Movie)session.get(Movie.class, id);
            movie.add(m);
            trans.commit();
            
        } catch (HibernateException e) {
            e.printStackTrace();
            rollbackTransaction();
        } 
        finally {
            close();
        }
        return movie;
    }
    
}
