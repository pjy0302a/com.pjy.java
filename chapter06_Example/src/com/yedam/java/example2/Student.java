package com.yedam.java.example2;

public class Student {
	
	private static int serialNum = 1000;
	private int studentId;
	private String studentName;
	private int grade;
	private String adderss;
	
	private int cardNumber; //카드번호
	Student(){
		serialNum++;
		studentId = serialNum;
		
		cardNumber = studentId + 100;
	}
	public static int getSerialNum() {
		return serialNum;
	}
	public static void setSerialNum(int serialNum) {
		Student.serialNum = serialNum;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getAdderss() {
		return adderss;
	}
	public void setAdderss(String adderss) {
		this.adderss = adderss;
	}
	
}
