package com.itbulls.learnit.javacore.Methods;

import java.util.Scanner;

public class SumDigitsInNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please, enter integer: ");
		int number = sc.nextInt();

		int sumOfDigits = sumDigitsInNumber(number);
		System.out.println(sumOfDigits);
	}

	public static int sumDigitsInNumber(int number) {

		String string = Integer.toString(number);

		String[] arrayStr = new String[string.length()];
		arrayStr = string.split("");

		int sum = 0;
		for (int i = 0; i < string.length(); i++) {
			if(arrayStr[i].equals("-")) {
				continue;
			}
			sum += Integer.parseInt(arrayStr[i]);
		}
		return sum;
	}
}
