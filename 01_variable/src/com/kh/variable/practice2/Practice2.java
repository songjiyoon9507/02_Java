package com.kh.variable.practice2;

import java.util.Scanner;

public class Practice2 {

	public void ex1() {
		Scanner sc = new Scanner (System.in);
		
		System.out.print("문자 : ");
		
		char result = sc.next().charAt(0);
		// "단어".charAt(0); => '단' char로 형변환까지 해줌
//		String input1 = sc.next(); // 입력된 단어 읽어옴
		
		// 읽어온 input 값을 input값 unicode input값의 유니코드
		System.out.printf("%c unicode : %d", result,(int)result);
		// input값은 char 형태니까 %c, unicode %d 정수형
		// 읽어진 input1 형변환 char , int
	}
}
