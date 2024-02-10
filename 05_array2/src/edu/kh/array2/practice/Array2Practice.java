package edu.kh.array2.practice;

import java.util.Arrays;
import java.util.Scanner;

public class Array2Practice { // 기능 작성 클래스
	
	Scanner sc = new Scanner(System.in);
	
	public void practice1() {
		
		String[][] str = new String[3][3];
		
		for(int row = 0 ; row < str.length ; row++) {
			for(int col = 0 ; col < str[row].length ; col++) {
				System.out.printf("(%d, %d)", row, col);
			}
			System.out.println();
		}
	}
	
	public void practice2() {
		
		int[][] str = new int[4][4];
		int count = 1;
		for(int row = 0 ; row < str.length ; row++) {
			for(int col = 0 ; col < str[row].length ; col++) {
				str[row][col] = count++;
				System.out.printf("%2d ",str[row][col]);
			}
			System.out.println();
		}
	}

	public void practice3() {
		
		int[][] str = new int[4][4];
		int count = str.length*str.length + 1;
		
		for(int row = 0 ; row < str.length ; row++) {
			for(int col = 0 ; col < str[row].length ; col++) {
				str[row][col] = count--;
				System.out.printf("%2d ",count);
			}
			System.out.println();
		}
	}

	public void practice4() {
		
		int[][] arr = new int[4][4];
		
		// 0행 합 row[0][0]
		
		int total = 0;
		int colSum = 0;
		int rowSum = 0;
		for(int row = 0 ; row < arr.length ; row++) {
			
			for(int col = 0 ; col < arr[row].length ; col++) {
				
				int random = (int)(Math.random()*10 +1);
				if(col != arr[row].length -1 && row != arr.length-1) {
					arr[row][col] = random;
//					rowSum += arr[row][col];
					rowSum += arr[row][col];
					System.out.printf("%2d ",arr[row][col]);
				}
								
//				if(col == arr[row].length) {
//					System.out.printf("%2d",colSum);
//					break;
//				}
				
				
				
			}			
//			for(int i = 0 ; i <arr.length ; i++) {
//				
//			}
			System.out.printf("%2d ",rowSum);
//			for(int i = 0; i<arr.length;i++) {
//				
//			}
			System.out.println();
		}
	}

	public void practice5() {
		int row = 0;
		int col = 0;
		
		while(row < 1 || row > 10 || col < 1 || col > 10) {
			System.out.print("행 크기 : ");
			row = sc.nextInt();
			System.out.print("열 크기 : ");
			col = sc.nextInt();
			if(row >= 1 && row <= 10 && col >= 1 && col <= 10) continue;
			System.out.println("반드시 1~10 사이의 정수를 입력해야 합니다.");
		}
		char[][] arr = new char[row][col];
		
		for(int i = 0 ; i < row ; i++) {
			for(int j = 0 ; j < col ; j++) {
				char random = (char)(Math.random()*26+65);
				arr[i][j] = random;
				System.out.printf("%c ", arr[i][j]);
			}
			System.out.println();
		}
	}
	
	public void practice6() {
		System.out.print("행의 크기 : ");
		int row = sc.nextInt();
		char ch = 'a';
		char[][] arr = new char[row][];
		
		for(int i = 0; i < arr.length ; i++) {
			System.out.printf("%d열의 크기 : ",i);
			int col = sc.nextInt();
			arr[i] = new char[col];
		}
		//System.out.println(Arrays.deepToString(arr));
		for(int i = 0; i < arr.length ; i++) {
			for(int j = 0; j < arr[i].length ; j++) {
				arr[i][j] = ch++;
				System.out.printf("%c ",arr[i][j]);
			}
			System.out.println();
		}
	}

	public void practice4_1() {
		
		int[][] arr = new int[4][4];
		
		int rowSum = arr.length-1; // 3
		int colSum = arr[0].length-1; // 3
		
		for(int i = 0 ; i < rowSum ; i++) {
			for(int j = 0 ; j < colSum ; j++) {
				arr[i][j] = (int)(Math.random()*10+1);
				
				arr[i][3] += arr[i][j];
				arr[3][j] += arr[i][j];
			}
		}
		
		for(int i = 0 ; i < arr.length ; i++) {
			for(int j = 0 ; j < arr[i].length; j++) {
				System.out.printf("%3d ", arr[i][j]);
	
				// 열의 합과 행의 합 의 총합 출력
				
				if(i == rowSum || j == colSum) {
					arr[rowSum][colSum] += arr[i][j];
				}
			}
			System.out.println();
		}
		
	}
	
	

}
