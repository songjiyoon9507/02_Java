package edu.kh.oop.abstraction.model.vo;

/* MVC 패턴
 * Model - 프로그램, 어플리케이션의 데이터, 비즈니스로직 담당
 * View - 사용자에게 데이터를 시각적으로 표현하는 부분 담당
 * Controller - model,view 간의 상호작용을 조정, 제어하는 역할의 담당
 * 			  - 사용자의 입력 처리하고 대응하는 작업 담당
 * */

// Model 안에 vo가 있는 거
// VO(Value Object) : 값 저장용 객체를 만들기 위한 클래스를 모아두는 패키지
public class People { // 국민(사람) 클래스 (사람을 만들기 위한 설계도)
	
	// 클래스란? 객체의 특성(속성, 기능)을 정의한 것
	// 객체를 만들기 위한 설계도
	
	// 속성 == 값 == data
	// 값을 저장하기 위한 변수 선언
	// -> 국민이라면 공통적으로 가지고 있는 속성만 작성(추상화)
	// 이름, 성별, 주민번호, 주소, 전화번호, 나이
	
	// 필드 == 필드 변수 == 멤버 변수 == 클래스 변수
	// (필드 부분) public 접근 제한자 (모두 접근 가능)
	
	// 캡슐화
	// - 데이터와 기능을 하나로 묶어서 관리하는 기법 (블록으로 인해 하나로 묶임)
	// - 데이터에 직접적인 접근을 제한 하는 것이 원칙이다.
	// -> 직접접근을 못하기 때문에
	//    클래스 내부에 간접 접근 방법을 제공하는 기능을 작성해둔다
	//    -> getter/setter (method)
	
	// *** 데이터 직접 접근 제한 ***
	// public(공공의) -> private(사적인, 개인적인) 변경
	private String name; // The field People.gender is not visible
	private char gender;
	private String pNo; // "220303-22222222"; 주민번호
	private String address;
	private String phone; // "010-1234-1234"
	private int age;
	// public double bitCoin; // 공통점이 아니므로 제거
	//   public      int      age;
	//[접근제한자]  자료형   변수명
	
	// 기능 == 행동 == method(메서드)
	public void tax() {
		// 기능그자체라서 호출만하면됨
		System.out.println("세금을 냅니다...");
	}
	
	public void vote() {
		System.out.println("투표를 합니다...");
	}

	// 캡슐화에서 사용할 간접 접근 기능(getter/setter)
	//public String getName() { // 가운데 String 반환형을 의미 void는 돌려줄 값 없을 때 씀
	//[접근제한자] 반환형 메서드명
	//	return name;
	//}
	
	//public void setName(String name) { // setter 호출한 곳에 돌려줄 값 없어서 void 사용
	// name 에 홍길동 들어올거임
	//	this.name = name; // 뒤에 name은 매개변수로 넘어온 name service 클래스에서 전달인자로 보냄	
	//}
	
	// alt shift s 또는 상단 메뉴 Source
	// -> Generate Getters and Setters...클릭
	// -> selectAll -> generate
	
	// name 변수의 값을 돌려 보내주는 간접 접근 기능
	// void : 반환할 값이 없다(반환형이 없다)
	// <-> 반환할 값이 있을 경우 그 값의 자료형을 작성(반환형)
	
	public String getName() {
		return name;
	}

	// name 변수에 값을 세팅하는 간접 접근 기능
	public void setName(String name) {
		// 매개변수 String name
		// -> String 타입의 데이터를 전달받아 저장하고 있는 변수
		// ** this : 현재 객체
		// 멤버 변수 name 에 매개변수 name 을 대입시키는 역할을 함
		this.name = name;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getpNo() {
		return pNo;
	}

	public void setpNo(String pNo) {
		this.pNo = pNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	
}
