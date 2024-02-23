package edu.kh.todoList.model.service;

import java.time.LocalDateTime;
import java.util.Map;

// Service :
// 데이터 가공, 로직 처리 등의 기능을 제공하는 역할

public interface TodoListService {
	// public abstract 가 없어도 추상 메서드
	
	/** 할 일 목록 반환 서비스
	 * @return todoList + 완료 개수
	 */
	Map<String, Object> todoListFullView();

	/** 날짜 포맷을 변환해서 반환
	 * @param regDate
	 * @return yyyy-MM-dd HH:mm:ss 형태 날짜 반환
	 */
	String dateFormat(LocalDateTime regDate);

}
