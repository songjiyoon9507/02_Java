package edu.kh.objarray.practice.model.vo;

public class Employee {
	private int empNo; // 사번
	private String empName; // 이름
	private String dept; // 부서
	private String job; // 직급
	private int salary; // 급여
	
	Employee() {}
	
	public Employee(int empNo, String empName, String dept, String job, int salary) {
		this.empNo = empNo;
		this.empName = empName;
		this.dept = dept;
		this.job = job;
		this.salary = salary;
	}

	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public String information() {
		return "사번 : " + empNo + ", 이름 : " + empName 
				+ ", 부서 : " + dept + ", 직급 : " + job
				+ ", 급여 : " + salary + "\n";
	}
	
	public String maxSalary() {
		return "이름 : " + empName + ", 부서 : " + dept + ", 급여 : " + salary + "\n";
	}
	
}
