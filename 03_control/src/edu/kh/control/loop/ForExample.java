package edu.kh.control.loop;

import java.util.Scanner;

public class ForExample { // 기능 제공
	
	Scanner sc = new Scanner(System.in);
	
	public void ex1() {
		/* for문
		 * - 끝이 정해져 있는 (횟수가 지정되어 있는) 반복문
		 * 
		 * [작성법]
		 * 
		 * for(초기식; 조건식; 증감식) {
		 * 		조건식이 true라면 반복 수행할 코드
		 * }
		 * 
		 * - 초기식 : for문을 제어하는 용도의 변수 선언
		 * 
		 * - 조건식 : for문의 반복 여부를 지정하는 식
		 * 			보통 초기식에 사용된 변수를 이용하여 조건식을 작성함.
		 * 
		 * - 증감식 : 초기식에 사용된 변수를
		 * 			for문이 끝날 때마다 증가 또는 감소시켜
		 * 			조건식의 결과를 변하게 하는 식 
		 * */	
		for (int i = 1; i <= 10; i++) {
			System.out.println(i);
		}
	}

	public void ex2() {
		// 1부터 입력받은수까지 1씩 증가하며 출력
		
		System.out.print("숫자 입력 : ");
		int num = sc.nextInt();
		
		for (int i = 1; i <= num ; i++) {
			
			System.out.println(i);
		}
	}

	public void ex3() {
		// 영어 알파벳 A 부터 Z 까지 한줄로 출력
		// ABXDEFGHIJKLMNOPQRSTUVWXYZ
		
		for (char ch = 65 ; ch <= 91 ; ch ++) {
			System.out.print(ch);
		}
		
		for(int i = 'A'; i <= 'Z'; i++) {
			System.out.print((char)i); // 강제형변환
		}
		
		for(char i = 'A' ; i <= 'Z'; i++) {
			System.out.print(i);
		}
	}

	public void ex4() {
		// 정수 5개를 입력 받아서 합계 구하기
		
		/* ex)
		 * 입력 1 : 10
		 * 입력 2 : 20
		 * 입력 3 : 30
		 * 입력 4 : 40
		 * 입력 5 : 50
		 * 합계 : 150
		 * */
		int sum = 0;
		for (int i = 1; i <= 5 ; i++) {
			System.out.print("입력 " + i + " : ");
			int input = sc.nextInt();
			
			sum += input;
		} System.out.print("합계 : " + sum);
	}

	public void ex5() {
		// 1부터 20까지 1씩 증가하면서 출력
		// 단, 입력 받은 수의 배수는 양쪽에 () 표시
		
		// ex)
		// 괄호를 표시할 배수 : 3
		// 1 2 (3) 4 5 (6) ... (18) 19 20
		System.out.print("괄호를 표시할 배수 : ");
		int input = sc.nextInt();
		
		for (int i = 1; i <= 20 ; i ++) {
			if (i % input == 0) {
				System.out.print("("+i+")");
			} else { // else 안 써주면 숫자 한번씩 더 나옴
				System.out.print(i);
			}
		}
	}

	public void ex6() {
		// [구구단 출력]
		// 2~9 사이 수를 하나 입력 받아
		// 해당 단을 출력
		// 단, 입력 받은 수가 2~9 사이가 아니면
		// "잘못 입력하셨습니다." 출력
		
		// 단 입력 :
		System.out.print("단 입력 : ");
		int dan = sc.nextInt();
		
		if (dan < 2 || dan > 9) {
			System.out.println("잘못 입력하셨습니다.");
		} else {
			for(int i = 1 ; i <= 9 ; i++) {
				System.out.println(dan + " X " + i + " = " + dan*i);
			}
		}
	}
	
	public void ex7() {
		
		for (int dan = 2; dan <= 9 ; dan++) {
			for (int i = 1; i <= 9 ; i++) {
				System.out.printf("%d X %d = %2d  ",dan,i,dan*i);
			}
			System.out.println();
		}
	}
	
	public void ex7_1() {
		
		for (int dan = 9; dan >= 2 ; dan--) {
			for (int i = 1; i <= 9 ; i++) {
				System.out.printf("%d X %d = %2d  ",dan,i,dan*i);
			}
			System.out.println();
		}
	}

	public void ex8() {
		// 숫자 세기 count
		
		// 1부터 20까지 1씩 증가하면서
		// 입력받은 수의 배수의 총 개수 출력
		// 입력받은 수의 배수의 합계 출력
		
		// 배수 입력 : 3
		// 3 6 9 12 15 18 : 6개
		// 3의 배수 합계 : 63
		
		System.out.print("배수 입력 : ");
		int input = sc.nextInt();
		int count = 0;
		int sum = 0;
		for (int i = 1; i <= 20 ; i++) {
			if (i % input == 0) { // input의 배수일 때
				count++;
				System.out.printf("%d ",i);
				sum += i;
			}
		}
		System.out.println(": " + count + "개");
		System.out.printf("%d의 배수 합계 : %d", input, sum);
	}
}
