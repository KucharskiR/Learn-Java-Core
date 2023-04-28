package com.itbulls.learnit.javacore.Methods;

import java.util.Scanner;

public class ConvertDecimalToRoman {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		mainLoop: while (true) {
			System.out.print("Please, select mode. If you want to convert Roman "
					+ "numbers to decimal - type 'R2D' and press enter." + System.lineSeparator()
					+ "If you want to convert decimal numbers to Roman - type 'D2R' and press enter: ");

			String mode = sc.next();
			if (mode.equalsIgnoreCase("R2D")) {
				while (true) {
					System.out.print("Please, enter Roman number you want to convert: ");
					String romanNumber = sc.next();
					if (isRomanNumberValid(romanNumber)) {
						System.out.println(roman2Decimal(romanNumber));
						break mainLoop;
					} else {
						System.out.println("You entered invalid Roman number. " + "Please, try one more time.");
						continue;
					}
				}
			} else if (mode.equalsIgnoreCase("D2R")) {
				while (true) {
					System.out.print("Please, enter decimal number " + "you want to convert: ");
					int decimalNumber = sc.nextInt();
					if (isDecimalNumberValid(decimalNumber)) {
						System.out.println(decimal2Roman(decimalNumber));
						break mainLoop;
					} else {
						System.out.println("Please, enter positive integer from 1 to 100.");
						continue;
					}

				}

			}

			System.out.println("Please, enter 'R2D' or 'D2R.");
		}
	}

	/**
	 * Converts decimal numbers to Roman.
	 * 
	 * Takes int value as a parameter. Works only with numbers from 1 to 100.
	 * 
	 * @param number to convert to Roman.
	 * @return string of Roman number.
	 */
	public static String decimal2Roman(int number) {
		int[] base = { 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		String[] romanNum = { "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
		String output = "";
		int reminder = number;
		int cal = number;
		int i = 0;
		while (reminder != 0) {
			i = 0;
			cal = reminder;
			while (base[i] > cal) {
				i++;
			}
			int roman = cal / base[i];
			reminder = cal % base[i];
			for (int j = 0; j < roman; j++) {
				output += romanNum[i];
			}
		}
		return output;
	}

	/**
	 * Converts Roman numbers to decimal.
	 * 
	 * Takes string value with Roman number as a parameter.
	 * 
	 * At first method validates if input string could be Roman number. After method
	 * uses algorithm to convert Roman numeral to decimal.
	 * 
	 * @param romanNumber
	 * @return decimal representation of Roman number
	 */

	public static int roman2Decimal(String romanNumber) {
		int[] base = { 100, 50, 10, 5, 1 };
		char[] romanNum = { 'C', 'L', 'X', 'V', 'I' };
		char[] romanChar = romanNumber.toUpperCase().toCharArray();
		int previous = 0;
		int output = 0;
		int j = 0;
		for (int i = (romanChar.length - 1); i >= 0; i--) {
			j = 0;
			while (romanChar[i] != romanNum[j]) {
				j++;
			}

			if (previous != 0 && previous > base[j]) {
				output -= base[j];
			} else {
				output += base[j];
			}

			previous = base[j];
		}
		return output;
	}

	/**
	 * Validation for Roman numbers.
	 * 
	 * Use regular expression which is checking if string really could be Roman
	 * number.
	 * 
	 * @param romanNumber
	 * @return true if String is Roman number
	 */
	public static boolean isRomanNumberValid(String romanNumber) {
		char[] romanNum = { 'C', 'L', 'X', 'V', 'I' };
		char[] romanString = romanNumber.toUpperCase().toCharArray();
		boolean check = false;
		for (char c : romanString) {
			check = false;
			for (char d : romanNum) {
				if (c == d)
					check = true;
			}
			if (!check)
				return false;
		}

		return true;
	}

	public static boolean isDecimalNumberValid(int decimalNumber) {
		if (decimalNumber < 1 || decimalNumber > 100)
			return false;
		else
			return true;
	}
}