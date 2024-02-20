package edu.kh.collection.pack1.model.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
//import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import edu.kh.collection.pack1.model.vo.Student;
// 중요함
// C R U D
// 추가 조회 수정 삭제
public class StudentService {
	
	// 필드
	
	private Scanner sc = new Scanner(System.in);
	
	// 학생 정보를 저장할 List 생성
	
	// java.util.List 인터페이스 : List 에 반드시 필요한 필수 기능을 모아둔 인터페이스
	// * 인터페이스 객체 생성 X, 부모 참조변수 O
	// 인터페이스는 미완성 클래스 객체 생성 안됨
	// List(); 안됨
	
	// java.util.ArrayList : 배열 형태 List (가장 대표적인 List 자식 클래스)
	
	// studentList 컬렉션 명
	
	// 추가, 수정, 삭제 효율적
	// private List studentList = new LinkedList();
	
	// 검색(조회)에 효율적
	// private List studentList = new ArrayList();
	// ArrayList() 기본생성자 : 기본 크기가 10짜리 리스트 생성
	//							-> 하지만 리스트는 크기가 늘었다 줄었다 하기 때문에 큰 의미 없음.
	
	// ArrayList(용량) : 용량만큼의 리스트 생성
	// 					 -> 너무 큰 값을 작성하면 메모리를 많이 소모함.
	
	// 제네릭스 (Generics)
	// -> 컬렉션에 저장되는 객체 타입을 한가지로 제한할 때 씀
	// 표기법 <E>
	private List<Student> studentList = new ArrayList<Student>();
	
	// The method add(Student) in the type List<Student> is not applicable for the arguments (Scanner)
	// 아래서 에러 뜸
	
	public StudentService() {
		studentList.add(new Student("홍길동", 25, "서울시 중구", 'M', 90));
		studentList.add(new Student("고영희", 23, "경기도 안산시", 'F', 100));
		studentList.add(new Student("강아지", 30, "서울시 강남구", 'M', 80));
		studentList.add(new Student("오미나", 27, "충북 청주시", 'F', 90));
		studentList.add(new Student("박주희", 24, "서울시 서대문구", 'F', 70));
	}
	
	public void ex() {
		// List 테스트
		
		// List.add(Object e) : 리스트에 객체를 추가
		// * 매개변수 타입이 Object == 모든 객체를 매개변수로 전달할 수 있음
		studentList.add(new Student()); // 0번째 인덱스에 Student 객체 넣어준 거
		// Student [name=null, age=0, region=null, gender=, score=0]
		// toString Override 형태로 나옴
		// studentList.add(sc); // 1번 인덱스에 Scanner 객체 전달
		// studentList.add("문자열"); // 2번 인덱스에 "문자열" 넣어줌 String 은 참조형 객체화 돼있음
		// studentList.add(new Object()); // 3번 인덱스에 Object 넣어줌
		
		// 컬렉션 특징 : 여러 타입의 데이터를 저장할 수 있음
		
		// Object List.get(index i); : 반환형이 Object 리스트에서 i 번째 인덱스에 있는 객체를 반환
		// 반환형이 Object == 모든 객체를 반환할 수 있다.
		// System.out.println(studentList.get(0).getName());
		// The method getName() is undefined for the type Object
		// 반환형이 Object 타입 Student 타입에 있는 getName 못 가져옴
		// 사용하려면 강제 형변환 해줘야함
		
		if(studentList.get(0) instanceof Student) {			
			System.out.println(((Student)studentList.get(0)).getName());
		}
		
		System.out.println(((Student)studentList.get(0)).getName());

//		System.out.println(studentList.get(1));
//		System.out.println(studentList.get(2));
//		System.out.println(studentList.get(3));
		
	}
	
	// 학생 관리 프로그램
	// 메뉴 출력용 메서드
	
	/**
	 * alt + shift + j
	 * 메서드 설명용 주석
	 * 메서드에 마우스 올려두면 여기에 적은 내용이 보임
	 * @ 치면 쓸 수 있는 메서드들 뜸
	 * @author songjiyoon9507@gmail.com
	 * @exception 발생할 것 같은 예외에 대해 작성
	 * 등등
	 */
	public void displayMenu() {
		
		int menuNum = 0; // 메뉴 선택용 변수
		
		do {
			
			System.out.println("\n===== 학생 관리 프로그램 =====\n");
			System.out.println("1. 학생 정보 추가");
			System.out.println("2. 학생 정보 전체 조회");
			System.out.println("3. 학생 정보 수정");
			System.out.println("4. 학생 정보 삭제");
			System.out.println("5. 이름으로 검색(일치)");
			System.out.println("6. 이름으로 검색(포함)");
			System.out.println("7. 나이순으로 정렬"); // Comparable
			System.out.println("8. 이름순으로 정렬"); // Comparator
			System.out.println("0. 프로그램 종료");
			
			System.out.print("메뉴 번호 선택 >> ");
			
			try {
				menuNum = sc.nextInt();
				System.out.println();
				
				switch(menuNum) {
				
				case 1 : System.out.println(addStudent()); break;
				case 2 : selectAll(); break;
				case 3 : System.out.println(updateStudent()); break;
				case 4 : System.out.println(removeStudent()); break;
				case 5 : searchName1(); break;
				case 6 : searchName2(); break;
				case 7 : sortByAge(); break;
				case 8 : sortByName(); break;
				case 0 : System.out.println("프로그램 종료"); break;
				default : System.out.println("메뉴에 작성된 번호만 입력하세요.");
				}
				
			} catch(InputMismatchException e) {
				System.out.println("\nerror : 입력 형식이 유효하지 않습니다. 다시 시도해주세요.");
				// 입력 버퍼에 들어와있는 잘못된 애 비워줘야함
				sc.nextLine();
				
				menuNum = -1;
				// 첫 반복시 잘못 입력하는 경우
				// menuNum이 0을 가지고 있어 종료되는데,
				// 이를 방지하기 위해 임의값 -1 대입 다시 반복하기 위해서
			}

		} while(menuNum != 0);
		
	}
	
	/**
	 * 1. 학생 정보 추가 메서드
	 * - 추가 성공 시 "성공" 실패 시 "실패" 문자열 반환
	 */
	public String addStudent() throws InputMismatchException {
		
		System.out.println("===== 학생 정보 추가 =====");
		
		System.out.print("이름 : ");
		String name = sc.next();

		System.out.print("나이 : ");
		int age = sc.nextInt();
		sc.nextLine();
		
		System.out.print("사는 곳 : ");
		String region = sc.nextLine();
		
		System.out.print("성별(M/F) : ");
		char gender = sc.next().charAt(0); // 'M' or 'F'
		
		System.out.print("점수 : ");
		int score = sc.nextInt();
		
		// Student 객체 생성 후 List 에 추가
		if (studentList.add(new Student(name, age, region, gender, score))) {
			// boolean java.util.List.add(Student e)
			// (반환형)				-> 제네릭으로 Student 만 들어올 수 있게 설정해놓음
			//						-> 제네릭 <Student> 때문에 List 에 추가할 수 있는 객체 타입이
			//						   Student 로 제한됨
			
			return "성공";
			
		} else {
			
			return "실패";
			
		}
	}
	
	/**
	 * 2. 학생 정보 전체 조회 메서드
	 * - List 가 비어있는 경우 "학생 정보가 없습니다." 출력
	 * - 있는 경우 전체 학생 출력
	 * */
	public void selectAll() {
		// - List 에 저장된 데이터의 개수를 얻어오는 방법 : int List.size()
		// -> 배열명.length 대신 사용
		
		System.out.println("===== 학생 전체 조회 =====");
		
		// studentList 가 비어있는 경우 "학생 정보가 없습니다." 출력
//		if(studentList.size() == 0) {
//			System.out.println("학생 정보가 없습니다.");
//		}
		
		if(studentList.isEmpty()) { // 비어있으면 true 반환
			System.out.println("학생 정보가 없습니다.");
			return; // 현재 메소드를 종료하고 호출한 곳으로 돌아감.
					// 단, 반환값은 없다(void)
		}
		
		// 일반 for 문
//		for(int i = 0 ; i < studentList.size() ; i++) {
//			System.out.println(studentList.get(i));
//		}
		
		// 향상된 for 문 (for each 문)
		// - 컬렉션, 배열의 모든 요소를 순차적으로 반복접근 할 수 있는 for 문
		// (순차적 : 0번 인덱스부터 마지막 요소까지 인덱스를 1씩 증가)
		
		// 작성법
		// for(컬렉션 또는 배열에서 꺼낸 한 개의 요소를 저장할 변수 : 컬렉션명 또는 배열명) {}
		
		int index = 0;
		
		for(Student std : studentList) {
			// std 에는 for 문 반복 시 마다 0, 1, 2, ... 인덱스 요소들 한번씩 저장됨
			System.out.print((index++)  + "번 : ");
			System.out.println(std); // toString 안써도 Override 돼서 자동으로 나옴
		}
		
	}
	
	/**
	 * 3. 학생 정보 수정 메서드
	 * - 학생 정보가 studentList에 있는지 검사
	 * - 없다면 "입력된 학생 정보가 없습니다." 문자열 반환
	 * - 입력된 숫자가 0보다 작은지 검사
	 * - 작다면 "음수는 입력할 수 없습니다." 문자열 반환
	 * - studentList 범위 내 인덱스 번호인지 검사
	 * - 범위를 초과했다면 "범위를 넘어선 값을 입력할 수 없습니다." 문자열 반환
	 * - 수정이 완료되었다면, "000의 정보가 변경되었습니다." 문자열 반환
	 * */
	public String updateStudent() throws InputMismatchException { // 만약, 문자열을 입력한 경우 -> 예외처리 throws
		
		// Student List.set(int index, Student e)
		// -> List 의 index 번째 요소를 전달 받은 e 로 변경
		// -> 반환값 Student == 변경 전 Student 객체가 담겨있다.
		
		System.out.println("===== 학생 정보 수정 =====");
		
		System.out.print("인덱스 번호 입력 : ");
		int index = sc.nextInt();
		
		// 학생 정보가 studentList 에 있는지 검사
		if(studentList.isEmpty()) {
			return "입력된 학생 정보가 없습니다.";
		// 입력된 숫자가 0보다 작은지 검사
		} else if(index < 0) {
			return "음수는 입력할 수 없습니다.";
		} else if(index >= studentList.size()) {
			return "범위를 넘어선 값을 입력할 수 없습니다.";
		} else {
			System.out.println(index + "번째에 저장된 학생 정보");
			System.out.println(studentList.get(index));
			// 주어진 인덱스에 저장된 객체를 리턴
			
			// 수정 코드 작성
			System.out.print("이름 : ");
			String name = sc.next();

			System.out.print("나이 : ");
			int age = sc.nextInt();
			sc.nextLine();
			
			System.out.print("사는 곳 : ");
			String region = sc.nextLine();
			
			System.out.print("성별(M/F) : ");
			char gender = sc.next().charAt(0); // 'M' or 'F'
			
			System.out.print("점수 : ");
			int score = sc.nextInt();
			
			// 입력 받은 index 번째에 새로운 학생 정보 세팅 == 수정
			// index 번째에 있던 기존 학생 정보가 반환되고, 그 객체를 temp 에 저장한다.
			Student temp = studentList.set(index, new Student(name, age, region, gender, score));
			
			return temp.getName() + "님의 정보가 변경되었습니다.";
			
		}
		
	}
	
	
	/**
	 * 4. 학생 정보 삭제 메서드
	 * @return String
	 */
	public String removeStudent() throws InputMismatchException {
		
		// Student List.remove(int index)
		// 리스트에서 index 번째 요소를 제거
		// 이 때, 제거된 요소가 반환된다.
		// * List 는 중간에 비어있는 인덱스가 없게 하기 위해서
		// remove() 동작 시 뒤쪽 요소를 한 칸씩 당겨온다.
		
		System.out.println("===== 학생 정보 삭제 =====");
		
		System.out.print("인덱스 번호 입력 : ");
		int index = sc.nextInt();
		
		// 리스트 비어있는지
		if(studentList.isEmpty()) {
			return "입력된 학생 정보가 없습니다.";
		// 입력된 숫자가 0보다 작은지 검사
		} else if(index < 0) {
			return "음수는 입력할 수 없습니다.";
		} else if(index >= studentList.size()) {
			return "범위를 넘어선 값을 입력할 수 없습니다.";
		} else {
			
			// 학생 정보 제거
			
			System.out.print("정말 삭제하시겠습니까? (Y/N) : ");
			char ch = sc.next().toUpperCase().charAt(0);
			// String 대문자 -> 대문자 0번 인덱스 문자
			
			// String.toUpperCase() : 문자열을 대문자로 변경
			// String.toLowerCase() : 문자열을 소문자로 변경
			
			if(ch == 'Y') {
				
				Student temp = studentList.remove(index);
				return temp.getName() + "님의 정보가 제거되었습니다.";
				
			} else {
				return "취소";
			}
		}
	}
	
	
	/**
	 * 이름이 일치하는 학생을 찾아서 조회하는 메서드(완전 일치)
	 * 검색할 이름 입력받아 studentList 에서 꺼내온 Student 객체의 name 값이 같은지 비교
	 * - 일치하는 경우 Student 객체 출력
	 * - 검색 결과가 없습니다. 출력
	 */
	public void searchName1() throws InputMismatchException {
		
		// 이름으로 검색 (일치)
		// for 문 안에서 한 애의 이름
		System.out.println("===== 이름으로 검색(일치) =====");
		System.out.print("이름 입력(완전 일치) : ");
		String name = sc.next();
//		boolean flag = true;
//
//		for (Student std : studentList) {
//			if (std.getName().equals(name)) {
//				System.out.println(std); // std.toString()
				
//				flag = false;
//			}
//		}
//		
//		if(flag) {
//			System.out.println("검색 결과가 없습니다.")
//		}
//		
//		
		int temp = 0;
		boolean flag = false;
		
		for (int i = 0 ; i < studentList.size() ; i++) {
			if(studentList.get(i).getName().equals(name)) {
				temp = i;
				flag = true;
			}	
		}
		
		if (flag) {
			System.out.println(studentList.get(temp));
		} else {
			System.out.println("검색 결과가 없습니다.");
		}
		
		
	}
	
	/**
	 * 이름에 특정 문자열이 포함되는 학생을 찾아서 조회하는 메서드
	 * 문자열 입력받아 studentList에서 꺼내온 Student 객체의 name 값에 포함되는 문자열인지 검사
	 * - 포함되는 경우 student 객체 출력
	 * - 검색 결과가 없습니다. 출력
	 */
	public void searchName2() throws InputMismatchException{
		// boolean String.contains(문자열) : String 에 문자열이 포함되어 있으면 true / 없으면 false
		System.out.println("===== 이름으로 검색(포함) =====");
		System.out.print("이름 입력(포함) : ");
		String name = sc.next();
		
		int temp = 0;
		boolean flag = false;
		
		for (int i = 0 ; i < studentList.size() ; i++) {
			if(studentList.get(i).getName().contains(name)) {
				temp = i;
				flag = true;
			}	
		}
		
		if (flag) {
			System.out.println(studentList.get(temp));
		} else {
			System.out.println("검색 결과가 없습니다.");
		}
		
	}
	
	/**
	 * 7. 나이순으로 정렬
	 * 나이에 따라 오름차순 정렬
	 */
	public void sortByAge() {
		Collections.sort(studentList);
		
		// 정렬된 결과 출력
		for(Student std : studentList) {
			System.out.println(std);
		}
	}
	
	/**
	 * 8. 이름순으로 정렬
	 */
	public void sortByName() {
		// 여러 개 만들 수 있음
		
		// 이름에 따라 정렬하는 Comparator 객체 생성
		Comparator<Student> nameComparator = Comparator.comparing(Student::getName)/*.reversed()*/;
		// Comparator 인터페이스의 static 메서드인 comparing() 을 사용하여 Comparator 객체를 생성
		// -> comparing()는 주어진 키(key)를 기반으로 객체를 비교함.
		// Student::getName : 메서드 레퍼런스(Method Reference) 메서드 참조
		// -> Student 클래스의 getName() 메서드를 가리키는 것.
		// -> 이 메서드를 비교의 키로 사용하여 각 Student 객체를 비교하고 정렬함.
		// --> Comparator.comparing(Student::getName) 은 이름(name)을 기준으로
		// 	   학생(Student) 객체를 비교하는 Comparator 를 생성.
		
		// 이름에 따라 정렬
		Collections.sort(studentList, nameComparator);
		
		// 정렬된 결과 출력
		for(Student std : studentList) {
			System.out.println(std);
		}
	}
	
}
