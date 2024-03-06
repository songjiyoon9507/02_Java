package bookManagement.model.service;

import java.util.List;

import bookManagement.model.dto.Book;

public interface BookManagementService {
	
	List<Book> bookListFullView();

	boolean addBookList(String title, String author, int price, String publisher, String category) throws Exception;
}
