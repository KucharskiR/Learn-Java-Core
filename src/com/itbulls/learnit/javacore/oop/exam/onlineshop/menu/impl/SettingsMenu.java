package com.itbulls.learnit.javacore.oop.exam.onlineshop.menu.impl;

import java.util.Scanner;

import com.itbulls.learnit.javacore.oop.exam.onlineshop.configs.ApplicationContext;
import com.itbulls.learnit.javacore.oop.exam.onlineshop.menu.Menu;

public class SettingsMenu implements Menu {

	private static final String SETTINGS = "1. Change Password" + System.lineSeparator() + "2. Change Email";
	private static final String INPUT_REGEX = "[1-2]{1}|menu$|exit$";

	private ApplicationContext context;

	{
		context = ApplicationContext.getInstance();
	}

	@Override
	public void start() {
		// <write your code here>
		while (true) {
			printMenuHeader();

			System.out.println(SETTINGS);

			Scanner sc = new Scanner(System.in);
			System.out.print("Please, enter option or type 'menu' to navigate back to the main menu: ");
			String option = sc.next();

			/*
			 * check input is 1 or 2
			 */
			if (!option.matches(INPUT_REGEX)) {
				System.out.println("Only 1, 2 is allowed. Try one more time");
				continue;
			} else {
				if (option.equals("1")) {
					// change password
					Menu changePasswordMenu = new ChangePasswordMenu();
					context.setMainMenu(changePasswordMenu);
					changePasswordMenu.start();
				}
				if (option.equals("2")) {
					// change email
					Menu changeEmailMenu = new ChangeEmailMenu();
					context.setMainMenu(changeEmailMenu);
					changeEmailMenu.start();
				}
				if (option.toLowerCase().equals("menu")) {
					break;
				}
			}
		}
	}

	@Override
	public void printMenuHeader() {
		// <write your code here>
		System.out.println("***** SETTINGS *****");
	}

}
