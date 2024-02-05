package edu.kh.control.condition;
// 다른 패키지에 있는 클래스가 필요할 때 하는 거 import
import java.util.Scanner;

public class ConditionExample { // 기능 제공용 클래스
	// method 기능들 모여있음
	// field 전역변수처럼 쓸 수 있음
	Scanner sc = new Scanner(System.in);
	
	// 제어문
	public void ex1() {
		
		// if문
		// 조건식이 true 일 때만 내부 코드 수행
		
		/*
		 * [작성법]
		 * if (조건식) {
		 * 		조건식이 true 일 때 수행할 코드 작성
		 * }
		 * 
		 * */
		
		// 입력받은 정수가 양수인지 검사
		// 양수라면 "양수입니다" 출력
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		if (num > 0) {
			System.out.println("양수입니다.");
		}
		if(num <= 0) {
			System.out.println("양수가 아닙니다.");
		}
	}
	
	public void ex2() {
		// if - else문
		// 조건식 결과가 true 면 if문,
		// false면 else 구문이 수행됨
		
		/*
		 * [작성법]
		 * if(조건식){
		 * 		조건식이 true일 때 수행될 코드
		 * } else {
		 * 		조건식이 false일 때 수행될 코드
		 * }
		 * 
		 * */
		
		// 홀짝 검사
		// 입력받은 정수값이 홀수이면 "홀수입니다." 출력
		// 0이면 "0입니다."
		// 짝수이면 "짝수입니다." 출력
		// else if 사용 X, 중첩 if문 사용
		System.out.print("숫자 입력 : ");
		int num = sc.nextInt();
		
		if (num % 2 == 1) {
			System.out.println("홀수입니다.");
		} else {
			if(num == 0) {
				System.out.println("0 입니다.");
			} else {
				System.out.println("짝수입니다.");
			}
		}
	}

	public void ex3() {
		// 양수, 음수, 0 판별
		// if(조건식) - else if(조건식) - else
		
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		
		if(num > 0) {
			System.out.println("양수 입니다.");
		} else if (num < 0) { // 바로 위에 있는 if문이 만족되지 않은 경우 수행
			System.out.println("음수 입니다.");
		} else {
			System.out.println("0 입니다.");
		}
	}
	
	public void ex4() {
		
		// 달(month)을 입력받아 해당 달에 맞는 계절 출력
		// 단, 겨울일 때 온도가 -15도 이하라면 "한파 경보", -12도 이하 "한파 주의보"
		// 여름일 때 온도가 35도 이상 "폭염 경보", 33도 이상 "폭염 주의보"
		// 1~12 사이가 아닐 땐 "해당하는 계절이 없습니다." 출력
		// 1,2,12 겨울
		// 3~5 봄
		// 6~8 여름
		// 9~11 가을
		
		// 온도는 변수 지정 or 입력받기
		
		// 겨울 한파주의보
		// 여름 폭염경보
		// 봄
		// 가을
		
		System.out.print("달 입력 : ");
		int month = sc.nextInt();
		System.out.print("온도 입력 : ");
		int temperature = sc.nextInt();
		
		if (month >= 3 && month <= 5) { // 봄일 때
			System.out.println("봄");
		} else if (month >= 6 && month <= 8) { // 여름일 때
			System.out.print("여름");
			if (temperature >= 35) {
				System.out.println(": 폭염 경보");
			} else if (temperature >= 33) {
				System.out.println(": 폭염 주의보");
			}
		} else if (month >= 9 && month <= 11) {
			System.out.println("가을");
		} else if (month == 12 || month == 1 || month == 2) {
			System.out.print("겨울");
			if (temperature <= -15) {
				System.out.println(": 한파 경보");
			} else if (temperature <= -12) {
				System.out.println(": 한파 주의보");
			}
		} else {System.out.println("해당하는 계절이 없습니다.");}
	}
	
	public void ex4_1() {
		System.out.print("달 입력 : ");
		int month = sc.nextInt();
		
		String season; // 아래 조건문 수행 결과를 저장할 변수 선언
		
		if(month == 1 || month == 2 || month == 12) {
			season = "겨울";
			
			System.out.print("온도 입력 : ");
			int temperature = sc.nextInt();
			
			if (temperature <= -15) {
				season += " 한파 경보";
				// 겨울 + 한파 경보
			} else if (temperature <= -12) {
				season += " 한파 주의보";
				// 겨울 + 한파 주의보
			}
			
		} else if (month >= 3 && month <= 5) {
			season = "봄";
		} else if (month >= 6 && month <= 8) {
			season = "여름";
			
			System.out.print("온도 입력 : ");
			int temperature = sc.nextInt();
			
			if (temperature >= 35) {
				season += " 폭염 경보";
				// 여름 + 폭염 경보
			} else if (temperature >= 33) {
				season += " 폭염 주의보";
				// 여름 + 폭염 주의보
			}
		} else if (month >= 9 && month <= 11) {
			season = "가을";
		} else {
			season = "해당하는 계절이 없습니다.";
		}
		
		System.out.println(season);
	}
	
	public void ex5() {
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();
		
		if (age <= 13) {
			System.out.println("어린이입니다.");
		} else if (age > 13 && age <= 19) {
			System.out.println("청소년입니다.");
		} else if (age > 19) {
			System.out.println("성인입니다.");
		}
		
	}

	public void ex6() {
		System.out.print("점수 입력 : ");
		int score = sc.nextInt();
		
		if (score < 0 || score > 100) {
			System.out.println("잘못 입력하셨습니다.");
		} else if (score >= 90) {
			System.out.println("A");
		} else if (score >= 80 && score < 90) {
			System.out.println("B");
		} else if (score >= 70 && score < 80) {
			System.out.println("c");
		} else if (score >= 60 && score < 70) {
			System.out.println("D");
		} else {
			System.out.println("F");
		}
	}

	public void ex7() {
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();
		System.out.print("키 입력 : ");
		double height = sc.nextDouble();
		
		if (age < 0 || age > 100) {
			System.out.println("잘못 입력하셨습니다.");
		} else if (age >= 12 && height >= 140) {
			System.out.println("탑승 가능");
		} else if (age < 12) {
			System.out.println("적정 연령이 아닙니다.");
		} else if (height < 140.0) {
			System.out.println("적정 키가 아닙니다.");
		}
	}

	public void ex8() {
		System.out.print("나이 : ");
		int age = sc.nextInt();
		
		
		if (age < 0 || age > 100) {
			System.out.println("나이를 잘못 입력하셨습니다.");
			return;
		}
		
		System.out.print("키 : ");
		double height = sc.nextDouble();
		
		if (height < 0 || height > 250.0) {
			System.out.println("키를 잘못 입력하셨습니다.");
			return;
		}
		
		if (age >= 12 && height < 140.0) {
			System.out.println("나이는 적절하나, 키가 적절치 않음");
		} else if (age < 12 && height >= 140.0) {
			System.out.println("키는 적절하나, 나이는 적절치 않음");
		} else if (age < 12 && height <140.0) {
			System.out.println("나이와 키 모두 적절치 않음");
		} else {
			System.out.println("탑승 가능");
		}
		
	}

	public void ex8_1() {
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();
		
		String result;
		
		if (age < 0 || age > 100) {
			result = "나이를 잘못 입력했어요";
		} else {
			System.out.print("키 입력 : ");
			double height = sc.nextDouble();
			
			if(height < 0 || height > 250) {
				result = "키를 잘못 입력했어요";
			} else {
				if(age < 12 && height >= 140.0) {
					result = "키는 적절하나, 나이가 적절치 않음";
				} else if (age >= 12 && height < 140.0) {
					result = "나이는 적절하나, 키가 적절치 않음";
				} else if (age < 12 && height < 140.0) {
					result = "나이와 키 모두 적절치 않음";
				} else {
					result = "탑승 가능";
				}
			}
		}
		System.out.println(result);
	}

}
