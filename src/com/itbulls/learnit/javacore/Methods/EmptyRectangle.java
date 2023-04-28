package com.itbulls.learnit.javacore.Methods;

import java.util.Scanner;

public class EmptyRectangle {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please, enter height of rectangle: ");
		int height = sc.nextInt();
		System.out.print("Please, enter width of rectangle: ");
		int width = sc.nextInt();

		drawRectangle(height, width);
	}

	public static void drawRectangle(int height, int width) {
		int i = 0;
		int j = 0;
		while (i < height ) {
			while (j < width) {
				if (i == 0 || i == (height - 1))
					System.out.print("*");
				else if (j == 0 || j == (width - 1)) {
					System.out.print("*");
				} else
					System.out.print(" ");
				j++;
			}
			System.out.println();
			i++;
			j = 0;
		}

	}

}
