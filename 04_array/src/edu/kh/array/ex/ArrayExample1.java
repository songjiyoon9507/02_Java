package edu.kh.array.ex;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayExample1 {
	Scanner sc = new Scanner(System.in);
	/* 배열(Array)
	 * - 같은 자료형의 변수를 하나의 묶음으로 다루는 것.
	 * - 묶여진 변수들은 하나의 배열명으로 불러지고
	 * 	 구분은 index 를 이용함 (index 는 0 부터 시작하는 정수)
	 * 
	 * */
	
	public void ex1() {
		
		// 변수 vs 배열
		// (차이점)
		
		// 변수 선언
		int num;
		// stack 영역에 int 자료형을 저장할 수 있는 공간 4byte 를 할당하고
		// 그 공간에 num 이라는 이름을 부여.
		
		// 변수 대입
		num = 10;
		// 생성된 num 이라는 변수 공간에 10 이라는 값을 대입
		
		// 변수 사용
		System.out.println("num에 저장된 값 : " + num);
		// num 이 작성된 자리에 num 에 저장된 값을 읽어와서 출력
		
		
		// 베열 선언
		int[] arr;
		int str[];
		// Stack 영역에 int[] 자료형 공간을 4byte 할당하고
		// 그 공간에 arr, str 이라는 이름을 부여
		// ** 해당 변수는 참조형으로 주소값만을 저장할 수 있다.
		
		// 배열 할당
		arr = new int[3];
		
		// new : "new 연산자" 라고 하며
		// 		 Heap 메모리 영역에 새로운 공간(배열, 객체)을 할당
		
		// int[3] : int 자료형 변수 3개를 하나의 묶음으로 나타내는 배열
		
		// new int[3] : heap 영역에 int 3칸 짜리 int[] 을 생성(할당)
		// 				** 생성된 int[]에는 시작 주소가 지정 **
		
		// arr = new int[3];
		// (int[])    (int[])    -> 같은 자료형 == 연산 가능
		
		// str = new double[5];
		// str 은 int 형
		// 자료형이 다르면 연산이 안됨
		
		// heap 영역에 생성된 int[]의 시작주소를
		// stack 영역에 생성된 arr 변수에 대입
		
		// -> arr 변수가 int[]을 참조하게됨
		// 	  그래서 arr 을 참조형이라고 함.
		
		System.out.println("arr의 주소값? : " + arr); //[I@5577140b
		
		// 배열 요소 값 대입
		// arr 자체는 int[] 주소를 참조하고 있는 참조형 변수이지만
		// arr[0], arr[1], arr[2] 은 int 자료형 변수이기 때문에 정수값을 대입할 수 있다.
		
		arr[0] = 10;
		arr[1] = 50;
		arr[2] = 1000;
		
		// 배열 요소 값 읽어오기      대입 전   대입 후
		System.out.println( arr[0] ); // 0         10
		System.out.println( arr[1] ); // 0         50
		System.out.println( arr[2] ); // 0        1000
	}
	
	public void ex2() {
		
		// 배열 선언 및 할당
		int[] arr = new int[4]; // 배열 4칸 할당
		
		arr[0] = 100;
		arr[1] = 200;
		arr[2] = 500;
		arr[3] = 1000;
		
		// 배열의 길이 (몇 칸 인가) : 배열명.length
		System.out.println("배열의 길이 : " + arr.length);
		
		// 배열과 for문
		for (int i = 0 ; i < arr.length ; i++) {
			// 0 1 2 3
			// System.out.println(arr[i]);
			System.out.printf("arr[%d]에 저장된 값 : %d\n", i , arr[i]);
		}
	}
	
	public void ex3() {
		// 5명의 키(cm)를 입력받고 평균 구하기
		
		// 1번 키 입력 : 170.5
		// 2번 키 입력 : 165.7
		// 3번 키 입력 : 184.3
		// 4번 키 입력 : 190.2
		// 5번 키 입력 : 174.4
		
		// 평균 : 177.02 cm
		
		double[] height = new double[5];
		// double[] 자료형 참조변수 height를 stack 영역에 생성하고
		// height에 heap 영역에 새로 생성된 double 5칸짜리 double[]의 시작 주소를 대입
		
		for(int i = 0 ; i < height.length ; i++) {
			System.out.print((i+1)+"번 키 입력 : "); // 1 2 3 4 5
			height[i] = sc.nextDouble();
			// 0 1 2 3 4
			
			// 각 인덱스에 입력받은 값을 대입(초기화)
		}
		System.out.println();
		
		double sum = 0; // 합계 저장용 변수
		
		for(int i = 0 ; i < height.length ; i++) {
			sum += height[i]; // 배열에 저장된 값을 sum 에 누적
		}
		
		System.out.printf(" 평균 : %.2f", sum/height.length);
		
	}
	
	public void ex4() {
		// 입력 받은 인원 수 만큼의 점수를 입력받아 배열에 저장
		// 입력이 완료되면 점수 합계, 평균, 최고점, 최저점 출력
		
		// ex)
		// 입력 받을 인원 수 : 4
		// 1번 점수 입력 : 100
		// 2번 점수 입력 : 80
		// 3번 점수 입력 : 50
		// 4번 점수 입력 : 60
		
		// 합계 : 290
		// 평균 : 72.5
		// 최고점 : 100
		// 최저점 : 50
		
		System.out.print("입력 받을 인원 수 : ");
		int input = sc.nextInt();
		
		int[] score = new int[input];
		
		int sum = 0;
		
		// input 수 는 반복할 수
		for (int i = 0; i < input ; i++) {
			System.out.print((i+1)+"번 점수 입력 : ");
			score[i] =sc.nextInt();
			sum += score[i];
		}
		System.out.println();
		System.out.printf("합계 : %d\n",sum);
		System.out.printf("평균 : %.1f\n",(double)sum/input);
		
		int max = score[0];
		int min = score[0];
		
		// i = 0부터 돌아도됨
		for(int i = 1 ; i < score.length ; i ++) {
			if (score[i] > max) {
				max = score[i];
			}
			if (score[i] < min) {
				min = score[i];
			}
		}
		System.out.printf("최고점 : %d\n",max);
		System.out.printf("최고점 : %d\n",min);
		// 최대값
		// int maxValue = Arrays.stream(score).max().getAsInt();
		// 최소값
		// int minValue = Arrays.stream(score).min().getAsInt();
	}

	public void ex5() {
		// 배열 선언과 동시에 초기화
		
		char[] arr = new char[5];
		
		for(int i = 0 ; i < arr.length; i++) {
			arr[i] = (char)('A' + i);
		}
		
		// ** Arrays 클래스
		// -> Java 에서 제공하는 배열과 관련된 기능을 모아둔 클래스
		
		// Arrays.toString(배열명) : 모든 요소 값을 출력
		
		System.out.println(Arrays.toString(arr)); // [A, B, C, D, E]
		
		int[] arr2 = new int[4]; // [0,0,0,0]
		System.out.println(Arrays.toString(arr2)); // [0, 0, 0, 0]
		// int형 배열 4칸짜리 생성 후 각 인덱스에 값을 대입하지 않았으므로
		// JVM에 의해 int형 기본값인 0으로 각각 초기화 되어있음.
		
		boolean[] arr3 = new boolean[2];
		System.out.println(Arrays.toString(arr3)); // [false, false]
		// 기본값 false
		
		String[] arr4 = new String[3];
		System.out.println(Arrays.toString(arr4)); // [null, null, null]
		// 참조형 기본값 null
		
		// 배열 선언과 동시에 (할당 및) 초기화
		char[] arr5 = {'A', 'B', 'C', 'D', 'E'};
		// {} (중괄호) 는 배열의 리터럴 표기법
		
		System.out.println(Arrays.toString(arr5)); // [A, B, C, D, E]
	}
	
	public void ex6() {
		// 점심 메뉴 뽑기 프로그램
		
		String[] arr = {"김밥", "서브웨이", "햄버거", "백반", "국밥", "파스타"};
		
		System.out.println("오늘 점심 메뉴 : " + arr[ (int)(Math.random() * 6) ]);
		
		// 0.0 <= x < 1.0
	}

	public void ex7() {
		// 배열을 이용한 검색
		
		// 입력 받은 정수가 배열에 있는지 없는지 확인
		// 만약 있다면 몇번 인덱스에 존재하는지 출력
		// int[] arr = {100, 200, 300, 400, 500, 600, 700, 800, 900, 1000};
		
		// ex)
		// 정수 입력 : 200
		// 1번째 인덱스에 존재
		
		// 정수 입력 : 5
		// 존재하지 않음
		
		int[] arr = {100, 200, 300, 400, 500, 600, 700, 800, 900, 1000};
		
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		// 신호를 나타내기 위한 변수
		int count = 0;
		
		for (int i = 0 ; i < arr.length ; i ++) {
			
			if (arr[i] == input) {
				System.out.printf("%d번째 인덱스에 존재",i);
				count++;
			}
		}
	
		if (count == 0) {
			System.out.println("존재하지 않음");
		}
		
		
	}

	public void ex7_1() {
		
		int[] arr = {100, 200, 300, 400, 500, 600, 700, 800, 900, 1000};
		
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		// 신호를 나타내기 위한 변수
		// flag == false : 일치하는 값이 존재하지 않음
		// flag == true : 일치하는 값이 존재
		
		boolean flag = false; // 검사전에는 없다고 가정
		
		// arr 배열 요소 순차 접근
		for (int i = 0 ; i < arr.length; i ++) {
			if(arr[i] == input) {
				System.out.println(i + "번째 인덱스에 존재");
				flag = true; // 일치하는 값이 있으므로 true로 변경
			}
		}
		
		// flag 상태를 검사
		if( !flag ) { // flag == false
			// if 문을 돌리려면 true 여야함
			// flag 에 ! 붙여서 flag 가 false 일 때 존재하지 않음 출력 
			System.out.println("존재하지 않음");
		}
	}

	public void ex8() {
		
		// 입력 받은 값과 일치하는 값이 있으면 인덱스 번호 출력
		// 없으면 "존재하지 않음" 출력
		
		String[] arr = {"사과", "딸기", "바나나", "키위", "멜론", "아보카도"};
		
		/*
		 * 과일 입력 : 아보카도
		 * 5번 인덱스에 존재
		 * 
		 * 과일 입력 : 수박
		 * 존재하지 않음
		 * */
		
		// input.equals("exit@")
		
		System.out.print("과일 입력 : ");
		String input = sc.next();
		
		boolean flag = false;
		
		for (int i = 0 ; i < arr.length; i++) {
			
			if (arr[i].equals(input)) { // String 비교시 equals() 사용
				System.out.println(i + "번째 인덱스에 존재");
				flag = true;
			}
		}
		if (!flag) {
			System.out.println("존재하지 않음");
		}
	}
	
	public void ex9() {
		// 1. 문자열을 입력받아 한 글자씩 잘라내어 char 배열에 순서대로 저장
		// 2. 문자 하나를 입력받아 일치하는 문자가 char 배열에 몇 개 존재하는지 확인
		// 3. 단, 일치하는 문자가 없을 경우 "존재하지 않습니다." 출력
		
		// 사용해야하는 기술, 기능
		// 1) 배열 검색
		// 2) String.length() : 문자열의 길이
		//    ex) "Hello".length() -> 5
		
		// 3) String.charAt(index) : 문자열에서 특정 index 에 위치한 문자 하나를 얻어옴.
		//    ex) "Hello".charAt(1) -> 'e'
		
		// 4) count (숫자세기)
		System.out.print("문자열 입력 : ");
		String input = sc.nextLine();
		int count = 0;
		// 빈 배열
		char[] arr = new char[(int)(input.length())];
		
		for (int i = 0 ; i < input.length() ; i ++) {
			arr[i] = input.charAt(i);
		}
		// System.out.println(Arrays.toString(arr));
		System.out.print("검색할 문자 입력 : ");
		
		char ch = sc.next().charAt(0); // string 형을 불러오는 거라서 charAt 붙여줌
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == ch) { // char 형태는 == 가능
				count++;
				// arr[i] 값과 검색할 문자 ch가 같은 경우
				// 카운트 늘려라
			}
		}
		// 결과 출력
		if( count > 0 ) {
			System.out.println(count + "개 있음");
		} else {
			System.out.println("존재하지 않음");
		}
		
	}
	
}
