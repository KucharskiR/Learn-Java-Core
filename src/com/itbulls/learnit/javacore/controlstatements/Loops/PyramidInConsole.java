package com.itbulls.learnit.javacore.controlstatements.Loops;

import java.util.Scanner;

public class PyramidInConsole {

	public static void main(String[] args) {
		System.out.print("Please, enter height of the pyramid: ");
		Scanner sc = new Scanner(System.in);

		int height = sc.nextInt();

		int i = 1;
		while (i <= height) {
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println("");
			i++;
		}
		while (i >= 0) {
			for (int j = 0; j < i-2; j++) {
				System.out.print("*");
			}
			System.out.println("");
			i--;
		}

	}

}
