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
		//  employeeCount를 길이로 하면 시작이 0이라서 출력 안나옴
		for (int i = 0 ; i < employees.length ; i++) {
			if (employees[i] == null) {
				employees[i] = (Employee)person;
				employeeCount++;
				// getInfo는 print 안됨 print 안에 넣어줘야함
				System.out.println("직원이 추가되었습니다 - " + employees[i].getInfo());
				break;
			}
		}
		if(employeeCount == employees.length) {   
			System.out.println("인원이 모두 충원되었습니다.");
		}
	}

	@Override
	public void removePerson(String id) {
		for(int i = 0 ; i < employeeCount ; i++) {
			
			if(employees[i].getId().equals(id)) {
				System.out.println("직원이 삭제되었습니다 - " + employees[i].getInfo());
				employees[i] = null;
				
				for(int j = i ; j < employeeCount ; j++) {
					if(j == employees.length - 1) break;
					employees[j] = employees[j+1];
					
					if(employees[j] == null) {
						break;
					}
				}
				employeeCount--;
			}
		}
	}

	@Override
	public void displayAllPerson() {
		// 전체 명단
		System.out.println("전체 직원 명단 : ");
		for (int i = 0 ; i < employeeCount ; i++) {
			System.out.println(employees[i].getInfo());
		}
	}
}
