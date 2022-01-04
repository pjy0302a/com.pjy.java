package com.yedam.java.ch0602;

public class MainExample {

	public static void main(String[] args) {
//		Car car = new Car("검정", 3000);
		
		Korean ko1 = new Korean("박자바", "011225-1234567");
		Korean ko2 = new Korean("김자바", "012225-2234567");
		System.out.println("ko1.name : " + ko1.name);
		System.out.println("ko1.name : " + ko1.ssn);
		System.out.println("ko2.name : " + ko2.name);
		System.out.println("ko2.name : " + ko2.ssn);
		
		System.out.println();
		
		Car car1 = new Car();
		System.out.println("car1.company : " + car1.company);
		System.out.println();
		
		Car car2 = new Car("아반떼");
		System.out.println("car2.company : " + car2.company);
		System.out.println("car2.model : " + car2.model);
		System.out.println();
		
		Car car3 = new Car("택시","흰색");
		System.out.println("car3.company : " + car3.company);
		System.out.println("car3.model : " + car3.model);
		System.out.println("car3.color : " + car3.color);
		System.out.println();
		
		Car car4 = new Car("티볼리","블루",200);
		System.out.println("car4.company : " + car4.company);
		System.out.println("car4.model : " + car4.model);
		System.out.println("car4.color : " + car4.color);
		System.out.println("car4.color : " + car4.maxSpeed);
		System.out.println();
	}

}
