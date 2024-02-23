package edu.kh.io.pack3.model.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import edu.kh.io.pack3.model.dto.Member;

public class ObjectService {
	
	/* ObjectInputStream / ObjectOutputStream
	 * 
	 * - Java 객체(Instance == Object)를 입/출력 할 때
	 *   사용하는 바이트 기반 "보조" 스트림
	 *   (보조 스트림은 단독 사용 불가능)
	 * 
	 * *** 직렬화(Serializable) ***
	 * - 객체를 직렬(직선) 형태로 변환
	 * 
	 * */
	
	/**
	 * 객체를 외부 파일로 출력
	 */
	public void objectOutput() {
		
		// 기반 스트림 필요
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		// 스트림 참조 변수 선언 아직 객체 만들기 전
		
		try {
			// c 드라이브 Member.dat 경로에 가서 찾고 없으면 만들어줌
			fos = new FileOutputStream("/io_test/20240222/Member.dat");
			// .dat 확장자 : data 를 담고 있는 파일을 나타내는 확장자
			// 객체 만들어서 내보내려고 data 확장자 만듦 객체들 내보낼 때 쓰는 확장자
			
			oos = new ObjectOutputStream(fos); // 객체 보조 스트림 생성
			// try catch 문 안에 작성 예외 발생 때문에
			
			// Member 객체 하나 생성
			Member member = new Member("member01", "pass01", "김회원", 30);
			
			// ObjectOutStream을 이용해서 Member 객체를 출력하기
			oos.writeObject(member); // 객체를 쓰는 거여서 writeObject 사용
			// 객체 출력하는 구문
			
			System.out.println("회원 출력 완료");
			
			// java.io.NotSerializableException: edu.kh.io.pack3.model.dto.Member
			// 직렬화가 되지 않았다. : 객체에 대해서
			// 멤버 클래스 직렬화 해줘야함
				
		} catch(Exception e) { // 모든 예외 Exception
			e.printStackTrace();
		} finally {
			// Stream 꼭 문 닫아야함
			// 보조 스트림 닫으면 기반 스트림도 닫힘
			try {
				// 그냥 닫으면 또 예외 발생해서 try catch 안에 작성
				if(oos != null) oos.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
			
		}
	
	}
	
	/**
	 * 외부 파일로 부터 객체 입력 받기
	 */
	public void objectInput() {
		// 파일로 내보낸 .dat 파일 가지고 올거임
		// Member 객체 만들어서 내보낸 파일
		
		// 파일 가져오는 기반 스트림
		FileInputStream fis = null;
		// 보조 스트림
		ObjectInputStream ois = null;
		
		try {
			
			// 파일 입력 기반 스트림 생성
			fis = new FileInputStream("/io_test/20240222/Member.dat");
			
			// 객체 입력 보조 스트림 생성
			ois = new ObjectInputStream(fis);
			
			// 스트림을 이용해 파일에 작성된
			// 직렬화된 Member 객체를 읽어와
			// 역직렬화를 수행하여 정상적인 Member 객체로 변경
			
			// Object ois.readObject() : 직렬화된 객체를 읽어와 역직렬화
			// 반환형이 Object Member 객체로 변경(다운캐스팅) 해줘야함
			// 최상위 부모 Object
			
			Member member = (Member)ois.readObject();
			
			// 읽어온 내용 확인
			System.out.println(member);
			
//			Member [id=member01, pw=pass01, name=김회원, age=30]
			// 내부 파일 내용 그대로 전달돼서 옴
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			
			try {
				if(ois != null) ois.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
}
