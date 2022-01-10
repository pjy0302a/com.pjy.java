package com.yedam.java.ch03;

public class BalanceInsufficientExecption extends Exception{
	public BalanceInsufficientExecption() {}
	public BalanceInsufficientExecption(String message){
		super(message);
	}
}
