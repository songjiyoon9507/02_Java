package edu.kh.op.practice;

import java.util.Scanner;

public class OperatorPractice { // 기능 제공 클래스
	// 실습문제1
	 public void practice1() {
		 
		 Scanner sc = new Scanner(System.in);
		 
		 System.out.print("인원 수 : ");
		 int input1 = sc.nextInt();
		 
		 System.out.print("사탕 개수 : ");
		 int input2 = sc.nextInt();
		 
		 System.out.println();
		 
		 System.out.printf("1인당 사탕 개수 : %d\n", (int)input2/input1);
		 System.out.printf("남는 사탕 개수 : %d", (int)input2%input1);
		 
	 }

	 // 실습문제2
	 public void practice2() {
		 
		 Scanner sc = new Scanner(System.in);
		 
		 System.out.print("이름 : ");
		 String name = sc.next();
		 
		 System.out.print("학년(정수만) : ");
		 int grade = sc.nextInt();
		 
		 System.out.print("반(정수만) : ");
		 int group = sc.nextInt();
		 
		 System.out.print("번호(정수만) : ");
		 int num = sc.nextInt();
		 
		 System.out.print("성별(남학생/여학생) : ");
		 String gender = sc.next();
		 
		 System.out.print("성적(소수점 아래 둘째 자리까지) : ");
		 double scole = sc.nextDouble();
		 
		 System.out.println();
		 
		 System.out.printf("%d학년 %d반 %d번 %s %s의 성적은 %.2f이다.", grade, group, num, name, gender, scole);
		 
	 }
	 
	 // 실습문제3
	 public void practice3() {
		 Scanner sc = new Scanner(System.in);
		 
		 System.out.print("국어 : ");
		 int kor = sc.nextInt();
		 
		 System.out.print("영어 : ");
		 int eng = sc.nextInt();
		 
		 System.out.print("수학 : ");
		 int math = sc.nextInt();
		 
		 int sum = kor + eng + math; // 합계
		 double avg = sum / 3.0; // 평균
		 
		 System.out.println();
		 
		 System.out.println("합계 : " + sum);
		 System.out.printf("평균 : %.1f\n", avg);
		 
		 boolean result = (kor >= 40) && (eng >= 40) && (math >= 40) && (avg >= 60);
		 
		 System.out.println(result ? "합격" : "불합격");
	 }
	 
}
