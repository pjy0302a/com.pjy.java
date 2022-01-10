package com.yedam.java.test02;

public class TossCard extends Card {
	private String company;
	private String cardStaff;
	
	TossCard(String cardNo, int validDate, int cvc, String cardStaff) {
		super(cardNo, validDate, cvc);
		this.cardStaff = cardStaff;
		company = "Toss";
	}

	@Override
	public void showCardInfo() {
		System.out.println("카드정보 - Card NO, " + cardNo);
		System.out.println("담담직원 - "+cardStaff + ", " + company);

	}
	


	
	
	

}
