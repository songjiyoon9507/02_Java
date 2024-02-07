package edu.kh.array.practice.service;

import java.util.Arrays;
import java.util.Scanner;

public class PracticeService { // 기능 제공 클래스
	Scanner sc = new Scanner(System.in);
	
	public void practice1() {
		int[] arr = new int[9];
		
		// arr[i] 일 때로 해서 값 대입해야함
		// 안 그러면 계산하기도 힘들고 출력할 때도 복잡함
		for (int i = 0; i < arr.length ; i++) {
			arr[i] = i + 1;
		
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		int sum = 0;
		for (int i = 0 ; i < arr.length ; i++ ) {
			if(i % 2 == 0) {
				sum += arr[i];
			}
		}
		System.out.println("짝수 번째 인덱스 합 : " + sum);
	}
	
	public void practice2() {
		int[] arr = new int[9];
		// 줄어들 변수 설정
		int num = 9;
		for (int i = 0; i < arr.length ; i ++) {
			arr[i] = num--;
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		int sum = 0;
		for (int i = 0 ; i < arr.length ; i++) {
			if (i % 2 == 1) {
				sum += arr[i];
			}
		}
		System.out.print("홀수 번째 인덱스 합 : " + sum);
	}
	
	public void practice3() {
		System.out.print("양의 정수 : ");
		int input = sc.nextInt();
		// 입력 받은 개수만큼 배열 크기 할당
		int[] arr = new int[input];
		for (int i = 0; i < input; i++) {
			arr[i] = i + 1;
			// 출력
			System.out.print(arr[i] + " ");
		}
	}
	
	public void practice4() {
	
		int[] arr = new int[5];  
		for (int i = 0 ; i < arr.length ; i++) {
			System.out.printf("입력 %d : ", i);
			arr[i] = sc.nextInt();
		}
		
		System.out.print("검색할 값 : ");
		int input = sc.nextInt();
		
		boolean flag = false;
		// for 문 안에 존재하지 않습니다. 넣으면 5번 출력됨
		for (int i = 0 ; i < arr.length ; i++) {
			if (arr[i] == input) {
				System.out.printf("인덱스 : %d",i);
				flag = true;
			}
		}
		if( !flag ) {
			System.out.println("일치하는 값이 존재하지 않습니다.");
		} 
	}
	
	public void practice5() {
		// 문자열 입력 받기
		System.out.print("문자열 : ");
		String str = sc.nextLine();
		
		// 입력 받은 문자열 빈 배열에 넣기
		char[] arr = new char[(int)(str.length())];
		for (int i = 0 ; i < str.length() ; i++) {
			arr[i] = str.charAt(i);
		}
		
		// 문자 입력 받기
		System.out.print("문자 : ");
		char ch = sc.next().charAt(0);
		// i 개수 셀 count 값
		int count = 0;
		System.out.printf("%s에 %c가 존재하는 위치(인덱스) : ", str, ch);
		for (int i = 0 ; i < arr.length ; i++) {
			if (arr[i] == ch ) {
				System.out.print(i + " ");
				count++;
			}
		}
		System.out.println();
		System.out.printf("%c 개수 : %d", ch, count);
		
	}
	
	public void practice6() {
		System.out.print("정수 : ");
		int input = sc.nextInt();
		
		// 배열 만들기
		int[] arr = new int[input];
		for(int i = 0 ; i < input ; i++) {
			System.out.printf("배열 %d번째 인덱스에 넣을 값 : ", i);
			arr[i] = sc.nextInt();
		}
		int sum = 0;
		for(int i = 0 ; i < input ; i++) {
			System.out.print(arr[i] + " ");
			sum += arr[i];
		}
		System.out.println();
		System.out.println("총 합 : " + sum);
	}
	
	public void practice7() {
		System.out.print("주민등록번호(-포함) : ");
		String str = sc.nextLine();
		// 주민등록번호만큼 길이의 배열
		char[] arr = new char[str.length()];
		for (int i = 0 ; i < str.length() ; i ++) {
			arr[i] = str.charAt(i);
			if (i > 7) {
				System.out.print("*");
				continue;
			}
			System.out.print(arr[i]);
		}
		
	}
	
	public void practice8() {
		int input;
		do {
			System.out.print("정수 : ");
			input = sc.nextInt();
			if (input < 3 || input % 2 != 1) {
				System.out.println("다시 입력하세요");
			}
		} while (input < 3 || input % 2 != 1);
		
		int[] arr= new int[input];
		
		int index = 1;
		
		for (int i = 0; i < input/2 ; i++) {
			arr[i] = index;
			index++;
		}
		// arr[i] i 값은 계속 늘어나야함
		// 위에 변수 설정
		for (int i = input/2 ; i < input; i++) {
			arr[i] = index;
			index--;
		}
		
		// 출력 ,
		for (int i = 0 ; i < input ; i ++) {
			System.out.print(arr[i]);
			if (i != input - 1) { // 마지막에만 출력 X
				System.out.print(", ");
			}
		}
	}
	
	public void practice9() {
		
		int[] arr = new int[10];
		System.out.print("발생한 난수 :");
		for (int i = 0 ; i < arr.length ; i++) {
			// 난수 1 ~ 10
			int random = (int)(Math.random()*10 + 1);
			arr[i] = random;
			System.out.print(" " + arr[i]);
		}
	}
	
	public void practice10() {
		
		int[] arr = new int[10];
		System.out.print("발생한 난수 :");
		for (int i = 0 ; i < arr.length ; i++) {
			int random = (int)(Math.random()*10 + 1);
			arr[i] = random;
			System.out.print(" " + arr[i]);
		}
		System.out.println();
		int max = arr[0];
		int min = arr[0];
		
		for (int i = 1 ; i < arr.length ; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
			if (arr[i] < min) {
				min = arr[i];
			}
		}
		System.out.printf("최대값 : %d\n", max);
		System.out.printf("최소값 : %d\n", min);
	}
	
	public void practice11() {
		
		int[] arr = new int[10];
		
		for(int i = 0 ; i < arr.length ; i++) {
			
			int random = (int)(Math.random()*10 +1);
			
			arr[i] = random;
			
			for(int j = 0 ; j < i; j++) {
				// i 반복 횟수만큼 j 늘어남
				if(random == arr[j]) {
					i--;
					break;
					// 검사하는 for 문을 종료하고 위로 올라가서 다시 난수 발생 시킴
				}
			}
		}
		for (int i = 0 ; i < arr.length ; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	public void practice12() {
		
		int[] arr = new int[6];
		
		for(int i = 0 ; i < arr.length ; i++) {
			
			int random = (int)(Math.random()*45 +1);
			
			arr[i] = random;
			
			for(int j = 0 ; j < i; j++) {
				// i 반복 횟수만큼 j 늘어남
				if(random == arr[j]) {
					i--;
					break;
					// 검사하는 for 문을 종료하고 위로 올라가서 다시 난수 발생 시킴
				}
			}
		}
		Arrays.sort(arr);
		
		for (int i = 0 ; i < arr.length ; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public void practice13() {
		System.out.print("문자열 : ");
		String str = sc.nextLine();
		
		char[] ch = new char[str.length()];
		
		System.out.print("문자열에 있는 문자 : ");
		
		for(int i = 0 ; i < str.length() ; i++) {
		
			
			ch[i] = str.charAt(i);
			
			System.out.print(ch[i]);
			if (i != str.length()-1) {
				System.out.print(", ");
			}
		}
		
		// 같은
		
//		char result = ch[0];
//		
//		for(int i = 0 ; i < ch.length ; i++) {
//			System.out.print(ch[i]);
//			if(ch[i] == ch[0]) {
//				
//			}
//		}
		
		
//		System.out.println();
		
		// 빈 배열에 ch[i] 하나씩 넣어주면서 중복된 게 있는지 판별
		// 중복 안 될 때만 출력 (이 때 카운트 올라감)
		// 문자 개수 출력
//		int count = 0;
//		
//		char[] result = new char[count];
//		boolean flag = false;
//		// 입력 받은 배열 길이만큼 반복
//		for(int i = 0 ; i < count ; i++) {
//			for (int j = 1 ; j < ch.length ; j++) {
//				if(result[i] != ch[j]) {
//					result[i] = ch[i];
//					count++;
//					flag = true;
//				}
//			}
//			if (!flag) {
//				System.out.println(result[i]);
//			}
//			if (i != result.length -1) {
//				System.out.print(", ");
//			}
//		}
		
//		for(int i = 0 ; i < ch.length ; i++) {
//			boolean flag = false;
//			
//			for(int j = 0 ; j < ch.length ; j++) {
//				if (ch[i] == result[j]) {
//					flag = true;
//					System.out.print(result[j]);
//				}
//			}
//			
//			if(!flag) {
//				count++;
//			}
//			
//			if (i != str.length()-1) {
//				System.out.print(", ");
//			}
//		}
//		System.out.println();
//		System.out.print("문자 개수 : " + count);
		
	}

	public void practice14() {

		System.out.print("배열의 크기를 입력하세요 : ");
		int input = sc.nextInt();
		// 입력한 크기만큼 배열 만들기
		String[] str = new String[input];
		
		for (int i = 1 ; i <= input ; i++) {
			System.out.printf("%d번째 문자열 : ",i);
			String text = sc.nextLine();
			System.out.println();
		}
	}
}
