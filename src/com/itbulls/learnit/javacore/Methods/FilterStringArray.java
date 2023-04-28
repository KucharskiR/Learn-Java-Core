package com.itbulls.learnit.javacore.Methods;

import java.util.Arrays;
import java.util.Scanner;

public class FilterStringArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please, enter any words separated by space: ");
		String userInput = sc.nextLine();
		System.out.print("Please, enter minumum word length to filter words: ");
		int minLength = sc.nextInt();
		
		String[] words = userInput.split("\\s+");
		String[] filteredWords = filterWordsByLength(minLength, words);
		System.out.println(Arrays.toString(filteredWords));
	}

	
	
	public static String[] filterWordsByLength(int minLength, String[] words) {
		
		int count = 0;
		for (String string : words) {
			if(string.length() >= minLength) {
				count++;
			}
		} 
		
		String[] outputArray = new String[count];
		
		int i = 0;
		for (String string : words) {
			if(string.length() >= minLength) {
				outputArray[i] = string;
				i++;
			}
		} 
		return outputArray;
	}

}