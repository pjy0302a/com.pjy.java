package com.yedam.java.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLExample_emp13 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 1. JDBC Driver 로딩
		Class.forName("org.sqlite.JDBC");

		// 2. DB서버 접속
		String url = "jdbc:sqlite:/c:/DEV/workspace/YedamDataBase.db";
		Connection conn = DriverManager.getConnection(url);

		/***************** INSERT ******************/
		// 3. PreparedStatement 객체생성
		String insert = "INSERT INTO emp13 VALUES (?,?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(insert);
		pstmt.setInt(1, 300);
		pstmt.setString(2, "Leo");
		pstmt.setString(3, "SA_VIP");
		pstmt.setInt(4, 25000);
		pstmt.setString(6, "IT");
		pstmt.setInt(7, 2300);

		// 4. SQL 실행
		int result = pstmt.executeUpdate();
		// 5. 결과값 출력 OR 연산
		System.out.println("INSERT 결과 : " + result);

		/***************** UPDATE ******************/
		// 3. PreparedStatement 객체생성
		String update = "UPDATE emp13 SET first_name = ?  WHERE employee_id = ?";
		pstmt = conn.prepareStatement(update);
		pstmt.setString(1, "Park");
		pstmt.setInt(2, 300);

		// 4. SQL 실행
		result = pstmt.executeUpdate();

		// 5. 결과값 출력 OR 연산
		System.out.println("UPDATE 결과 : " + result);

		/***************** SELECT ******************/
		// 3. PreparedStatement 객체생성
		String select = "Select * from emp13";
		pstmt = conn.prepareStatement(select);
		// 4. SQL 실행
		ResultSet rs = pstmt.executeQuery();

		// 5. 결과값 출력 OR 연산
		while (rs.next()) {
			String emp13 = " 고유번호 " + rs.getInt("employee_id") 
						+ " 이름 : "+ rs.getString("first_name") 
						+ " ID : " + rs.getString("job_id")
						+ " SALARY : " + rs.getInt("salary");
						
			System.out.println(emp13);
 		}
		/***************** DELETE ******************/
		// 3. PreparedStatement 객체생성
		String delete = "DELETE FROM emp13 WHERE employee_id = ?";
		pstmt = conn.prepareStatement(delete);
		pstmt.setInt(1,300);
		// 4. SQL 실행
		result = pstmt.executeUpdate();
		// 5. 결과값 출력 OR 연산
		System.out.println("DELETE 결과 : " + result);
		
	}

}
