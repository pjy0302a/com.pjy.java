package com.yedam.java.app.dept;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO {
	
	//각 메서드에서 공통적으로 사용하는 필드
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
	//DB 연결정보
	private String jdbc_driver = "org.sqlite.JDBC";
	private String jdbc_url = "jdbc:sqlite:/c:/DEV/workspace/YedamDataBase.db";
	
	//싱글톤
	private static DepartmentDAO instance = new DepartmentDAO();
	private DepartmentDAO() {}
	public static DepartmentDAO getInstance() {
		return instance;
	}
	
	//메서드
	
	//JDBC Driver 로딩
	//DB 연결
	// -> connect() 메소드
	public void connect() {
		try {
			Class.forName(jdbc_driver);	//JDBC Driver 로딩
			
			conn = DriverManager.getConnection(jdbc_url);	//DB연결
			
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC Driver 로딩 실패");
		} catch (SQLException e) {
			System.out.println("DB 연결 실패");
		}
		
	}
	//자원 해제 -> disconnect() 메서드
	public void disconnect() {
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			System.out.println("자원이 정상적으로 해제되지 못 했습니다.");
		}
	}
	
	//PreparedStatement 객체 생성
	//SQL 실행
	//결과값 출력 or 연산
	// -> CRUD 메서드
	
	//전체조회
	public List<Department> selectAll(){
		List<Department> list = new ArrayList<Department>();
		try {
			connect();
			String select = "SELECT * FROM departments ORDER BY department_id";
			pstmt = conn.prepareStatement(select);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Department dept = new Department();
				dept.setDepartment_Id(rs.getInt("department_id"));
				dept.setDepartment_Name(rs.getString("department_name"));
				dept.setManager_Id(rs.getString("manager_id"));
				dept.setLocation_Id(rs.getInt("location_id"));
				
				list.add(dept);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		return list;
		
	}
	
	//단건조회
	public Department selectOne(int departmentId) {
		Department dept = null;	//데이터가없을경우 null값 반환하기위함
		try {
			connect();
			String select = "SELECT * FROM departments WHERE department_id = ?";
			pstmt = conn.prepareStatement(select);
			pstmt.setInt(1, departmentId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dept = new Department();
				dept.setDepartment_Id(rs.getInt("department_Id"));
				dept.setDepartment_Name(rs.getString("department_name"));
				dept.setManager_Id(rs.getString("manager_id"));
				dept.setLocation_Id(rs.getInt("location_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return dept;
	}
	//등록
	public void insert(Department dept) {
		try {
			connect();
			String insert = "INSERT INTO departments VALUES(?,?,?,?)";
			pstmt = conn.prepareStatement(insert);
			pstmt.setInt(1, dept.getDepartment_Id());
			pstmt.setString(2, dept.getDepartment_Name());
			pstmt.setString(3, dept.getManager_Id());
			pstmt.setInt(4, dept.getLocation_Id());
			
			int result = pstmt.executeUpdate();
			
			System.out.println(result + "건이 등록되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	//수정
	public void update(Department dept) {
		try {
			connect();
			String update = "UPDATE departments SET department_name = ? Where department_id= ? ";
			pstmt = conn.prepareStatement(update);
			pstmt.setString(1, dept.getDepartment_Name());
			pstmt.setInt(2, dept.getDepartment_Id());
			
			int result = pstmt.executeUpdate();
			
			System.out.println(result + "건이 수정되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	//삭제
	public void delete(int departmentId) {
		try {
			connect();
			String delete = "DELETE FROM departements WHERE department_id = ?";
			pstmt = conn.prepareStatement(delete);
			pstmt.setInt(1, departmentId);
			
			int result = pstmt.executeUpdate();
			
			System.out.println(result + "건이 삭제되었습니다.");
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
}
