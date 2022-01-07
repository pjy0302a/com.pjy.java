package com.yedam.java.ch02;

public class Product<T, M> {
	private T kind;
	private M mode;
	
	public void setKind(T kind) {
		this.kind = kind;
	}
	
	public void setModel(M mode) {
		this.mode = mode;
	}
	public T getkind() {
		return kind;
	}
	public M getModel() {
		return mode;
	}
}
