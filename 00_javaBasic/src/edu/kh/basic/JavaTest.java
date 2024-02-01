package edu.kh.basic;

// 한 줄 주석 : 컴파일러(번역기)가 해석하지 않는 부분 코드 진행에 아무런 문제가 없음

/* 범위 주석
 * 
 * 
 * 
 * */
// class : 자바 코드가 작성되는 영역
public class JavaTest { // 자동으로 작성돼있음

	public static void main(String[] args) {
		// main method(메서드) : 자바 애플리케이션(프로그램)을 실행하기 위해 반드시 필요한 메서드
		// method : 하나의 기능 단위 
		
		System.out.println("Hello world!!!");
		System.out.println("점심 뭐 먹지?");
		System.out.println("12345");
		
		System.out.println("-----------------------");
		
		// 숫자 연산
		System.out.println("1+2"); // 문자열 그대로
		System.out.println(1 + 2);
		
		// "" 안에 작성된 코드는 단순 문자열로 인식
		// "" 안에 작성되지 않은 코드는 숫자, 변수로 인식
		
		System.out.println(50 - 23);
		System.out.println(12 * 13);
		System.out.println(327 / 3);
		System.out.println(12 % 2);
		// 산술 연산자 다 똑같이 씀
		
		// ""(문자열) + 숫자 함께 작성
		
		System.out.println("14 * 19 =" + 266); // + 대신 , 쓰면 안됨
		System.out.println("14 * 19 =" + 14 * 19); // 연산 합쳐서 출력
		
		System.out.println("90 + 70 + 65 = " + 90 + 70 + 65);
		// 연산 순서 앞에서부터 적용돼서 문자열 이어쓰기 됨
		System.out.println("90 + 70 + 65 = " + (90 + 70 + 65));
		// 자바는 사칙연산의 우선순위를 그대로 따름
		// -> 우선 계산을 원하면 () 괄호 사용
		
		// + 기호의 역할
		// -> 숫자 + 숫자 = 덧셈 연산 결과
		// -> 문자열 + 숫자 or
		//    문자열 + 문자열 --> 이어쓰기
	}
	
}