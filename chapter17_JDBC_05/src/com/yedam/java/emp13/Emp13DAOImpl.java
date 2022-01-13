package com.yedam.java.emp13;

import java.beans.ParameterDescriptor;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.java.common.DAO;

public class Emp13DAOImpl extends DAO implements Emp13DAO {
	private static Emp13DAOImpl instance = new Emp13DAOImpl();
	private Emp13DAOImpl() {}
	public static Emp13DAOImpl getInstance() {
		return instance;
	}
	
	@Override
	public List<Emp13> selectAll() {
		List<Emp13> list = new ArrayList<Emp13>();
		try {
			connect();
			String select = "SELECT * FROM emp13 ORDER BY employee_id";
			pstmt = conn.prepareStatement(select);
			rs = pstmt.executeQuery();	//명령어를 처리하고 그 결과값을 가져온다.
			while(rs.next()) {
				Emp13 emp = new Emp13();
				emp.setEmployeeid(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setJobId(rs.getString("job_id"));
				emp.setSalary(rs.getInt("salary"));
				emp.setCommissoinPct(rs.getString("commission_pct"));
				emp.setDepartmentName(rs.getString("department_name"));
				emp.setLocationId(rs.getInt("location_id"));
				
				list.add(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	@Override
	public Emp13 selectOne(int employeeid) {
		Emp13 emp = null;
		try {
			connect();
			String select = "SELECT * FROM emp13 where employee_id = ?";
			pstmt = conn.prepareStatement(select);
			pstmt.setInt(1, employeeid);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				emp = new Emp13();
				emp.setEmployeeid(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setJobId(rs.getString("job_id"));
				emp.setSalary(rs.getInt("salary"));
				emp.setCommissoinPct(rs.getString("commission_pct"));
				emp.setDepartmentName(rs.getString("department_name"));
				emp.setLocationId(rs.getInt("location_id"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		return emp;
	}

	@Override
	public void insert(Emp13 emp) {
		try {
			connect();
			String insert = "INSERT INTO emp13 VALUES (?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(insert);
			pstmt.setInt(1, emp.getEmployeeid());
			pstmt.setString(2, emp.getFirstName());
			pstmt.setString(3, emp.getJobId());
			pstmt.setInt(4, emp.getSalary());
			pstmt.setString(5, emp.getCommissoinPct());
			pstmt.setString(6, emp.getDepartmentName());
			pstmt.setInt(7, emp.getLocationId());
			
			int result = pstmt.executeUpdate();
			
			System.out.println(result + "건이 등록되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	@Override
	public void update(Emp13 emp) {
		try {
			connect();
			String update = "UPDATE emp13 SET department_name = ? WHERE employee_id = ?";
			pstmt = conn.prepareStatement(update);
			pstmt.setString(1, emp.getFirstName());
			pstmt.setInt(2, emp.getEmployeeid());
			
			int result = pstmt.executeUpdate();
			
			System.out.println(result + "건이 수정되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	@Override
	public void delete(int employeeid) {
		try {
			connect();
			String delete = "DELETE FROM emp13 WHERE employee_id = ?";
			pstmt = conn.prepareStatement(delete);
			pstmt.setInt(1, employeeid);
			
			int result = pstmt.executeUpdate();
			
			System.out.println(result + "건이 수정되었습니다.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

}
