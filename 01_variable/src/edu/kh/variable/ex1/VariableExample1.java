package edu.kh.variable.ex1;

public class VariableExample1 { // 클래스 파일명이랑 같아야함 편집하면 에러남
	// 생성된 .java 파일과 class 오른쪽에 작성된 이름은 같아야 한다.
	
	// main method 찾아감 반드시 필요함 JRE 실행할 때 처음으로 찾아가는 곳
	public static void main(String[] args) {
		
		System.out.println(2 * 3.141592653589793 * 5);
		System.out.println(3.141592653589793 * 5 * 5);
		System.out.println(3.141592653589793 * 5 * 5 * 20);
		System.out.println(4 * 3.141592653589793 * 5 * 5);
		
		/* 변수 (Variable)
		 * - 메모리(RAM)에 값을 기록하는 공간
		 * -> 공간에 기록되는 값(Data)이 변할 수 있어서 변수라고 한다.
		 * 
		 * -변수는 여러 종류 존재 (저장되는 값의 형태, 크기가 다름)
		 * 
		 * 변수 사용의 장점
		 * 1. 가독성 증가
		 * 2. 재사용성 증가(한번만든 변수를 계속 사용)
		 * 3. 코드 길이의 감소
		 * 4. 유지보수성 증가(코드 수정이 간단해짐)
		 * 
		 * */
		
		// 변수 사용
		double pi = 3.141592653589793; // 원주율
		int r = 5; // 반지름(radius)
		int h = 20; // 높이(heigjt)
		
		System.out.println("---------------------");
		
		System.out.println(2 * pi * r); // 원의 둘레
		System.out.println(pi * r * r); // 원의 넓이
		System.out.println(pi * r * r * h); // 원기둥의 부피
		System.out.println(4 * pi * r * r); // 구의 겉넓이
	}
	
}
