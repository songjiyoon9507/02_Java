package com.kh.inheritance.model.dto;

public class BasicPhone extends Phone {
	
	private boolean hasPhysicalKeyboard; // 물리적 키보드 유무
	
	public boolean isHasPhysicalKeyboard() {
		return hasPhysicalKeyboard;
	}

	public void setHasPhysicalKeyboard(boolean hasPhysicalKeyboard) {
		this.hasPhysicalKeyboard = hasPhysicalKeyboard;
	}

	public BasicPhone() {}
	
	// alt + shift + s + field + invoke 에 아래 화살표 눌러서 선택하면 자동으로 완성됨
	public BasicPhone(String brand, String model, int year, int price, boolean hasPhysicalKeyboard) {
		super(brand, model, year, price);
		this.hasPhysicalKeyboard = hasPhysicalKeyboard;
	}
	
	public void checkKeyboard() {
		// 부모 클래스 가져오는 방법
		super.printInfo();
		if (hasPhysicalKeyboard/* == true */) {
			System.out.println("이 휴대폰은 물리적 키보드가 있습니다.");
		} else {
			System.out.println("이 휴대폰은 물리적 키보드가 없습니다.");
		}
	}
	
}
