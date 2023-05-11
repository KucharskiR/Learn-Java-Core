package com.itbulls.learnit.javacore.oop.exam.onlineshop.enteties.impl;

import java.util.Arrays;

import com.itbulls.learnit.javacore.oop.exam.onlineshop.enteties.Cart;
import com.itbulls.learnit.javacore.oop.exam.onlineshop.enteties.Product;

public class DefaultCart implements Cart {

	// <write your code here>
	private static final int DEFAULT_CART_CAPACITY = 100;
	private Product[] products;

	private int lastProductIndex;
	
	{
		products = new Product[DEFAULT_CART_CAPACITY];
	}

	@Override
	public boolean isEmpty() {
		// <write your code here>
		for (Product product : products) {
			if(product != null) {
				return false;
			}
		}
		
		return true;
	}

	@Override
	public void addProduct(Product product) {
		// <write your code here>
		if (product == null) {
			return;
		}
		if (products.length <= lastProductIndex) {
			products = Arrays.copyOf(products, products.length << 1);
		}
		products[lastProductIndex++] = product;
		return;
	}

	@Override
	public Product[] getProducts() {
		// <write your code here>
		int nonNullProdcutsAmount = 0;
		for (Product product : products) {
			if(product != null) {
				nonNullProdcutsAmount++;
			}
		}

		Product[] outputProducts = new Product[nonNullProdcutsAmount];

		int index = 0;
		for (Product product : products) {
			if (product != null) {
				outputProducts[index++] = product;
			}
		}

		return outputProducts;
	}

	@Override
	public void clear() {
		// <write your code here>
		lastProductIndex = 0;
		products = new Product[DEFAULT_CART_CAPACITY];
		}
}
