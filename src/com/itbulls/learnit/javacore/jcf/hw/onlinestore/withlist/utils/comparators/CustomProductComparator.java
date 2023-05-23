package com.itbulls.learnit.javacore.jcf.hw.onlinestore.withlist.utils.comparators;

import java.util.Comparator;

import com.itbulls.learnit.javacore.jcf.hw.onlinestore.withlist.enteties.Product;

public class CustomProductComparator implements Comparator<Product> {

	@Override
	public int compare(Product product1, Product product2) {
//		<write your code here>
		int a = product1.getCategoryName().compareTo(product2.getCategoryName());
		int b = (int) (product1.getPrice() - product2.getPrice());
		int c = product1.getProductName().compareTo(product2.getProductName());
		
		return (a == 0) ? (b == 0 ? c : b) : a;
	}

}