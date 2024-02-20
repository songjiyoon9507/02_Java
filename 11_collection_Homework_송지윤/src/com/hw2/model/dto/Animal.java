package com.hw2.model.dto;

public abstract class Animal {
	
	protected String name;
	
	public Animal() {}

	public Animal(String name) {
		this.name = name;
	}
	
	// 추상 메서드를 가지려면 추상 클래스여야함
	public abstract void sound();
}
