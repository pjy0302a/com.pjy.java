package com.yedam.java.movie;

public class Login {
	private String loginId;
	private String loginPw;
	private String loginName;
	private String loginAuthority;
	
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getLoginPw() {
		return loginPw;
	}
	public void setLoginPw(String loginPw) {
		this.loginPw = loginPw;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getLoginAuthority() {
		return loginAuthority;
	}
	public void setLoginAuthority(String loginAuthority) {
		this.loginAuthority = loginAuthority;
	}
	@Override
	public String toString() {
		return "Login [loginId=" + loginId + ", loginPw=" + loginPw + ", loginName=" + loginName + ", loginAuthority="
				+ loginAuthority + "]";
	}
	
}
