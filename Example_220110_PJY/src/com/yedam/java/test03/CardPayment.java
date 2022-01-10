package com.yedam.java.test03;

public class CardPayment implements Payment {
	private double cardRatio;
	
	public CardPayment(double cardRatio) {
		this.cardRatio = cardRatio;
	}
	@Override
	public void showInfo() {
		
		double on = ONLINE_PAYMENT_RATIO + cardRatio;
		double off = OFFLINE_PAYMENT_RATIO + cardRatio;
		System.out.println("*** 카드로 결제 시 할인 정보");
		System.out.println("온라인 결제시 총 할인율 : " + on);
		System.out.println("오프라인 결제시 총 할인율 : " + off);
	}
	@Override
	public int online(int price) {
		
		
		return (int) (price - (price * (ONLINE_PAYMENT_RATIO + cardRatio)));
	}

	@Override
	public int offline(int price) {
		
		return (int) (price - (price * (OFFLINE_PAYMENT_RATIO + cardRatio)));
	}

	

}
