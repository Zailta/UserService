package com.microservices.user.UserEntity;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Entity;

@Entity
public class UserEntity {

	@UuidGenerator
	private String userId;
	private String userName;
	private String emaail;
	private String about;
	private String firstName;
	private String lastName;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmaail() {
		return emaail;
	}
	public void setEmaail(String emaail) {
		this.emaail = emaail;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
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
	
	

}
