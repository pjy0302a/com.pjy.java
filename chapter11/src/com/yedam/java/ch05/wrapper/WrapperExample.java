package com.yedam.java.ch05.wrapper;

public class WrapperExample {

	public static void main(String[] args) {
		//Boxing
		Integer obj1 = new Integer(100);
		Integer obj2 = new Integer("200");
		
		Integer obj3 = Integer.valueOf(100);
		Integer obj4 = Integer.parseInt("200");
		
		//Unboxing
		int value4 = obj4.intValue();
		int value5 = obj3.intValue();
		System.out.println(value4);
		System.out.println(value5);
		
		//자동
		Integer obj = 100;
		
		int value = obj;
		
//		int result = obj.intValue() + 100;
		int result = obj + 100;
 		System.out.println(result);
 		
 		//포장객체비교
 		System.out.println("[-128~127를 초과한 경우]");
 		Integer obj5 =300;
 		Integer obj6 =300;
 		System.out.println("==결과 : " + (obj5 == obj6));
 		System.out.println("언박싱 후 결과 : " + (obj5.intValue() == obj6.intValue()));
 		System.out.println("equals 결과 : " + obj5.equals(obj6));
 		
 		System.out.println("[-128~127를 범위값일 경우]");
 		Integer obj7 = 100;
 		Integer obj8 = 100;
 		
 		System.out.println("==결과 : " + (obj7 == obj8));
 		System.out.println("언박싱 후 결과 : " + (obj7.intValue() == obj8.intValue()));
 		System.out.println("equals 결과 : " + obj7.equals(obj8));
 		
 		
	}

}
