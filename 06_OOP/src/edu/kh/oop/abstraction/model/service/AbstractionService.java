package edu.kh.oop.abstraction.model.service;

import edu.kh.oop.abstraction.model.vo.People;
// ctrl + shift + o : 해당 클래스에서 임포트 안된 거 전부 임포트하기

// Service : 특정 기능(비지니스 로직)을 제공하는 클래스
public class AbstractionService {
	
	public void ex1() { // method 생성 vo에 기능 이용할 것임
		// 국민 객체 만들기
		// 설계도를 통해서 만들어진 게 객체
		
		People p1 = new People();
		// People p1 : People 객체의 주소를 저장하여 참조하는 변수 p1
		// new People(); : 새로운 People 객체를 Heap 영역에 생성
		// 변수명에 대입해줌
		// People 자료형 자리 (사용자 정의 자료형)
		// int num = 10;
		
		
		// ** 클래스 이름이 자료형처럼 사용된다
		// == 그래서 클래스를 "사용자 정의 자료형"이라고도 한다!! **
		
		// setter가 할 일
//		p1.name = "홍길동";
//		p1.gender ='남';
//		p1.pNo = "240207-3456789";
//		p1.address = "서울시 중구 남대문로 120 그레이츠청계 3층 E강의장";
//		p1.phone = "010-1234-1234";
//		p1.age = 0;
		// getter가 할 일
//		System.out.println("p1의 name : " + p1.name);
//		System.out.println("p1의 gender : " + p1.gender);
//		System.out.println("p1의 pNo : " + p1.pNo);
//		System.out.println("p1의 address : " + p1.address);
//		System.out.println("p1의 phone : " + p1.phone);
//		System.out.println("p1의 age : " + p1.age);
		
		// 간접접근하는 방법
		
		p1.setName("홍길동"); // setName 호출하면서 "홍길동" 전달
		p1.setGender('남');
		p1.setpNo("240207-3456789");
		p1.setAddress("서울시 중구 남대문로 120 그레이츠청계 3층 E강의장");
		p1.setPhone("010-1234-1234");
		p1.setAge(0);
		
		System.out.println("p1의 name : " + p1.getName());
		System.out.println("p1의 gender : " + p1.getGender());
		System.out.println("p1의 pNo : " + p1.getpNo());
		System.out.println("p1의 address : " + p1.getAddress());
		System.out.println("p1의 phone : " + p1.getPhone());
		System.out.println("p1의 age : " + p1.getAge());
		p1.tax();
		p1.vote();
		System.out.println("====================================");
		
		// 본인 객체
		People p2 = new People();
		p2.setName("송지윤");
		p2.setGender('여');
		p2.setpNo("950719-2******");
		p2.setAddress("서울특별시 영등포구 도신로 4길 14, 현대1차APT 102동 601호");
		p2.setPhone("010-2066-6592");
		p2.setAge(28);
		
		System.out.println("p2의 name : " + p2.getName());
		System.out.println("p2의 gender : " + p2.getGender());
		System.out.println("p2의 pNo : " + p2.getpNo());
		System.out.println("p2의 address : " + p2.getAddress());
		System.out.println("p2의 phone : " + p2.getPhone());
		System.out.println("p2의 age : " + p2.getAge());
		p2.tax();
		p2.vote();
		
		
	}
}
