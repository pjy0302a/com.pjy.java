package com.yedam.java.Quiz4;

import java.util.Scanner;

public abstract class Calculator {
	protected int a,b;
	abstract protected int cal();
	protected void input() {
		Scanner scan = new Scanner(System.in);
		System.out.println("정수 2개를 입력하세요 >>");
		a = scan.nextInt();
		b = scan.nextInt();
	}
	public void run() {
		input();
		int res = cal();
		System.out.println("계산된 값은 " + res);
	}


}
