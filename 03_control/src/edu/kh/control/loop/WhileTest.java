package edu.kh.control.loop;

import java.util.Scanner;

public class WhileTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("2 ~ 9 사이 정수 입력 : ");
			
			// next(); 는 입력 타입이 문자열
			// next(); -> nextint();
			int input = sc.nextInt();
			
			// sc.nextLine(); 은 필요 없음
			
			// input <= 9 는 9 이하 숫자 모두 입력 받을 수 있음
			// input <= 9 -> input >= 2 && input <= 9
			if(input >= 2 && input <= 9) { // 2 ~ 9 사이 정수 입력 받아야함
				for(int num = 1 ; num <= 9 ; num++) {
					// printf 에 입력해야할 결과값 3개
					// input, num -> input, num, input*num
					System.out.printf("%d * %d = %d\n", input, num, input*num);
				}
				// 제대로 단수 출력이 나온 후 while 문 종료 위해
				// break; 필요
				break;
			} else {
				System.out.println("2이상 9이하의 정수만 입력해주세요.");
			}
		}
	}
}
