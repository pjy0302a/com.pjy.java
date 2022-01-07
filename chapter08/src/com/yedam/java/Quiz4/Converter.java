package com.yedam.java.Quiz4;

import java.util.Scanner;

public abstract class Converter {
	protected double ratio;
	
	abstract protected double convert(double src);
	abstract protected String getSrcString();
	abstract protected String getDestString();
	
//	protected Converter(double ratio) {
//		this.ratio = ratio;
//	}
	
	public void run() {
		Scanner scan = new Scanner(System.in);
		System.out.println(getSrcString() + "을 " + getDestString() + "로 바꿉니다.");
		System.out.println(getSrcString() + "을 입력하세요 >>");
		double val = scan.nextDouble();
		double res = convert(val);
		System.out.println("변환 결과: " + res + getDestString()+"입니다.");
		scan.close();
	}
}
