package com.yedam.java.Quiz;

public class Product {
	// 필드
	private String name; // 이름
	private int price; // 가격
	// 생성자

	public Product(String name, int price) {
		this.name = name;
		this.price = price;

	}

	// 메소드
	public String getName() {

		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
