package edu.kh.control.practice;

import java.util.Scanner;

public class ConditionPractice { // 기능 작성 클래스

	Scanner sc = new Scanner(System.in);
	
	public void practice1() {
		
		System.out.print("숫자를 한 개 입력하세요 : ");
		int num = sc.nextInt();
		
		if (num > 0 && num % 2 == 0) {
			System.out.println("짝수입니다.");
		} else if (num > 0 && num % 2 == 1) {
			System.out.println("홀수입니다.");
		} else {
			System.out.println("양수만 입력해주세요");
		}
		
	}

	public void practice2() {
		
		System.out.print("국어점수 : ");
		int kor = sc.nextInt();
		
		System.out.print("영어점수 : ");
		int eng = sc.nextInt();
		
		System.out.print("수학점수 : ");
		int math = sc.nextInt();
		
		int sum = kor + eng + math;
		float avg = (kor+eng+math)/3;
		
		if (kor >= 40 && eng >= 40 && math >= 40 && avg >= 60) {
			System.out.println("국어 : " + kor);
			System.out.println("영어 : " + eng);
			System.out.println("수학 : " + math);
			System.out.println("합계 : " + sum);
			System.out.printf("평균 : %.1f\n", avg);
			System.out.println("축하합니다, 합격입니다!");
		} else {
			System.out.println("불합격입니다.");
		}
		
	}
	
	public void practice3() {
		
		System.out.print("1~12 사이의 정수 입력 : ");
		
		int month = sc.nextInt();
		
		int day;
		
		switch(month) {
			case 1 : case 3 : case 5 : case 7 : case 8 : case 10 : case 12 :
				day = 31;
				System.out.printf("%d월은 %d일까지 있습니다.",month,day);
				break;
			case 2 :
				day = 28;
				System.out.printf("%d월은 %d일까지 있습니다.",month,day);
				break;
			case 4 : case 6 : case 9 : case 11 :
				day = 30;
				System.out.printf("%d월은 %d일까지 있습니다.",month,day);
				break;
			default :
				System.out.printf("%d월은 잘못 입력된 달입니다.", month);
				break;
		}
		
	}
	
	public void practice4() {
		System.out.print("키(m)를 입력해 주세요 : ");
		double height = sc.nextDouble();
		System.out.print("몸무게(kg)를 입력해 주세요 : ");
		double weight = sc.nextDouble();
		
		double bmi = weight/(height*height);
		
		String result;
		
		if (bmi < 18.5) {
			result = "저체중";
		} else if (bmi >= 18.5 && bmi < 23) {
			result = "정상체중";
		} else if (bmi >= 23 && bmi < 25) {
			result = "과체중";
		} else if (bmi >= 25 && bmi < 30) {
			result = "비만";
		} else {
			result = "고도 비만";
		}
		System.out.println("BMI 지수 : " + bmi);
		System.out.println(result);
		
	}

	public void practice5() {
		
		System.out.print("중간 고사 점수 : ");
		int mid = sc.nextInt();
		double midPer = mid*0.2;
		
		System.out.print("기말 고사 점수 : ");
		int end = sc.nextInt();
		double endPer = end*0.3;
		
		System.out.print("과제 점수 : ");
		int home = sc.nextInt();
		double homePer = home*0.3;
		
		System.out.print("출석 횟수 : ");
		int att = sc.nextInt();
		double attPer = att*5*0.2;
		
		if (att < 14) {
			System.out.printf("Fail [출석 횟수 부족 (%d/20)]",att);
		}
		
		System.out.println("=============결과=============");
		System.out.printf("중간 고사 점수(20) : %.1f\n",midPer);
		System.out.printf("기말 고사 점수(30) : %.1f\n",endPer);
		System.out.printf("과제 점수     (30) : %.1f\n",homePer);
		System.out.printf("출석 점수     (20) : %.1f\n",attPer);
		System.out.printf("총점 : %.1f\n",(midPer+endPer+homePer+attPer));
		
		if ((midPer+endPer+homePer+attPer) >= 70) {
			System.out.println("Pass");
		} else if((midPer+endPer+homePer+attPer) < 70) {
			System.out.println("Fail [점수 미달]");
		}
		
	}
	
}