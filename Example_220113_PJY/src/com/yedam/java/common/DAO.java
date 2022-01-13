package com.yedam.java.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
	//DB연결정보
	private String jdbc_driver = "org.sqlite.JDBC";
	private String jdbc_url = "jdbc:sqlite:/C:/DEV/Workspace/BookDataBase.db";
	
	//각 메서드에서 공통으로 사용하는 필드
	protected Connection conn = null;
	protected PreparedStatement pstmt = null;
	protected ResultSet rs = null;
	
	//connect() 메서드
	public void connect() {
		try {
			//JDBC Driver 로딩
			Class.forName(jdbc_driver);
			//DB 서버 연결
			conn = DriverManager.getConnection(jdbc_url);
		}catch (SQLException e) {
			System.out.println("DB 접속 실패");
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC Driver 로딩 실패");
		}
	}
	public void disconnect() {
		try {
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(conn != null) conn.close();
		}catch (SQLException e) {
			System.out.println("자원 해제 실패");
		}
	}
	
}
