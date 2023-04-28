package com.itbulls.learnit.javacore.Mathematics;

import java.util.Scanner;

public class AreaOfTriangle {

	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
		
		System.out.print("Please, enter A side of a triangle: ");
		int a = sc.nextInt();
		
		System.out.print("Please, enter B side of a triangle: ");
		int b = sc.nextInt();
		
		System.out.print("Please, enter C side of a triangle: ");
		int c = sc.nextInt();
		
		float p = (float)(a+b+c)/2;
		double triangleArea =Math.sqrt(p*(p-a)*(p-b)*(p-c)); 
		
		System.out.println("Triangle area is: " + triangleArea);
		
	}


}
