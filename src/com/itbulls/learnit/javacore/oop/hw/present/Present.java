package com.itbulls.learnit.javacore.oop.hw.present;

import java.util.Arrays;

public class Present {
	
	private static final int DEFAULT_MAX_SWEETS = 10;
	
	private Sweet[] sweets;
	private int lastSweetIndex;
	
	{
		sweets = new Sweet[DEFAULT_MAX_SWEETS];
	}
	
	public Present() {
	}
	
	public void addSweet(Sweet sweet) {
		if (sweet == null) {
			return;
		}
		if(sweets.length <= lastSweetIndex) {
			sweets = Arrays.copyOf(sweets, sweets.length << 1);
		}
		sweets[lastSweetIndex++] = sweet;
	}

	public double calculateTotalWeight() {
		if (sweets == null) {
			return 0;
		}
		double totalWeight = 0;
		for (Sweet sweet : sweets) {
			if (sweet == null) {
				continue;
			}
			totalWeight += sweet.getWeight();
		}
		return totalWeight;
	}

	public Sweet[] filterSweetsBySugarRange(double minSugarWeight,
			double maxSugarWeight) {
		if (sweets == null) {
			return new Sweet[0];
		}
		int sweetsInRange = 0;
		for (Sweet sweet : sweets) {
			if(sweet == null) {
				continue;
			}
			if (sweet.getSugarWeight() >= minSugarWeight && sweet.getSugarWeight() <= maxSugarWeight) {
				sweetsInRange++;
			}
		}
		
		Sweet[] outputSweets = new Sweet[sweetsInRange];
		int index = 0;
		for (Sweet sweet : sweets) {
			if(sweet == null) {
				continue;
			}
			if (sweet.getSugarWeight() >= minSugarWeight && sweet.getSugarWeight() <= maxSugarWeight) {
				outputSweets[index++] = sweet;
			}
		}
		return outputSweets;
	}

	public Sweet[] getSweets() {
		int nonNullSweetsAmount = 0;
		for (Sweet sweet : sweets) {
			if (sweet != null) {
				nonNullSweetsAmount++;
			}
		}
		
		Sweet[] filteredSweets = new Sweet[nonNullSweetsAmount];
		int index = 0;
		for (Sweet sweet : sweets) {
			if (sweet != null) {
				filteredSweets[index++] = sweet;
			}
		}
		return filteredSweets;
	}

}
