package com.itbulls.learnit.javacore.oop.exam.onlineshop.menu.impl;

import com.itbulls.learnit.javacore.oop.exam.onlineshop.configs.ApplicationContext;
import com.itbulls.learnit.javacore.oop.exam.onlineshop.enteties.Order;
import com.itbulls.learnit.javacore.oop.exam.onlineshop.menu.Menu;
import com.itbulls.learnit.javacore.oop.exam.onlineshop.services.OrderManagementService;
import com.itbulls.learnit.javacore.oop.exam.onlineshop.services.impl.DefaultOrderManagementService;

public class MyOrdersMenu implements Menu {

	private ApplicationContext context;
	private OrderManagementService orderManagementService;

	{
		context = ApplicationContext.getInstance();
		orderManagementService = DefaultOrderManagementService.getInstance();
	}

	@Override
	public void start() {
		// <write your code here>
		printMenuHeader();

		/*
		 * get orders by userId
		 */
		Order[] myOrders = orderManagementService.getOrdersByUserId(context.getLoggedInUser().getId());

		/*
		 * check is user orders are empty else print list and continue
		 */
		if (myOrders.length == 0 && myOrders[0] == null) {
			System.out.println("Unfortunately, you don’t have any orders yet. "
					+ "Navigate back to main menu to place a new order");
		} else {
			for (Order order : myOrders) {
				System.out.println(order.toString());
			}
		}

	}

	@Override
	public void printMenuHeader() {
		// <write your code here>
		System.out.println("***** MY ORDERS *****");
	}

}
