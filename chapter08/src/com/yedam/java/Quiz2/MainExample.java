package com.yedam.java.Quiz2;

public class MainExample {

	public static void main(String[] args) {
		//문제2) 다음을 만족하는 클래스 SalaryMan를 작성하시오.
		//		-필드 salary 월 급여액을 저장하며, int형으로 초기값으로 1,000,000 저장
		//		-메소드 getAnnualGross()는 연봉을 계산해 반환하는 메소드로
		//		-연봉은 12월치 월급여액에 한달치 월급여액 * 500%를 더한 값으로 한다.
		//		-기본 생성자에서 필드 salary의 초기 값을 사용하며,
		// 		-정수형 매개변수를 가지는 생성자에서 해당 매개변수를 월급여액으로 저장
		System.out.println(new SalaryMan().getAnnualGross());
		System.out.println(new SalaryMan(2000000).getAnnualGross());
	}

}
