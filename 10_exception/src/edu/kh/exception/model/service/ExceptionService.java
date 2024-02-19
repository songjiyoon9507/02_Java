package edu.kh.exception.model.service;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionService {
	
	// 예외(Exception) : 소스 코드의 수정으로 해결 가능한 오류
	
	// 예외는 두 종류로 구분됨
	// 1) Unchecked Exception : 선택적으로 예외 처리 (ex. Runtime Exception...)
	// 2) Checked Exception : 필수적으로 예외 처리 (ex. IOException, 나머지...)
	
	private Scanner sc = new Scanner(System.in);
	
	public void ex1() {
		
		System.out.println("두 정수를 입력받아 나누기한 몫을 출력");
		
		System.out.print("정수 1 입력 : ");
		int input1 = sc.nextInt();
		
		System.out.print("정수 2 입력 : ");
		int input2 = sc.nextInt();
		
		
		// System.out.println("결과 : " + input1/input2);
		
		// 결과
		// 두 정수를 입력받아 나누기한 몫을 출력
		// 정수 1 입력 : 5
		// 정수 2 입력 : 0
		// java.lang.ArithmeticException: / by zero
		// java.lang.ArithmeticException : 산술적 예외 발생
		// 0으로 나눌 수 없다.
		
		try {
			System.out.println("결과 : " + input1/input2);
			// 예외 발생할 것 같은 코드 넣어줌
		} catch(ArithmeticException e) {
			// try 에서 던져진 예외를 catch 문의 매개변수 e 로 잡음.
			
			System.out.println("infinity"); // 처리코드
		}
		
		// 위와 똑같은 결과 나옴
		if(input2 != 0) {
			System.out.println("결과 : " + input1/input2);
		} else {
			System.out.println("infinity");
		}
		
		// 발생하는 예외 중 일부 예외 try~catch 구문 사용 안해도
		// 예외 상황 방지할 수 있다. (if-else 사용)
		// 일부 예외 == 대부분 Unchecked Exception
		
	}
	
	public void ex2() {
		
		// 여러 가지 예외에 대한 처리 방법
		
//		System.out.print("입력 1 : ");
//		int num1 = sc.nextInt();
//		// 숫자 아닌 거 입력했을 때 발생
//		// InputMismatchException
//		
//		
//		System.out.print("입력 2 : ");
//		int num2 = sc.nextInt();
//		// InputMismatchException
//		
//		System.out.println("결과 : " + num1/num2);
//		// 0으로 나눴을 때 발생
//		// ArithmeticException
//		
//		String str = null;
//		
//		System.out.println(str.charAt(0));
//		// null 값에서 무언가를 꺼내려 했을 때
//		// NullPointerException
		
		// InputMismatchException
		// ArithmeticException
		// NullPointerException
		try {
			System.out.print("입력 1 : ");
			int num1 = sc.nextInt();
			
			System.out.print("입력 2 : ");
			int num2 = sc.nextInt();

			System.out.println("결과 : " + num1/num2);

			String str = null;
			
			System.out.println(str.charAt(0));
			
		} catch(InputMismatchException e) { // import 해줘야함
			System.out.println("타입에 맞는 값만 입력해주세요");
		} catch(ArithmeticException e) {
			System.out.println("0 으로 나눌 수 없습니다.");
		} catch(Exception e) {
			// Exception 클래스 : 모든 예외의 최상위 부모
			// 다형성 - 업캐스팅 : 부모타입 참조변수로 자식객체 참조
			
			// (모든 자식 예외들을 다 잡아서 처리 가능)
			// ** 상위 타입의 예외 클래스를 catch 문에 작성하면
			// 	  다형성 업캐스팅에 의해 모두 잡아서 처리 가능 **
			
			System.out.println("뭔지 모르겠으나 예외가 발생해서 처리함.");
			e.printStackTrace();
			// 발생한 예외에 대한 메서드와 위치에 대한 모든 내용을 출력
			// 예외 발생 지점 추적
			
			/*
			 * java.lang.NullPointerException: Cannot invoke "String.charAt(int)" because "str" is null
			 * at edu.kh.exception.model.service.ExceptionService.ex2(ExceptionService.java:97)
			 * at edu.kh.exception.run.ExceptionRun.main(ExceptionRun.java:12)
			 * */
		}
		
	}
	
	public void ex3() {
		
		// try - catch - finally
		// finally : try 구문에서 예외가 발생 하든 말든 무조건 마지막에 수행
		
		try { 
			
			System.out.print("입력 1 : ");
			int num1 = sc.nextInt();
			
			System.out.print("입력 2 : ");
			int num2 = sc.nextInt();

			System.out.println("결과 : " + num1/num2);
			
			// InputMismatchException
			// ArithmeticException
			// NullPointerException
			
		} catch(ArithmeticException e) {
			System.out.println("예외 처리 됨");
			
			// catch 문 매개변수 활용
			// 매개변수 e : 예외 관련된 정보 + 예외 관련 기능
			
			System.out.println(e.getClass()); // 어떤 예외 클래스인가?
			// java.lang.ArithmeticException
			
			System.out.println(e.getMessage()); // 예외 발생시 출력된 내용
			// / by zero
			
			System.out.println(e); // e.toString()
			// java.lang.ArithmeticException: / by zero
			
			
		} finally {
			// 무조건 수행됨
			// Resource leak: 'sc' is never closed
			// 메모리 누수 발생
			// sc.close;
			System.out.println("무조건 수행 됨");
			sc.close();
			// 스캐너 통로 닫기 : 메모리 누수 방지
			// 다 사용했으면 닫아줘야함
			// 통로 닫기 할 때 finally 에 작성해줌
		}
		
	}
	
	public void ex4() {
		
		// throws : 호출한 메서드에게 예외를 던짐
		//			-> 호출한 메서드에게 예외를 처리하라고 위임하는 행위
		
		// throw : 예외를 강제 발생 구문
		
		try {
			methodA();			
		} catch(Exception e) {
			// Exception : 모든 예외의 최상위 부모
			// == 예외 종류 상관없이 모두 처리
			
			System.out.println("methodC 에서부터 발생한 예외를 ex4에서 잡아 처리함.");
		}
	}
	
	public void methodA() throws IOException {
		methodB();
		// The method methodB() is undefined for the type ExceptionService
	}
	
	public void methodB() throws IOException {
		methodC();
	}
	
	public void methodC() throws IOException {
		// 예외 강제 발생
		throw new IOException();
		
//		try {
//			throw new IOException();
//			
//		} catch(IOException e) {
//			e.printStackTrace();
//		}
		// 메서드마다 다 써줘야함
	}
	
	
}
