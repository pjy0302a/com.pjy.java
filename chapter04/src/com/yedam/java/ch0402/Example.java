package com.yedam.java.ch0402;

import java.util.Scanner;

public class Example {

	public static void main(String[] args) {
		// for 문

		// 예제 1 - 0부터 90까지 출력 10단위로 출력
		for (int i = 0; i <= 90; i += 10) {
			System.out.println(i);
		}

		// 예제 2 - 0부터 20까지 짝수
		for (int i = 0; i <= 20; i++) {
			if (i % 2 != 0) {
				continue;
			}
			System.out.println(i);
		}
		// 예제 3
		Scanner scan = new Scanner(System.in);
//		System.out.println("숫자 5개를 입력하세요.");
//		int sum = 0;
//		for (int i = 1; i <= 5; i++) {
//			
//			System.out.print("숫자를 입력하세요 . :");
//			int num = Integer.parseInt(scan.nextLine());
//			sum += num;
//			System.out.println("출력 : " + sum);
//		}
		// 예제 4 - 1부터 사용자가 입력한 숫자까지 합계
		System.out.println("숫자를 입력하세요. ");
		int sum1 = 0;
		int num1 = Integer.parseInt(scan.nextLine());
		for (int i = 1; i <= num1; i++) {
			sum1 = sum1 + i;
		}
		System.out.println(sum1);

	}

}
