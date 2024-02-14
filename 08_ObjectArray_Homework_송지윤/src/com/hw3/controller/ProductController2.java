package com.hw3.controller;

import java.util.Scanner;

import com.hw3.model.vo.Product;
import com.hw3.model.vo.Product2;

public class ProductController2 {
	
	private Product2[] pro = null;
	
	public static int count = 0;
	
	// ~(틸드) 표시 (default) 는 아예 생략
	Scanner sc = new Scanner(System.in);
	
	// 초기화 블록 이용
	{
		pro = new Product2[10];
	}
	
	public void mainMenu() {
		
		int num = 0;
		
		do {
			System.out.println("===== 제품 관리 메뉴 =====");
			System.out.println();
			System.out.println("1. 제품 정보 추가");
			System.out.println("2. 제품 전체 조회");
			System.out.println("3. 제품 정보 삭제");
			System.out.println("4. 제품 정보 수정");
			System.out.println("0. 프로그램 종료");
			System.out.println();
			System.out.print("번호 입력 : ");
			num = sc.nextInt();
			
			switch(num) {
			
				case 1 : productInput(); break;
					
				case 2 : productPrint(); break;
					
				case 3 : productDelete(); break;
					
				case 4 : updateProduct(); break;
				
				case 0 : System.out.println("프로그램 종료"); break;
					
				default : System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
			
		} while(num != 0);
		
	}
	
	public void productInput() {
		
			// 빈 배열에 입력 받은 값 넣기
			System.out.print("제품 번호 : ");
			int pId = sc.nextInt();
			
			sc.nextLine(); // 입력버퍼에 있는 개행문자 제거
				
			System.out.print("제품명 : ");
			String pName = sc.nextLine();
				
			System.out.print("제품 가격 : ");
			int price = sc.nextInt();
			
			sc.nextLine();
				
			System.out.print("제품 세금 : ");
			double tax = sc.nextDouble();
			
			// 제품 추가할 때마다 count 늘어남 index 넘버도 늘어남
			pro[count] = new Product2(pId, pName, price, tax);
		
	}
	
	public void productPrint() {
		
		for(int i = 0 ; i < count ; i++) {
			System.out.println( pro[i].information());

		}	
		
	}
	
	public void productDelete() {
		
		System.out.println("========제품 정보 삭제 메뉴========");
		System.out.print("삭제할 제품의 제품번호 입력 : ");
		int inputNum = sc.nextInt();
		
		for(int i = 0; i < pro.length ; i++) {
			System.out.println(pro[i].getPId());
			
			if(inputNum == pro[i].getPId()) {
				System.out.print("정말 삭제하시겠습니까? (y/n)");
				
				char answer = sc.next().charAt(0);
				if(answer == 'y' || answer == 'Y') {
					pro[i] = null;
					System.out.println("제품 정보가 삭제되었습니다.");
					// break 안 써주면 에러 뜸 다시 for 문을 돌아서
					count--;
					break;
				}
			}
		}
	}
	
	public void updateProduct() {
		System.out.println("==========제품 정보 수정 메뉴==========");
		System.out.print("수정할 제품의 제품번호 입력 : ");
		int inputNum = sc.nextInt();
		
		for(int i = 0 ; i < pro.length ; i++) {
			if(inputNum == pro[i].getPId()) {
				
				System.out.print("수정할 제품 번호 : ");
				int pld = sc.nextInt();
				pro[i].setPId(pld);
				sc.nextLine();
				
				System.out.print("수정할 제품명 : ");
				String pName = sc.nextLine();
				pro[i].setpName(pName);
				
				System.out.print("수정할 제품 가격 : ");
				int price = sc.nextInt();
				pro[i].setPrice(price);
				sc.nextLine();
				
				break;
			}
		}
	}
	
}
