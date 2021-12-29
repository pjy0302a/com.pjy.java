package com.yedam.java.ch0402;

import java.util.Scanner;

public class Quiz2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		//문제1
		System.out.print("x 를 입력하세요 : ");
		int x = Integer.parseInt(scan.nextLine());
		System.out.print("y 를 입력하세요 : ");
		int y = Integer.parseInt(scan.nextLine());
		if((x > 0)&&(y > 0)) {
			System.out.println("1사분면");
		} else if((x < 0)&&(y > 0)) {
			System.out.println("2사분면");
		} else if((x < 0)&&(y < 0)) {
			System.out.println("3사분면");
		} else if((x > 0)&&(y < 0)) {
			System.out.println("4사분면");
		} else {
			System.out.println("잘못입력하셨습니다.");
		}
		//문제2
		System.out.print("년도를 입력하시오 : ");
		int year = Integer.parseInt(scan.nextLine());
		if((year%4 == 0 ) && (year%100!=0) || (year%400 == 0)){
			System.out.println(year + "은 윤년");
		
		}else {
			System.out.println(year + "은 평년");
		}
		//문제3
		System.out.print("가위바위보를 내세요! : ");
		String com= scan.nextLine();
		switch (com) {
		case "가위":
			System.out.println("이기기 위해선 바위를 내야합니다.");
			break;
		case "바위":
			System.out.println("이기기 위해선 보를 내야합니다.");
			break;
		case "보":
			System.out.println("이기기 위해선 가위를 내야합니다.");
			break;
		default:
			System.out.println("가위,바위,보를 입력하세요");
		}
		//문제4
		String star = "*";
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print(star);
			}
			System.out.println();
		}
		
		//문제5
		System.out.print("단을 입력하시오. : ");
		int m = Integer.parseInt(scan.nextLine());
		System.out.print("곱을 입력하시오. : ");
		int n = Integer.parseInt(scan.nextLine());
		for(int i=m;i<=m;i++) {	//2
			for(int j=1;j<=n;j++) { //3
				System.out.printf("%d X %d = %d\n",i,j,i*j);
			}
			
		}
		
	}

}
