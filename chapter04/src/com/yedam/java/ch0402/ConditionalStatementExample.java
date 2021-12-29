package com.yedam.java.ch0402;

public class ConditionalStatementExample {

	public static void main(String[] args) {
		// for문

		for (int i = 1; i <= 10; i++) {
			System.out.println(i);
		}
		int z = 1;
		for (; z <= 100; z++) {
			System.out.println(z);
		}

		for (int i = 0, j = 100; (i <= 50) && (j >= 50); i += 10, j--) {
			System.out.println(i + "," + j);
		}
		// 1부터 100까지 더한 값
		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			sum += i;
		}
		System.out.println("1~100까지 더한 합계 : " + sum);

		sum = 0;
		int index = 0;
		for (index = 1; index <= 100; index++) {
			sum += index;
			System.out.println("sum : " + sum + ", index : " + index);
		}
		// 구구단
		for (int m = 2; m <= 9; m++) {
			System.out.println("*** " + m + "단 ***");
			for (int n = 1; n <= 9; n++) {
				System.out.printf("%d X %d = %d\n", m, n, (m * n));
			}
		}
		// while문
		int m = 1;
		while (m <= 10) {
			System.out.println(m);
			m++;
		}

		sum = 0;
		index = 0;

		while (index <= 100) {
			sum += index;
			index++;

			System.out.println("sum : " + sum + ", index : " + index);
		}
		index = 1;
		while (index != 1) {
			System.out.println("while 반본묵이 " + index + "번 실행됩니다.");
		}

		do {
			System.out.println("do ~ while 반본묵이 " + index + "번 실행됩니다.");
		} while (index != 1);

		while (true) {
			int num = (int) (Math.random() * 6) + 1;
			System.out.println(num);
			if (num == 6) {
				break;
			}
		}
		System.out.println("프로그램 종료");

		for (char upper = 'A'; upper <= 'Z'; upper++) {
			for (char lower = 'a'; lower <= 'z'; lower++) {
				System.out.println(upper + "-" + lower);
				if (lower == 'g') {
					break;
				}
			}
			System.out.println("1)안쪽 for문 종료");
		}
		System.out.println("1)바깥쪽 for문 종료");

		System.out.println("프로그램 종료");

		Outter : for (char upper = 'A'; upper <= 'Z'; upper++) {
			for (char lower = 'a'; lower <= 'z'; lower++) {
				System.out.println(upper + "-" + lower);
				if (lower == 'g') {
					break Outter;
				}
			}
			System.out.println("1)안쪽 for문 종료");
		}
		System.out.println("1)바깥쪽 for문 종료");
		
		for(int i = 1; i <= 10; i++) {
			if(i%2!= 0) {
				continue;
			}
			System.out.println(i);
		}
	}

}
