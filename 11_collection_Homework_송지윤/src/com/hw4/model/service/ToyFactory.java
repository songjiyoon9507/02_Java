package com.hw4.model.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.hw4.model.dto.Toy;

public class ToyFactory extends Toy {
	private Scanner sc = new Scanner(System.in);
	private List<Toy> toyList = new ArrayList<Toy>();
	private Map<Integer, String> materialList = new HashMap<Integer, String>();
	
	// 기본 생성자 호출했을 때 이미 List 있음
	public ToyFactory() {
		materialList.put(1, "면직물");
		materialList.put(2, "플라스틱");
		materialList.put(3, "유리");
		materialList.put(4, "고무");
		// 여기에 material 도 있어야함
		toyList.add(new Toy("마미롱레그", 8, 36000, "분홍색", 19950805, "1,4"));
		toyList.add(new Toy("허기워기", 5, 12000, "파란색", 19940312, "1,2"));
		toyList.add(new Toy("키시미시", 5, 15000, "분홍색", 19940505, "1,2"));
		toyList.add(new Toy("캣냅", 8, 27000, "보라색", 19960128, "1,2"));
		toyList.add(new Toy("파피", 12, 57000, "빨간색", 19931225, "1,2,4"));
	}
	
	public void displayMenu() {
		int menuNum = 1;
		
		do {
			
			System.out.println("<< 플레이타임 공장 >>");
			System.out.println("1. 전체 장난감 조회하기");
			System.out.println("2. 새로운 장난감 만들기");
			System.out.println("3. 장난감 삭제하기");
			System.out.println("4. 장난감 제조일 순으로 조회하기");
			System.out.println("5. 연령별 사용 가능한 장난감 리스트 조회하기");
			System.out.println("6. 재료 추가");
			System.out.println("7. 재료 제거");
			System.out.print("선택 : ");
			menuNum = sc.nextInt();
			sc.nextLine();
			
			switch(menuNum) {
			
			case 1 : allToy(); break;
			case 2 : newToy(); break;
			
			}
			
		} while(menuNum != 0);
	}
	
	public void allToy() {
		
		// toyList 다 보여주면 됨
		System.out.println("<전체 장난감 목록>");
		String temp;
		String m = "";
		for(Toy toy : toyList) {
			temp = toy.getMaterial();
			String[] arr = temp.split(",");
			// System.out.println(Arrays.toString(arr));
			
			
			for(int i = 0 ; i < arr.length ; i++) {
				// System.out.println(Integer.parseInt(arr[i]));
				m += materialList.get(Integer.parseInt(arr[i]));
				// System.out.println(materialList.get(Integer.parseInt(arr[i])));
			}
			System.out.println(m + "\n");
		}
		//toyList.setMaterial(m);
		
	}
	
	public void newToy() {
		
		// toyList 에 추가
		System.out.println("<새로운 장난감 추가>");
		
		System.out.print("장난감 이름 : ");
		String toyName = sc.nextLine();
		
		System.out.print("사용 가능 연령 : ");
		int useAge = sc.nextInt();
		sc.nextLine();
		
		System.out.print("가격 : ");
		int toyPrice = sc.nextInt();
		sc.nextLine();
		
		System.out.print("색상 : ");
		String toyColor = sc.nextLine();
		
		System.out.print("제조일(YYYYMMDD 형식으로 입력) : ");
		int date = sc.nextInt();
		
		while(true) {
			
			System.out.print("재료를 입력하세요 (종료하려면 'q'를 입력하세요) : ");
			String material = sc.next();
			
			
			
			if(material.equals("q")) {
				System.out.println("새로운 장난감이 추가되었습니다.");
				return;
			}
			
			
			
		}
		
		
	}
	
}
