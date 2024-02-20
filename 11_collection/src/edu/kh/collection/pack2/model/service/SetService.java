package edu.kh.collection.pack2.model.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import edu.kh.collection.pack2.model.vo.Person;

public class SetService {
	
	/* Set(집합, 주머니)
	 * - 기본적으로 순서를 유지하지 않음
	 *   (index 없음 -> get() 메서드가 없음)
	 * 
	 * - 중복 데이터 저장 X (같은 객체가 들어오면 덮어쓰기)
	 * 
	 * Set 인터페이스의 자식 클래스
	 * 1. HashSet (대표) : 처리 속도가 빠른 Set
	 * 2. LinkedHashSet  : 순서를 유지하는 Set
	 * 3. TreeSet        : 자동 정렬되는 set
	 * 
	 * */
	
	/**
	 * HashSet 사용법
	 * - 사용 조건 1 : 객체에 equals()   오버라이딩 되어 있어야함
	 * - 사용 조건 2 : 객체에 hashCode() 오버라이딩 되어 있어야함
	 * 
	 * -> String, Integer 등 자바에서 제공하는 객체
	 * 	  모두 equals(), hashCode() 오버라이딩이 되어있는 상태
	 */
	public void method1() {
		// HashSet 객체 생성
		Set<String> set = new HashSet<String>(); // 다형성 - 업캐스팅
//		Set<String> set = new LinkedHashSet<String>();
		
		// 1. boolean add(E e) : 추가
		set.add("네이버");
		set.add("카카오");
		set.add("라인");
		set.add("쿠팡");
		set.add("배달의민족");
		set.add("당근마켓");
		set.add("토스");
		set.add("직방");		
		set.add("야놀자");
		
		System.out.println(set);
		// [배달의민족, 당근마켓, 직방, 카카오, 네이버, 야놀자, 쿠팡, 라인, 토스]
		// -> HashSet 순서 유지 X 확인
		
		// 중복 저장 확인
		set.add("배달의민족");
		set.add("배달의민족");
		set.add("배달의민족");
		set.add("배달의민족");
		set.add("배달의민족");
		
		System.out.println(set);
		// [배달의민족, 당근마켓, 직방, 카카오, 네이버, 야놀자, 쿠팡, 라인, 토스]
		// [배달의민족, 당근마켓, 직방, 카카오, 네이버, 야놀자, 쿠팡, 라인, 토스]
		// -> 중복 저장 X 확인
		
		// null : 참조하는 객체가 없음
		// null 도 중복 X 확인
		set.add(null);
		set.add(null);
		set.add(null);
		set.add(null);
		set.add(null);
		set.add(null);
		
		System.out.println(set);
		// [null, 배달의민족, 당근마켓, 직방, 카카오, 네이버, 야놀자, 쿠팡, 라인, 토스]
		// null 1회 출력
		
		// 2. int size() : Set 에 저장된 객체(참조변수)의 수 반환
		System.out.println("set.size() : " + set.size());
		// set.size() : 10
		
		// 3. boolean remove(E e) : 
		// 전달받은 매개변수 e 를 Set 에서 제거
		// 제거 성공 true, 없으면 false
		System.out.println(set.remove("배달의민족"));
		// true
		System.out.println(set.remove("유플러스"));
		// false
		System.out.println(set);
		
		// 4. boolean contains(E e) : 
		// 전달받은 e 가 Set 에 있으면 true, 없으면 false
		System.out.println("쿠팡 있는지 확인 : " + set.contains("쿠팡"));
		// 쿠팡 있는지 확인 : true
		System.out.println("삼성 있는지 확인 : " + set.contains("삼성"));
		// 삼성 있는지 확인 : false
		
		// 5. void clear() : Set 에 저장된 내용을 모두 삭제
		set.clear();
		System.out.println(set);
		// []
		
		// 6. boolean isEmpty() : 비어있으면 true, 아니면 false
		System.out.println(set.isEmpty());
		// true
	}
	
	/**
	 * Set 에 저장된 요소(객체)를 꺼내는 방법
	 * 1. Iterator(반복자) 이용
	 * 2. List 로 변환
	 * 3. 향상된 for 문 이용
	 */
	public void method2() {
		
		Set<String> set = new HashSet<String>();
		
		set.add("몽쉘");
		set.add("꼬북칩");
		set.add("쿠크다스");
		set.add("빈츠");
		set.add("포카칩");
		
		// 1. Iterator(반복자)
		// - 컬렉션 객체에 저장된 요소를
		//   하나씩 순차 접근하는 객체
		
		// Iterator Set.iterator() :
		// - 현재 Set 을 순차 접근할 수 있는 Iterator 객체 반환
		Iterator<String> it = set.iterator();
		
		// boolean Iterator.hasNext() : 
		// 다음 순차 접근할 요소가 있으면 true, 없으면 false 반환
		System.out.println("[1. Iterator]");
		while(it.hasNext()) {
			// 다음 요소가 있으면 반복, 없으면 멈춤
			
			// E Iterator.next() : 다음 요소를 꺼내와 반환
			String temp = it.next();
			System.out.println(temp);
		}
		
		System.out.println("========================");
		
		System.out.println("[2. List로 변환]");
		
		// Set 에 저장된 객체를 이용해서 List 를 생성
		List<String> list = new ArrayList<String>(set);
		
		// 일반 for 문
		for(int i = 0 ; i < list.size() ; i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println("========================");
		
		System.out.println("[3. 향상된 for문]");
		for(String snack : set) {
			System.out.println(snack);
		}
	}
	
	/**
	 * 직접 만든 클래스 (Person) 를 이용해 만든 객체를
	 * Set 에 저장(중복 제거 확인)
	 */
	public void method3() {
		
		Person p1 = new Person("홍길동", 25, '남');
		Person p2 = new Person("홍길동", 25, '남');
		Person p3 = new Person("홍길동", 30, '남');
		Person p4 = new Person("김길순", 20, '여');
		
		// Set 객체 생성 후 p1 ~ p4
		Set<Person> personSet = new HashSet<Person>();
		personSet.add(p1);
		personSet.add(p2);
		personSet.add(p3);
		personSet.add(p4);
		
		System.out.println("========================");
		
		for(Person p : personSet) {
			System.out.println(p);
		}
//		Person [name=김길순, age=20, gender=여]
//		Person [name=홍길동, age=25, gender=남]
//		Person [name=홍길동, age=30, gender=남]
//		Person [name=홍길동, age=25, gender=남]
		
		// hashCode equals 오버라이딩을 안해서 중복 제거 안된 상태
		
		// 중복 제거 후
//		Person [name=홍길동, age=30, gender=남]
//		Person [name=김길순, age=20, gender=여]
//		Person [name=홍길동, age=25, gender=남]
		
		System.out.println("========================");
		
		// hashCode() : 객체 식별 번호 (정수)
		System.out.println("p1 : " + p1.hashCode());
		System.out.println("p2 : " + p2.hashCode());
		System.out.println("p3 : " + p3.hashCode());
		System.out.println("p4 : " + p4.hashCode());
		
//		p1 : 55605822
//		p2 : 55605822
//		p3 : 55610627
//		p4 : 45920299
		
		// A.equals(B) : A와 B가 가지고있는 필드값이 같다면 true
		System.out.println(p1.equals(p2));
		// true
		
		System.out.println(p1.equals(p3));
		// false
		
		// ***************************************************
		// Hash 라는 단어가 포함된 컬렉션 이용 시
		// hashCode(), equals() 오버라이딩 필수적으로 진행
		// ***************************************************
	}
	
	/**
	 * TreeSet : 이진 트리 구조를 이용해 객체를 저장하는 Set
	 * -> 기본 오름차순 정렬
	 * 
	 * 전제 조건 : 저장되는 객체는 Comparable 인터페이스 상속 필수
	 * -> Integer (Wrapper 클래스) 는 Comparable 상속 되어있음
	 */
	public void method4() {
		
		// 난수 생성
		// 1) Math.random()
		// 2) Random.nextInt()
		
		Random random = new Random();
		
		// Integer(객체, Wrapper class) <==> int(기본 자료형)
		Set<Integer> lotto = new TreeSet<Integer>();
		
		// lotto 에 저장된 값이 6개 미만이면 반복
		// == 6개 멈춤
		
		while(lotto.size() < 6) {
			lotto.add( random.nextInt(45) + 1 ); // 0 <= x < 45
			// 1 ~ 45 사이 난수
		}
		
		System.out.println(lotto);
		
	}
	
	/**로또 번호 생성기
	 * 금액을 입력 받아(천원 단위)
	 * 1000원 당 1회씩 번호를 생성해서 List 에 저장한 후
	 * 생성 종료 시 한 번에 출력
	 * 
	 * <pre>
	 * 금액 입력 : 3000
	 * 
	 * 1회 : [11, 20, 34, 35, 42, 43]
	 * 2회 : [1, 12, 22, 33, 35, 44]
	 * 3회 : [5, 6, 24, 43, 44, 45]
	 * </pre>
	 * 
	 */	
//	public void lottoNumberGenerator(int price) {
//		
//		int num = price/1000; 
//		
//		List<Integer> list = new ArrayList<Integer>();
//		
//		Random random = new Random();
//		
//		for(int i = 0 ; i < num ; i++) {
//			
//			while(list.size() < 6) {
//				list.add( random.nextInt(45) + 1 ); // 0 <= x < 45
//				// 1 ~ 45 사이 난수
//			}
//			
//		}
//		
////		Comparator<Integer> lotto = Comparator.comparing(null);
//		
//		System.out.println(list);
//	}
	
	public void lottoNumberGenerator() {
		Scanner sc =new Scanner(System.in);
		
		System.out.print("금액 입력 : ");
		int amount = sc.nextInt();
		
		Random random = new Random();
		
		// 생성된 로또 번호 묶음(TreeSet)을 저장할 List
		List<Set<Integer>> lottoList = new ArrayList<Set<Integer>>();
	
		for(int i = 0 ; i < amount/1000 ; i++) {
			
			// for 문 반복될 때마다 새로운 Set 객체를 생성
			Set<Integer> lotto = new TreeSet<Integer>();
			
			while(lotto.size() < 6) {
				lotto.add( random.nextInt(45) + 1 ); // 1 ~ 45 사이 난수 추가
			}
			
			lottoList.add(lotto); // List 에 Set 추가(담기)
			// -> 반복 시 마다
			// List 각 인덱스에 서로 다른 Set 참조 주소가 저장됨
			
		}
		
		// 출력용 반복문
		for(int i = 0 ; i < lottoList.size() ; i++) {
			System.out.println((i+1) + "회 : " + lottoList.get(i));
		}
	}
}
