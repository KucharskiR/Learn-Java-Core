package com.itbulls.learnit.javacore.Strings;

import java.util.Formatter;

public class PINumberFormatting {

	public static void main(String[] args) {
		Formatter fPi = new Formatter();
		fPi.format("%.1f", Math.PI);
		System.out.println(fPi);
		
		fPi = new Formatter();
		fPi.format("%.2f", Math.PI);
		System.out.println(fPi);
		
		fPi = new Formatter();
		fPi.format("%.3f", Math.PI);
		System.out.println(fPi);
		
		fPi = new Formatter();
		fPi.format("%.4f", Math.PI);
		System.out.println(fPi);
		
		fPi = new Formatter();
		fPi.format("%.5f", Math.PI);
		System.out.println(fPi);


	}

}
