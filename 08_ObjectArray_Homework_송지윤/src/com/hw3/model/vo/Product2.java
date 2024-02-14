package com.hw3.model.vo;

import com.hw3.controller.ProductController2;

public class Product2 {
	private int pId; // 제품 번호
	private String pName; // 제품명
	private int price; // 제품 가격
	private double tax; // 제품 세금
	
	public int getPId() {
		return pId;
	}

	public void setPId(int pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public Product2() {
		// static 변수 부르는 법
		// 클래스명.변수명
		ProductController2.count++;
	}

	public Product2(int pId, String pName, int price, double tax) {
		
		this.pId = pId;
		this.pName = pName;
		this.price = price;
		this.tax = tax;
		
		ProductController2.count++;
	}
	
	public String information() {
		return "제품번호 : " + pId + ", 제품명 : " + pName +
				", 가격 : " + price + ", 세금 : " + tax;
	}
	
}
