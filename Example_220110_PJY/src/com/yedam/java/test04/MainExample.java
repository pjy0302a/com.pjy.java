package com.yedam.java.test04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainExample {
	public static void main(String[] args) {
		boolean run = true;
		Scanner scan = new Scanner(System.in);
		TodoClass todoClass = new TodoClass();
		String todo = null;
		String can = null;
		int name ;
		while (run) {
			System.out.println("=== 1.할일입력 | 2. 전체조회 | 3.할일조회 | 4.할일완료 | 5.종료 ===");
			System.out.print("선택>");
			int input = scan.nextInt();

			switch (input) {

			case 1:

				System.out.print("할 일> ");
				todo = scan.next();
				can = scan.next();
				todoClass.addtoDo(todo, can);
				
				break;
			case 2:
				todoClass.allprint();
				

				break;
			case 3:
				todoClass.selectprint();
				break;
			case 4:
				System.out.print("완료 할 일을 선택해주세요> ");
				name = scan.nextInt();
				todoClass.complete(name);
				
				break;


			case 5:
				System.out.println("종료되었습니다.");
				run = false;
				break;
					
			}
			}
	}

}