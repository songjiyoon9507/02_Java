package edu.kh.poly.ex2.model.service;

// 계산기 인터페이스
// -> 모든 계산기에 대한 공통 필드, 기능명을 제공하는 접점(interface)의 용도
public interface Calculator {
	
	// 인터페이스 : 추상클래스의 변형체 (추상클래스보다 추상도 높음)
	// - 추상클래스 : 일부만 추상메서드 (0개 이상)
	// - 인터페이스 : 모두 추상메서드
	
	// 필드 (무조건 상수만 가능)
	// (묵시적으로 public static final ==> 상수)
	public static final double PI = 3.14;
	static final int MAX_NUM = 100000; // public 빼도 public
	public int MIN_NUM = -100000; // static 빼도 static
	int ZERO = 0; // 둘 다 빼도 public static
	
	// 메서드 (묵시적으로 public abstract)
	
	public abstract int plus(int num1, int num2);
	
	int minus(int num1, int num2);
	
	int multiple(int num1, int num2);

	int divide(int num1, int num2);
	
//	public void ex1() {};
	// Abstract methods do not specify a body
	// 추상메서드로 만들어라
	
	
	
}
