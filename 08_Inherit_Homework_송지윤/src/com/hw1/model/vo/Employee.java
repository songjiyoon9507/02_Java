package com.hw1.model.vo;

public class Employee extends Person {
	private int salary; // 급여
	private String dept; // 부서
	
	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public Employee() {}

	public Employee(String name, int age, double height, double weight, int salary, String dept) {
		super(age, height, weight);
		// 자식은 직접접근 가능
		// Person 의 protected 필드
		this.name = name;
		// super.name = name;
		this.salary = salary;
		this.dept = dept;
	}
	
	@Override
	public String information() {
		return super.information() + String.format(" / 급여 : %d / 부서 : %s", salary, dept);
	}
}
