package com.yedam.java.account;

public interface AccountDAO {
	//계좌조회
	public Account selectAccountInfo(long accountNo);
	//계좌개설 즉시조회
	public long selectAccountNo(Account account);
	//계좌 개설
	public void createAccount(Account account);
	
	public void updateAccount(Account account);
}
