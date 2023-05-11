package com.itbulls.learnit.javacore.oop.exam.onlineshop.menu.impl;

import java.util.Scanner;

import com.itbulls.learnit.javacore.oop.exam.onlineshop.configs.ApplicationContext;
import com.itbulls.learnit.javacore.oop.exam.onlineshop.enteties.Order;
import com.itbulls.learnit.javacore.oop.exam.onlineshop.enteties.impl.DefaultOrder;
import com.itbulls.learnit.javacore.oop.exam.onlineshop.menu.Menu;
import com.itbulls.learnit.javacore.oop.exam.onlineshop.services.OrderManagementService;
import com.itbulls.learnit.javacore.oop.exam.onlineshop.services.impl.DefaultOrderManagementService;

public class CheckoutMenu implements Menu {

	private static final String CARD_REGEX = "[0-9]{16}";
	private ApplicationContext context;
	private OrderManagementService orderManagementService;

	{
		context = ApplicationContext.getInstance();
		orderManagementService = DefaultOrderManagementService.getInstance();
	}

	@Override
	public void start() {
		// <write your code here>
		while (true) {
			printMenuHeader();
			System.out
					.println("Enter your credit card number without spaces and press enter if you confirm purchase: ");
			Scanner sc = new Scanner(System.in);
			String cardNumber = new String();
			cardNumber = sc.next();
			
			/*
			 *  create new order
			 */
			
			Order newOrder = new DefaultOrder(cardNumber, context.getSessionCart().getProducts(),
					context.getLoggedInUser().getId());
			
			/*
			 *  validation card number
			 */
			if (!newOrder.isCreditCardNumberValid(cardNumber)) {
				System.out
				.println("You entered invalid credit card number. Valid credit card should containt 16 digits. "
						+ "	Please, try one more time");
				continue;
			}
			
			/*
			 *  add order to array
			 */
			orderManagementService.addOrder(newOrder);
			
			System.out.println("Thanks a lot for your purchase. Details about order delivery "
					+ "are sent to your email");
			//
			// clear cart after checkout
			//
			context.getSessionCart().clear();
			
			//
			// go to main menu
			//
			Menu goToMainMenu = new MainMenu();
			context.setMainMenu(goToMainMenu);
			goToMainMenu.start();
		}

	}

	@Override
	public void printMenuHeader() {
		// <write your code here>
		System.out.println("***** CHECKOUT *****");
	}

}
