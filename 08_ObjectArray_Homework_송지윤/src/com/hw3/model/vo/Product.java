package com.hw3.model.vo;

import com.hw3.controller.ProductController;

public class Product {
	private int pld; // 제품 번호
	private String pName; // 제품명
	private int price; // 제품 가격
	private double tax; // 제품 세금
	
	public int getPld() {
		return pld;
	}

	public void setPld(int pld) {
		this.pld = pld;
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

	public Product() {
		ProductController.count++;
	}

	public Product(int pld, String pName, int price, double tax) {
		
		this.pld = pld;
		this.pName = pName;
		this.price = price;
		this.tax = tax;
		
		ProductController.count++;
	}
	
	public String information() {
		return null;
	}
	
}
