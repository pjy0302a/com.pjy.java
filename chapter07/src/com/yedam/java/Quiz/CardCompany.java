package com.yedam.java.Quiz;

public class CardCompany {
	private static CardCompany instance = new CardCompany();
	
	private CardCompany() {}
	
	public static CardCompany getInstance() {
		return instance;
	}
	public static Card createCard() {
		return new Card();
	}
}
