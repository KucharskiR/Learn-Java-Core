package com.itbulls.learnit.javacore.Methods;

import java.util.Scanner;

public class FirstCharCapital {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please, enter any text: ");
		String userInput = sc.nextLine();

		System.out.println(firstCharToTitleCase(userInput));
	}

	public static String firstCharToTitleCase(String string) {
		String output = "";
		String[] stringArr = string.toLowerCase().split("\s+");

		for (int i = 0; i < stringArr.length; i++) {
			String[] word = stringArr[i].split("");
			String upper = word[0].toUpperCase();
			word[0] = upper;

			for (int j = 0; j < word.length; j++) {
				output += word[j];
			}
			if(i < (stringArr.length - 1))
			output += " ";
		}

		return output;
	}
}
