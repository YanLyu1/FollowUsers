package com.neu.edu.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="category_table")
public class Category {
	
	public Category(String title) {
		// TODO Auto-generated constructor stub
		this.title = title;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long categoryID;
	
	@Column(name="category_title")
	private String title;
	
	@ManyToMany
	@JoinTable(name = "category_advert_table", joinColumns = {
			@JoinColumn(name = "categoryID", nullable = false)}, inverseJoinColumns = {
					@JoinColumns(name = "advertID")})
	private Set<Advert> categories = new HashSet<Advert>();

}
