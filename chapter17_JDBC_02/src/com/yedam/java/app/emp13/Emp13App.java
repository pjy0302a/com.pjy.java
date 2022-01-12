package com.yedam.java.app.emp13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.yedam.java.app.dept.Department;

public class Emp13App {

	public static void main(String[] args) {
		boolean run = true;
		Scanner scan = new Scanner(System.in);
		Emp13DAO dao = Emp13DAO.getInstance();

		Emp13 emp = null;
		int employeeId = 0;

		while (run) {
			System.out.println();
			System.out.println("=== 1.등록 2.수정 3.삭제 4.부서조회 5.전체조회 9.종료 ===");
			System.out.println("선택>");
			int menuNo = Integer.parseInt(scan.nextLine());

			switch (menuNo) {
			case 1:
				emp = new Emp13();
				System.out.print("부서번호> ");
				emp.setEmployeeId(Integer.parseInt(scan.nextLine()));
				System.out.print("이름> ");
				emp.setFirstName(scan.nextLine());
				System.out.print("소속부서>");
				emp.setJobId(scan.nextLine());
				System.out.print("연봉> ");
				emp.setSalary(Integer.parseInt(scan.nextLine()));
				System.out.print("연봉인상률> ");
				emp.setCommissoin_Pct(scan.nextLine());
				System.out.print("부서이름>");
				emp.setDepartment_Name(scan.nextLine());
				System.out.print("위치이름");
				emp.setLocation_Id(Integer.parseInt(scan.nextLine()));
				dao.insert(emp);
				break;
			case 2:
				emp = new Emp13();
				System.out.print("부서번호>");
				emp.setEmployeeId(Integer.parseInt(scan.nextLine()));
				System.out.println("부서이름>");
				emp.setFirstName(scan.nextLine());
				
				dao.update(emp);
				break;
			case 3:
				System.out.println("부서번호>");
				employeeId = Integer.parseInt(scan.nextLine());
				dao.delete(employeeId);
				break;
			case 4:
				System.out.println("부서번호>");
				employeeId = Integer.parseInt(scan.nextLine());
				emp = dao.selectOne(employeeId);
				System.out.println(emp);
				break;
			case 5:
				List<Emp13> list = dao.selectAll();
				for(Emp13 emp13 : list) {
					System.out.println(emp13);
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
