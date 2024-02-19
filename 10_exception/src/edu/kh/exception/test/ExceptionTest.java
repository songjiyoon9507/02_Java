package edu.kh.exception.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ExceptionTest {
	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 컴파일 에러 => 개발자가 코드 잘못 쓴 경우
		// int a = 99.9;
		// Type mismatch: cannot convert from double to int
		// 자료형이 맞지 않아 연산 불가하여 "컴파일 에러"가 발생(코드 틀림)
		// 코드로 수정 가능
		int a = (int)99.9;
		
		// 런타임 에러 => 프로그램 수행 중 발생하는 에러
		// 				  주로 if 문으로 처리 가능하다.
		// 에러가 날 것 같은 상황에 if 문 작성해서 코드를 처리해라라고 쓸 수 있음
		
		int[] arr = new int[3]; // 길이 3 : 인덱스 0, 1, 2 까지
		
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		// arr[3] = 40;
		// 컴파일 에러는 없음 (런타임 에러)
		// Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
		// at edu.kh.exception.test.ExceptionTest.main(ExceptionTest.java:27)
		// java.lang.ArrayIndexOutOfBoundsException : 배열 범위 초과 예외
		
		if(3 >= arr.length) { // 배열 인덱스 범위 초과 시
			System.out.println("배열 범위를 초과했습니다.");
		} else {
			arr[3] = 40;
			arr[4] = 50;
		}
		
		// 실행 결과
		// 배열 범위를 초과했습니다.
		
	}
}
