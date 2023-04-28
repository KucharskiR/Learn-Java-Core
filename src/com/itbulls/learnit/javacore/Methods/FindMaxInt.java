package com.itbulls.learnit.javacore.Methods;

import java.util.Arrays;
import java.util.Scanner;

public class FindMaxInt {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please, enter integer numbers separated by space: ");
	
		String[] stringArray = sc.nextLine().split("\\s+");
		
		int[] intArray = new int[stringArray.length];
		
		int i = 0;
		for (String string : stringArray) {
			intArray[i] = Integer.parseInt(string);
			i++;
		}
		
		int maxInt = findMaxIntInArray(intArray);

		System.out.println("*** Initial Array ***");
		System.out.println(Arrays.toString(intArray));
		System.out.println("*** Max number in array ***");
		System.out.println(maxInt);

	}
	public static int findMaxIntInArray(int[] intArray) {
		int[] a = intArray;
		Arrays.sort(a);
		return a[a.length - 1];
	}
}
