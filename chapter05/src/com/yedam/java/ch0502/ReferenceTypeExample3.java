package com.yedam.java.ch0502;

import java.util.Scanner;

public class ReferenceTypeExample3 {

	public static void main(String[] args) {
		//예제1 - 주어진 배열 안의 값을 전부 더하고 합과 평균을 출력
		int[] arr1 = {10,20,30,50,3,60,-5};
		int sum = 0;
		for(int i = 0;i<arr1.length;i++) {
			sum += arr1[i];
		}
		System.out.println("합 : " + sum );
		double avg = sum/arr1.length;
		System.out.println("평균 : " + avg );
		
		//예제2 - 주어진 배열 안의 값을 출력하는데 인덱스가  
		//       2의배수인경우만 출력한다
		for(int i=0;i<arr1.length;i++) {
			if(i%2 == 0) {	
			System.out.print(arr1[i]+" ");
			}
			}
		System.out.println();
		//예제3 - 인덱스번호 2개를 입력받아, 그 값을 서로 바꿔보세요
		Scanner scan = new Scanner(System.in);
		System.out.print("첫번쨰 인덱스: ");
		int num1 = scan.nextInt();
		System.out.print("두번쨰 인덱스: ");
		int num2 = scan.nextInt(); 
		
		int temp = arr1[num1];
		arr1[num1] = arr1[num2];
		arr1[num2] = temp;
		for(int i = 0;i<arr1.length;i++) {
			
			System.out.print(arr1[i] + " ");
		}
	}

}
