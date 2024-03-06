package bookManagement.model.dao;

import java.util.List;

import bookManagement.model.dto.Book;

public interface BookManagementDAO {
	
	/** 파일 저장
	 * @throws Exception
	 */
	void saveFile() throws Exception;
	
	List<Book> bookListFullView();

	boolean addBookList(String title, String author, int price, String publisher, String category) throws Exception;
}
