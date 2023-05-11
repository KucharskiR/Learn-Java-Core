package com.itbulls.learnit.javacore.oop.exam.onlineshop.menu.impl;

import com.itbulls.learnit.javacore.oop.exam.onlineshop.configs.ApplicationContext;
import com.itbulls.learnit.javacore.oop.exam.onlineshop.menu.Menu;

public class SignOutMenu implements Menu {

	private ApplicationContext context;
	
	{
		context = ApplicationContext.getInstance();
	}
	
	@Override
	public void start() {
		// <write your code here>
		context.setLoggedInUser(null);
	}

	@Override
	public void printMenuHeader() {
		// <write your code here>	
		System.out.println("***** SIGN OUT *****");
	}

}
