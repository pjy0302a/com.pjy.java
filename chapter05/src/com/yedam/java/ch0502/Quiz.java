package com.yedam.java.ch0502;

import java.util.Scanner;

public class Quiz {

	public static void main(String[] args) {
		
		int[] arr1 = {10,20,30,50,3,60,-3};
		//문제1
		System.out.println("문제1 : " + arr1[5]);
		//문제2
		System.out.print("문제2 : ");
		for(int i=0;i<arr1.length;i++) {
			if(arr1[i]!= arr1[3])
				System.out.print(arr1[i]+ " ");
		}
		System.out.println();
		//문제3
		System.out.print("문제3 : 변경하고 싶은 인덱스 값 : ");
		Scanner scan = new Scanner(System.in);
		int index = Integer.parseInt(scan.nextLine());
		int temp = 1000;
		arr1[index] = temp;
		for(int i=0;i<arr1.length;i++) {
			System.out.print(arr1[i]+ " ");
		}
		System.out.println();
		//문제4
		int max = arr1[0];
		int min = arr1[0];
		for(int i=0;i<arr1.length;i++) {
//			System.out.println(arr1[i]);
			if(arr1[i]>max) {
				max = arr1[i];
			}else if(arr1[i]<min) {
				min = arr1[i];
			}
			
		}
		System.out.println("문제4 : 최대값 : " + max + " 최소값 : " + min);
		//문제5
		System.out.println("문제5");
		int[] arr2 = new int[10];
//		int[] arr3 = new int[];
		
		for(int i=0;i<arr2.length;i++) {
			System.out.print("정수를 입력하세요:");
			int ten = Integer.parseInt(scan.nextLine());
				arr2[i] = ten;
//				System.out.println(arr2[i]);
		}
		for(int j=0;j<arr2.length;j++) {
//			System.out.println(arr2[j]);
			if (arr2[j]%3==0) {
				System.out.println("3의배수 : "+arr2[j]);
			}
		}

		
	}

}
