package com.itbulls.learnit.javacore.oop.hw.present;

public abstract class Cookie extends Sweet {
	
	double doughWeight;

	public Cookie() {
	
	}
	
	public Cookie(String name, double weight, double sugarWeight, double doughWeight) {
		super(name, weight, sugarWeight);
		this.doughWeight = doughWeight;
	}

	public double getDoughWeight() {
		return doughWeight;
	}

	public void setDoughWeight(double doughWeight) {
		this.doughWeight = doughWeight;
	}

	@Override
	public String toString() {
		return "Cookie [name=" + name + ", weight=" + weight + ", sugarWeight="
				+ sugarWeight + ", doughWeight=" + doughWeight + "]";
	}

}
