package com.yedam.java.ch0402;

import java.util.Scanner;

public class Quiz {

	public static void main(String[] args) {
		//문제1
		String s ="";
		String star = "*";
		for(int i=1; i<=5; i++) {
			s += star;
			System.out.println(s);
		}
		//문제2
		int sum = 0;
		for(int i=1; i<=100; i++) {
			if(i%2 != 0) {
				continue;	
			}
			sum++;
		}
		System.out.println("2의 배수가 아닌 숫자 : " + sum);
		//문제3
		int x = 1;
		int y = 1;
		Label :for (x=1; x<=10; x++) {
			for(y=1;y<=10; y++) {
				if(x*4 + y*5 == 60) {
					break Label;
				}
			}
			
		}
		System.out.println("x의 값 : "+ x + " y의 값 : " + y);
		//문제4
		int dice = 0;
		do {
			 dice = (int)(Math.random()*10)+1;
			System.out.println(dice);
		}while(dice != 7);
		System.out.println("반복문 종료");
		
		//문제5
		int result = 0 ;
		int cnt = 0;
		while(result != 5) {
			
			int num1 = (int)(Math.random()*6)+1;
			int num2 = (int)(Math.random()*6)+1;
			cnt++;
			result = num1+num2;
			System.out.println("("+num1 + ")" + "("+num2+")");
			
		}
		System.out.println("던진 횟수 : "+cnt);
		
		//문제7
//		boolean run = true;
//		int balance = 0;
//		Scanner scan = new Scanner(System.in);
//		while(run) {
//			System.out.println("----------------------------");
//			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
//			System.out.println("----------------------------");
//			System.out.print("선택> ");
//			int ye = 0;
//			int ch = 0;
//			
//			int input = Integer.parseInt(scan.nextLine());
//			if(input == 1) {
//				System.out.println("예금액> : ");
//				 ye = Integer.parseInt(scan.nextLine());
//				 balance += ye;
//				 
//				
//			} else if(input==2){
//				System.out.println("출금액> : ");
//				 ch = Integer.parseInt(scan.nextLine());
//				 if ((balance - ch) < 0) {
//					 System.out.println("잔액이 없습니다.");
//				 } else {
//					 balance -= ch;
//				 }
//				 
//
//			} else if(input==3) {
//				
//				System.out.println(balance);
//			} else if(input==4) {
//				run = false;
//				System.out.println("종료되었습니다.");
//			}else {
//				System.out.println("잘못 입력하셨습니다.");
//				continue;
//			}
//			
//		}
		//
		boolean run1 = true;
		int balance1 = 0;
		Scanner scan1 = new Scanner(System.in);
		while(run1) {
			System.out.println("----------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("----------------------------");
			System.out.print("선택> ");
			int menuNo = Integer.parseInt(scan1.nextLine());
			switch (menuNo) {
			case 1://예금
				System.out.println("예금액>");
				balance1 += Integer.parseInt(scan1.nextLine());

				break;
			case 2://출금
				System.out.println("출금액>");
				balance1 -= Integer.parseInt(scan1.nextLine());

				break;
			case 3://잔고
				System.out.println(balance1);
				break;
			case 4://종료
				run1 = false;
				System.out.println("종료완료.");
				break;
			default:
				break;
			}
	}

	}
}