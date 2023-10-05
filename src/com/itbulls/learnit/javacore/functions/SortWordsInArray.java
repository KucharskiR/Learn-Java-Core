package com.itbulls.learnit.javacore.functions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SortWordsInArray {

	public SortWordsInArray() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please, enter 7 words separated by space: ");
//		<write your code here>
		
		String inputWords = scanner.nextLine();
		
		String[] array = inputWords.split("\\s+");
		
		ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(array));
		
		for (String string : arrayList) {
			System.out.println(string);
		}
		
	
		
	}
	public static ArrayList<String> quicksort(ArrayList<String> array, int left, int right) {
		if(right <= left) {
			System.out.println("Empty array");
			return null;
		}
		
		int i = left - 1, j = right + 1;
		
		int pivot = array.get((int)(array.size() / 2)).length();
		
		while(true) {
			while(pivot > array.get(++i).length());
			
			while(pivot < array.get(--j).length());
			
			if(i <= j)
				swap(array, i, j);
			else 
				break;
		}
		
		if(j > left)
			quicksort(array, left, j);
		if(i < right)
			quicksort(array, i, right);
		
		return array;
	}
	
	public static final <T> void swap (List<T> l, int i, int j) {
		  Collections.<T>swap(l, i, j);
	}
}
