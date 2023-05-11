package com.itbulls.learnit.javacore.oop.exam.onlineshop.menu.impl;

import java.util.Scanner;

import com.itbulls.learnit.javacore.oop.exam.onlineshop.configs.ApplicationContext;
import com.itbulls.learnit.javacore.oop.exam.onlineshop.enteties.Cart;
import com.itbulls.learnit.javacore.oop.exam.onlineshop.enteties.Product;
import com.itbulls.learnit.javacore.oop.exam.onlineshop.enteties.impl.DefaultCart;
import com.itbulls.learnit.javacore.oop.exam.onlineshop.menu.Menu;
import com.itbulls.learnit.javacore.oop.exam.onlineshop.services.ProductManagementService;
import com.itbulls.learnit.javacore.oop.exam.onlineshop.services.impl.DefaultProductManagementService;

public class ProductCatalogMenu implements Menu {

	private static final String CHECKOUT_COMMAND = "checkout";
	private ApplicationContext context;
	private ProductManagementService productManagementService;

	{
		context = ApplicationContext.getInstance();
		productManagementService = DefaultProductManagementService.getInstance();
	}

	@Override
	public void start() {
		// <write your code here>
		Cart cart = context.getSessionCart();
		String productId = new String();

		while (!productId.toLowerCase().equals("checkout") || !productId.toLowerCase().equals(MainMenu.MENU_COMMAND)) {
			printMenuHeader();
			System.out.println(
					"Enter product id to add it to the cart or 'menu' if you want ot navigate back to the main menu");

			/*
			 * product list
			 */
			Product[] productList = productManagementService.getProducts();

			for (Product product : productList) {
				System.out.println(product.toString());
			}

			Scanner sc = new Scanner(System.in);
			System.out.println("Product ID to add to cart: ");
			productId = sc.next();

			/*
			 * Back to 'menu'
			 */
			if (productId.toLowerCase().equals(MainMenu.MENU_COMMAND)) {
				break;
			}

			/*
			 * Error handling - product with id not exist
			 */

			if (productId.matches("[0-9]")
					&& productManagementService.getProductById(Integer.parseInt(productId)) == null) {
				System.out.println("Please, enter product ID if you want to add product to cart. "
						+ "Or enter ‘checkout’ if you want to proceed with checkout. "
						+ "Or enter ‘menu’ if you want to navigate back to the main menu");
				continue;
			}

			/*
			 * Error handling - user not logged
			 */
			if (context.getLoggedInUser() == null) {
				System.out.println("You are not logged in. Please, sign in or create new account");
				continue;
			}

			/*
			 * Error handling - cart is empty
			 */
			if (productId.toLowerCase().equals("checkout")) {
				if (context.getSessionCart().isEmpty() == true) {
					System.out.println("Your cart is empty. Please, add product to cart first and then"
							+ " proceed with checkout");
					continue;
				} else {
					break;
				}
			} else {
				/*
				 * Adding product to cart
				 */
				Product product = productManagementService.getProductById(Integer.parseInt(productId));
				if (product != null) {
					cart.addProduct(product);
					System.out.println("Product " + product.getProductName()
							+ " has been added to your cart. If you want to add a new product input next id");
				}
			}

		}

		if (productId.toLowerCase().equals("checkout")) {
			Menu checkoutMenu = new CheckoutMenu();
			context.setMainMenu(checkoutMenu);
			checkoutMenu.start();
		} else {
			Menu goToMainMenu = new MainMenu();
			context.setMainMenu(goToMainMenu);
			goToMainMenu.start();
		}
	}

	@Override
	public void printMenuHeader() {
		// <write your code here>
		System.out.println("***** PRODUCT CATALOG *****");
	}

}
