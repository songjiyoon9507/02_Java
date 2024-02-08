package edu.kh.oop.practice.model.service;

import edu.kh.oop.practice.model.vo.Hero;

public class HeroService {
	
	public void practice() {
		
		Hero h1 = new Hero();
		
		h1.setNickName("송지윤");
		h1.setJob("취업준비생");
		h1.setHp(100);
		h1.setMp(100);
		h1.setLevel(1);
		h1.setExp(0);
		
		Hero h2 = new Hero();
		
		h2.setNickName("송지윤's mother");
		h2.setJob("마법사");
		h2.setHp(500);
		h2.setMp(500);
		h2.setLevel(50);
		h2.setExp(450);
		
		System.out.printf("닉네임 : %s\n", h1.getNickName());
		System.out.printf("직업 : %s\n", h1.getJob());
		System.out.printf("HP : %d\n", h1.getHp());
		System.out.printf("MP : %d\n", h1.getMp());
		System.out.printf("레벨 : %d\n", h1.getLevel());
		System.out.printf("경험치 : %d\n", h1.getExp());
		System.out.println();
		
		h1.attack(100);
		h1.attack(100);
		h1.attack(100);
		h1.attack(100);
		h1.attack(100);
		h1.attack(100);
		
		h1.magicJump();
		h1.magicJump();
		h1.magicJump();
		h1.magicJump();
		h1.magicJump();
		h1.magicJump();
		h1.magicJump();
		h1.magicJump();
		h1.magicJump();
		h1.magicJump();
		h1.magicJump();
		h1.magicJump();
		h1.magicJump();
		
		System.out.println();
		
		System.out.printf("닉네임 : %s\n", h2.getNickName());
		System.out.printf("직업 : %s\n", h2.getJob());
		System.out.printf("HP : %d\n", h2.getHp());
		System.out.printf("MP : %d\n", h2.getMp());
		System.out.printf("레벨 : %d\n", h2.getLevel());
		System.out.printf("경험치 : %d\n", h2.getExp());
		
		System.out.println();
		
		h2.attack(600);
		h2.magicJump();
		
	}
}
