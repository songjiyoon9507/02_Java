package com.hw1.run;

import java.util.Scanner;

import com.hw1.model.vo.Employee;

public class EmpRun {
	public static void main(String[] args) {
		
		Employee[] emps = new Employee[10];
		
		Scanner sc = new Scanner(System.in);
		
		int count = 0;
		
		while(true) {
			
			System.out.print("이름 : ");
			String name = sc.next();
			
			System.out.print("나이 : ");
			int age = sc.nextInt();
			
			System.out.print("신장 : ");
			double height = sc.nextDouble();

			System.out.print("몸무게 : ");
			double weight = sc.nextDouble();
			
			System.out.print("급여 : ");
			int salary = sc.nextInt();
			
			System.out.print("부서 : ");
			String dept = sc.next();
			
			emps[count] = new Employee(name, age, height, weight, salary, dept);
			count++;
			
			System.out.print("계속 추가하시겠습니까? (y/n) : ");
			String str = sc.next().toUpperCase();
			
			if(str.equals("N")) break;
			
		}
		
		for(Employee emp : emps) {
			
			if(emp == null) break; // NullPointerException 방지
			
			System.out.println(emp.information());
		}
		
	}
}
