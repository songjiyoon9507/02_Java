package com.hw2.model.service;

import com.hw2.model.dto.Employee;
import com.hw2.model.dto.Person;

public class Company implements ManagementSystem {
	
	private Employee[] employees; // 전체 직원 저장용 배열
	private int employeeCount; // 직원수
	
	public Employee[] getEmployees() {
		return employees;
	}

	public void setEmployees(Employee[] employees) {
		this.employees = employees;
	}

	public int getEmployeeCount() {
		return employeeCount;
	}

	public void setEmployeeCount(int employeeCount) {
		this.employeeCount = employeeCount;
	}
	
	public Company(int size) {
		employees = new Employee[size];
		employeeCount = 0;
	}

	@Override
	public void addPerson(Person person) {
		
		for (int i = 0 ; i < employeeCount; i++) {
			if (employees[i] == null) {
				employees[i] = (Employee)person;
				employeeCount++;
				System.out.print("직원이 추가되었습니다 - ");
				employees[i].getInfo();
				break;
			}
		}
		
	}

	@Override
	public void removePerson(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayAllPerson() {
		// TODO Auto-generated method stub
		
	}
	
}
