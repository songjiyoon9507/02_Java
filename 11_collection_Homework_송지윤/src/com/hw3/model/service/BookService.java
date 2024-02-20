package com.hw3.model.service;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import com.hw3.model.dto.Book;

public class BookService {
	private Scanner sc = new Scanner(System.in);
	private ArrayList<Book> bookList = new ArrayList<Book>();
	private ArrayList<Book> favoriteList = new ArrayList<Book>();
	
	public BookService() {
		bookList.add(new Book(1111, "세이노의 가르침", "세이노", 6480, "데이원"));
		bookList.add(new Book(2222, "문과남자의 과학공부", "유시민", 15750, "돌베개"));
		bookList.add(new Book(3333, "역행자", "자청", 17550, "웅진지식하우스"));
		bookList.add(new Book(4444, "꿀벌의 예언", "베르나르 베르베르", 15120, "열린책들"));
		bookList.add(new Book(5555, "도둑맞은 집중력", "요한 하리", 16920, "어크로스"));
	}
	
	public void displayMenu () {
		
		int menuNum = 1;
		
		do {
			
			System.out.println("\n=== 도서 목록 프로그램 ===\n");
			System.out.println("1. 도서 등록\n");
			System.out.println("2. 도서 조회\n");
			System.out.println("3. 도서 수정\n");
			System.out.println("4. 도서 삭제\n");
			System.out.println("5. 즐겨찾기 추가\n");
			System.out.println("6. 즐겨찾기 삭제\n");
			System.out.println("7. 즐겨찾기 조회\n");
			System.out.println("8. 추천도서 뽑기\n");
			System.out.println("0. 프로그램 종료\n");
			
			System.out.print("메뉴를 입력하세요 : ");
			menuNum = sc.nextInt();
			
			switch(menuNum) {
			
			case 1 : addBook(); break;
			case 2 : searchBook(); break;
			case 3 : updateBook(); break;
			case 4 : removeBook(); break;
			case 5 : addFavorite(); break;
			case 6 : deleteFavorite(); break;
			case 7 : displayFavorite(); break;
			case 8 : randomPick(); break;
			case 0 : System.out.println("프로그램 종료"); break;
			default : System.out.println("잘못 입력하셨습니다."); break;
			}
			
			
		} while (menuNum != 0);
		
	}
	
	
	/**
	 * 도서 등록
	 * 도서 번호, 도서 제목, 도서 저자, 도서 가격, 도서 출판사 입력 받고
	 * 등록 완료 출력
	 */
	public void addBook() {
		System.out.println("\n===== 도서 등록 =====\n");
		
		System.out.print("도서 번호 : ");
		int bookNum = sc.nextInt();
		sc.nextLine();
		
		System.out.print("\n도서 제목 : ");
		String title = sc.nextLine();
		
		System.out.print("\n도서 저자 : ");
		String author = sc.nextLine();
		
		System.out.print("\n도서 가격 : ");
		int price = sc.nextInt();
		sc.nextLine();
		
		System.out.print("\n도서 출판사 : ");
		String publisher = sc.nextLine();
		
		bookList.add(new Book(bookNum, title, author, price, publisher));
		
		System.out.println("\n등록 완료");
	}
	
	
	/**
	 * 도서 조회
	 */
	public void searchBook() {
		for(Book list : bookList) {
			System.out.println(list.toString());
		}
	}
	
	/**
	 * 도서 수정
	 * 도서 번호 입력 받아서 수정
	 * 도서명, 도서 저자, 도서 가격, 도서 출판사
	 * 도서번호빼고 다 바꿈
	 * 0 수정 종료
	 */
	public void updateBook() {
		
		System.out.println("\n======= 도서 수정 =======\n");
		
		System.out.print("수정할 도서 번호를 입력하세요 : ");
		int num = sc.nextInt();
		
		boolean flag = false;
		for(Book list : bookList) {
			if(list.getBookNum() == num) {
				flag = true;
			}
		}
		
		if(flag) {
			System.out.println("\n1. 도서명\n");
			System.out.println("2. 도서 저자\n");
			System.out.println("3. 도서 가격\n");
			System.out.println("4. 도서 출판사\n");
			System.out.println("0. 수정 종료\n");
			
			System.out.print("어떤 정보를 수정하시겠습니까? ");
			int x = sc.nextInt();
			sc.nextLine();
			
//			do {
				
				switch(x) {
				
				case 1 :
					System.out.println("\n===== 도서명 수정 =====\n");
					System.out.print("수정할 도서명을 입력하세요 : ");
					String title = sc.nextLine();
					modifyTitle(title, num);
					break;
					
				case 2 :
					System.out.println("\n===== 도서 저자 수정 =====\n");
					System.out.print("수정할 저자명을 입력하세요 : ");
					String author = sc.nextLine();
					modifyAuthor(author, num); break;
					
				case 3 : 
					System.out.println("\n===== 도서 가격 수정 =====\n");
					System.out.print("수정할 가격을 입력하세요 : ");
					int price = sc.nextInt();
					sc.nextLine();
					modifyPrice(price, num); break;
					
				case 4 :
					System.out.println("\n===== 도서 출판사 수정 =====\n");
					System.out.print("수정할 출판사명을 입력하세요 : ");
					String publisher = sc.nextLine();
					modifyAuthor(publisher, num); break;
				
				case 0 : System.out.println("\n수정을 종료합니다."); break;
				
				default : System.out.println("\n잘못 입력하셨습니다."); break;
				
				
				}
//			} while(x != 0);
			
//			if(x == 1) {
//				System.out.println("\n===== 도서명 수정 =====\n");
//				System.out.print("수정할 도서명을 입력하세요 : ");
//				String title = sc.nextLine();
//				if(title != null) {
//					System.out.println(modifyTitle(title, num));
//				}
//			}
			
//			while(x != 0) {
				
//			}
			
			
		} else {
			System.out.println("\n일치하는 도서 정보가 없습니다.");
		}
	}
	
	
	/**
	 * 도서명 수정
	 */
	public void modifyTitle(String title, int num) {
		
		
		
		// 도서번호로 받아온 애의 title 교체
		// 수정할 도서명을 입력하세요
		// 입력 받고
		// bookList.get(i) == num 일 때
		// 
		// bookList.get(i) 수정해주고
		// 수정 완료 출력
//		boolean flag = true;	
//		int index = 0;
		
//		for(Book list : bookList) {
//			index++;
//			if (list.getBookNum() == num) {
//				flag = true;
//				break;
//			}
//		}
//		
//		if (flag) {
//			bookList.get(index).setTitle(title);
//			System.out.println("\n수정 완료");			
//		}
		int index = 0;
		boolean flag = false;
		for(Book list : bookList) {
			index++;
			if(list.getBookNum() == num) {
				flag = true;
				break;
			}
		}
		
		if(flag) {
			bookList.get(index-1).setTitle(title);
			System.out.println("\n수정 완료");
		}
		
	}
	
	/**
	 * 도서 저자 수정
	 */
	public void modifyAuthor(String author, int num) {
		int index = 0;
		boolean flag = false;
		for(Book list : bookList) {
			index++;
			if(list.getBookNum() == num) {
				flag = true;
				break;
			}
		}
		if(flag) {
			bookList.get(index-1).setAuthor(author);
			System.out.println("\n수정 완료");
		}
	}
	
	/**
	 * 도서 가격 수정
	 */
	public void modifyPrice(int price, int num) {
		int index = 0;
		boolean flag = false;
		for(Book list : bookList) {
			index++;
			if(list.getBookNum() == num) {
				flag = true;
				break;
			}
		}
		if(flag) {
			bookList.get(index-1).setPrice(price);;
			System.out.println("\n수정 완료");
		}
	}
	
	/**
	 * 도서 출판사 수정
	 */
	public void modifyPublisher(String publisher, int num) {
		int index = 0;
		boolean flag = false;
		for(Book list : bookList) {
			index++;
			if(list.getBookNum() == num) {
				flag = true;
				break;
			}
		}
		if(flag) {
			bookList.get(index-1).setAuthor(publisher);
			System.out.println("\n수정 완료");
		}
	}
	
	/**
	 * 도서 삭제
	 * 번호 받아서 삭제하시겠습니까 물어보고
	 * 삭제
	 */
	public void removeBook() {
		System.out.println("\n===== 도서 삭제 =====\n");
		System.out.print("삭제할 도서 번호를 입력하세요 : ");
		int num = sc.nextInt();
		sc.nextLine();
		
		int index = 0;
		boolean flag = true;
		// 존재하는 번호인지 아닌지 먼저
		for(Book list : bookList) {
			index++;
			if(list.getBookNum() == num) {
				flag = false;
				break;
			}
		}
		
		if(flag) { // 존재하는 도서번호 아닐 때
			System.out.println("일치하는 도서 번호가 없습니다.");
		} else {
			System.out.print("\n정말 삭제하시겠습니까? (Y/N) : ");
			char ch = sc.next().toUpperCase().charAt(0);
			if(ch == 'Y') {
				Book remove = bookList.remove(index-1);
				System.out.println("\n" + remove.getTitle() + " 삭제 완료");
			} else {
				System.out.println("삭제 취소");
			}
			
		}
	}
	
	// favoriteList
	public void addFavorite() {
		System.out.println("\n===== 즐겨찾기 추가 =====");
		System.out.print("\n즐겨찾기에 추가할 도서 번호 입력 : ");
		int num = sc.nextInt();
		boolean flag = false;
		
		for(int i = 0 ; i < bookList.size(); i++) {
			Book temp = bookList.get(i);
			if(temp.getBookNum() == num) {
				favoriteList.add(temp);
				System.out.println("\n즐겨찾기 추가 완료");
				System.out.println("\n즐겨찾기에 추가된 도서명 : " + temp.getTitle());
				flag = true;
				break;
			}
		}
		if(!flag) {
			System.out.println("\n일치하는 도서 번호가 없습니다.");
		}
	}
	
	public void deleteFavorite() {
		System.out.println("\n===== 즐겨찾기 삭제 =====");
		System.out.print("\n즐겨찾기에서 삭제할 도서 번호 입력 : ");
		int num = sc.nextInt();
		sc.nextLine();
		
		boolean flag = true;
		for(int i = 0; i < favoriteList.size() ; i++) {
			if(favoriteList.get(i).getBookNum() == num) {
				flag = false;
				System.out.print("\n정말 삭제하시겠습니까? (Y/N) : ");
				char ch = sc.next().toUpperCase().charAt(0);
				if(ch == 'Y') {
					favoriteList.remove(i);
					System.out.println("\n즐겨찾기에서 삭제되었습니다.");
				} else {
					System.out.println("\n즐겨찾기 삭제 취소");
				}
			}
		}
		if(flag) {
			System.out.println("\n즐겨찾기 목록에 존재하지 않는 도서 번호입니다.");
		}
	}
	
	public void displayFavorite() {
		System.out.println("\n===== 즐겨찾기 조회 =====");
		
		if(favoriteList.size() == 0) {
			System.out.println("\n즐겨찾기 목록이 비어있습니다.");
		}
		
		for(Book list : favoriteList) {
			System.out.println(list.toString());
		}
	}
	
	public void randomPick() {
		
		System.out.println("\n===== 추천 도서 뽑기 =====");
		
		int i = (int)(Math.random()*bookList.size());

		System.out.println(bookList.get(i).toString());
		
	}
}
