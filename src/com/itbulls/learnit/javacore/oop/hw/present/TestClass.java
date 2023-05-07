package com.itbulls.learnit.javacore.oop.hw.present;

public class TestClass {
	
	private int lastIndex;
	
	public TestClass () {
	}
	
	public void output() {
		lastIndex += 2;
		System.out.println(lastIndex);
		System.out.println(lastIndex << 1);
	}

}
