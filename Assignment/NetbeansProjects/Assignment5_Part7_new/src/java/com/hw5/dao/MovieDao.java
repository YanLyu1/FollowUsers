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
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
/**
 *
 * @author root
 */
public class MovieDao {
    //get SessionFactory from configuration file
//    TimeZone timeZone = TimeZone.getTimeZone("UTC");
    private  SessionFactory sf ;//= new  Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    private static Session session = null;
    
    public MovieDao() {
    }
    
    protected SessionFactory setUp() throws Exception {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        try {
            this.sf = configuration.buildSessionFactory(registry);
            
        } catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
        return sf;
    }

    
    
    private Session getSession() throws Exception{
        if (session == null || !session.isOpen()){
            session = setUp().openSession();
        }
        return session;
    }

    private void beginTransaction() throws Exception{
        getSession().beginTransaction();
    }
    
    private void commit() throws Exception{
        getSession().getTransaction().commit();;
    }

    private void close() throws Exception{
        if (session !=null)
        {
            getSession().close();
        }
    }
    
    private void rollbackTransaction() throws Exception{
        getSession().getTransaction().rollback();
    }
    
    public int addMovie(Movie movie) throws Exception{
        int result = 0;
        try {
            beginTransaction();
            getSession().save(movie);
            commit();
            //close();
            result = 1;
        } catch (HibernateException e) {
            e.printStackTrace();
            rollbackTransaction();
        } catch (Exception ex) {
            Logger.getLogger(MovieDao.class.getName()).log(Level.SEVERE, null, ex);
        }
         finally{
            close();
        }
        return result;
    }
    
    public ArrayList<Movie> searchMovies(String keyword, String type) throws Exception {
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
//            if(session.isOpen())
            close();
        }
        return movieList;
    }
    
    public ArrayList<Movie> searchMoviesByID(long id) throws Exception {
        ArrayList<Movie> movie = new ArrayList<>();
        Movie m = new Movie();
        try {
            session = setUp().openSession();
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