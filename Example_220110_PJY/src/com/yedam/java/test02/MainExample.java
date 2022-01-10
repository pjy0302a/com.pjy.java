package com.yedam.java.test02;

public class MainExample {

	public static void main(String[] args) {
		Card card = new Card("5432-4567-9534-3657", 20251203, 253);
		card.showCardInfo();
		TossCard tossCard = new TossCard(card.cardNo, card.validDate, card.cvc,"신빛용");
		tossCard.showCardInfo();
		DGBCard dgbCard = new DGBCard(card.cardNo, card.validDate, card.cvc, "신빛용");
		dgbCard.showCardInfo();
	}

}
