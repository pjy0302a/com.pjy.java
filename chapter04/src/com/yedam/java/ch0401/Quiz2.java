package com.yedam.java.ch0401;

import java.util.Scanner;

public class Quiz2 {

	public static void main(String[] args) {
		// 문제1
		int num1  = 1;
		int num2  = 2;
		if ((num1 + num2) > 0 ) {
			System.out.println("Natural Number");
		} else {
			System.out.println("실수");
		}
		// 문제2
		if ((num1 > num2)) {
			System.out.println(">");
		} else if (( num1 < num2)){
			System.out.println("<");
		} else {
			System.out.println("=");
		}
		// 문제3
		double key = 1.85;
		double kg  = 70.2; 
		double BMI = kg / (key*key);
		System.out.println(BMI);
		if (BMI < 18.5) {
			System.out.println("저체중");
		} else if ((BMI>=18.5) && BMI<25) {
			System.out.println("정상");
		} else if ((BMI>25) && BMI<30) {
			System.out.println("과체중");
		}else if ( BMI<=30 ) {
			System.out.println("비만");
		}
		//문제4
		Scanner scan = new Scanner(System.in);
		System.out.print("1~9단을 입력하시오 : ");
		int input = scan.nextInt();
		switch (input) {
		
		case 1:
			System.out.println("1 * 6 = 6");
			break;
		case 2:
			System.out.println("2 * 6 = 12");
			break;
		case 3:
			System.out.println("3 * 6 = 18");
			break;
		case 4:
			System.out.println("4 * 6 = 24");
			break;
		case 5:
			System.out.println("5 * 6 = 30");
			break;
		case 6:
			System.out.println("6 * 6 = 36");
			break;
		case 7:
			System.out.println("7 * 6 = 42");
			break;
		case 8:
			System.out.println("8 * 6 = 48");
			break;
		case 9:
			System.out.println("9 * 6 = 54");
			break;
		default:
			System.out.println("1~9단 까지의 값을 입력해주세요 ");
			break;
		}
		// 문제5
		System.out.print("1~100자리의 수를 입력하세요 : ");
		int score = scan.nextInt();
		score = (score/10);
		switch (score) {
		case 10:
		case 9:
			System.out.println("A등급");
			break;
		case 8:
			System.out.println("B등급");
			break;
		case 7:
			System.out.println("C등급");
			break;
		case 6:
			System.out.println("D등급");
			break;
		case 5:
		case 4:
		case 3:
		case 2:
		case 1:
		case 0:
			System.out.println("E등급");
			break;
		default:
			System.out.println("1~100자리를 입력해주세요!");
			break;
		}
//		Scanner scan = new Scanner(System.in);
//		System.out.print("1~100자리의 수를 입력하세요 : ");
//		int score = scan.nextInt();
//		if ((score >= 90) && (score <=100)) {
//			score = 'A';
//		} else if ((score >= 80) && (score <90)){
//			score = 'B';
//		} else if ((score >= 70) && (score <80)){
//			score = 'C';
//		} else if ((score >= 60) &&(score <70)){
//			score = 'D';
//		} else if ((score >= 0) &&(score <60)){ 
//			score = 'E';
//		}
//		switch (score) {
//		case 'A':
//			System.out.println("A등급입니다");
//			break;
//		case 'B':
//			System.out.println("B등급입니다");
//			break;
//		case 'C':
//			System.out.println("C등급입니다");
//			break;
//		case 'D':
//			System.out.println("D등급입니다");
//			break;
//		case 'E':
//			System.out.println("E등급입니다");
//		default:
//			System.out.println("1~100까지의 수를 입력해야합니다!");
//			break;
//		}
	}

}
