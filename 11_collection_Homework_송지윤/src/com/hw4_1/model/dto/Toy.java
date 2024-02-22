package com.hw4_1.model.dto;

import java.util.Objects;
import java.util.Set;

public class Toy {
	
	private String name;
	private int age;
	private int price;
	private String color;
	private String manufactureDate; // 제조일(문자열로 표현 - 20240222)
	// 재료가 한가지씩이 아님 여러 개 받을 수 있음
	// 똑같은 재료 중복 불가
	private Set<String> materials;
	
	public Toy() {}

	public Toy(String name, int age, int price, String color, String manufactureDate, Set<String> materials) {
		super();
		this.name = name;
		this.age = age;
		this.price = price;
		this.color = color;
		this.manufactureDate = manufactureDate;
		this.materials = materials;
	}

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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(String manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	public Set<String> getMaterials() {
		return materials;
	}

	public void setMaterials(Set<String> materials) {
		this.materials = materials;
	}

	// materials 안에 있는 모든 재료를 문자열 형태로 만들어 반환하는 메서드
	public String getMaterialsAsString() {
		StringBuilder sb = new StringBuilder();
		
		for(String material : materials) {
			sb.append(material).append(", ");
		}
		
		// 마지막 쉼표와 공백 제거하기
		if(sb.length() > 0) {
			// 값이 있을 때
			sb.setLength(sb.length()-2);
			// 공백이랑 쉼표 2개 없애줄 거임 (-2)
			// 뒤에서 없어짐
		}
		
		return sb.toString();
		
	}

	@Override
	public String toString() {
//		return "이름 : " + name + " / " + age + ", price=" + price + ", color=" + color + ", manufactureDate="
//				+ manufactureDate + ", materials=" + materials + "]";
		
		// toString printf 처럼 쓰는 방법 format
		
		return String.format("이름 : %s / 가격 : %d / 색상 : %s / 사용가능연령 : %d / 제조년월일 : %s / 재료 : %s",
							name, price, color, age, manufactureDate, getMaterialsAsString());
	}
	
	// 장난감을 저장할 컬렉션에 중복된 장난감이 있어서는 안된다. (Set) (HashSet)
	// HashSet 쓰려면 오버라이딩 해야함
	
	@Override
	public int hashCode() {
		return Objects.hash(age, color, manufactureDate, materials, name, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Toy other = (Toy) obj;
		return age == other.age && Objects.equals(color, other.color)
				&& Objects.equals(manufactureDate, other.manufactureDate) && Objects.equals(materials, other.materials)
				&& Objects.equals(name, other.name) && price == other.price;
	}

}
