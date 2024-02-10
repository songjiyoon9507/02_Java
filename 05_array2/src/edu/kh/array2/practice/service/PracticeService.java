package edu.kh.array2.practice.service;


import java.util.Arrays;
import java.util.Scanner;

public class PracticeService { // 기능 제공 클래스
	
	Scanner sc = new Scanner(System.in);
	
	public void practice7() {
		String[] students = {"강건강", "남나나", "도대담", "류라라", "문미미", "박보배",
				"송성실", "윤예의", "진재주", "차천축", "피풍표", "홍하하"};
		
		String[][] str = new String[3][2];
		
		int num = 0;
		for(int i = 1 ; i <= 2 ; i++) {
			System.out.printf("==%d분단==\n",i);
			for(int row = 0 ; row < str.length; row++) {
				for(int col = 0 ; col < str[row].length ; col++) {
					str[row][col] = students[num];
					num++;
					System.out.printf("%s ",str[row][col]);
				}
				System.out.println();
			}
		}
	}
	
	public void practice7_1() {
		String[] students = {"강건강", "남나나", "도대담", "류라라", "문미미", "박보배",
				"송성실", "윤예의", "진재주", "차천축", "피풍표", "홍하하"};
		String[][] str1 = new String[3][2];
		String[][] str2 = new String[3][2];
		int num = 0;
		System.out.println("==1분단==");
		for(int row = 0 ; row < str1.length; row++) {
			for(int col = 0 ; col < str1[row].length ; col++) {
				str1[row][col] = students[num];
				num++;
				System.out.printf("%s ",str1[row][col]);
			}
			System.out.println();
		}
		System.out.println("==2분단==");
		for(int row = 0 ; row < str2.length; row++) {
			for(int col = 0 ; col < str2[row].length ; col++) {
				str2[row][col] = students[num];
				num++;
				System.out.printf("%s ",str2[row][col]);
			}
			System.out.println();
		}
	}
	
	public void practice8() {
		String[] students = {"강건강", "남나나", "도대담", "류라라", "문미미", "박보배",
				"송성실", "윤예의", "진재주", "차천축", "피풍표", "홍하하"};
		
		String[][] str = new String[3][2];
	
		int num = 0;
		for(int i = 1 ; i <= 2 ; i++) {
			System.out.printf("==%d분단==\n",i);
			for(int row = 0 ; row < str.length; row++) {
				for(int col = 0 ; col < str[row].length ; col++) {
					str[row][col] = students[num];
					num++;
					System.out.printf("%s ",str[row][col]);
				}
				System.out.println();
			}
		}
		System.out.println("=====================================");
		System.out.print("검색할 학생 이름을 입력하세요 : ");
		String name = sc.next();
		int num2 = 0;
		for(int i = 1 ; i <= 2 ; i++) {
			// System.out.printf("==%d분단==\n",i);
			for(int row = 0 ; row < str.length; row++) {
				for(int col = 0 ; col < str[row].length ; col++) {
					str[row][col] = students[num2];
					num2++;
					//System.out.println(num);
					//System.out.println(str[row][col]);
					if(str[row][col].equals(name)) {
						int s = 0;
						if (num2 <= 6) {s=1;}
						if (num2 >= 7) {s=2;}
						int n = 0;
						if (num2 == 1 || num2 == 2 || num2 == 7 || num2 == 8) {n=1;}
						if (num2 == 3 || num2 == 4 || num2 == 9 || num2 == 10) {n=2;}
						if (num2 == 5 || num2 == 6 || num2 == 11 || num2 ==12) {n=3;}
						String d = "";
						if (num2 % 2 == 0) {d = "오른쪽";}
						if (num2 % 2 == 1) {d = "왼쪽";}
						System.out.printf("검색하신 %s 학생은 %d분단 %d번째 줄 %s에 있습니다.", name, s, n, d);
					}
				}
			}
		}	
	}

	public void practice9() {
		String[][] str = new String[6][6];
		for(int i = 0 ; i < str.length-1 ; i++) {
			str[0][i+1] = i + "";
			str[i+1][0] = i + "";
		}
		// System.out.println(Arrays.deepToString(str));
		
		int row = 0;
		int col = 0;
		
		while(true) {
			System.out.print("행 인덱스 입력 : ");
			row = sc.nextInt();
			
			if(row < 0 || row > 4) {
				System.out.println("0~4사이 인덱스를 입력해주세요.");
				continue; // 입력 안하면 다른 수를 넣어도 열 인덱스 입력 뜸
				// 브레이크를 건너 뜀 while 문 다시 반복
			}
			
			break;
		}
		
		while(true) {
			System.out.print("열 인덱스 입력 : ");
			col = sc.nextInt();
			
			if(col < 0 || col > 4) {
				System.out.println("0~4사이 인덱스를 입력해주세요");
				continue;
			}
			break;
		}
		
		for(int i = 0 ; i < str.length ; i++) {
			for(int j = 0 ; j < str[i].length ; j++) {
				
				if(i == row && j == col) {
					str[i + 1][j + 1] = "X";
				}
				
				// 안 쓰면 빈칸이 다 null 로 나옴
				if(str[i][j] == null) {
					str[i][j] = " ";
				}
				
				System.out.print(str[i][j] + " "); // " " 안 붙이면 띄어쓰기가 없어짐
			}
			System.out.println();
		}
		
	}

	public void practice10() {
		String[][] str = new String[6][6];
		for(int i = 0 ; i < str.length-1 ; i++) {
			str[0][i+1] = i + "";
			str[i+1][0] = i + "";
		}
		// System.out.println(Arrays.deepToString(str));
		
		int row = 0;
		int col = 0;
		
		
		while(true) {
			while(true) {
				System.out.print("행 인덱스 입력 : ");
				row = sc.nextInt();
				
				if(row == 99) {
					break;
				}
				
				if(row < 0 || row > 4) {
					System.out.println("0~4사이 인덱스를 입력해주세요.");
					continue; // 입력 안하면 다른 수를 넣어도 열 인덱스 입력 뜸
					// 브레이크를 건너 뜀 while 문 다시 반복
				}
				
				break;
			}
			
			if(row == 99) {
				System.out.println("프로그램 종료");
				break;
			}
			
			while(true) {
				System.out.print("열 인덱스 입력 : ");
				col = sc.nextInt();
				
				if(col < 0 || col > 4) {
					System.out.println("0~4사이 인덱스를 입력해주세요");
					continue;
				}
				break;
			}
			
			for(int i = 0 ; i < str.length ; i++) {
				for(int j = 0 ; j < str[i].length ; j++) {
					
					if(i == row && j == col) {
						str[i + 1][j + 1] = "X";
					}
					
					// 안 쓰면 빈칸이 다 null 로 나옴
					if(str[i][j] == null) {
						str[i][j] = " ";
					}
					
					System.out.print(str[i][j] + " "); // " " 안 붙이면 띄어쓰기가 없어짐
				}
				System.out.println();
			}
		}
		
	}
	
}
