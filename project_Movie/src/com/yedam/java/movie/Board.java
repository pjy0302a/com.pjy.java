package com.yedam.java.movie;

public class Board {
	private  int SerialNum;
	private String title;
	private String contents;
	private String loginId;
	private String loginAuthority;
	private String date;
//	private static int count = 0;
//	public Board(){
//		
////		count++;
////		SerialNum = count;
//	}
	public int getSerialNum() {
		return SerialNum;
	}
	public void setSerialNum(int serialNum) {
		SerialNum = serialNum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getLoginAuthority() {
		return loginAuthority;
	}
	public void setLoginAuthority(String loginAuthority) {
		this.loginAuthority = loginAuthority;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "no : " + SerialNum + " 제목 : " + title + " 내용 : " + contents + " 작성자 :" + loginId
				 + " 게시일 : " + date + "";
		//+ ", loginAuthority=" + loginAuthority
	}
	
}
