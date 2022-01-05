package com.yedam.java.Quiz;

public class MainExample {

	public static void main(String[] args) {
		//문제1
		//별다방 아메리카노 4000
		//콩다방 카페라떼 4500
		System.out.println("==============문제1==============");
		Person kim = new Person("Kim",8000);
		Person lee = new Person("Lee",9800);
		//Person 클래스 생성
		StarCafe starCafe = new StarCafe("별다방 1호점");
		kim.buyCoffee(starCafe);
		starCafe.showInfo();
		//StarCafe 클래스 생성
		BeanCafe beanCafe = new BeanCafe("콩다방 동성로점");
		lee.buyCoffee(beanCafe);
		beanCafe.showInfo();
		//beanCafe 클래스생성
		kim.showInfo();
		lee.showInfo();
		
		System.out.println("==============문제2==============");

		//문제2 
		Card kbCard = new Card();
		Card kdbCard = new Card();
		System.out.println("kbCard : " + kbCard.getCardNo());
		System.out.println("kdbCard : " + kdbCard.getCardNo());
		
		System.out.println("==============문제3==============");
		//문제3
		CardCompany company = CardCompany.getInstance();
		Card firstCard = company.createCard();
		Card secondCard = company.createCard();
		System.out.println("첫번째 카드 : " + firstCard.getCardNo());
		System.out.println("두번째 카드 : " + secondCard.getCardNo());
	}

}
