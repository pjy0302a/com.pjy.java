package com.yedam.java.test02;

public class DGBCard extends Card {
	private String company;
	private String cardStaff;
	DGBCard(String cardNo, int validDate, int cvc,String cardStaff) {
		super(cardNo, validDate, cvc);
		this.cardStaff = cardStaff;
		company = "대구은행";
	}
	@Override
	public void showCardInfo() {
		super.showCardInfo();
		System.out.println("담당직원 - " + cardStaff + ", " + company);
	}

}
