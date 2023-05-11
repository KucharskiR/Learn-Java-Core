package com.itbulls.learnit.javacore.oop.exam.onlineshop.menu.impl;

import java.util.Scanner;

import com.itbulls.learnit.javacore.oop.exam.onlineshop.configs.ApplicationContext;
import com.itbulls.learnit.javacore.oop.exam.onlineshop.enteties.User;
import com.itbulls.learnit.javacore.oop.exam.onlineshop.menu.Menu;
import com.itbulls.learnit.javacore.oop.exam.onlineshop.services.UserManagementService;
import com.itbulls.learnit.javacore.oop.exam.onlineshop.services.impl.DefaultUserManagementService;

public class SignInMenu implements Menu {

	private ApplicationContext context;
	private UserManagementService userManagementService;

	{
		context = ApplicationContext.getInstance();
		userManagementService = DefaultUserManagementService.getInstance();
	}

	@Override
	public void start() {
		// <write your code here>
		printMenuHeader();
		Scanner sc = new Scanner(System.in);
		System.out.print("Please, enter your email: ");
		String email = sc.next();
		System.out.print("Please, enter your password: ");
		String password = sc.next();

		User user = userManagementService.getUserByEmail(email.toLowerCase());

		if (user == null || !user.getPassword().equals(password)) {
			System.out.println("Unfortunately, such login and password doesn't exist");
			return;
		}
		context.setLoggedInUser(user);
		System.out.println("Glad to see you back "+ user.getFirstName() + " " + user.getLastName());
		return;
	}

	@Override
	public void printMenuHeader() {
		// <write your code here>
		System.out.println("***** SIGN IN *****");
	}

}
