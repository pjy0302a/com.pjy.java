package com.yedam.java.Quiz;

public class BeanCafe {
	private String cafeName;
	private int money;
	private int personnel;
	BeanCafe(String cafeName) {
		this.cafeName = cafeName;
	}
	

	void buyCoffee(int money) {
		this.money += money;
		this.personnel ++;
	}
	void showInfo() {
		System.out.println(cafeName + "의 고객은 "+personnel +"명 매출은 " + money+"입니다.");
	}
}
