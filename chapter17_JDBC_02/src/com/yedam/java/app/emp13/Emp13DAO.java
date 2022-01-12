package com.yedam.java.app.emp13;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Emp13DAO {
	// 각메서드에서 사용하는 필드
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	// DB연결정보
	private String jdbc_driver = "org.sqlite.JDBC";
	private String jdbc_url = "jdbc:sqlite:/c:/DEV/workspace/YedamDataBase.db";
	// 싱글톤
	private static Emp13DAO instance = new Emp13DAO();

	private Emp13DAO() {
	}

	public static Emp13DAO getInstance() {
		return instance;
	}

	public void connection() {
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(jdbc_url);
		} catch (ClassNotFoundException e) {
			System.out.println("jdbc_driver 로딩 실패");
		} catch (SQLException e) {
			System.out.println("연결완료");
		}
	}

	public void disconnect() {

		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			System.out.println("자원해제 완료");
		}

	}
	//전체조회
	public List<Emp13> selectAll(){
		List<Emp13> list = new ArrayList<Emp13>();
		try {
			connection();
			String select = "SELECT * FROM emp13 ORDER BY employee_id";
			pstmt = conn.prepareStatement(select);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Emp13 emp  = new Emp13();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setJobId(rs.getString("job_id"));
				emp.setSalary(rs.getInt("salary"));
				emp.setCommissoin_Pct(rs.getString("commission_pct"));
				emp.setDepartment_Name(rs.getString("department_name"));
				emp.setLocation_Id(rs.getInt("location_id"));
				
				list.add(emp);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	public Emp13 selectOne(int employeeid) {
		Emp13 emp = null;
		try {
			connection();
			String select = "SELECT * FROM emp13 WHERE employee_id = ?";
			pstmt = conn.prepareStatement(select);
			pstmt.setInt(1, employeeid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				emp = new Emp13();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setJobId(rs.getString("job_id"));
				emp.setSalary(rs.getInt("salary"));
				emp.setCommissoin_Pct(rs.getString("commission_pct"));
				emp.setDepartment_Name(rs.getString("department_name"));
				emp.setLocation_Id(rs.getInt("location_id"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			disconnect();
		}
		return emp;
	}
	public void insert(Emp13 emp) {
		try {
			connection();
			String insert = "INSERT INTO emp13 VALUES(?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(insert);
			pstmt.setInt(1, emp.getEmployeeId());
			pstmt.setString(2, emp.getFirstName());
			pstmt.setString(3, emp.getJobId());
			pstmt.setInt(4, emp.getSalary());
			pstmt.setString(5, emp.getCommissoin_Pct());
			pstmt.setString(6, emp.getDepartment_Name());
			pstmt.setInt(7, emp.getLocation_Id());
			
			int result = pstmt.executeUpdate();
			System.out.println(result + "건이 입력되었습니다. ");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	public void update(Emp13 emp) {
		try {
			connection();
			String update = "UPDATE emp13 SET First_Name = ? WHERE employee_Id= ? ";
			pstmt = conn.prepareStatement(update);
			pstmt.setString(1, emp.getFirstName());
			pstmt.setInt(2, emp.getEmployeeId());
			
			int result = pstmt.executeUpdate();

			
			System.out.println(result + "건이 수정되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	public void delete(int employeeId) {
		try {
			connection();
			String delete = "DELETE FROM emp13 WHERE employee_Id = ?";
			pstmt = conn.prepareStatement(delete);
			pstmt.setInt(1, employeeId);
			
			int result = pstmt.executeUpdate();
			
			System.out.println(result + "건이 삭제되었습니다.");
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
}
