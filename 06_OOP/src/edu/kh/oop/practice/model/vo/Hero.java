package edu.kh.oop.practice.model.vo;

public class Hero {
	
	// 속성
	// 필드 == 멤버 변수
	private String nickName;
	private String job;
	private int hp;
	private int mp;
	private int level;
	private int exp;
	
	// 기능
	// alt shift s 단축키
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getMp() {
		return mp;
	}
	public void setMp(int mp) {
		this.mp = mp;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	
	public void attack(int exp2) { // 500 들어오면
		System.out.printf("%s 은/는 공격을 했다!\n", nickName);
		// this.exp 쓰면 위에 있는 멤버 변수 exp 말하는 거
		exp += exp2; // 기존 경험치에 500 더함
		System.out.printf("현재 경험치 : %d\n", exp);
		int x = exp;
		if (exp > 500) { // 기존 경험치가 500 넘으면
			x = exp/500; // 몫만큼 level up
			level += x;
			System.out.printf("%s의 레벨이 %d 올랐습니다.\n", nickName, x);
			System.out.printf("%s님의 현재 레벨 : %d\n", nickName, level);
			exp = exp%500;
			System.out.printf("경험치 : %d\n", exp);
		}
	}
	
	public void magicJump() {
		if (mp <= 0) {
			System.out.println("더 이상 매직 점프할 수 없어요!");
		} else {
			System.out.printf("%s의 점프!\n", nickName);
			mp -= 10;
		}
	}
	
}
