package com.yedam.java.emp13;

public class Emp13 {
	private int employeeid;
	private String firstName;
	private String jobId;
	private int salary;
	private String commissoinPct;
	private String departmentName;
	private int locationId;
	public int getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
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
	public String getCommissoinPct() {
		return commissoinPct;
	}
	public void setCommissoinPct(String commissoinPct) {
		this.commissoinPct = commissoinPct;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	@Override
	public String toString() {
		return "Emp13 [employeeid=" + employeeid + ", firstName=" + firstName + ", jobId=" + jobId + ", salary="
				+ salary + ", commissoinPct=" + commissoinPct + ", departmentName=" + departmentName + ", locationId="
				+ locationId + "]";
	}
	
	
}
