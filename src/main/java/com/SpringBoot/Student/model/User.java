package com.SpringBoot.Student.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name ="user")
public class User {
	
	
	@Id
	@Column(name= "id_user")
	/* @NotEmpty(message="Field cannot be Blank!") */
	private String uid;
	
	/* @NotEmpty */
	@Column(name= "uname")
	private String uname;
	
	/* @NotEmpty(message="Field cannot be Blank!") */
	@Column(name= "email")
	private String email;
	
	/* @NotEmpty */
	@Column(name= "password")
	private String password;
	
	/* @NotEmpty(message="Field cannot be Blank!") */
	@Column(name= "role")
	private String role;
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", uemail=" + email
				+ ", password=" + password + ", role=" + role + "]";
	}

}
