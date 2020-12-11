package com.me.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="COMMENT_ID")
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long commentId;
	
	
	@Column(name = "content")
	private String content;
	
	@ManyToOne(targetEntity=com.me.pojo.User.class, cascade = CascadeType.MERGE)
	@JoinColumn(
	        name="USER_ID",nullable=false)
	private User user;
	
	@ManyToOne(targetEntity=com.me.pojo.Passage.class, cascade = CascadeType.MERGE)
	@JoinColumn(
	        name="PASSAGE_ID",nullable=false)
	private Passage passage;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public long getCommentId() {
		return commentId;
	}

	public void setCommentId(long commentId) {
		this.commentId = commentId;
	}

	public Passage getPassage() {
		return passage;
	}

	public void setPassage(Passage passage) {
		this.passage = passage;
	}
	
	
}
