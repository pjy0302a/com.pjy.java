package com.yedam.java.ch0401;

import java.util.Scanner;

public class Quiz {

	public static void main(String[] args) {
		// 문제1
		int x = -5;
		int y = 10;
		int result;
		
		//1-1
		result = -x;
		System.out.println("문제 1-1 " + result);
		//1-2
		result = ++x + y--;
		System.out.println("문제 1-2 " + result);
		//1-3
		result = --x + ++y;
		System.out.println("문제 1-3 " + result);
		
		// 문제2
		System.out.println("문제 2 ");		
		
		int m = 10;
		int n = 5;
		//System.out.println((m*2 == n*4) || (n<=5));
		System.out.println((m*2 == n*4) && (n<5));
		//System.out.println((m/2 > 5) && (n%2 <1));
		System.out.println((m/2 >= 5) && (n%2 <=1));
		
		// 문제3
		System.out.println("문제 3 ");		
		int val = 0;

		val += 10;
		System.out.println(val);
		val -= 5;
		System.out.println(val);
		val *= 3;
		System.out.println(val);
		val /= 5 ;
		System.out.println(val);
		
		// 문제4
		System.out.println("문제 4 ");
		Scanner scan = new Scanner(System.in);
		System.out.print("값 : ");
		int input = scan.nextInt();
		input  = (input > 0 )? input:0;
		System.out.println(input);
		
		// 문제5
		System.out.println("문제 5 ");
		int a = 10;
		int b = -8;
		
		String result1 = (a < 0 || b < 0 ) ? "One of a or b is negative number" : "both a and b are zero or more";
		System.out.println(result1);
		/*
		 * if (a<0 || b<0) { System.out.println("One of a or b is negative number"); }
		 * else { System.out.println("both a and b are zero or more"); }
		 */
		
	}

}
