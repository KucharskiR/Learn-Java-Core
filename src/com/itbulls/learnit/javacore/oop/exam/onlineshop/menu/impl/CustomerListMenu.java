package com.itbulls.learnit.javacore.oop.exam.onlineshop.menu.impl;

import com.itbulls.learnit.javacore.oop.exam.onlineshop.configs.ApplicationContext;
import com.itbulls.learnit.javacore.oop.exam.onlineshop.enteties.User;
import com.itbulls.learnit.javacore.oop.exam.onlineshop.menu.Menu;
import com.itbulls.learnit.javacore.oop.exam.onlineshop.services.UserManagementService;
import com.itbulls.learnit.javacore.oop.exam.onlineshop.services.impl.DefaultUserManagementService;

public class CustomerListMenu implements Menu {

	private ApplicationContext context;
	private UserManagementService userManagementService;
	
	{
		userManagementService = DefaultUserManagementService.getInstance();
		context = ApplicationContext.getInstance();
	}
	
	@Override
	public void start() {
		// <write your code here>
		printMenuHeader();
		
		User[] userList = userManagementService.getUsers();
		if(!(userList.length == 0)) {
			for (User user : userList) {
				System.out.println(user.toString());
				}
		} else {
			System.out.println("User list is empty");
		}
	}

	@Override
	public void printMenuHeader() {
		// <write your code here>	
		System.out.println("***** CUSTOMER LIST *****");
	}

}
