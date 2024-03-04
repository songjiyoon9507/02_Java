package bookManagement.model.dao;

import java.util.List;

import bookManagement.model.dto.Book;

public interface BookManagementDAO {
	
	/** 파일 저장
	 * @throws Exception
	 */
	void saveFile() throws Exception;
	
	List<Book> bookListFullView();
}
