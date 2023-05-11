package com.itbulls.learnit.javacore.oop.exam.onlineshop.menu.impl;

import java.util.Scanner;

import com.itbulls.learnit.javacore.oop.exam.onlineshop.configs.ApplicationContext;
import com.itbulls.learnit.javacore.oop.exam.onlineshop.enteties.impl.DefaultUser;
import com.itbulls.learnit.javacore.oop.exam.onlineshop.menu.Menu;
import com.itbulls.learnit.javacore.oop.exam.onlineshop.services.UserManagementService;
import com.itbulls.learnit.javacore.oop.exam.onlineshop.services.impl.DefaultUserManagementService;

public class SignUpMenu implements Menu {

	private UserManagementService userManagementService;
	private ApplicationContext context;

	{
		userManagementService = DefaultUserManagementService.getInstance();
		context = ApplicationContext.getInstance();
	}

	@Override
	public void start() {
		// <write your code here>
		printMenuHeader(); 
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter your first name: ");
		String name = sc.next();
		System.out.print("Please enter your last name: ");
		String lastName = sc.next();
		System.out.print("Please enter your password: ");
		String password = sc.next();
		System.out.print("Please enter your email: ");
		String email = sc.next();
	
		/*
		 * Create user instance
		 */
		DefaultUser newUser = new DefaultUser(name, lastName, password, email);
		System.out.println(userManagementService.registerUser(newUser));
		context.setLoggedInUser(newUser);
		
		
	}

	@Override
	public void printMenuHeader() {
		// <write your code here>	
		System.out.println("***** SIGN UP *****");
	}

}
