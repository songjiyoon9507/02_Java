package com.hw4.controller;

import com.hw4.model.vo.Member;

public class MemberController {
	
	public static int SIZE = 10; // 최대 회원 수 = 10
	
	private int memberCount; // 현재 회원 수
	
	private Member[] mem = new Member[SIZE]; // 회원 객체 배열
	
	{
		mem[0] = new Member("user01", "pass01", "김유신", 20, 'M', "kim12@naver.com");
		mem[1] = new Member("user02", "pass02", "이순신", 60, 'M', "lee2@naver.com");
		mem[2] = new Member("user03", "pass03", "유관순", 17, 'F', "yo5@hanmail.net");
		mem[3] = new Member("user04", "pass04", "연개소문", 57, 'M', "yeon@gmail.com");
		mem[4] = new Member("user05", "pass05", "신사임당", 45, 'F', "shin@naver.com");
		memberCount = 5;
	}
	
	public int getMemberCount() {
		return memberCount;
	}
	
	// 호출한 곳에 자료형Member 배열 변수명 mem 돌려줌
	public Member[] getMem() {
		return mem;
	}
	
	public Member checkId(String userId) {
		// MemberMenu에서 Member m = mc.checkId(userId); 로 호출함
		// 매개 변수 userId 자료형 Member
		
		// 아이디로 검색된 결과를 담을 변수 초기화
		
		Member m = null;
		
		// 동일한 아이디가 존재하는 경우
		// m 에 대입해서 리턴 동일한 아이디 가진 mem
		// mem 은 여기서 만든 거 객체 배열 이름
		// Member[] mem = new Member[SIZE]
		
		// 반복횟수는 memberCount만큼 배열 크기만큼 돌 필요 없음
		// 만들 때마다 memberCount 올려줘야함
		for(int i = 0 ; i < memberCount ; i++) {
			if (mem[i].getUserId().equals(userId)) {
				m = mem[i];
			}
		}
		return m;
		// 이렇게 돌려보내면 아이디 같을 때는 mem[i]가 가고
		// 아이디 같은 게 없을 때는 null이 감(호출한 곳으로 돌아감)
		// 호출한 곳은 MemberMenu
		// 다시 MemberMenu로 돌아가서 호출한 곳 확인
	}
	
	public void insertMember(Member m) {
		// 아까 MemberMenu 에 insertMember 메소드 안에서 Member m 으로 checkId 호출함 매개변수는 userId
		// 지금은 insertMember 안에 새로운 멤버를 new 매개변수생성자로 생성해서 그걸 매개변수로
		// 보냄 Member m = 새로운 객체 생성
		
		// 매개 변수로 전달받은 회원정보를 mem 객체에 추가
		
		// 어떻게 넣을지 몰라서 답지 확인함
		mem[memberCount] = m;
		// memberCount 1 증가 시켜줘야함 mem 한명 늘었음
		memberCount++;
		
		// console 확인 결과 1번은 잘 작동함
	}
	
	public Member searchMember(int menu, String search) {
		
		// 검색된 회원 정보를 담을 변수 초기화
		Member searchMember = null;
		
		// 매개변수로 전달 받은 search 문자열을 menu 번호에 따라 searchMember 변수에 대입
		switch(menu) { // menu 번호에 따라 전달될 값 달라짐
		// 1. 아이디로 검색 search 가 아이디 값임
		case 1 : // search 를 아이디로 검색하고 searchMember 에 대입
			for(int i = 0 ; i < memberCount ; i++) {
				if (mem[i].getUserId().equals(search)) {
					searchMember = mem[i];
				}
			}
			break;
		case 2 : // 2. 이름으로 검색하기
			for(int i = 0 ; i < memberCount ; i++) {
				if (mem[i].getName().equals(search)) {
					searchMember = mem[i];
				}
			}
			break;
		case 3 : // 3. 이메일로 검색하기
			for(int i = 0 ; i < memberCount ; i++) {
				if (mem[i].getEmail().equals(search)) {
					searchMember = mem[i];
				}
			}
			break;
			
		default : break;
		
		}
		
		return searchMember;
		
	}
	
	public void updateMember(Member m, int menu, String update) {
		
		// userId로 검색해서 찾은 m
		switch(menu) {
		
		case 1 : m.setUserPwd(update); break;
		case 2 : m.setName(update); break;
		case 3 : m.setEmail(update); break;
		
		default : break;
		
		}
		
	}
	
	public void deleteMember(String userId) {
		// 매개변수로 전달받은 userId가 mem 에 존재하는 경우 해당 회원 삭제
		for(int i = 0 ; i < memberCount ; i++) {
			
			if(mem[i].getUserId().equals(userId)) {
				mem[i] = null;
				// 다음 인덱스 객체들의 정보를 한 칸씩 앞으로 이동 시킴
				for (int j = i ; j < memberCount ; j++) {
					// 비운 배열부터 차있던 배열까지
					// 10개가 다 찼을 때 지우면 오류 발생
					// 아래 문장 추가로 해결
					if(j == 9)break;
					mem[j] = mem[j+1];
					if(mem[j] == null) {
						break;
					}
				}
				memberCount--;
			}
			
		}
		
	}
	
	public Member[] sortIdAsc() {
		// 기존의 회원 객체 배열 (mem) 변경하지 않고 정렬된 결과만 보여주기
		// 기존 배열 복사해서 사용
		
		
		return null;
	}
	
	public Member[] sortDesc() {
		return null;
	}
	
	public Member[] sortAgeAsc() {
		return null;
	}
	
	public Member[] sortAgeDesc() {
		return null;
	}
	
	public Member[] sortGenderDesc() {
		return null;
	}
	
}
