package com.way2learnonline.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



@Entity
public class Verification {
	@Id
	@GeneratedValue
	private Long id;
	

	private  String username;
	
	public Verification() {
		// TODO Auto-generated constructor stub
	}


	public Verification(String username) {
		super();
		this.username = username;
	}



	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
