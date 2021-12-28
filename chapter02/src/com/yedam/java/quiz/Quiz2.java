package com.yedam.java.quiz;

import java.util.Scanner;

public class Quiz2 {

	public static void main(String[] args) {
		// 문제 9
		long var1 = 2L;
		float var2 = 1.8f;
		double var3 = 2.5;
		String var4 = "3.9";
		
		int result = (int)(var1+var2+(int)var3+Double.parseDouble(var4));
		System.out.println(result);
		
		// 문제 10
		String str1 = 2+3+"";
		String str2 = 2+""+3;
		String str3 = ""+2+3;
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		
		// 문제 11
		byte value1 = Byte.parseByte("10");
		Integer value2 = Integer.parseInt("1000");
		float value3 = Float.parseFloat("20.5");
		double value4 = Double.parseDouble("3.14159");
		
		



		}
	
	}




