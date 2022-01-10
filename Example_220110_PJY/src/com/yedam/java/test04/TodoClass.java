package com.yedam.java.test04;

import java.util.ArrayList;
import java.util.List;


public class TodoClass {
	List<ToDo> list;
	
	public TodoClass(){
		list = new ArrayList<ToDo>();
	}
	
	public void addtoDo(String toDo, String can) {
		list.add(new ToDo(toDo, can));
	}
	public void allprint() {
		for (ToDo work : list) {
			
			System.out.println(work.getNum() + ") " + work.getToDo() + " " + work.getCan() + " "
					+ (work.isTf() ? "완료" : "미완료"));
		
	}
	}
	public void selectprint() {
		for (ToDo work : list) {
			if (work.isTf() == false) {
				System.out.println(work.getNum() + ") " + work.getToDo() + " " + work.getCan() + " "
						+ (work.isTf() ? "완료" : "미완료"));

			}
			
			
		}
		
	}
	public void complete(int name) {
		
 		for (ToDo work : list) {
			if (name == work.getNum()) {
				if (work.isTf() == false) {
					System.out.println("해당 할 일을 완료처리하였습니다.");
					work.setTf(true);
				}
				else {
					System.out.println("해당 할 일은 이미 완료되었습니다.");
				}
			}
		}
	}
}
