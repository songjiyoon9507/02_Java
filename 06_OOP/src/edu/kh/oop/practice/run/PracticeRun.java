package edu.kh.oop.practice.run;

import edu.kh.oop.practice.model.service.BookService;
import edu.kh.oop.practice.model.service.HeroService;

public class PracticeRun {
	public static void main(String[] args) {
		
		HeroService hs = new HeroService();
		
		// hs.practice();

		/* 현실 객체 : 속성과 기능을 가진 독립적으로 인식되는 모든 것
		 * 
		 * 객체 지향 언어 : 객체간의 상호작용에 대한 개념을 컴퓨터로 옮겨 만들어낸 것
		 * 
		 * 자바 객체 : 클래스에 정의된 내용대로 new 연산자를 통해 메모리 영역에 생성한 것
		 * 
		 * class : 객체의 속성과 기능에 대한 정의를 한 것 (설계도)
		 * 
		 * new 연산자 : new 연산자를 이용하면 Heap 메모리 영역에 객체가 생성된다.
		 * 
		 * 추상화 : 공통점만 추출하고, 불필요한 부분 제거하는 과정
		 * 
		 * 캡슐화 : 속성과 기능을 하나로 묶어 관리하며, 데이터의 직접 접근 제한을 원칙으로 함.
		 * 			대신 간접접근을 할 수 있도록 클래스 내부에 getter / setter 메서드를 작성함.
		 * 
		 * 캡슐화 원칙
		 * - (필드에 작성되는) 멤버변수에 대한 접근 권한은 private 을 원칙으로 함
		 * - 멤버변수에 대한 연산처리를 목적으로 한 메서드는 클래스 내부에 작성함
		 * - 멤버 메서드는 클래스 밖에서 접근 가능하도록 public 으로 설정함.
		 * 
		 * 메서드/기능의 정의
		 * 해당 메서드가 어떤 기능을 수행/실행할 것인지 작성하는 것 (정의하는 것)
		 * 
		 * 메서드의 호출
		 * 정의된 메서드의 내용대로 수행/실행 할 수 있도록 메서드명을 부르는 것.
		 * 정의된 내용에 따라 단순 수행 후 반환값이 없을 수도 있고, 있을 수도 있다.
		 * 
		 * return : 메서드를 종료하고 호출한 곳으로 되돌아가는 것.
		 * 			return 뒤에 값이 있다면 값과 함께 호출한 곳으로 돌아간다.
		 * 
		 * public String ex1() {
		 * 		return "Hi";
		 * }
		 * 위 메서드 상세히 해석
		 * 
		 * 어디서든 접근 가능한(public) ex1 이라는 이름의 메서드를 정의하고,
		 * 수행할 내용은 "Hi" 라는 문자열 값을 호출한 곳으로 되돌려주는 메서드이다.
		 * return 값 ("Hi")의 자료형이 string 이기 때문에, 메서드 정의 시 반환형에 String 을 작성한 것이다.
		 * */
		
		BookService bs = new BookService();
		
		bs.practice();
	}
}
