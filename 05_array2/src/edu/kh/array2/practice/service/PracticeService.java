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
		int col = 0;
		int row = 0;
		for(int i = 0 ; i < str.length ; i++) {
				System.out.println(col);
				col++;			
			for(int j = 0 ; j < str[i].length ; j++) {
				if (col == 1) {
					System.out.print(j);
				}

			}
		}
		
	}


	
	
	
}
