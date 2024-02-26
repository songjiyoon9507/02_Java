package edu.kh.todoList.model.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.kh.todoList.model.dao.TodoListDAO;
import edu.kh.todoList.model.dao.TodoListDAOImpl;
import edu.kh.todoList.model.dto.Todo;

public class TodoListServiceImpl implements TodoListService {

	// 필드
	private TodoListDAO dao = null;
	
	// 기본 생성자
	public TodoListServiceImpl() throws FileNotFoundException, IOException, ClassNotFoundException {
		// TodoListServiceImpl 객체가 생성될 때
		// TodoListDAOImpl 객체 생성
		dao = new TodoListDAOImpl();
		// 부모 타입 참조 변수 = 자식 객체(다형성 업캐스팅)
	}

	@Override
	public Map<String, Object> todoListFullView() {
		
		// 1. 할 일 목록 DAO에서 얻어오기
		List<Todo> todoList = dao.todoListFullView();
		
		// 2. 할 일 목록에서 완료(complete 필드 값이 true)인 요소가 몇 개인지 카운트
		int completeCount = 0;
		
		for(Todo todo : todoList) { // TodoList 순차 접근
			
			if (todo.isComplete()) { // true 인 경우
				completeCount++;
			}
			
		}
		
		// 3. todoList, completeCount 를 저장할 Map 생성
		// -> 메서드는 반환을 하나밖에 못해서
		//    여러 개를 반환해야 하는 경우 Map 같은 컬렉션에 묶어서 반환
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("todoList", todoList);
		map.put("completeCount", completeCount);
		
		// 4. map 반환
		return map;
	}

	@Override
	public String dateFormat(LocalDateTime regDate) {
		// yyyy-MM-dd HH:mm:ss 형태 날짜 반환
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		// regDate에 저장되어있는 날짜 데이터를
		// formatter 에 지정된 형식으로 변경
		String formattedDateTime = regDate.format(formatter);
		
		return formattedDateTime;
	}

	/**
	 * 할 일 상세 조회 서비스
	 */
	@Override
	public void todoDetailView(int index) {
		
		// 1. DAO에 있는 todoList에서 index 번째 요소(Todo) 반환 받기
		//    없으면 null 반환
		Todo todo = dao.todoDetailView(index);
	}
}
