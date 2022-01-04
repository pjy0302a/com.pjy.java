package com.yedam.java.example;

import java.util.Scanner;

public class MainExample {
	public static void main(String[] args) {
		//문제1
		//Calculator 클래스 -> 사칙연산 메서드
		Calculator cal = new Calculator();
//		int x = 10;
//		int y = 4;
//		System.out.println(cal.plus(x, y));
		int result1 = cal.plus(10, 5);
		int result2 = cal.minus(10, 5);
		int result3 = cal.mulit(10, 5);
		double result4 = cal.divide(10, 5);

		
		System.out.println("더하기" + result1);
		System.out.println("빼기" + result2);
		System.out.println("곱하기" + result3);
		System.out.println("나누기" + result4);

		
		//문제2 
		//TV 클래스 -> 다음과 같은 형태의 생성자와 메서드를 가진다.
		TV myTV = new TV("LG",2017,32);
		myTV.showinfo();
		
		//문제3
		//Grade 클래스 -> 3과목의 점수를 입력받아 성적평균을 출력한다.
		Scanner scan = new Scanner(System.in);
		System.out.println("수학, 과학, 영어 순으로 3개의 정수 입력 >>");
		int math = scan.nextInt();
		int science = scan.nextInt();
		int english = scan.nextInt();
		Grade myGrade = new Grade(math, science, english);
		//average() 메서드는 평균을 계산하여 리턴
		System.out.println("평균 : " + myGrade.average());
	}
}
