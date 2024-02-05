package edu.kh.control.practice;

import java.util.Scanner;

public class LoopPractice {
	Scanner sc = new Scanner(System.in);
	
	public void practice1() {
		
		System.out.print("1이상의 숫자를 입력하세요 : ");
		int input = sc.nextInt();
		
		if(input < 1) {
			System.out.println("1 이상의 숫자를 입력해주세요.");
		} else { // 1 이상 수
			for(int i = 1 ; i <= input ; i++) {
				System.out.print(i + " ");
			}		
		}
	}

	public void practice2() {
		
		System.out.print("1이상의 숫자를 입력하세요 : ");
		int input = sc.nextInt();
		
		if(input < 1) {
			System.out.println("1 이상의 숫자를 입력해주세요.");
		} else { // 1 이상 수
			for(int i = input ; i >= 1 ; i--) {
				System.out.print(i + " ");
			}		
		}
	}
	
	public void practice3() {
		System.out.print("정수를 하나 입력하세요 : ");
		int input = sc.nextInt();
		int sum = 0;
		
		for (int i = 1 ; i <= input ; i++) {
			sum += i;
			System.out.printf("%d ",i);
			if (i == input) break;
			System.out.print("+ ");
		}
		System.out.print("= " + sum);
	}
	
	public void practice4() {
		
		System.out.print("첫 번째 숫자 : ");
		int num1 = sc.nextInt();
		
		System.out.print("두 번째 숫자 : ");
		int num2 = sc.nextInt();
		
		if (num1 < 1 || num2 < 1) {
			System.out.println("1 이상의 숫자를 입력해주세요.");
		} else { // 둘 다 1 이상 수
			
			if (num1 >= num2) {
				for (int i = num2 ; i <= num1 ; i++) {
					System.out.print(i + " ");
				}
			} else {
				for(int j = num1 ; j <= num2 ; j++)
				System.out.print(j + " ");
			}
		}
	}
	
	public void practice5() {
		
		System.out.print("숫자 : ");
		int dan = sc.nextInt();
		
		System.out.printf("===== %d단 =====\n",dan);
		for(int i = 1; i <= 9; i++) {
			System.out.printf("%d * %d = %2d\n", dan, i, dan*i);
		}
	}
	
	public void practice6() {
		System.out.print("숫자 : ");
		int dan = sc.nextInt();
		
		if (dan < 2 || dan > 9) {
			System.out.println("2~9 사이 숫자만 입력해주세요.");
		} else {
			for(int j = dan ; j <=9 ; j++) {
				System.out.printf("===== %d단 =====\n", j);
				for(int i = 1 ; i <= 9 ; i++) {
					System.out.printf("%d * %d = %2d\n", j, i, j*i);
				}
			}
		}
	}
	
	public void practice7() {
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		String arr = "";
		
		for(int i = 1 ; i <= input ; i++) {
			arr += "*";
			System.out.println(arr);
		}
	}
	
	public void practice7_1() {
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		for(int i = 1; i <= input ; i++) {
			for(int j = 1; j <= i ; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public void practice8() {
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		for(int i = input ; i >= 1 ; i--) {
			for(int j = 1 ; j <= i ; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public void practice9() {
		System.out.print("정수 입력 : ");
		int line = sc.nextInt();
		
		int star = 1;
		int space = line-star;
		
		// 줄 수만큼 반복
		for (int i = 1; i <= line; i++) {
			// 공백 먼저 처음에 line-star 만큼 찍혀야함
			for (int j = 1 ; j <= space ; j ++) {
				System.out.print(" ");
			}
			// 별 찍어야함
			for (int j = 1 ; j <= star ; j++) {
				System.out.print("*");
			}
			// 찍을 때마다 공백은 하나씩 줄고
			// 별은 늘어야함
			// 한 줄 찍을 때마다
			space--;
			star++;
			System.out.println();
		}
	}
	
	public void practice10() {
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		// 늘어나기 반복 입력받은 수만큼
		for(int i = 1; i <= input ; i++) {
			for (int j = 1; j <= i ; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		// 줄어들기는 입력받은 수 -1만큼 반복
		for(int i = input-1; i >= 1 ; i--) {
			for (int j = 1 ; j <= i  ; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public void practice11() {
		System.out.print("정수 입력 : ");
		int line = sc.nextInt();
		int star = 1;
		int space = line-star;
		// line 수만큼 반복
		for (int i = 1; i <= line; i++) {
			// 왼쪽 공백
			for (int j = 1; j <= space ; j++) {
				System.out.print(" ");
			}
			// 가운데 별
			for (int j = 1; j <= star ; j++) {
				System.out.print("*");
			}
			// 오른쪽 공백 (왼쪽이랑 똑같음)
			for (int j = 1; j <= space ; j++) {
				System.out.print(" ");
			}
			star += 2;
			space--;
			System.out.println();
		}
	}
	
	public void practice12() {
		// 5줄
		// 반복 규칙
		// 첫번째 줄 마지막 줄은 줄수만큼 찍힘
		System.out.print("정수 입력 : ");
		int line = sc.nextInt();
		// 위 아래 두 줄 빼고 가운데는 양 끝만
		// line - 2
		// 위
		for (int i = 1; i <= line ; i++) {
			System.out.print("*");
		}
		System.out.println();
		// 가운데
		// 가운데 줄 반복은 line - 2
		for (int i = 1; i <= line-2 ; i ++) {
			System.out.print("*");
			for(int j = 1; j <= line-2 ; j++) {
				System.out.print(" ");
			}
			System.out.print("*");
			System.out.println();
		}
		
		// 아래
		for (int i = 1; i <= line ; i++) {
			System.out.print("*");
		}
		
	}
	
	public void practice13() {
		System.out.print("자연수 하나를 입력하세요 : ");
		int input = sc.nextInt();
		int count = 0;
		if(input > 0 && input % 1 == 0) { //자연수
			for (int i = 1 ; i <= input; i++) {
				if(i % 2 == 0 || i % 3 == 0) {
					System.out.printf("%d ",i);
				}
				if (i % 2 == 0 && i % 3 ==0) {
					count++;
				}
			}
			System.out.println();
			System.out.println("count : "+ count);
		} else {
			System.out.println("자연수를 입력해주세요");
		}
	}
	
}
