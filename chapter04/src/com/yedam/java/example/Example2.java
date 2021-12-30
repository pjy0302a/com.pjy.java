package com.yedam.java.example;

import java.util.Scanner;

public class Example2 {

	public static void main(String[] args) {
		// ATM기가 있고 입금, 출금, 잔액조회
		// 1. 출금을 할때 잔액보다 많을 경우 잔액부족
		// 2. 입금, 출금, 잔액조회 -> 비밀번호(1234)로 정보확인
		boolean run = true;
		int balance = 0;
		Scanner scan = new Scanner(System.in);
		Out: while (run) {
			System.out.println("----------------------------");
			System.out.println("1.입금 | 2.출금 | 3.잔액조회 | 4.종료");
			System.out.println("----------------------------");
			System.out.print("선택> ");
			int menuNo = scan.nextInt();
			if(menuNo == 4) {
				System.out.println("종료되었습니다.");
				run = false;
				continue;
			}
			if ((menuNo < 4 && menuNo > 0)) {
				System.out.print("비밀번호를 입력해주세요 : ");
					int passwd = 0;
					passwd = scan.nextInt();

				if (passwd == 1234) {
					switch (menuNo) {
					case 1:
						System.out.print("입금할 금액 : ");
						int x = scan.nextInt();
						balance += x;
						break;
					case 2:
						System.out.print("출금할 금액 : ");
						int y = scan.nextInt();
						if (y <= balance) {
							balance -= y;
						} else {
							System.out.println("잔액이 부족합니다.");
						}
						break;
					case 3:
						System.out.print("잔액조회 : ");
						System.out.println(balance);
						break;
					}
					
				}
				else {
					System.out.println("비밀번호가 틀렸습니다");
			}
			}
		}
//		boolean run = true;
//		int balance = 0;
//		Scanner scan = new Scanner(System.in);
//		while(run) {
//			System.out.println("----------------------------");
//			System.out.println("1.입금 | 2.출금 | 3.잔고 | 4.종료");
//			System.out.println("----------------------------");
//			System.out.print("선택> ");
//			int menuNo = Integer.parseInt(scan.nextLine());
//			switch (menuNo) {
//			case 1://예금
//				System.out.println("예금액>");
//				balance += Integer.parseInt(scan.nextLine());
//
//				break;
//			case 2://출금
//				System.out.println("출금액>");
//				balance -= Integer.parseInt(scan.nextLine());
//
//				break;
//			case 3://잔고
//				System.out.println(balance);
//				break;
//			case 4://종료
//				run = false;
//				System.out.println("종료완료.");
//				break;
//			default:
//				break;
//			}
//	}
	}

}
