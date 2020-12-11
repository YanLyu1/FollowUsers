package com.me.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="USER_ID")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "phoneNum")
	private int phoneNum;
	
	@OneToMany(targetEntity=com.me.pojo.Passage.class, mappedBy="user")
	//@JoinColumn(name = "USER_ID")
	private Set<Passage> passageCatelog;
	
	@OneToMany(targetEntity=com.me.pojo.Comment.class, cascade = CascadeType.ALL, mappedBy="user")
	//@JoinColumn(name = "USER_ID")
	private Set<Comment> userComment;
	
	@ManyToMany(mappedBy="likedByList")
	//@JoinTable(name = "User_Passage", joinColumns = {@JoinColumn(name = "userId", referencedColumnName = "userId")},inverseJoinColumns = {@JoinColumn(name = "passageId", referencedColumnName ="passageId")})
    public Set<Passage> userLikes;
	
	public User() {
		
	}
	
	
	
	public Set<Comment> getUserComment() {
		return userComment;
	}



	public void setUserComment(Set<Comment> userComment) {
		this.userComment = userComment;
	}



	public Set<Passage> getUserLikes() {
		return userLikes;
	}


	public void setUserLikes(Set<Passage> userLikes) {
		this.userLikes = userLikes;
	}


	public void setPassageCatelog(Set<Passage> passageCatelog) {
		this.passageCatelog = passageCatelog;
	}


	public Set<Passage> getPassageCatelog() {
		return passageCatelog;
	}


	public long getUserId() {
		return userId;
	}


	public void setUserId(long userId) {
		this.userId = userId;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(int phoneNum) {
		this.phoneNum = phoneNum;
	}


	@Override
	public String toString() {
		return   name ;
	}
	
	
	
	
	
}
