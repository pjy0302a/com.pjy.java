package com.yedam.java.example;

import java.util.Scanner;

public class Example3 {

	public static void main(String[] args) {
		//1부터 10사이의 임의의 숫자를 발생시킵니다.
		//총 3번의 기회가 있고
		//기회 내에 미성공 시 프로그램 종료
		Scanner scan = new Scanner(System.in);
		boolean run = true;
		int cnt = 0;
		int Dice = (int)(Math.random()*10)+1;
//		System.out.println(Dice);
		while(run) {
			if (cnt == 3) {
				System.out.println("기회가 끝났습니다.");
				//run = false;
				break;
			} else{
				System.out.print("1 ~ 10 사이의 수를 입력하세요 : ");
				int user = scan.nextInt();
				if(user == Dice) {
					System.out.println("정답입니다.");
					//run = false;
					break;
				} else if(user > Dice) {
					System.out.println("값이 큽니다");
				} else if(user < Dice) {
					System.out.println("값이 작습니다.");
				}
				
				cnt ++;
			}
			
		}

	}

}
