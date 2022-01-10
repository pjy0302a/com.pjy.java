package com.yedam.java.ch03;

public class Account {
	private long balance;
	
	public long getBalance() {
		return balance;
	}
	
	public void deposit(int money) {
		balance += money;
	}
	
	public void withDraw(int money) throws BalanceInsufficientExecption {
		if(balance < money) {
			throw new BalanceInsufficientExecption("잔고부족 : "
					+ (money - balance) + "모자랍니다.");//throw 강제로 예외발생 
		}
		balance -= money;
	}
}
