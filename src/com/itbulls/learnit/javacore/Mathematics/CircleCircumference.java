package com.itbulls.learnit.javacore.Mathematics;

import java.util.Scanner;

public class CircleCircumference {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Please, enter circle radius: ");
		int r = sc.nextInt();
		double circleCircumference = 2 * Math.PI*r;

		System.out.println("Circle circumference is: " + circleCircumference);
	}

}
