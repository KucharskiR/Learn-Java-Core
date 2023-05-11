package com.itbulls.learnit.javacore.oop.exam.onlineshop.menu.impl;

import java.util.Scanner;

import com.itbulls.learnit.javacore.oop.exam.onlineshop.configs.ApplicationContext;
import com.itbulls.learnit.javacore.oop.exam.onlineshop.menu.Menu;

public class ChangePasswordMenu implements Menu {
	
	private ApplicationContext context;
	
	{
		context = ApplicationContext.getInstance();
	}

	@Override
	public void start() {
		// <write your code here>
		printMenuHeader();
		//change password
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter new password: ");
		String newPassword = sc.next();
		context.getLoggedInUser().setPassword(newPassword);
		System.out.println("Your password has been successfuly changed");
	}

	@Override
	public void printMenuHeader() {
		// <write your code here>	
		System.out.println("***** CHANGE PASSWORD *****");
	}

}
