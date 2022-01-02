package com.yedam.java.ch0502;

import java.util.Scanner;

public class Quiz2 {

	public static void main(String[] args) {
		boolean run = true;
		int[] score = null;
		int cnt = 0;
		// 학생수 배열의 공간
		while (run) {
			Scanner scan = new Scanner(System.in);
			System.out.println("--------------------------------------------");
			System.out.println("1.학생수 | 2.정수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("--------------------------------------------");
			int input = Integer.parseInt(scan.nextLine());
			int m = 0;
			int number = 0;
			int max = 0;
			int sum = 0;
			if(input == 5) {
				System.out.println("종료되었습니다.");
				run = false;
			}
			else if (cnt == 0 && input != 1) {
				System.out.print("학생수를 입력해주십시오.");
//				cnt++;
				System.out.println(cnt);
				continue;
			} 
			else {
				switch (input) {
				case 1:
					// 배열 학생수
					System.out.println("학생수>");
					m = Integer.parseInt(scan.nextLine());

					score = new int[m];

//				for(int i=0;i<=score.length;i++) {
//				
//					System.out.println(score[i]);
//				}
					break;
				case 2:
					for (int i = 0; i < score.length; i++) {
						System.out.println("scores" + "[" + i + "]>");
						number = Integer.parseInt(scan.nextLine());
						score[i] = number;
//						System.out.println(score[i]);
					}
					break;
				case 3:
					for (int i = 0; i < score.length; i++) {
						System.out.println("score"+"["+i+"] : "+score[i]);
					}
					break;
				case 4:
					for (int i = 0; i < score.length; i++) {
						sum += score[i];
					}
					for (int i = 0; i < score.length; i++) {
						if (max < score[i]) {
							max = score[i];
						}
					}
					System.out.println("최고 점수 : " + max);
					float avg = (float)sum / score.length;
					System.out.println("평균 점수 : " + avg);
					break;
				case 5:
					run = false;
					System.out.println("종료되었습니다.");
					break;
				default:

					break;
				
			}
		}
			cnt++;
		}


	}

}
