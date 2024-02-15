package com.hw1.model.vo;

public class Student extends Person {
	private int grade; // 학년
	private String major; // 전공
	
	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public Student() {}

	public Student(String name, int age, double height, double weight, int grade, String major) {
		super(age, height, weight);
		// Person 의 protected 필드
		this.name = name;
		this.grade = grade;
		this.major = major;
	}
	
	@Override
	public String information() {
		return super.information()
				+ String.format(" / 학년 : %d / 전공 : %s", grade, major);
	}
}
