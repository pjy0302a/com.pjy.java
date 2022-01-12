package com.yedam.java.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.yedam.java.emp13.Emp13;
import com.yedam.java.emp13.Emp13DAO;
import com.yedam.java.emp13.Emp13DAOImpl;

public class Emp13Frame {
	private Emp13DAO empDAO = Emp13DAOImpl.getInstance();
	private Scanner scanner = new Scanner(System.in);
	
	public Emp13Frame() {
		boolean run = true;
		while(run) {
		//메뉴출력
		menuPrint();
		int menuNo = Integer.parseInt(scanner.nextLine());
		
		//각메뉴별 기능실행
		if(menuNo == 1) {
			//등록
			insertEmp13();
		}else if(menuNo ==2) {
			//수정
			updateEmp13();
		}else if(menuNo ==3) {
			//삭제 
			deleteEmp13();
		}else if(menuNo ==4) {
			//단건조회
			selectOne();
		}else if(menuNo ==5) {
			//전체조회
			selectAll();
		}else if(menuNo ==9) {
			//종료
			end();
			break;
		}
		}
	}


	public void menuPrint() {
		System.out.println();
		System.out.println("=== 1.등록 2.수정 3.삭제 4.단건조회 5.전체조회 9.종료 ===");
		System.out.println("선택>");
	}
	private void insertEmp13() {
		//부서정보 입력
		Emp13 emp = inputEmpInfo();
		//부서정보 등록
		empDAO.insert(emp);
	}


	private void updateEmp13() {
		//부서정보 입력
		Emp13 emp = inputEmpName();
		//부서정보 수정
		empDAO.update(emp);
	}
	private void deleteEmp13() {
		int Empid  = inputEmpId();
		
		empDAO.delete(Empid);
	}
	private void selectOne() {
		int employeeid  = inputEmpId();
		
		Emp13 emp = empDAO.selectOne(employeeid);
		
		if(emp == null) {
			System.out.println("해당 부서 정보가 존재하지 않습니다.");
		}else {
			System.out.println(emp);
		}
	}
	private void selectAll() {
		List<Emp13> list = empDAO.selectAll();
		
		for(Emp13 emp : list) {
			System.out.println(emp);
		}
	}
	private void end() {
		System.out.println("종료되었습니다");
	}
	
	public Emp13 inputEmpInfo() {
		
		Emp13 emp = new Emp13(); 
		
		System.out.println("부서번호>");
		emp.setEmployeeid(Integer.parseInt(scanner.nextLine()));
		
		System.out.println("이름>");
		emp.setFirstName(scanner.nextLine());
		
		System.out.println("직업>");
		emp.setJobId(scanner.nextLine());
		
		System.out.println("연봉>");
		emp.setSalary(Integer.parseInt(scanner.nextLine()));
		
		System.out.println("인센티브>");
		emp.setCommissoinPct(scanner.nextLine());
		
		System.out.println("부서이름>");
		emp.setDepartmentName(scanner.nextLine());
		
		System.out.println("지역번호>");
		emp.setLocationId(Integer.parseInt(scanner.nextLine()));
		return emp;
	}
	public Emp13 inputEmpName() {
		Emp13 emp = new Emp13();
		System.out.print("부서번호>");
		emp.setEmployeeid(Integer.parseInt(scanner.nextLine()));
		System.out.print("부서이름>");
		emp.setDepartmentName(scanner.nextLine());
		return emp;
	}
	public int inputEmpId() {
		int employeeid = 0;
		System.out.println("부서번호>");
		employeeid = Integer.parseInt(scanner.nextLine());
		return employeeid;
	}
}
