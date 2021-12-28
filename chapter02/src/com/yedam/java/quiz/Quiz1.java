package com.yedam.java.quiz;

public class Quiz1 {

	public static void main(String[] args) {
		//문제1
		int a = 10, b = 50, c = 90;
		// a = 50, b = 90, c = 10
		int temp1 = a; //10
		a = b; //10
		b = c; //50
		c = temp1; //90
		System.out.println("a:" + a + ",b:" + b + ",c:" + c );

		

	}

}
