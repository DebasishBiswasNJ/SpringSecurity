package com.way2learnonline.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;




@Entity
@Table(name = "users")
public class MyAppUser {

	@Id
	@NotNull
	private  String username;
	@NotNull
	private String firstName;
	@NotNull
	private String lastName;
	@Email
	@NotNull
	private String email;
	@NotNull
	private String password;
	
	private boolean enabled=true;
	
	@ElementCollection

	@Column(name="AUTHORITY")
	@CollectionTable(name = "AUTHORITIES",joinColumns = {@JoinColumn(name="USERNAME")})
	private Set<String> authorities;
	
	
	
	public MyAppUser() {
		authorities= new HashSet<>();
		authorities.add("USER");
	}
	
	
	public MyAppUser( String username,  String firstName,  String lastName,
			  String email,  String password, boolean enabled) {
		super();
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.enabled=enabled;
		authorities= new HashSet<>();
		authorities.add("USER");
	}





	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


	public boolean isEnabled() {
		return enabled;
	}


	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


	public Set<String> getAuthorities() {
		return authorities;
	}


	public void setAuthorities(Set<String> authorities) {
		this.authorities = authorities;
	}
	
	
	
	
	
}
