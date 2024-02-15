package com.hw4.view;

import java.util.Scanner;

import com.hw4.controller.MemberController;

public class MemberMenu {
	
	private MemberController mc = new MemberController();
	
	Scanner sc = new Scanner(System.in);
	
	public void mainMenu() {
		
		int menuNum = 0;
		
		do {
			
			System.out.println("===== 회원 관리 메뉴 =====");
			System.out.println("1. 신규 회원 등록");
			System.out.println("2. 회원 정보 검색");
			System.out.println("3. 회원 정보 수정");
			System.out.println("4. 회원 정보 삭제");
			System.out.println("5. 회원 정보 출력");
			System.out.println("6. 회원 정보 정렬");
			System.out.println("0. 프로그램 종료");
			System.out.print("메뉴 선택 >> ");
			menuNum = sc.nextInt();
			
			switch(menuNum) {
				case 1 : insertMember(); break;
				case 2 : searchMember(); break;
				case 3 : updateMember(); break;
				case 4 : deleteMember(); break;
				case 5 : printAllMember(); break;
				case 6 : sortMember(); break;
				case 0 : 
					System.out.println("프로그램 종료");
					break;
			}
			
		} while(menuNum != 0);
		
	}
	
	public void insertMember() {
//		// 1. 현재 회원 수 (memberCount) 가 최대 회원 수 (SIZE)를 넘어설 경우 return
//		if (mc.getMemberCount() > mc.SIZE) {
//			return;
//		}
//		
//		// 2. 아이디를 입력 받아 MemberController의 checkId() 메소드로 전달 >> 결과값
//		
//		System.out.print("아이디 입력 : ");
//		String userId = sc.next();
//		
//		mc.checkId(userId);
//		
//		System.out.print("비밀번호 입력 : ");
//		String userPwd = sc.next();
//		
//		System.out.print("이름 입력 : ");
//		String name = sc.next();
//		
//		System.out.print("나이 입력 : ");
//		int age = sc.nextInt();
//		sc.nextLine();
//		
//		System.out.print("성별 입력 : ");
//		char gender = sc.nextLine().charAt(0);
//		
//		System.out.println("이메일 입력 : ");
//		String email = sc.nextLine();
	
	}
	
	public void searchMember() {}
	
	public void updateMember() {}
	
	public void deleteMember() {}
	
	public void printAllMember() {}
	
	public void sortMember() {}
}
