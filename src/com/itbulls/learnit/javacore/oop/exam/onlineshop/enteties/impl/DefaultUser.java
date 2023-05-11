package com.itbulls.learnit.javacore.oop.exam.onlineshop.enteties.impl;

import com.itbulls.learnit.javacore.oop.exam.onlineshop.enteties.User;

public class DefaultUser implements User {

	public static int id;
	// <write your code here>
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	
//	static {
//		 id++;
//	}
	
	public DefaultUser() {
	}
	
	public DefaultUser(String firstName, String lastName, String password, String email) {
		// <write your code here>
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
		
	}

	@Override
	public String getFirstName() {
		// <write your code here>
		return firstName;
	}

	@Override
	public String getLastName() {
		// <write your code here>
		return lastName;
	}

	@Override
	public String getPassword() {
		// <write your code here>
		return password;
	}

	@Override
	public String getEmail() {
		// <write your code here>
		return email;
	}
	
	
	@Override
	public String toString() {
		return "DefaultUser [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", password="
				+ password + ", email=" + email + "]";
	}

	@Override
	public void setPassword(String password) {
		// <write your code here>
		this.password = password;
	}

	@Override
	public void setEmail(String newEmail) {
		// <write your code here>
		this.email = newEmail;
	}

	@Override
	public int getId() {
		// <write your code here>
		return id;
	}
	
	void clearState() {
		// <write your code here>
		id = 0;
		this.firstName = null;
		this.lastName = null;
		this.email = null;
		this.password = null;
		
	}
}
