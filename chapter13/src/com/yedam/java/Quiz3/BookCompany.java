package com.yedam.java.Quiz3;

public class BookCompany {
	private static BookCompany instance = new BookCompany();
	
	public BookCompany() {
	}
	
	public static BookCompany getInstance() {
		return instance;
	}
	public static Book createdBook() {
		return new Book();
	}
}
