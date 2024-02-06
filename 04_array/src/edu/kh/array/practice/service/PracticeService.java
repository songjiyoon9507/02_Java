package edu.kh.array.practice.service;

import java.util.Arrays;

public class PracticeService { // 기능 제공 클래스
	
	public void practice1() {
		int[] arr = new int[9];
		
		
		for (int i = 0; i < arr.length ; i++) {
			arr[i] = i + 1;
		
			System.out.print(arr[i] + " ");
		}
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
		int num = 9;
		
		for (int i = 0; i < arr.length ; i ++) {
			arr[i] = num--;
			System.out.print(arr[i] + " ");
		}
		
	}
	
	
	
	
	
}
