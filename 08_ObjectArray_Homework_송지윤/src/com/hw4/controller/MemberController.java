package com.hw4.controller;

import com.hw4.model.vo.Member;

public class MemberController {
	
	public static int SIZE = 10; // 최대 회원 수 = 10
	
	private int memberCount; // 현재 회원 수
	
	private Member[] mem = new Member[SIZE]; // 회원 객체 배열
	
	public int getMemberCount() {
		return memberCount;
	}
	
	public Member[] getMem() {
		return mem;
	}
	
	public Member checkId(String userId) {
		// 동일한 아이디가 존재하는 경우
//		for(int i = 0 ; i < mem.length ; i++) {
//			if (mem[i].getName().equals(userId)) {
//				return userId;
//			} else {
//				return null;
//			}
//		}
		return null;
	}
	
	public void insertMember(Member m) {
		
	}
	
	public Member searchMember(int menu, String search) {
		return null;
	}
	
	public void updateMember(Member m, int menu, String update) {
		
	}
	
	public void deleteMember(String userId) {
		
	}
	
	public Member[] sortIdAsc() {
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
