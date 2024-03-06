package bookManagement.model.service;

import java.util.List;

import bookManagement.model.dao.BookManagementDAO;
import bookManagement.model.dao.BookManagementDAOImpl;
import bookManagement.model.dto.Book;

public class BookManagementServiceImpl implements BookManagementService {
	
	// DAO와 연결
	private BookManagementDAO dao = null;
	
	public BookManagementServiceImpl() throws Exception {
		dao = new BookManagementDAOImpl();
	}

	@Override
	public List<Book> bookListFullView() {
		return dao.bookListFullView();
	}

	/**
	 * 추가 되면 true 추가 안 되면 false 반환
	 */
	@Override
	public boolean addBookList(String title, String author, int price, String publisher, String category) throws Exception {
		// TODO Auto-generated method stub
		return dao.addBookList(title, author, price, publisher, category);
	}
	
	
}
