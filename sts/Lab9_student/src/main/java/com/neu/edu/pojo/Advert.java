package com.neu.edu.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "advert_table")
public class Advert {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long advertID;
	@Column(name = "firstname")
	private String title;
	@Column(name = "lastname")
	private String message;
	@ManyToOne(fetch=FetchType.EAGER, optional = false)
	private User user;
	@ManyToMany(mappedBy = "categories")
	private Set<Category> categories = new HashSet<Category>();
	

	public long getAdvertID() {
		return advertID;
	}

	public void setAdvertID(long advertID) {
		this.advertID = advertID;
	}

	public String getTitle() {
		return title;
	}

	public User getUser() {
		return user;
	}
	

	public void setUser(User user) {
		this.user = user;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
