package com.hw2.model.dto;

public abstract class Person {
	
	protected String id; // 고유번호
	protected String name; // 이름
	
	public Person(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public abstract String getInfo();
}
