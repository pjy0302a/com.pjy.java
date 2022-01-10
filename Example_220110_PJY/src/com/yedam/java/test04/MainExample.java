package com.yedam.java.test04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainExample {
	public static void main(String[] args) {
		boolean run = true;
		Scanner scan = new Scanner(System.in);
		List<ToDo> list = new ArrayList<ToDo>();
		String todo = null;
		String can = null;
		int name;
		while (run) {
			System.out.println("=== 1.할일입력 | 2. 전체조회 | 3.할일조회 | 4.할일완료 | 5.종료 ===");
			System.out.print("선택>");
			int input = scan.nextInt();

			switch (input) {

			case 1:

				System.out.print("할 일> ");
				todo = scan.next();
				can = scan.next();
				list.add(new ToDo(todo, can));
				break;
			case 2:

				for (ToDo work : list) {
					
						System.out.println(work.getNum() + ") " + work.getToDo() + " " + work.getCan() + " "
								+ (work.isTf() ? "완료" : "미완료"));
					
					
				}

				break;
			case 3:
				for (ToDo work : list) {
					if (work.isTf() == false) {
						System.out.println(work.getNum() + ") " + work.getToDo() + " " + work.getCan() + " "
								+ (work.isTf() ? "완료" : "미완료"));

					}
					

				}
				break;
			case 4:
				System.out.print("완료 할 일을 선택해주세요> ");
				name = scan.nextInt();

				for (ToDo work : list) {
					if (name == work.getNum()) {
						if (work.isTf() == false) {
							System.out.println("해당 할 일을 완료처리하였습니다.");
							work.setTf(true);
							if (work.isTf() == true) {
								list.remove(Integer.valueOf(work.getNum()));
							}
						}
						else {
							System.out.println("해당 할 일은 이미 완료되었습니다.");
						}
					}
				}
				break;


			case 5:
				System.out.println("종료되었습니다.");
				run = false;
				break;
					
			}
			}
	}

}