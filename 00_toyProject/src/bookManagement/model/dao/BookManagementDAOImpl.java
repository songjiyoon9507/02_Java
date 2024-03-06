package bookManagement.model.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import bookManagement.model.dto.Book;

public class BookManagementDAOImpl implements BookManagementDAO {
	
	// C 드라이브 toy_project 폴더에 BookManagement 파일로 생성 예정
	private final String FILE_PATH = "/toy_project/BookManagement.dat";
	
	// 아래로 3개 다 이름만 만들어 둔 것
	
	// 객체 input output 스트림을 null 로 선언해둠
	private ObjectInputStream ois = null;
	private ObjectOutputStream oos = null;
	
	// Book 사용자 정의 자료형 List null 로 참조변수만 선언
	private List<Book> bookList = null;
	
	public BookManagementDAOImpl() throws Exception {
		// DAOImpl 을 호출해서 사용할 때 만들어질 것들
		
		// 1. 파일
		File file = new File(FILE_PATH);
		
		if(file.exists()) {
			// 저 폴더에 저 파일이 존재할 때
			try {
				// 폴더에 있는 파일을 InputSteam 통해 읽어와
				// ObjectStream 통해서 객체 변환
				ois = new ObjectInputStream(new FileInputStream(FILE_PATH));
				
				// 읽어온 객체를 다운 캐스팅 하여 bookList에 넣어줌
				bookList = (ArrayList<Book>)ois.readObject();
			} finally {
				if(ois != null) ois.close();
			}
		} else {
			// 파일이 존재하지 않을 때
			
			File directory = new File("/toy_project");
			if(!directory.exists()) directory.mkdir();
			// toy_project 폴더 없을 때 폴더 생성
			// C 드라이브에 폴더 있고 바로 파일이라서 mkdir() 사용
			// 폴더 안에 폴더 안에 폴더... 라면 mkdirs() 사용해서
			// 모든 폴더 생성해줘야함
			
			bookList = new ArrayList<Book>();
			
			bookList.add(new Book(1, "셈을 할 줄 아는 까막눈이 여자", "요나스 요나손", 13320, "열린책들", "장편소설"));
			bookList.add(new Book(2, "거인의 노트", "김익한", 16200, "다산북스", "자기계발"));
			bookList.add(new Book(3, "와카바소 셰어하우스입니다", "하타노 도모미", 14400, "넥서스", "장편소설"));
			bookList.add(new Book(4, "미루기의 기술", "존 페리", 10800, "21세기북스", "자기계발"));
			bookList.add(new Book(5, "메리골드 마음 세탁소", "윤정은", 13500, "북로망스", "장편소설"));
			bookList.add(new Book(6, "달러구트 꿈 백화점 : 잠들어야만 입장 가능합니다", "이미예", 24840, "팩토리나인", "장편소설"));
			
			// bookList 객체 생성해서 Output 스트림 통해서 파일에 넣어줌
			try {
				oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
				oos.writeObject(bookList);
			} finally {
				if(oos != null) oos.close();
			}
			System.out.println("*** bookList.dat 파일 생성 완료 ***");
		}
	}

	@Override
	public void saveFile() throws Exception {
		try {
			// 덮어쓰기
			oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
			oos.writeObject(bookList);
		} finally {
			oos.close();
		}
	}

	@Override
	public List<Book> bookListFullView() {
		return bookList;
	}

	@Override
	public boolean addBookList(String title, String author, int price, String publisher, String category) throws Exception {
		// index + 1 도서 번호 등록
		boolean temp = bookList.add(new Book(bookList.size()+1, title, author, price, publisher, category));
		saveFile();
		return temp;
	}
}
