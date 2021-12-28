package com.yedam.java.ch0302;

import java.util.Scanner;

public class Quiz {
		//문제 9
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		/*
		 * System.out.print("첫 번째 수 : "); double num1 = scan.nextDouble();
		 * 
		 * System.out.print("두 번째 수 : "); double num2 = scan.nextDouble();
		 * 
		 * double result;
		 * 
		 * if ((num2==0) || (num2==0.0)){ System.out.println("or 결과: 무한대"); } else {
		 * result = num1/num2;
		 * 
		 * System.out.println(result); }
		 */
		//문제 11
		/*
		 * System.out.print("아이디:"); String name = scan.nextLine();
		 * System.out.print("패스워드:"); String strPassword = scan.nextLine(); int password
		 * = Integer.parseInt(strPassword);
		 * 
		 * if(name.equals("java")) { if(password == 12345) {
		 * System.out.println("로그인 성공"); } else { System.out.println("로그인 실패:패스워드가 틀림");
		 * } } else { System.out.println("로그인 실패:아이디 존재하지 않음"); }
		 */
		//Quiz
		int x = 10;
		int y = 10;
		int result;
		//1-1
		result = -x;
		System.out.println(result);
		//1-2
		result = x + y++;
		System.out.println(result);
		//1-3
		result = x + --y;
		//result = --x + y;
		System.out.println(result);
		//1-4
		//result = x / y;
		System.out.printf("목 : %d 나머지 : %d",x/y,x%y);
		
	}

}
