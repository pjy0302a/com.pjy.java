package com.yedam.java.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
	//DB 연결정보
	private String jdbc_driver = "org.sqlite.JDBC";
	private String jdbc_url = "jdbc:sqlite:/c:/DEV/workspace/YedamDataBase.db";
	
	//각 메서드에서 공통으로 사용하는 필드
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//connect() 메서드
	public void connect() {
		//JDBC Driver 로딩
		try {
			Class.forName(jdbc_driver);
			
			//DB 연결
			conn = DriverManager.getConnection(jdbc_url);
		}catch (SQLException e) {
			System.out.println("DB 연결 실패");
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC Driver 로딩 실패");
			
		}
	}
	
}
