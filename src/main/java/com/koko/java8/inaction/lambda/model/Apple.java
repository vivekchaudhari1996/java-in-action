package com.koko.java8.inaction.lambda.model;

public class Apple {
	private int weight;
	private Color color;

	public Apple(int weight, Color color) {
		super();
		this.weight = weight;
		this.color = color;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Apple [weight=" + weight + ", color=" + color + "]";
	}

	public enum Color {
		RED, GREEN;
	}
}
