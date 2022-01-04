package com.yedam.java.example;

public class Grade {
	int math;
	int science;
	int english;

	Grade(int math, int science, int english) {
		this.math = math;
		this.science = science;
		this.english = english;
	}


	double average() {
		return (math + science + english) / 3.0;
	}

}
