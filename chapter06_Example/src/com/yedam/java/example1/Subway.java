package com.yedam.java.example1;

public class Subway {
	//필드
	private String SubwayNumber;
	private int money;
	private int passengerCount;
	//생성자
	Subway(String SubwayNumber){
		this.SubwayNumber = SubwayNumber;
	}
	//메소드
	void take(int money) {
		this.money += 2000;
		passengerCount ++;
	}
	
	void showInfo() {
		System.out.println("버스 " + SubwayNumber + "번의 승객은" + passengerCount 
				+ "명이고, 수입은 "+money+"입니다.");
	}
}
