package com.yedam.java.Quiz;

import java.util.Scanner;

public class MainExample {
	public static void main(String[] args) {
		boolean run = true;
		Product[] list = null;
		int productNum = 0;

		while (run) {
			Scanner scan = new Scanner(System.in);
			System.out.println("------------------------------------------------------");
			System.out.println("1.상품 수 | 2.상품 및 가격입력 | 3.제품별 가격 | 4.분석 | 5.종료");
			System.out.println("------------------------------------------------------");
			int input = scan.nextInt();

			switch (input) {

			case 1:
				System.out.print("상품수 > : ");
				productNum = scan.nextInt();
				list = new Product[productNum];
				break;
			case 2:
				for (int i = 0; i < list.length; i++) {
					System.out.print("상품명>");
					String name = scan.next();
					System.out.print("가격>");
					int price = scan.nextInt();

					Product product = new Product(name, price);
					list[i] = product;

				}
				break;
			case 3:

				for (int i = 0; i < list.length; i++) {
					System.out.println(list[i].getName() + " " + list[i].getPrice());
				}
//				for(Product product : list) {
//					System.out.printf("%d");
//				}
				break;
			case 4:
				int max = 0;

				for (int i = 0; i < list.length; i++) {
					Product product = list[i];
					if (product.getPrice() > max) {
						max = product.getPrice();
					}
				}
				String name = null;
				int sum = 0;
				for (int i = 0; i < list.length; i++) {
					Product product = list[i];
					if (product.getPrice() == max) {
						name = product.getName();
						continue;
					} else {
						sum += product.getPrice();
					}
				}
				System.out.println("최고가 제품 : " + name);
				System.out.println("최고값 뺀 합 : " + sum);

				break;
			case 5:

				break;
			}

		}

	}
}
