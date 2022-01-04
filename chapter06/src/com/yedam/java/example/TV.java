package com.yedam.java.example;

public class TV {
	String brand ;
	int year;
	int inch;
	
	TV(String brand,int year, int inch){
//		this(brand,year,inch);
		this.brand = brand;
		this.year = year;
		this.inch = inch;
	}
	
	void showinfo() {
		System.out.println(brand+"에서 만든 "+year+"년형"+inch+"인치 TV");
	}
	
}
