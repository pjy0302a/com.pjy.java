package com.yedam.java.ch0502;

import java.util.Scanner;

public class Quiz3 {

	public static void main(String[] args) {
		boolean run = true;
		int[] make = null;
		int i = 1;
		int k = 0;
		int number = 0;
		while (run) {
			Scanner scan = new Scanner(System.in);
			System.out.println("--------------------------------------------");
			System.out.println("1.상품수 | 2.가격입력 | 3.제품별가격 | 4.분석 | 5.종료");
			System.out.println("--------------------------------------------");
			int input = scan.nextInt();
			
			switch (input) {
				
			case 1:
				System.out.print("상품수 > : ");
				int m = scan.nextInt();
				make = new int[m];
				break;
			case 2:
				k=0;
				i=1;
				for (int num : make) {
					System.out.print(i + "번쨰 제품의 가격 : " );
					number = scan.nextInt();
					make[k] += number;
					i++;
					k++;
				}
				break;
			case 3:
				
				 k=0;
				 i=1;
				for (int num : make) {
					System.out.println(i + "번쨰 제품의 가격은 " + num);
					i++;
					k++;
				}
				break;
			case 4:
				int index = 0;
				int max = 0;
				int sum = 0;
				i=0;
				k=1;
				double avg = 0;
				for (int num : make) {
					if (num > max) {
						max = num;
					}
					
				}
				for (int num : make) {
					if(num==max) {
						index = k;
						continue;
					}
					sum += num;
					k++;
				}
				
//				int a;
//				for(a =0;a<make.length;a++)
//				{
//					if(make[a]==max) {
//						index = a+1;
//						continue;
//					}
//					sum += make[a];
//				}
					
					
				
				System.out.println("최고가격 : "  + index);
				System.out.println("최고값을 뺀 합 : " + sum);
				break;
			case 5:
				run = false;
				break;

			}

		}

	}

}
