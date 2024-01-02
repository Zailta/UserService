package com.microservices.user.UserEntity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.UuidGenerator;

import com.microservices.user.Userutility.UserRatings;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class UserEntity {
	@Id
	@UuidGenerator
	private String userId;
	private String userName;
	private String email;
	private String about;
	private String firstName;
	private String lastName;
	@Transient
	List <UserRatings> ratings = new ArrayList<UserRatings> ();
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
		return email;
	}
	public void setEmaail(String emaail) {
		this.email = emaail;
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
