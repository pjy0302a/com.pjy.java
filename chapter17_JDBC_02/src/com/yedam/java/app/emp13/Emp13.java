package com.yedam.java.app.emp13;

public class Emp13 {
	private int employeeId;
	private String firstName;
	private String jobId;
	private int salary;
	private String commissoin_Pct;
	private String department_Name;
	private int location_Id;
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getCommissoin_Pct() {
		return commissoin_Pct;
	}
	public void setCommissoin_Pct(String commissoin_Pct) {
		this.commissoin_Pct = commissoin_Pct;
	}
	public String getDepartment_Name() {
		return department_Name;
	}
	public void setDepartment_Name(String department_Name) {
		this.department_Name = department_Name;
	}
	public int getLocation_Id() {
		return location_Id;
	}
	public void setLocation_Id(int location_Id) {
		this.location_Id = location_Id;
	}
	@Override
	public String toString() {
		return "Emp13 [employeeId=" + employeeId + ", firstName=" + firstName + ", jobId=" + jobId + ", salary="
				+ salary + ", commissoin_Pct=" + commissoin_Pct + ", department_Name=" + department_Name
				+ ", location_Id=" + location_Id + "]";
	}
	
	
}
