package com.yedam.java.test04;

public class ToDo {
	private static int serial;
	
	private String toDo;
	private String can;
	private int num;
	private boolean tf;
	
	public ToDo(String toDo, String can) {
		this.toDo = toDo;
		this.can = can;
		this.tf = false; // 할일 미완료
		serial++;
		num = serial;
	}

	public String getCan() {
		return can;
	}

	public void setCan(String can) {
		this.can = can;
	}

	public static int getSerial() {
		return serial;
	}

	public static void setSerial(int serial) {
		ToDo.serial = serial;
	}

	public String getToDo() {
		return toDo;
	}

	public void setToDo(String toDo) {
		this.toDo = toDo;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public boolean isTf() {
		return tf;
	}

	public void setTf(boolean tf) {
		this.tf = tf;
	}
}
