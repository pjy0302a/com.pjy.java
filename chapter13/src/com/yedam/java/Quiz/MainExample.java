package com.yedam.java.Quiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainExample {
	public static void main(String[] args) {
		boolean run = true;
		int productNum = 0;

		List<Product> list = new ArrayList<Product>();

		while (run) {
			Scanner scan = new Scanner(System.in);
			System.out.println("------------------------------------------------------");
			System.out.println("1.상품 및 가격입력 | 2.제품별 가격 | 3.분석 | 4.종료");
			System.out.println("------------------------------------------------------");
			int input = scan.nextInt();

			switch (input) {

			case 1:

				System.out.print("상품명>");
				String name = scan.next();
				System.out.print("가격>");
				int price = scan.nextInt();
//					Product product = new Product(name, price);
				list.add(new Product(name, price));

				break;
			case 2:

				for (int i = 0; i < list.size(); i++) {
					System.out.println(list.get(i).getName() + " " + list.get(i).getPrice());
				}
//				for(Product product : list) {
//					System.out.printf("%d");
//				}
				break;
			case 3:
				int max = 0;

				for (int i = 0; i < list.size(); i++) {

					if (list.get(i).getPrice() > max) {
						max = list.get(i).getPrice();
					}
				}
				String name1 = null;
				int sum = 0;
				for (int i = 0; i < list.size(); i++) {

					if (list.get(i).getPrice() == max) {
						name1 = list.get(i).getName();
						continue;
					} else {
						sum += list.get(i).getPrice();
					}
				}
				System.out.println("최고가 제품 : " + name1);
				System.out.println("최고값 뺀 합 : " + sum);

				break;
			case 4:
				run = false;
				break;
			}

		}

	}
}