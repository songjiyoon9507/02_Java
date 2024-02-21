package com.hw4.model.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import com.hw4.model.dto.Toy;

public class ToyFactory {
	private Scanner sc = new Scanner(System.in);
	private Set<Toy> toyList = new HashSet<Toy>();
	private Map<Integer, String> materialList = new HashMap<Integer, String>();
	
	// 기본 생성자 호출했을 때 이미 List 있음
	public ToyFactory() {
		materialList.put(1, "면직물");
		materialList.put(2, "플라스틱");
		materialList.put(3, "유리");
		materialList.put(4, "고무");
		// 여기에 material 도 있어야함
		toyList.add(new Toy("마미롱레그", 36000, "분홍색", 8, 19950805, "면직물, 고무"));
		toyList.add(new Toy("허기워기", 12000, "파란색", 5, 19940312, "면직물, 플라스틱"));
		toyList.add(new Toy("키시미시", 15000, "분홍색", 5, 19940505, "면직물, 플라스틱"));
		toyList.add(new Toy("캣냅", 27000, "보라색", 8, 19960128, "면직물, 플라스틱"));
		toyList.add(new Toy("파피", 57000, "빨간색", 8, 19931225, "면직물, 플라스틱, 고무"));
	}
	
	public void displayMenu() {
		int menuNum = 1;
		
		do {
			
			System.out.println("\n<< 플레이타임 공장 >>");
			System.out.println("1. 전체 장난감 조회하기");
			System.out.println("2. 새로운 장난감 만들기");
			System.out.println("3. 장난감 삭제하기");
			System.out.println("4. 장난감 제조일 순으로 조회하기");
			System.out.println("5. 연령별 사용 가능한 장난감 리스트 조회하기");
			System.out.println("6. 재료 추가");
			System.out.println("7. 재료 제거");
			System.out.println("0. 프로그램 종료");
			System.out.print("선택 : ");
			menuNum = sc.nextInt();
			sc.nextLine();
			
			switch(menuNum) {
			
			case 1 : allToy(); break;
			case 2 : newToy(); break;
			case 3 : removeToy(); break;
			case 4 : sortByDate(); break;
			case 5 : groupAge(); break;
			case 6 : addMaterial(); break;
			case 7 : removeMaterial(); break;
			case 0 : System.out.println("프로그램 종료"); break;
			default : System.out.println("목록에 없는 번호입니다. 다시 선택해주세요.");
			}
			
		} while(menuNum != 0);
	}
	
	public void allToy() {
		
		System.out.println("\n<전체 장난감 목록>");
		int num = 0;
		for(Toy toy : toyList) {
			num++;
			System.out.println(num + ". " + toy);
		}
	}
	
	public void newToy() {
		
		// toyList 에 추가
		System.out.println("\n<새로운 장난감 추가>");
		
		System.out.print("장난감 이름 : ");
		String name = sc.nextLine();
		
		for(Toy toy : toyList) {
			if(toy.getToyName().equals(name)) {
				System.out.println("똑같은 장난감은 추가할 수 없습니다.");
				return;
			}
		}
		
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
		sc.nextLine();
		
		List<String> material = new ArrayList<String>();
		while(true) {
			
			System.out.print("재료를 입력하세요 (종료하려면 'q'를 입력하세요) : ");
			String input = sc.nextLine();
			
			if(input.equals("q")) {
				break;
			} else {
				material.add(input);
			}
		}
		
		String sb = "";
		
		for(int i = 0 ; i < material.size() ; i++) {
			if(i == material.size()-1) {
				
				sb += material.get(i);
			} else {
				sb += (material.get(i) + ", ");					
			}
		}
		toyList.add(new Toy(name, toyPrice, toyColor, useAge, date, sb));
		System.out.println("새로운 장난감이 추가되었습니다.");
	}
	
	public void removeToy() {
		System.out.print("삭제할 장난감의 이름을 입력하세요:");
		String name = sc.next();
		
//		for(Toy toy : toyList) {
//			
//			ArrayList<Toy> removeList = new ArrayList<Toy>();
//			
//			if(toy.getToyName().equals(name)) {
//				
//				System.out.println("장난감이 삭제되었습니다.");
//				break;
//			}
//		}
		
//		List<Toy> list = new ArrayList<Toy>(toyList);
//		
//		System.out.println(list);
		
//		boolean flag = false;
//		
//		for (int i = 0 ; i < toyList.size() ; i ++) {
//			if(toyList.contains(name)) {
//				toyList.remove(i);		
//				break;
//			} else {
//				flag = true;
//			}
//		}
//		if(flag) {
//			System.out.println("일치하는 장난감이 없습니다.");			
//		} else {			
//			System.out.println("장난감이 삭제되었습니다.");
//		}
		
		Iterator<Toy> it = toyList.iterator();
		
		boolean flag = false;
		
		while(it.hasNext()) {
			Toy toy = it.next();
			if(toy.getToyName().equals(name)) {
				toyList.remove(toy);
				flag = true;
				break;
			}
		}
		
		if(flag) {
			System.out.println("장난감이 삭제되었습니다.");
		} else {
			System.out.println("일치하는 장난감이 없습니다.");
		}
	}
	
	
	/**
	 * 장난감 제조일 순으로 조회하기
	 * 제조일 순으로 장난감을 정렬
	 */
	public void sortByDate() {
		System.out.println("\n<제조일 순으로 장난감을 정렬>");
		Iterator<Toy> it = toyList.iterator();
		List<Toy> list = new ArrayList<Toy>();
		while(it.hasNext()) {
			list.add(it.next());
		}
//		System.out.println(list);
		Collections.sort(list);
//		System.out.println(list.toString());
		int index = 0;
		for(Toy toy : list) {
			index++;
			System.out.println(index + ". " + toy);
		}
		
//		Comparator<Toy> dateComparator = Comparator.comparing(Toy::getDate);
//		Collections.sort(toyList,dateComparator);
//		while(it.hasNext()) {
//			Toy toy = it.next();
//			if(toy.getToyName().equals(name)) {
//				toyList.remove(toy);
//				flag = true;
//				break;
//			}
//		}
	}
	
	public void groupAge() {
		System.out.println("\n<연령별로 사용 가능한 장난감>");
		
		Comparator<Toy> ageComparator = Comparator.comparing(Toy::getUseAge);
		
		List<Toy> copy = new ArrayList<Toy>(toyList);
		
		Collections.sort(copy, ageComparator);
		
		int age = 0;
		int index = 0;
		
		for(int i = 0 ; i <copy.size() ; i++) {
			if(copy.get(i).getUseAge() != age) {
				index = 0;
				age = copy.get(i).getUseAge();
				System.out.printf("[연령:%d세]\n",age);
			}
			index++;
			System.out.println(index + ". " + copy.get(i).toString());
		}
		
		
		
		
//		List<Toy> copyToy = toyList;
//		
//		for(int i = 0 ; i < copyToy.size() ; i++) {
//			
//			int age = copyToy.g
//			
//		}
		
		
		
		
//		Iterator<Toy> it = toyList.iterator();
//		List<Toy> list = new ArrayList<Toy>();
//		while(it.hasNext()) {
//			list.add(it.next());
//		}
//		
//		boolean flag = false;
//		Set<Integer> age = new HashSet<Integer>(); 
//		
//		for(int i = 0 ; i < list.size() ; i++) {
//			age.add(list.get(i).getUseAge());
//			age.add(list.get(i).getUseAge());
//			System.out.printf("[연령:%d세]\n",age.remove(age));
//			flag = true;
//			for(int j = 0 ; j < list.size() ; j++) {
//				if(list.get(j).getUseAge() == age.) {
//					System.out.println(list.get(j));
//				}
//			}
//		}
		
//		if(flag) {
//			System.out.printf("[연령:%d세]\n",age);			
//		}
		
		
		
		
	}
	
	public void addMaterial() {
		
		System.out.println("\n<재료 추가>");
		System.out.println("*** 현재 등록된 재료 ***");
		
		Set<Entry<Integer, String>> entrySet = materialList.entrySet();
		
		for(Entry<Integer, String> entry : entrySet) {
			System.out.printf("%d: %s\n",entry.getKey(),entry.getValue());
		}
		
		while(true) {
			
			System.out.println("========================");
			System.out.print("재료 교유번호(key) 입력 : ");
			int num = sc.nextInt();
			sc.nextLine();
			
			System.out.print("재료명 입력 : ");
			String str = sc.nextLine();
			
			
			if(materialList.get(num) == null) {
				materialList.put(num, str);
				System.out.println("새로운 재료가 성공적으로 등록되었습니다.");
				return;
			} else {
				System.out.println("이미 해당 키에 재료가 등록되어 있습니다.");
				System.out.print("덮어쓰시겠습니까? (Y/N) : ");
				char ch = sc.next().toUpperCase().charAt(0);
				sc.nextLine();
				if (ch == 'Y') {
					materialList.put(num, str);
					System.out.println("재료가 성공적으로 덮어쓰기 되었습니다.");
					return;
				} else {
					System.out.println("덮어쓰기 취소");
					return;
				}
			}
		}
		
	}
	
	public void removeMaterial() {
		System.out.println("\n<재료 제거>");
		System.out.println("*** 현재 등록된 재료 ***");
		
		Set<Entry<Integer, String>> entrySet = materialList.entrySet();
		
		for(Entry<Integer, String> entry : entrySet) {
			System.out.printf("%d: %s\n",entry.getKey(),entry.getValue());
		}
		
		while(true) {
			System.out.println("========================");
			System.out.print("삭제할 재료명 입력 : ");
			String str = sc.nextLine();
			
			boolean flag = false;
			int temp = 0;
			
			for(Entry<Integer, String> entry : entrySet) {
				if(entry.getValue().equals(str)) {
					temp= entry.getKey();
					flag = true;
				}
			}
			
		if(flag) {
			materialList.remove(temp);
			System.out.printf("재료 \"%s\"가 성공적으로 제거되었습니다.\n",str);
			return;
		} else {
			System.out.println("해당 이름의 재료가 존재하지 않습니다.");
			return;
		}
				
//				System.out.println("새로운 재료가 성공적으로 등록되었습니다.");
//				return;
//			} else {
//				System.out.println("이미 해당 키에 재료가 등록되어 있습니다.");
//				System.out.print("덮어쓰시겠습니까? (Y/N) : ");
//				char ch = sc.next().toUpperCase().charAt(0);
//				if (ch == 'Y') {
//					materialList.put(num, str);
//					System.out.println("재료가 성공적으로 덮어쓰기 되었습니다.");
//					return;
//				} else {
//					System.out.println("덮어쓰기 취소");
//					return;
//				}
//			}
		}
	}
}
