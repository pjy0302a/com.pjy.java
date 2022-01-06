package com.yedam.java.Quiz3;

public class StudentScores {
	private String name;
	private int myClass;
	private int korean;
	private int english;
	private int math;

	public StudentScores(String name, int myClass) {
		this.name = name;
		this.myClass = myClass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMyClass() {
		return myClass;
	}

	public void setMyClass(int myClass) {
		this.myClass = myClass;
	}

	public int getKorean() {
		return korean;
	}

	public void setKorean(int korean) {
		this.korean = korean;
	}

	public int getEnglish() {
		return english;
	}

	public void setEnglish(int english) {
		this.english = english;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getTotal() {
		
//		total = korean + english + math;
		return korean + english + math;
	}
	
	
	public double getAverage() {
		

		return getTotal()/3;
	}
	
	
	
}
