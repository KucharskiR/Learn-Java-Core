package com.itbulls.learnit.javacore.oop.exam.onlineshop.services.impl;

import java.util.Arrays;

import com.itbulls.learnit.javacore.oop.exam.onlineshop.enteties.Order;
import com.itbulls.learnit.javacore.oop.exam.onlineshop.services.OrderManagementService;

public class DefaultOrderManagementService implements OrderManagementService {

	private static final int DEFAULT_ORDER_CAPACITY = 10;
	private Order[] orders;

	private static DefaultOrderManagementService instance;

	// <write your code here>
	private int lastOrderIndex;

	{
		orders = new Order[DEFAULT_ORDER_CAPACITY];
	}

	public static OrderManagementService getInstance() {
		if (instance == null) {
			instance = new DefaultOrderManagementService();
		}
		return instance;
	}

	@Override
	public void addOrder(Order order) {
		// <write your code here>
		if (order == null) {
			return;
		}

		if (orders.length <= lastOrderIndex) {
			orders = Arrays.copyOf(orders, orders.length << 1);
		}
		orders[lastOrderIndex++] = order;
	}

	@Override
	public Order[] getOrdersByUserId(int userId) {
		// <write your code here>
		int userIdOrders = 0;
		for (Order order : orders) {
			if (order != null && order.getCustomerId() == userId) {
				userIdOrders++;
			}
		}

		int index = 0;
		Order[] outputOrders = new Order[userIdOrders];
		for (Order order : orders) {
			if (order != null && order.getCustomerId() == userId) {
				outputOrders[index++] = order;
			}
		}
		return outputOrders;
	}

	@Override
	public Order[] getOrders() {
		// <write your code here>
		int nonNullOrdersAmount = 0;
		for (Order order : orders) {
			if (order != null) {
				nonNullOrdersAmount++;
			}
		}

		Order[] filteredOrders = new Order[nonNullOrdersAmount];

		int index = 0;
		for (Order order : orders) {
			if (order != null) {
				filteredOrders[index++] = order;
			}
		}
		return filteredOrders;
	}

	void clearServiceState() {
		// <write your code here>
		lastOrderIndex = 0;
		orders = new Order[DEFAULT_ORDER_CAPACITY];
	}

}
