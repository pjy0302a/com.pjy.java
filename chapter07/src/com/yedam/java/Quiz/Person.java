package com.yedam.java.Quiz;

public class Person {
	// 필드
	private String name;
	private int money;
	private int personnel;

	Person(String name, int money) {
		this.name = name;
		this.money = money;
	}
	
	public void buyCoffee(BeanCafe beanCafe) {
		if (money >= 4500) {
			money -= 4500;
			beanCafe.buyCoffee(4500);
		}else {
			beanCafe.buyCoffee(0);
		}
	}

	public void buyCoffee(StarCafe starCafe) {
		if (money >= 4000) {
			money -= 4000;
			
			starCafe.buyCoffee(4000);
		}else {
			starCafe.buyCoffee(0);
		}
	}


	public void showInfo() {
		System.out.println(name +"씨의 남은돈은"+ money+"");
	}
}
