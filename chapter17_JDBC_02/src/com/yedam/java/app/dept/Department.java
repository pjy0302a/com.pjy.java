package com.yedam.java.app.dept;

public class Department {
	private int department_Id;
	private String department_Name;
	private String manager_Id;
	private int location_Id;
	public int getDepartment_Id() {
		return department_Id;
	}
	public void setDepartment_Id(int department_Id) {
		this.department_Id = department_Id;
	}
	public String getDepartment_Name() {
		return department_Name;
	}
	public void setDepartment_Name(String department_Name) {
		this.department_Name = department_Name;
	}
	public String getManager_Id() {
		return manager_Id;
	}
	public void setManager_Id(String manager_Id) {
		this.manager_Id = manager_Id;
	}
	public int getLocation_Id() {
		return location_Id;
	}
	public void setLocation_Id(int location_Id) {
		this.location_Id = location_Id;
	}
	@Override
	public String toString() {
		return "Department [department_Id=" + department_Id + ", department_Name=" + department_Name + ", manager_Id="
				+ manager_Id + ", location_Id=" + location_Id + "]";
	}
	
	
}
