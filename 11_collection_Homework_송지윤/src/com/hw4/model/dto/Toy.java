package com.hw4.model.dto;

public class Toy implements Comparable<Toy> {
	// 장난감 속성
	private String toyName; // 장난감 이름
	private int toyPrice; // 장난감 가격
	private String toyColor; // 장난감 색상
	private int useAge; // 사용연령
	private int date; // 제조년월일
	private String material; // 재료
	
	public String getToyName() {
		return toyName;
	}
	public void setToyName(String toyName) {
		this.toyName = toyName;
	}
	public int getToyPrice() {
		return toyPrice;
	}
	public void setToyPrice(int toyPrice) {
		this.toyPrice = toyPrice;
	}
	public String getToyColor() {
		return toyColor;
	}
	public void setToyColor(String toyColor) {
		this.toyColor = toyColor;
	}
	public int getUseAge() {
		return useAge;
	}
	public void setUseAge(int useAge) {
		this.useAge = useAge;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	
	public Toy() {}
	
	public Toy(String toyName, int toyPrice, String toyColor, int useAge, int date, String material) {
		this.toyName = toyName;
		this.toyPrice = toyPrice;
		this.toyColor = toyColor;
		this.useAge = useAge;
		this.date = date;
		this.material = material;
	}
	@Override
	public String toString() {
		return "이름 : " + toyName + " / 가격 : " + toyPrice + " / 색상 : " + toyColor + " / 사용가능연령 : " + useAge
				+ " / 제조년월일 : " + date + " / 재료 : " + material;
	}
	
	@Override
	public int compareTo(Toy other) {
		return this.date - other.date;
	}
	
	

	
}
