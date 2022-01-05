package com.yedam.java.Quiz;

public class Card {
	private static int serial = 100;
	private int CardNo;
	
	Card(){
		serial++;
		CardNo=serial;
	}

	public static int getSerial() {
		return serial;
	}

	public static void setSerial(int serial) {
		Card.serial = serial;
	}

	public int getCardNo() {
		return CardNo;
	}

	public void setCardNo(int getCardNo) {
		this.CardNo = getCardNo;
	}

	

	

	

	
	
}
