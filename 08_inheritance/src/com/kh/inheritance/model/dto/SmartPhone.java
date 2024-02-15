package com.kh.inheritance.model.dto;

public class SmartPhone extends Phone {
	private String operatingSustem; // OS
	private int storageCapacity; // 스토리지공간크기
	
	public String getOperatingSustem() {
		return operatingSustem;
	}

	public void setOperatingSustem(String operatingSustem) {
		this.operatingSustem = operatingSustem;
	}

	public int getStorageCapacity() {
		return storageCapacity;
	}

	public void setStorageCapacity(int storageCapacity) {
		this.storageCapacity = storageCapacity;
	}

	public SmartPhone() {}

	public SmartPhone(String brand, String model, int year, int price, String operatingSustem, int storageCapacity) {
		super(brand, model, year, price);
		this.operatingSustem = operatingSustem;
		this.storageCapacity = storageCapacity;
	}
	
	@Override
	public void printInfo() {
		// 자동완성하면 자동으로 생김
		super.printInfo();
		System.out.println("Operating System : " + operatingSustem);
		System.out.println("Storage Capacity : " + storageCapacity + "GB");	
	}
}
