package bookManagement.model.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import bookManagement.model.dto.Book;
import bookManagement.model.service.BookManagementService;
import bookManagement.model.service.BookManagementServiceImpl;

public class BookManagementView {
	// 입력 버퍼 참조변수 선언
	private BufferedReader br = null;
	
	// service와 연결
	private BookManagementService service = null;
	
	public BookManagementView() {
		try {
			service = new BookManagementServiceImpl();
			
			br = new BufferedReader(new InputStreamReader(System.in));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void startView() {
		
		int input = 0;
		
		do {
			
			try {
				// selectMenu 메서드에서 던진 Exception 여기서 잡아줌
				input = selectMenu();
				
				switch(input) {
				
				case 1 : searchBookList(); break;
				case 2 : addBookList(); break;
				
				case 0 : System.out.println("@@@@@ 프로그램 종료 @@@@@"); break;
				default : System.out.println("### 메뉴에 작성된 번호만 입력해주세요. ###");
				}
				
				
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		} while(input != 0);
	}
	
	public int selectMenu() throws Exception {
		System.out.println("\n========== [ 도서 관리 프로그램 ] ==========\n");
		
		System.out.println("1. 도서 목록 조회");
		System.out.println("2. 도서 등록");
		System.out.println("3. 도서 검색");
		System.out.println("0. 프로그램 종료");
		
		System.out.print("메뉴 선택 >> ");
		int input = Integer.parseInt(br.readLine());
		return input;
	}
	
	public void searchBookList() {
		
		int menuNum = 0;
		
		do {
			
			try {
				
				menuNum = selectSearchList();
				
				switch(menuNum) {
				case 1 : bookListFullView(); break;
				
				case 0 : System.out.println("도서 정보 조회 종료"); break;
				}
				
				
				
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		} while(menuNum != 0);
	}
	
	public int selectSearchList() throws Exception {
		System.out.println("\n========== [ 도서 정보 조회 ] ==========\n");
			
		System.out.println("1. 도서 목록 전체 조회");
		System.out.println("2. 제목으로 검색하기");
		System.out.println("3. 장르별로 검색하기");
		System.out.println("4. 낮은 가격 순으로 정리하기");
		System.out.println("5. 높은 가격 순으로 정리하기");
		System.out.println("0. 메인 메뉴로 돌아가기");
		
		System.out.print("메뉴 선택 >> ");
		int menuNum = Integer.parseInt(br.readLine());

		return menuNum;
		
	}
	
	public void bookListFullView() {
		System.out.println();
		for (Book list : service.bookListFullView()) {
			System.out.println(list);
		}
	}
	
	/**
	 * 제목으로 검색하기
	 */
	public void searchTitle() {
		
	}
	
	public void addBookList() throws Exception {
		System.out.println("\n========== [ 신규 도서 등록 ] ==========\n");
		
		while (true) {
			
			System.out.print("제목 : ");
			String title = br.readLine();
			
			System.out.print("저자 : ");
			String author = br.readLine();
			
			System.out.print("가격 : ");
			int price = Integer.parseInt(br.readLine());
			
			System.out.print("출판사 : ");
			String publisher = br.readLine();
			
			System.out.print("장르 : ");
			String category = br.readLine();
			
//			System.out.print("등록을 종료하려면 'exit' 입력해주세요.");
//			String exit = br.readLine();
//			
//			if(exit.equals("exit")) {
//				System.out.println("###### 도서 등록 종료 ######");
//				return;
//			} else {
				
			boolean temp = service.addBookList(title, author, price, publisher, category);
				
			if (temp) {
				System.out.println("[ 신규 도서 등록 완료 ]");
			} else {
				System.out.println("[ 신규 도서 등록 실패 ]");
			}
				
//			}
			
			System.out.println("등록을 종료하려면 'exit' 입력해주세요.");
			System.out.println("등록을 계속하시려면 아무 키나 눌러주세요.");
			String exit = br.readLine();
			
			if(exit.equals("exit")) {
				System.out.println("##### 도서 등록 종료 #####");
				return;
			}
		}
		
	}
}
