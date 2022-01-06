package com.yedam.java.Quiz4;

public class NamedCircle extends Circle {
	private String name;
	
	public NamedCircle(int radius, String name) {
		super(radius);
		this.name = name;
		
	}
	void show() {
		System.out.println( this.name+ ", 반지름" + getRadius());
		
	}
	
}
