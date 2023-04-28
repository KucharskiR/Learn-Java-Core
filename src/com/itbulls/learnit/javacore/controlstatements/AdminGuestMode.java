package com.itbulls.learnit.javacore.controlstatements;

import java.util.Arrays;

public class AdminGuestMode {

	public static void main(String[] args) {

		if (Arrays.asList(args).contains("--admin") == true) {
			if (Arrays.asList(args).contains("--guest") == true) {
				System.out.println("Please, select either 'ADMIN' or 'GUEST' mode for this program");
			} else
				System.out.println("Hello, Admin!");
		} else {
			if (Arrays.asList(args).contains("--guest") == true) {
				System.out.println("Hello, Guest!");
			}
		}
	}

}
