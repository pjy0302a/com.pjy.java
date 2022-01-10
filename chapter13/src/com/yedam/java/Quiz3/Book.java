package com.yedam.java.Quiz3;

public class Book {
	
	private static int serial;
	
	private String name;
	private String author;
	private boolean tf;
	private int booknum;
	

	public Book(String name, String author) {
		this.name = name;
		this.author = author;
		this.tf = false;
		serial++;
		booknum = serial;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public boolean isTf() {

		return tf;
	}

	public boolean isTf(boolean tf) {

		return tf;
	}

	public void setTf(boolean tf) {
		this.tf = tf;

	}

	public int getBooknum() {

		return booknum;
	}

	public void setBooknum(int booknum) {
		this.booknum = booknum;
	}

	public static int getSerial() {
		return serial;
	}

	public static void setSerial(int serial) {
		Book.serial = serial;
	}



}
