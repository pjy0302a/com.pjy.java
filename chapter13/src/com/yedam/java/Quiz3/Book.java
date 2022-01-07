package com.yedam.java.Quiz3;

public class Book {
	private String name;
	private String author;
	private boolean tf;
	private int booknum;
	private static int serial=1000;
	
	 
	public Book(String name, String author){
		this.name = name;
		this.author = author;
		booknum = serial;
		booknum++;
	}
}
