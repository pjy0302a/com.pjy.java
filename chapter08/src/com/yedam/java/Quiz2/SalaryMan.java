package com.yedam.java.Quiz2;

public class SalaryMan {
	//필드
	private int salary;
	
	//생성자
	public SalaryMan() {
		salary = 1000000;
	}
	public SalaryMan(int salary) {
		
		this.salary = salary;

	}
	//메소드
	  int getAnnualGross() {
		int salarys = 0;
		salarys = salary * 12 + salary*5;
		
		  return salarys;
	}
	
}
