package com.yedam.java.ch0401;

import java.util.Scanner;

public class Example {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		/*
		 * //예제1 - 숫자를 입력받아 70점이상이면 합격 미만이면 불합격 int score =
		 * Integer.parseInt(scan.nextLine());
		 * 
		 * if(score >= 70) { System.out.println("합격"); }else {
		 * System.out.println("불합격"); }
		 */ // 예제2 - 정수 한개를 입력받아 해당 정수가 2의 배수인지 확인
		/*
		 * int num = Integer.parseInt(scan.nextLine());
		 * 
		 * if(num%2 ==0) { System.out.println("2의 배수입니다."); } else {
		 * System.out.println("2의 배수가 아닙니다."); }
		 */
		// 예제 3 - 점수는 0~100점 사이 값이여야 하며 벗어날 경우 "점수 입력 오류" 출력
		// 60점 이상이면 합격, 미만이면 불합격
		// boolean result = false;

//		System.out.print("1~100사이의 값을 입력하세요 : ");
//		int score = Integer.parseInt(scan.nextLine());
//		//while(result = false) {
//		
//		if((score >= 0) && (score<=100) ) {
//			if(score >= 60) {
//				System.out.println("합격");
//				// result = true;
//			}else{
//				System.out.println("불합격");
//			}
//			
//		} else {
//			System.out.println("점수입력오류!");
//		}

		// }

		// 예제4 System.out.print("키가 몇이신가요? :");
		double key = Double.parseDouble(scan.nextLine());
		if (key >= 110) {
			System.out.println("라바 트위스터 탑승!");
		} else if (key < 110) {
			System.out.println("보호자가 있으신가요? : ");
			System.out.println("1 : 보호자와 동행 2 : 혼자");
			int selected = Integer.parseInt(scan.nextLine());
			if (selected == 1) {
				System.out.println("보호자와 라바 트위스터를 탑승 할 수 있습니다.");
			} else {
				System.out.println("보호자와 같이 오세요!");
			}
		}
		// switch문
		// 예제1 - 정수를 입력 받아 0일 경우 false, 1일 경우 true , 둘다아닐경우 "체크오류"
		System.out.print("정수 0 또는 1을 입력하시오. :");
		int inputnum = Integer.parseInt(scan.nextLine());
		switch (inputnum) {
		case 0:
			System.out.println("false");
			break;
		case 1:
			System.out.println("true");
			break;

		default:
			System.out.println("체크오류");
			break;
		}

		// 예제2

		System.out.print("정수를 입력하시오 : ");
		int inputnum2 = Integer.parseInt(scan.nextLine());
		switch (inputnum2 % 2) {
		case 0:
			System.out.println(inputnum2 + "는 짝수입니다 ");
			break;
		case 1:
			System.out.println(inputnum2 + "는 홀수입니다 ");
			break;
		default:
			System.out.println("다시 입력해주세요");
			break;
		}

	}

}
