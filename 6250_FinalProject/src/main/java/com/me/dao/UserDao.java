package com.me.dao;



import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.hibernate.mapping.List;

import com.me.exception.UserException;
import com.me.pojo.User;

public class UserDao extends DAO {

	public UserDao() {
	}

	//得到UserID
	public User get(long userId) throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("from User where userId = :userId");
			q.setLong("userId", userId);
			User user = (User) q.uniqueResult();
			commit();
			return user;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get user " + userId, e);
		}
	}

	//注册User
	public User register(User u) throws UserException {
		try {
			begin();
			getSession().save(u);
			commit();
			return u;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Exception while creating user: " + e.getMessage());
		}
	}

	//删除User
	public void delete(User user) throws UserException {
		try {
			begin();
			getSession().delete(user);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not delete user " + user.getName() , e);
		}
	}
	
	//Login User
	public User login(String name, String password) throws UserException{
		try {
			begin();
			Criteria cri = getSession().createCriteria(User.class);
			cri.add(Restrictions.eq("name", name));
			if(cri.uniqueResult()==null) {
				commit();
				return null;
			}
			User user = (User)cri.uniqueResult();
			if(user.getPassword().equals(password)) {
				commit();
				return user;
			}else {
				commit();
				return null;
			}
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not Search user " , e);
		}
	}
	
	//Get user Name
	public User getUserName(String name) throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("from User where name = :name");
			q.setString("name", name);
			if(q.uniqueResult()==null) {
				commit();
				return null;
			}
			User user = (User) q.uniqueResult();
			commit();
			return user;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get user by name" + name, e);
		}
	}
	
	//Exsist
	public boolean isUserExsist(String name) throws UserException {
		
		if(getUserName(name)!=null) {
			//存在返回true
			return true;
		}
		return false;
		
	}
	
	
}
