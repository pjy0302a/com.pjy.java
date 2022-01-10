package com.yedam.java.ch03;

public class Example {

	public static void main(String[] args) {
		Account account = new Account();
		
		account.deposit(10000);
		System.out.println("예금액 : " + account.getBalance());
		
		try {
			account.withDraw(30000);
		} catch (BalanceInsufficientExecption e) {
			String message = e.getMessage();
			System.out.println(message);
			System.out.println();
			e.printStackTrace();
		}
	}

}
