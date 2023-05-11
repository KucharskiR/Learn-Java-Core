package com.itbulls.learnit.javacore.oop.exam.onlineshop.enteties.impl;

import java.util.Arrays;

import com.itbulls.learnit.javacore.oop.exam.onlineshop.enteties.Order;
import com.itbulls.learnit.javacore.oop.exam.onlineshop.enteties.Product;

public class DefaultOrder implements Order {

	private static final int AMOUNT_OF_DIGITS_IN_CREDIT_CARD_NUMBER = 16;
	private static final String CARD_VALID_REGEX = "[0-9]{16}";

	private String creditCardNumber;
	private Product[] products;
	private int customerId;

	public DefaultOrder() {
	}
	
	public DefaultOrder(String creditCardNumber, Product[] products, int customerId) {
		super();
		this.creditCardNumber = creditCardNumber;
		this.products = products;
		this.customerId = customerId;
	}

//	@Override
//	public boolean isCreditCardNumberValid(String creditCardNumber) {
//		// <write your code here>
//		/*
//		 * check card validation number 0 - 9
//		 */
//		if (!(Long.parseLong(creditCardNumber) > 0)){
//			return false;
//		}
//		if (!creditCardNumber.matches(CARD_VALID_REGEX)) {
//			return false;
//		}
//		
//		/*
//		 * count number of characters in card number
//		 */
//		char[] creditCardNumberChars = creditCardNumber.toCharArray();
//		int creditCardNumbers = 0;
//		for (char char1 : creditCardNumberChars) {
//			if (!(Character.getNumericValue(char1) >= 0 && Character.getNumericValue(char1) <= 9)) {
//				return false;
//			} 
//			creditCardNumbers++;
//		}
//		if (creditCardNumbers == AMOUNT_OF_DIGITS_IN_CREDIT_CARD_NUMBER) {
//			return true;
//		}
//		return false;
		/*
		 * code copied from learn it
		 */
		@Override
		public boolean isCreditCardNumberValid(String creditCardNumber) {
			return creditCardNumber.toCharArray().length == AMOUNT_OF_DIGITS_IN_CREDIT_CARD_NUMBER && 
					!creditCardNumber.contains(" ") && Long.parseLong(creditCardNumber) > 0;
	} 

	@Override
	public void setCreditCardNumber(String creditCardNumber) {
		// <write your code here>
		this.creditCardNumber = creditCardNumber;
	}

	@Override
	public void setProducts(Product[] products) {
		// <write your code here>
		this.products = products;
	}

	@Override
	public void setCustomerId(int customerId) {
		// <write your code here>
		this.customerId = customerId;
	}

	@Override
	public int getCustomerId() {
		return this.customerId;
	}

	@Override
	public String toString() {
		return "Order: [creditCardNumber=" + creditCardNumber + ", products=" + Arrays.toString(products)
				+ ", customerId=" + customerId + "]";
	}

}
