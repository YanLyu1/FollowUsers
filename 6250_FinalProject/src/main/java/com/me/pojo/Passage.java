package com.me.pojo;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="PASSAGE_ID")
public class Passage {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long passageId;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "discription")
	private String discription;
	
	@Column(name = "content")
	private String content;
	
	@Column(name = "thumbNum")
	private int thumbNum;
	
	@ManyToOne(targetEntity=com.me.pojo.User.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_ID",nullable=false)
	private User user;
	
	@OneToMany(targetEntity=com.me.pojo.Comment.class,fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy="passage")
	private Set<Comment> commentCatelog;
	
	@ManyToMany
    @JoinTable(name="Passage_User_Like")
    public Set<User> likedByList;
	
	public Passage() {
		
	}
	
	
	
	public Set<User> getLikedByList() {
		return likedByList;
	}



	public void setLikedByList(Set<User> likedByList) {
		this.likedByList = likedByList;
	}



	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}



	public long getPassageId() {
		return passageId;
	}
	public void setPassageId(long id) {
		this.passageId = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public int getThumbNum() {
		return thumbNum;
	}
	public void setThumbNum(int thumbCount) {
		this.thumbNum = thumbCount;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Set<Comment> getCommentCatelog() {
		return commentCatelog;
	}
	public void setCommentCatelog(Set<Comment> commentCatelog) {
		this.commentCatelog = commentCatelog;
	}
	
	
}
