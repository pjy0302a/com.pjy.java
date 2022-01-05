package com.yedam.java.example2;

public class StudentExample {

	public static void main(String[] args) {
		Student studentLee = new Student();
		studentLee.setStudentName("이지원");
		System.out.println(studentLee.getStudentId());
		System.out.println(studentLee.getStudentName()+"의 학번 : "+studentLee.getStudentId());
	}

}
