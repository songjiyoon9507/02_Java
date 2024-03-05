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
				
				case 1 : bookListFullView(); break;
				
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
		
		System.out.println("1. 도서 목록 전체 조회");
		System.out.println("2. 도서 등록하기");
		
		System.out.println("0. 프로그램 종료");
		
		System.out.print("메뉴 선택 >> ");
		int input = Integer.parseInt(br.readLine());
		return input;
	}
	
	public void bookListFullView() {
		System.out.println("\n========== [ 도서 정보 전체 조회 ] ==========\n");
		
		for (Book list : service.bookListFullView()) {
			System.out.println(list);
		}
	}
}
