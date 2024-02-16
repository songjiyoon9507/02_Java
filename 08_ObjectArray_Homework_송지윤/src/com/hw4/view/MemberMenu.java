package com.hw4.view;

import java.util.Scanner;

import com.hw4.controller.MemberController;
import com.hw4.model.vo.Member;

public class MemberMenu {
	
	private MemberController mc = new MemberController();
	
	Scanner sc = new Scanner(System.in);
	
	public void mainMenu() {
		
		int menuNum = 0;
		
		do {
			
			System.out.println("===== 회원 관리 메뉴 =====");
			System.out.println("1. 신규 회원 등록");
			System.out.println("2. 회원 정보 검색");
			System.out.println("3. 회원 정보 수정");
			System.out.println("4. 회원 정보 삭제");
			System.out.println("5. 회원 정보 출력");
			System.out.println("6. 회원 정보 정렬");
			System.out.println("0. 프로그램 종료");
			System.out.print("메뉴 선택 >> ");
			menuNum = sc.nextInt();
			sc.nextLine();
			
			switch(menuNum) {
				case 1 : insertMember(); break;
				case 2 : searchMember(); break;
				case 3 : updateMember(); break;
				case 4 : deleteMember(); break;
				case 5 : printAllMember(); break;
				case 6 : sortMember(); break;
				case 0 : 
					System.out.println("프로그램 종료");
					break;
				default : System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
			
		} while(menuNum != 0);
		
	}
	
	public void insertMember() {
		// 1. 현재 회원 수 (memberCount) 가 최대 회원 수 (SIZE)를 넘어설 경우 return
		if (mc.getMemberCount() >= mc.SIZE) {
			System.out.println("회원 수를 초과했습니다.");
			return;
		}
		
		// 2. 아이디를 입력 받아 MemberController의 checkId() 메소드로 전달 >> 결과값
		
		System.out.print("아이디 입력 : ");
		String userId = sc.nextLine();
		
		// MemberController 에서 Member m = null; 을 사용
		// Member 자료형 m 변수명 으로 checkId에 전달인자 userId 넣어서
		// MemberController에 있는 checkId 호출
		Member m = mc.checkId(userId);
		
		// 나는 아래에 변수명 없이 if(mc.checkId(userId) != null)로 바로 사용함
		// 나중에 값 넣을 때 뭐가 잘못 됐는지 모르겠음
		// 이거 때문인가?
		
		// 호출 후 MemberController로 가서 checkId() 내용 확인
		
		// checkId() 내용 변경 후 다시 옴
		// 받은 값은 Member 자료형의 변수명 m
		// 값은 아이디 같은 거 있을 때는 mem[i]의 값(중요하지 않음 지금은)
		// 없을 때는 null (여기에 넣어줄 거라서 이게 중요함)
		
		if (m != null) { // 동일한 아이디가 존재하는 경우
			System.out.println("동일한 아이디가 존재합니다. 회원등록 실패");
		} else { // 동일한 아이디가 존재하지 않는 경우
			System.out.print("비밀번호 입력 : ");
			String userPwd = sc.nextLine();
			
			System.out.print("이름 입력 : ");
			String name = sc.nextLine();
			
			System.out.print("나이 입력 : ");
			int age = sc.nextInt();
			sc.nextLine();
			
			System.out.print("성별 입력 : ");
			char gender = sc.nextLine().charAt(0);
			
			System.out.print("이메일 입력 : ");
			String email = sc.nextLine();
			
			// 입력 받은 정보를 Member 의 매개변수 생성자를 이용하여
			// 객체 생성 후 (여기까진 맞음)
			// MemberController의 insertMember() 메소드로 전달
			// 전에 위에를 잘못 입력해서 밑줄 나와서 정답대로 입력했다가 지움
			// insertMember에 내용이 없어서 그런거였음
			mc.insertMember(new Member(userId, userPwd, name, age, gender, email));
		}
	
	}
	
	public void searchMember() {
		// do while 문 사용하면 무조건 한번은 실행이라서 9번 눌러도 검색내용 : 이 나옴
		
		// 처음에 안 된 이유는 여기서 MemberController 호출해서 사용하고 값을 돌려 받아서
		// 다시 사용해야하는데 변수를 안 만들고 호출만해서 답을 빈 자리에 받음.
//		int menu = 0;
//		
//		do {
//			System.out.println("===== 회원 정보 검색 =====");
//			System.out.println("1. 아이디로 검색하기");
//			System.out.println("2. 이름으로 검색하기");
//			System.out.println("3. 이메일로 검색하기");
//			System.out.println("9. 이전 메뉴로");
//			
//			System.out.print("메뉴 선택 : ");
//			menu = sc.nextInt();
//			sc.nextLine();
//			
//			System.out.print("검색 내용 : ");
//			String search = sc.nextLine();
//			
//			// 돌려 받은 값을 처리 안해서 문제였음
//			// MemberController에 searchMemu 메소드로
//			// menu 와 search 문자열 전달
//			Member searchMember = mc.searchMember(menu, search);
//			// 이 문장 작성후 MemberController로 넘어감
//			// MemberController에서 return 한 값이 searchMember에 대입됨
//			
//			if(searchMember != null) {
//				System.out.println("===== 검색 결과 =====");
//				System.out.println(searchMember.information());
//			} else {
//				System.out.println("검색된 결과가 없습니다.");
//			}
//			
//		} while (menu != 9);
		// 위에 코드는 실행되지 않음 실행 되지 않는 이유는 변수를 만들어서
		// 호출한 곳에서 돌려 받은 값을 변수에 넣어서 사용했어야했는데 그걸 안함
		
//		while(true) {
//			System.out.println("===== 회원 정보 검색 =====");
//			System.out.println("1. 아이디로 검색하기");
//			System.out.println("2. 이름으로 검색하기");
//			System.out.println("3. 이메일로 검색하기");
//			System.out.println("9. 이전 메뉴로");
//			
//			// 이 때 9번 누르면 이전 메뉴로 돌아감
//			System.out.print("메뉴 선택 : ");
//			int menu = sc.nextInt();
//			sc.nextLine();
//			
//			if(menu == 9) {
//				System.out.println("이전 메뉴로 돌아갑니다.");
//				return;
//				// 호출한 곳으로 돌아가라
//			}
//			// 고치다 보니 호출이 안 되는 게 MemberController
//			// Switch 문 안에 break; 때문인 것 같음 return;이나
//			// 호출한 곳으로 돌아가는 다른 게 필요할 것 같음
//			switch 문은 잘못 없었음^^	
		
//			System.out.print("검색 내용 : ");
//			String search = sc.nextLine();
//			
//			
//			mc.searchMember(menu, search);
//			
//		}
		// 3트
		while(true) {
			System.out.println("===== 회원 정보 검색 =====");
			System.out.println("1. 아이디로 검색하기");
			System.out.println("2. 이름으로 검색하기");
			System.out.println("3. 이메일로 검색하기");
			System.out.println("9. 이전 메뉴로");
			
			System.out.print("메뉴 선택 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			
			// 이건 여기에 써줘야하는 게 맞음 switch 문에서 9 break 걸어도
			// 검색 내용 : 나오고 그 후에 switch 문 결과 나옴 호출이 더 뒤라서
			if(menu == 9) {
				System.out.println("이전 메뉴로 돌아갑니다.");
				return;
			}

			System.out.print("검색 내용 : ");
			String search = sc.nextLine();
			
			Member searchMember = mc.searchMember(menu, search);
			
			if(searchMember != null) {
				System.out.println("===== 검색 결과 =====");
				System.out.println(searchMember.information());
			} else {
				System.out.println("검색된 결과가 없습니다.");
			}
			
		}
	}
	
	public void updateMember() {
		
		while(true) {
			
			System.out.println("===== 회원 정보 수정 =====");
			System.out.println("1. 비밀번호 수정");
			System.out.println("2. 이름 수정");
			System.out.println("3. 이메일 수정");
			System.out.println("9. 이전 메뉴로");
			
			System.out.print("메뉴 선택 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			
			if(menu == 9) {
				System.out.println("이전 메뉴로 돌아갑니다.");
				return;
			}
			
			System.out.print("변경할 회원 아이디 : ");
			String userId = sc.nextLine();
			
			// 1. MemberController의 checkId로 userId 전달
			
			Member m = mc.checkId(userId);
			
			if (m == null) { // 일치하는 아이디 없을 때
				System.out.println("변경할 회원이 존재하지 않습니다.");
			} else { // 일치할 때 기존 정보 출력
				System.out.println(m.information());
				System.out.print("변경 내용 입력 : ");
				String update = sc.nextLine();
				mc.updateMember(m, menu, update);
				System.out.println("회원의 정보가 변경되었습니다.");
			}
		}
	}
	
	public void deleteMember() {
		System.out.print("삭제할 회원 아이디 : ");
		String userId = sc.nextLine();
		
		// 1. MemberController의 checkId()에 userId 전달
		Member m = mc.checkId(userId);
		
		// 돌아온 결과 값 null 이면 값 없는 거
		// 아니면 mem[i] 돌아옴
		if(m == null) { // 값 없을 때
			System.out.println("삭제할 회원이 존재하지 않습니다.");
		} else { // null 이 아닐 때
			// 기존 정보 출력
			System.out.println(m.information());
			System.out.print("정말 삭제하시겠습니까? (y/n) : ");
			// char answer = sc.next().toUpperCase().charAt(0);
			// char 형 아니고 String 으로 받아서 toUpperCase
			String answer = sc.next().toUpperCase();
			// 대소문자 구분 없이 'Y'인 경우 MemberController의 deleteMember()에
			// userId 전달
			if (answer.equals("Y")) { // string 으로 받았으니까 큰따옴표
				// Y인 경우 MemberController의 deletMember()에 userId 전달
				mc.deleteMember(userId);
				// 돌려 받을 값 없음 그냥 지울거임
				System.out.println("회원의 정보가 삭제되었습니다.");
			}
		}
		
	}
	
	public void printAllMember() {
		// MemberController의 getMem() 메소드 호출 결과 값 mem : Member[]
		Member[] mem = mc.getMem();
		for(int i = 0 ; i < mem.length ; i++) {
			if(mem[i] != null) {
				// 결과 값 안의 존재하는 회원들 정보 출력
				System.out.println(mem[i].information());
			} else {
				// mem[i] == null 일 때 반복문 종료
				break;
			}
		}
	}
	
	public void sortMember() {
		
		Member[] sortMem = null; // 정렬 결과를 받아 줄 객체배열 초기화
		
		while(true) {
			System.out.println("===== 회원 정보 정렬 =====");
			System.out.println("1. 아이디 오름차순 정렬");
			System.out.println("2. 아이디 내림차순 정렬");
			System.out.println("3. 나이 오름차순 정렬");
			System.out.println("4. 나이 내림차순 정렬");
			System.out.println("5. 성별 내림차순 정렬(남여순)");
			System.out.println("9. 이전 메뉴로");
			
			System.out.print("메뉴 선택 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			
			if(menu == 9) {
				System.out.println("이전 메뉴로 돌아갑니다.");
				return;
			}
			
			switch(menu) {
			case 1 : mc.sortAgeAsc(); break;
			
			
			
			
			}
			
			
		}
		
	}
}
