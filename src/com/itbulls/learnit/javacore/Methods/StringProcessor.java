package com.itbulls.learnit.javacore.Methods;

public class StringProcessor {

	public static final String INPUT_DATA = "Login;Name;Email" + System.lineSeparator()
			+ "peterson;Chris Peterson;peterson@outlook.com" + System.lineSeparator()
			+ "james;Derek James;james@gmail.com" + System.lineSeparator() + "jackson;Walter Jackson;jackson@gmail.com"
			+ System.lineSeparator() + "gregory;Mike Gregory;gregory@yahoo.com";

	public static void main(String[] args) {
		System.out.println("===== Convert 1 demo =====");
		System.out.println(convert1(INPUT_DATA));

		System.out.println("===== Convert 2 demo =====");
		System.out.println(convert2(INPUT_DATA));

	}

	public static String convert1(String input) {
		String[] linesArray = input.split("\r\n");
		String[] oneLineArray = new String[linesArray[0].length()];
		String outputString = "";
		for (int i = 1; i < linesArray.length; i++) {

			oneLineArray = linesArray[i].split(";");
			for (int j = 0; j < oneLineArray.length; j++) {
				if (j == 0) {
					outputString = String.join("", outputString, oneLineArray[j]);
				} else {
					if (j == 1) {
						outputString = String.join(" ==> ", outputString, "");
					} else {
						outputString = String.join("", outputString, oneLineArray[j]);
					}
				}
			}
			outputString = String.join("", outputString, System.lineSeparator());

		}

		return outputString;

	}

	public static String convert2(String input) {
		String[] linesArray = input.split("\r\n");
		String[] oneLineArray = new String[linesArray[0].length()];
		String outputString = "";
		for (int i = 1; i < linesArray.length; i++) {

			oneLineArray = linesArray[i].split(";");
			for (int j = 0; j < oneLineArray.length; j++) {
				if (j == 0) {
					outputString = String.join("", outputString, "");
				} else {
					if (j == 1) {
						outputString = String.join("", outputString, oneLineArray[j]);
					} else {
						outputString = String.join(" (email: ", outputString, oneLineArray[j]);
						outputString = String.join("", outputString, ")");
					}
				}
			}
			outputString = String.join("", outputString, System.lineSeparator());

		}

		return outputString;
	}

}
