package edu.kh.array2.practice;

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
		
		
		
		int colSum = 0;
		int total = 0;
		for(int row = 0 ; row < arr.length ; row++) {
			int rowSum = 0;
			
			for(int col = 0 ; col < arr[row].length ; col++) {
				
				int random = (int)(Math.random()*10 +1);
				if(col != arr[row].length -1 && row != arr.length-1) {
					arr[row][col] = random;
					rowSum += arr[row][col];
					System.out.printf("%2d ",arr[row][col]);
				}
								
				if(col == arr[row].length -1) {
					System.out.printf("%2d",rowSum);
				}
				

				
				
				
				
			}
			
			System.out.println();
		}
	}



}
