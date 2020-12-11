package com.me.dao;

import org.hibernate.HibernateException;

import com.me.exception.CommentException;
import com.me.pojo.Comment;

public class CommentDao extends DAO {
	//Create a comment
	public Comment createPassage(Comment comment) throws CommentException {
		try {
			begin();
			getSession().merge(comment);
			commit();
			return comment;
		} catch (HibernateException e) {
			rollback();
			throw new CommentException("Exception while creating user: " + e.getMessage());
		}
	}
	

}
