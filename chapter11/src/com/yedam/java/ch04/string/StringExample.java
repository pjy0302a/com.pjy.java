package com.yedam.java.ch04.string;

import java.io.UnsupportedEncodingException;

public class StringExample {

	public static void main(String[] args) {
		byte[] bytes = { 72, 101, 108, 108, 111, 32, 74, 97, 118, 97 };
		String str1 = new String(bytes);
		System.out.println(str1);

		String str2 = new String(bytes, 6, 4);
		System.out.println(str2);

		System.out.println();
		
		// charAt()
		String ssn = "010624-1230123";
		char gender = ssn.charAt(7);
		switch (gender) {
		case '1':
		case '3':
			System.out.println("남자 입니다.");
			break;
		case '2':
		case '4':
			System.out.println("여자 입니다.");
			break;

		default:
			break;
		}
		
		System.out.println();
		
		//getBytes()
		String str = "안녕하세요";
		byte[] bytesX = str.getBytes();
		System.out.println("bytesX.length : " + bytesX.length);
		
		try {
			byte[] bytesY = str.getBytes("EUC-KR");
			System.out.println("bytesY.length : " + bytesY.length);
			String strY = new String(bytesY,"EUC-KR");
			System.out.println("bytesY -> strY : " + strY);
			
			byte[] bytesZ = str.getBytes("UTF-8");
			System.out.println("bytesZ.length : " +bytesZ.length);
			String strZ = new String(bytesZ, "UTF-8");
			System.out.println("bytesZ -> strZ : " + strZ);
		}catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	
		System.out.println();
		//indexOf();
		String subject = "자바 프로그래밍";
		
		subject.indexOf("프로그래밍");
		
		int location = subject.indexOf("프로그래밍");
		System.out.println(location);
		
		if(subject.indexOf("JAVA") != -1) {
			System.out.println("JAVA가 포함되어 있습니다.");
		}else {
			System.out.println("JAVA가 포함되어 있지 않습니다.");
		}
		System.out.println();
		//length()
		ssn = "7306241230123";
		int length = ssn.length();
		if(length == 13) {
			System.out.println("주민번호 자리수가 맞습니다.");
		}else {
			System.out.println("주민번호 자리수가 틀립니다.");
		}
		
		System.out.println();
		//replace()
		String oldStr = "자바는 객체 지향 언어입니다. 자바는 풍부한 API를 지원합니다.";
		String newStr = oldStr.replace("자바", "JAVA");
		System.out.println(oldStr);
		System.out.println(newStr);
		
		System.out.println();
		//substring();
		ssn = "880815-1234567";
		
		String firstName = ssn.substring(0,6);
		String secondName = ssn.substring(7);
			
		System.out.println(firstName);
		System.out.println(secondName);
		
		System.out.println();
		//toLowerCase(), toUpperCase()
		String strA = "Java Programming";
		String strB = "JAVA Programming";
		
		System.out.println(strA.equals(strB));
		
		String lowerStr1 = strA.toLowerCase();
		String lowerStr2 = strB.toLowerCase();
		
		System.out.println(lowerStr1.equals(lowerStr1));
		System.out.println(strA.equalsIgnoreCase(strB));
		
		System.out.println();
		//trim()
		String tel1 = "          02";
		String tel2 = "123        ";
		String tel3 = "    1234     ";
		
		String telA = tel1 + tel2 + tel3;
		System.out.println(telA);
		String telB = tel1.trim() + tel2.trim() + tel3.trim();
		System.out.println(telB);
	}

}
