package com.me.dao;

import org.hibernate.HibernateException;

import com.me.pojo.Applicant;

public class ApplicationDAO extends DAO{
	public Applicant create(Applicant applicant) {
		try {
			begin();
			getSession().save(applicant);
			commit();
		}catch(HibernateException e) {
			rollback();
		}
		
		return applicant;
	}

}
