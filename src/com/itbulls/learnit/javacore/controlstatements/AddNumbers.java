package com.itbulls.learnit.javacore.controlstatements;

public class AddNumbers {

	public static void main(String[] args) {
		String numberOne = args[0];
		String numberTwo;

		if (args.length <= 1) {
			numberTwo = "0";
		} else {
			numberTwo = args[1];
		}

		if (numberOne.contains(".") || numberOne.contains(",")) {
			if (numberTwo.contains(".") || numberTwo.contains(",")) {
				System.out.println(Double.parseDouble(numberOne) + Double.parseDouble(numberTwo));
			} else {
				System.out.println(Double.parseDouble(numberOne) + Double.parseDouble(numberTwo));
			}
		} else {
			if (numberTwo.contains(".") || numberTwo.contains(",")) {
				System.out.println(Double.parseDouble(numberOne) + Double.parseDouble(numberTwo));
			} else {
				System.out.println(Integer.parseInt(numberOne) + Integer.parseInt(numberTwo));
			}
		}
	}

}
