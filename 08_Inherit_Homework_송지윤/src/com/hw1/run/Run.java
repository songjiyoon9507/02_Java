package com.hw1.run;

import java.util.Scanner;

import com.hw1.model.vo.Employee;
import com.hw1.model.vo.Student;

public class Run {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Student[] stuArr = new Student[3];
		
		stuArr[0] = new Student("홍길동", 20, 178.2, 70.0, 1, "정보시스템공학과");
		stuArr[1] = new Student("김말똥", 21, 187.3, 80.0, 2, "경영학과");
		stuArr[2] = new Student("강개순", 23, 167.0, 45.0, 4, "정보통신공학과");
		
//		System.out.println(stuArr[0].information());
//		System.out.println(stuArr[1].information());
//		System.out.println(stuArr[2].information());
		
		// 학생 정보 모두 출력
		// 향상된 for 문
		// Student 자료형인 std 변수 : stuArr 배열 접근
		for(Student std : stuArr) {
			System.out.println(std.information());
		}
		
		System.out.println("===========================================================");
		
		Employee[] empArr = new Employee[10];
		
		while(true) {
			boolean flag = true;
			
			for(int i = 0 ; i < empArr.length ; i++) {
				
				System.out.print("이름 : ");
				String name = sc.next();
				sc.nextLine();

				
				System.out.print("나이 : ");
				int age = sc.nextInt();
				sc.nextLine();
				
				System.out.print("키 : ");
				double height = sc.nextDouble();
				sc.nextLine();

				
				System.out.print("몸무게 : ");
				double weight = sc.nextDouble();
				sc.nextLine();

				System.out.print("급여 : ");
				int salary = sc.nextInt();
				sc.nextLine();

				System.out.print("부서 : ");
				String dept = sc.next();
				sc.nextLine();

				System.out.print("계속 추가하시겠습니까? (y/n) : ");
				char answer = sc.next().charAt(0);
				
				empArr[i] = new Employee(name, age, height, weight, salary, dept);
				
				if(answer == 'y' || answer == 'Y') {
					continue;
				} else {
					flag = false;
					break;
				}
				
			}
			
			if(!flag) {
				break;
			}
		}
		
		for (int i = 0; i < empArr.length ; i++) {
			if(empArr[i] != null) {
				System.out.println(empArr[i].information());
			} else {
				break;
			}
		}
	}
}
