package com.yedam.java.Quiz;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MainExample2 {

	public static void main(String[] args) {
		boolean run = true;
//		Product[] list = null;
		int productNum = 0;

		Map<String, Integer> list = new HashMap<String, Integer>();

		while (run) {
			Scanner scan = new Scanner(System.in);
			System.out.println("------------------------------------------------------");
			System.out.println("1.상품 및 가격입력 | 2.제품별 가격 | 3.분석 | 4.종료");
			System.out.println("------------------------------------------------------");
			int input = scan.nextInt();

			switch (input) {

//			case 1:
//				System.out.print("상품수 > : ");
//				productNum = scan.nextInt();
//				list = new Product[productNum];
//				break;
			case 1:

				
				System.out.print("상품명>");
				String name = scan.next();
				System.out.print("가격>");
				int price = scan.nextInt();
//					Product product = new Product(name, price);
//				list.add(new Product(name, price));
				list.put(name, price);

				break;
			case 2:

//				Set<Map.Entry<String, Integer>> entrySet = list.entrySet();
//				Iterator<Map.Entry<String, Integer>> entryIterator = entrySet.iterator();
				Set<String> keySet = list.keySet();
				Iterator<String> keyIterator = keySet.iterator();
				while(keyIterator.hasNext()) {
					String key = keyIterator.next();
					Integer value = list.get(key);
					
					System.out.println(key + " " + value );
				}
//				for (int i = 0; i < list.size(); i++) {
//					System.out.println(list.get(i).getName() + " " + list.get(i).getPrice());
//				}
//				for(Product product : list) {
//					System.out.printf("%d");
//				}
				break;
			case 3:
				Set<String> keySet1 = list.keySet();
				Iterator<String> keyIterator1 = keySet1.iterator();
				int max = 0;
				String name1 = null;
				int sum1 = 0;
				
				while(keyIterator1.hasNext()) {
					String key = keyIterator1.next();
					Integer value = list.get(key);
					if(value > max) {
						 max = value;
					}
					
				}
				while(keyIterator1.hasNext()) {
					String key = keyIterator1.next();
					Integer value = list.get(key);
					if(value == max) {
						 name1 = key;
					}
					else {
						sum1 += value;
					}
					
				}
	
				System.out.println(name1);
				System.out.println(sum1);
//				System.out.println(sum);
//				for (int i = 0; i < list.size(); i++) {
//
//					if (list.get(i).getPrice() > max) {
//						max = list.get(i).getPrice();
//					}
//				}
//				String name1 = null;
//				int sum = 0;
//				for (int i = 0; i < list.size(); i++) {
//
//					if (list.get(i).getPrice() == max) {
//						name1 = list.get(i).getName();
//						continue;
//					} else {
//						sum += list.get(i).getPrice();
//					}
//				}
//				System.out.println("최고가 제품 : " + name1);
//				System.out.println("최고값 뺀 합 : " + sum);

				break;
			case 5:

				break;
			}

		}

	}

}
