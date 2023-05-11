package com.itbulls.learnit.javacore.oop.exam.onlineshop.menu.impl;

import java.util.Scanner;
import java.util.regex.Pattern;

import com.itbulls.learnit.javacore.oop.exam.onlineshop.configs.ApplicationContext;
import com.itbulls.learnit.javacore.oop.exam.onlineshop.menu.Menu;

public class ChangeEmailMenu implements Menu {

	private static final String EMAIL_REGEX = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?";

	private ApplicationContext context;

	{
		context = ApplicationContext.getInstance();
	}

	@Override
	public void start() {
		// <write your code here>
		while (true) {
			printMenuHeader();
			// change email
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter new email: ");
			String newEmail = sc.next();

			/*
			 * Email validation
			 */

			final Pattern EMAIL = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);

			if (EMAIL.matcher(newEmail).matches() == true) {
				context.getLoggedInUser().setEmail(newEmail);
				System.out.println("Your email has been successfully changed");
				break;
			} else {
				System.out.println("Not correct email adress, please type valid email address format");
				continue;
			}
		}

	}

	@Override
	public void printMenuHeader() {
		// <write your code here>
		System.out.println("***** CHANGE EMAIL *****");
	}

}
