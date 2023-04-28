package com.itbulls.learnit.javacore.Enumerations;

import java.util.Scanner;

public class DemoEnum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Please, enter message type to check it priority: ");
			String userInput = sc.next();

			if (isValidMessageType(userInput)) {
				MessageType message = MessageType.valueOf(userInput);
				System.out.println(message.getPriority());
				break;
			} else {
				System.out.println("Please, enter valid " + "message type. Only 'A', 'B', 'C' or 'D' are allowed");
				continue;
			}

		}

	}

	private static boolean isValidMessageType(String userInput) {
		return userInput.matches("([A-D])");
	}

}
