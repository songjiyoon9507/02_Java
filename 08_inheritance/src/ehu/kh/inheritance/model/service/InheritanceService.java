package ehu.kh.inheritance.model.service;

import ehu.kh.inheritance.model.dto.Employee;
import ehu.kh.inheritance.model.dto.Person;
import ehu.kh.inheritance.model.dto.Student;

// 비지니스 로직 처리하는 클래스
public class InheritanceService {
	
	// 상속 확인 예제
	public void ex1() {
		
		Person p = new Person();
		
		p.setName("홍길동");
		p.setAge(25);
		p.setNationality("대한민국");
		
		System.out.println(p.getName());
		System.out.println(p.getAge());
		System.out.println(p.getNationality());
	
		System.out.println("=========================================");
		
		// Person을 상속받은 Student가 Person의 필드, 메소드를
		// 정말 사용할 수 있는가?
		
		// Student 객체 생성
		Student std = new Student();
		
		// Student만의 고유한 필드
		std.setGrade(3);
		std.setClassRoom(5);
		
		// Person 클래스로부터 상속받은 필드, 메서드
		std.setName("고길동");
		std.setAge(19);
		std.setNationality("대한민국");
		
		System.out.println(std.getGrade());
		System.out.println(std.getClassRoom());
		System.out.println(std.getName());
		System.out.println(std.getAge());
		System.out.println(std.getNationality());
		
		System.out.println("=========================================");
		
		Employee emp = new Employee();
		
		// Employee 만의 고유 메서드
		emp.setCompany("KH정보교육원");
	
		// Person 클래스로부터 상속받은 메서드
		emp.setName("조미현");
		emp.setAge(20);
		emp.setNationality("대한민국");
	
		System.out.println(emp.getCompany());
		System.out.println(emp.getName());
		System.out.println(emp.getAge());
		System.out.println(emp.getNationality());
		
		p.breath();
		p.move();
		std.breath();
		std.move();
		emp.breath();
		emp.move();
		
		// 상속의 특징 : 코드 추가 및 수정에 용이함
		//				 코드 길이 감소 및 중복 제거 효과
	}
	
	// super() 생성자 이용방법
	public void ex2() {
		
		// Student 매개변수 5개짜리 생성자
		Student std = new Student("김철수", 17, "한국", 1, 3);
		
		System.out.println(std.getName());
		System.out.println(std.getAge());
		System.out.println(std.getNationality());
		System.out.println(std.getGrade());
		System.out.println(std.getClassRoom());
		
	}
	
	// 오버라이딩 확인 예제
	public void ex3() {
		
		Student std = new Student();
		Employee emp = new Employee();
		
		// 오버라이딩 X -> Person 의 메소드
		std.move();
		
		// 오버라이딩 O -> Employee 의 메소드
		emp.move();
	}
	
	// toString() 오버라이딩 확인 예제
	public void ex4() {
		
		Person p = new Person("김철수", 17, "한국");
		System.out.println(p.toString());
		System.out.println(p);
		// print 구문 수행 시 참조변수명을 작성하면
		// 자동으로 toString() 메소드를 호출해서 출력해준다
		
		// Person 에 toString() 없으면 원래는 주소값 출력됨
		
		System.out.println("=========================================");
		
		Student std = new Student("이백점", 18, "미국", 2, 6);
		System.out.println(std.toString());
		
		System.out.println("=========================================");
		
		Employee emp = new Employee("김노동", 30, "한국", "삼성전자");
		// System.out.println(emp.toString());
		System.out.println(emp);
	}
}
