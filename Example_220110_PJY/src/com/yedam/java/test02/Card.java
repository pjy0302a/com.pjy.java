package com.yedam.java.test02;

public class Card {
	public String cardNo;
	public int validDate;
	public int cvc;
	
	Card(String cardNo, int validDate, int cvc){
		this.cardNo = cardNo;
		this.validDate = validDate;
		this.cvc = cvc;
		
	}
	
	public void showCardInfo() {
		System.out.println("Card NO : " + cardNo + ", 유효기간 : " + validDate + ", CVC : " + cvc);

	}
}
