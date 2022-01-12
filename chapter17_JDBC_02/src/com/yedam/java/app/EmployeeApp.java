package com.yedam.java.app;

import java.util.List;
import java.util.Scanner;

import com.yedam.app.employee.Employee;

public class EmployeeApp {

	public static void main(String[] args) {
		boolean run = true;
		Scanner scan = new Scanner(System.in);
		EmployeeDAO dao = EmployeeDAO.getInstance();

		Employee emp = null;
		int employeeId = 0;

		while (run) {
			System.out.println();
			System.out.println("=== 1.등록 2.수정 3.삭제 4.사원조회 5.전체조회 9.종료");
			System.out.print("선택>");
			int menuNo = scan.nextInt();

			switch (menuNo) {
			case 1:
				emp = new Employee();
				System.out.print("사번>");
				emp.setEmployeeId(scan.nextInt());
				System.out.print("이름>");
				emp.setFirstName(scan.next());
				System.out.print("성>");
				emp.setLastName(scan.next());
				System.out.print("이메일>");
				emp.setEmail(scan.next());
				System.out.print("전화번호>");
				emp.setPhoneNumber(scan.next());
				System.out.print("입사일>");
				emp.setHireDate(scan.next());
				System.out.print("직급>");
				emp.setJobId(scan.next());
				System.out.print("연봉>");
				emp.setSalary(scan.nextInt());
				System.out.print("상여>");
				emp.setCommissionPct(scan.next());
				System.out.print("상사>");
				emp.setMenagerId(scan.next());
				System.out.print("부서>");
				emp.setDepartmentId(scan.next());
				
				dao.insert(emp);
				
				break;
			case 2:
				emp = new Employee();
				System.out.print("사번>");
				emp.setEmployeeId(scan.nextInt());
				System.out.print("연봉>");
				emp.setSalary(scan.nextInt());
				
				dao.update(emp);
				break;

			case 3:
				System.out.print("사번>");
				employeeId = scan.nextInt();
				dao.delete(employeeId);
				
				break;

			case 4:
				System.out.print("사번>");
				employeeId = scan.nextInt();
				emp = dao.selectOne(employeeId);
				System.out.println(emp);
				break;

			case 5:
				List<Employee> list = dao.selectAll();
				for(Employee employee : list) {
					System.out.println(employee);
				}
				break;
				
			case 9:
				run = false;
				System.out.println("프로그램 종료");
				break;
				
			default:
				break;
			}
		}
	}

}
