package com.itbulls.learnit.javacore.oop.exam.onlineshop.menu.impl;

import java.util.Scanner;

import com.itbulls.learnit.javacore.oop.exam.onlineshop.Main;
import com.itbulls.learnit.javacore.oop.exam.onlineshop.configs.ApplicationContext;
import com.itbulls.learnit.javacore.oop.exam.onlineshop.menu.Menu;

public class MainMenu implements Menu {

	public static final String MENU_COMMAND = "menu";
	private static final String INPUT_REGEX = "[1-6]{1}|menu$|exit$";

	private static final String MAIN_MENU_TEXT_FOR_LOGGED_OUT_USER = "Please, enter number in console to proceed."
			+ System.lineSeparator() + "1. Sign Up" + System.lineSeparator() + "2. Sign In" + System.lineSeparator()
			+ "3. Product Catalog" + System.lineSeparator() + "4. My Orders" + System.lineSeparator() + "5. Settings"
			+ System.lineSeparator() + "6. Customer List";

	private static final String MAIN_MENU_TEXT_FOR_LOGGED_IN_USER = "Please, enter number in console to proceed."
			+ System.lineSeparator() + "1. Sign Up" + System.lineSeparator() + "2. Sign Out" + System.lineSeparator()
			+ "3. Product Catalog" + System.lineSeparator() + "4. My Orders" + System.lineSeparator() + "5. Settings"
			+ System.lineSeparator() + "6. Customer List";;

	private ApplicationContext context;

	{
		context = ApplicationContext.getInstance();
	}

	@Override
	public void start() {
		// <write your code here>
		String userInput = new String();

		while (!userInput.matches(Main.EXIT_COMMAND)) {
			/*
			 * Checking if user i logged
			 */
			if (context.getLoggedInUser() != null) {
				this.printMenuHeader();
				System.out.println(MAIN_MENU_TEXT_FOR_LOGGED_IN_USER);
			} else {
				this.printMenuHeader();
				System.out.println(MAIN_MENU_TEXT_FOR_LOGGED_OUT_USER);
			}
			Scanner sc = new Scanner(System.in);
			System.out.print("User input: ");
			userInput = sc.next();

			/*
			 * Error handling - number from 1 - 6 and 'menu' and 'exit' word
			 */
			if (!userInput.matches(INPUT_REGEX)) {
				System.out.println("Only 1, 2, 3, 4, 6 is allowed. Try one more time");
				continue;
			}

			switch (userInput) {
			case "1":
				Menu signUpMenu = new SignUpMenu();
				context.setMainMenu(signUpMenu);
				signUpMenu.start();
				break;
			case "2":
				/*
				 * Logout presing number 2
				 */
				if (context.getLoggedInUser() != null) {
					Menu signOutMenu = new SignOutMenu();
					context.setMainMenu(signOutMenu);
					signOutMenu.start();
					break;
				}
				Menu signInMenu = new SignInMenu();
				context.setMainMenu(signInMenu);
				signInMenu.start();
				break;
			case "3":
				Menu productCatalogMenu = new ProductCatalogMenu();
				context.setMainMenu(productCatalogMenu);
				productCatalogMenu.start();
				break;
			case "4":
				if (context.getLoggedInUser() == null) {
					System.out.println("Please, log in or create new account to see list of your orders");
					break;
				}
				Menu myOrdersMenu = new MyOrdersMenu();
				context.setMainMenu(myOrdersMenu);
				myOrdersMenu.start();
				break;
			case "5":
				if (context.getLoggedInUser() == null) {
					System.out.println("Please, log in or create new account to change your account settings");
				}
				Menu settingsMenu = new SettingsMenu();
				context.setMainMenu(settingsMenu);
				settingsMenu.start();
				break;
			case "6":
				Menu customerListMenu = new CustomerListMenu();
				context.setMainMenu(customerListMenu);
				customerListMenu.start();
				break;

			default:
				break;
			}
		}
	}

	@Override
	public void printMenuHeader() {
		// <write your code here>
		System.out.println("****** MAIN MENU *****");
	}

}
