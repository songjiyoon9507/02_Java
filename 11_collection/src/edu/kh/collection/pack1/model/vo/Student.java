package edu.kh.collection.pack1.model.vo;

public class Student implements Comparable<Student> {
	
	// 필드
	private String name; // 이름
	private int age; // 나이
	private String region; // 지역
	private char gender; // 성별
	private int score; // 점수
	
	// 기본생성자
	public Student() {}
	
	// 매개변수 생성자
	public Student(String name, int age, String region, char gender, int score) {
		this.name = name;
		this.age = age;
		this.region = region;
		this.gender = gender;
		this.score = score;
	}
	
	// getter/setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	// toString() 오버라이딩
	// alt + shift + s -> s (Generate toString...) -> 엔터
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", region=" + region + ", gender=" + gender + ", score="
				+ score + "]";
	}
	
	
	// 한가지에 대한 정렬밖에 못 정함
	// Student 클래스에서 더 이상 못함
	@Override
	public int compareTo(Student other) {
		// ctrl space 눌러도 완성됨
		// 지금 Student 객체와 other 로 들어온 객체를 비교
		// 나이를 기준으로 오름차순 정렬
//		return this.age - other.age;
		// 나이를 기준으로 내림차순 정렬
		return other.age - this.age;
	}
	
	
	
}
