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
	
	
}
