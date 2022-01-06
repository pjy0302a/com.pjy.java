package com.yedam.java.Quiz3;

public class MainExample {

	public static void main(String[] args) {
		//문제3)다음을 만족하는 클래스 StudentScores를 작성하시오.
		//		-필드로 학생이름(String), 학급(int),
		//		 국어점수(int), 영어점수(int), 수학점수(int)를 가진다.
		//		-기본생성자는 없으며,
		//		-생성자를 통해 학생이름과 학급을 저장한다.
		//		-매소드는 다음과 같이 구성된다.
		//		1) 각 필드별 getter와 setter
		//		2) 매소드 getTotal()은 모든 과목의 점수를 더한 총합을 반환한다.
		//		3) 매소드 getAverage()은 모든 과목의 점수의 평균을 반환한다.
		
		StudentScores studentHong = new StudentScores("홍길동",1);
		studentHong.setKorean(100);
		studentHong.setEnglish(60);
		studentHong.setMath(76);
		
		System.out.println("학생 "+ studentHong.getName()
				+ "의 총 점수는 " + studentHong.getTotal()
				+ "이고, 평균은 " + studentHong.getAverage() + "입니다.");
	}

}
