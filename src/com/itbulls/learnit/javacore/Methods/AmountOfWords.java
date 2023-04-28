package com.itbulls.learnit.javacore.Methods;

import java.util.Scanner;

public class AmountOfWords {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please, enter any text: ");
	
		int amountOfWords = getWordsAmount(sc.nextLine());
		
		System.out.println("Amount of words in your text: " + amountOfWords);
	}

	public static int getWordsAmount(String text) {
		String[] textArray = text.split("\\s+");
		return textArray.length;
	}
}
