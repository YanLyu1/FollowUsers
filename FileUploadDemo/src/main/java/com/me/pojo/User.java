package com.me.pojo;

import java.util.List;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class User {
	
	public User() {
		super();
	}
	
	private List<CommonsMultipartFile> photo;   //for DataBinder to bind <input type="file".../>
										  //will not be mapped for Hibernate as we store the file in the FileSystem
										  //file will be placed into this field by DataBinder
										  //file is in the memory. needs to be transferred to the FileSystem using java.io.file
	private String filename;     
	
	private String fname;

	
	public List<CommonsMultipartFile> getPhoto() {
		return photo;
	}
	public void setPhoto(List<CommonsMultipartFile> photo) {
		this.photo = photo;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	
}
