package com.itbulls.learnit.javacore.controlstatements.Loops;

import java.util.Scanner;

public class NewLineForDigit {

	public static void main(String[] args) {
		System.out.print("Please, enter any integer: ");
		Scanner sc = new Scanner(System.in);
		
		char[] integerArr = sc.next().toCharArray();
		
		for (char c : integerArr) {
			
			System.out.println(c);
			
		}
		
	}

}
