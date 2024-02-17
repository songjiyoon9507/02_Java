package com.hw2.model.service;

import com.hw2.model.dto.Person;
import com.hw2.model.dto.Prisoner;

public class Prison implements ManagementSystem {

	private Prisoner[] prisoners; // 전체 수용자 저장용 배열
	
	private int prisonerCount; // 수용자 수
	
	public Prisoner[] getPrisoners() {
		return prisoners;
	}

	public void setPrisoners(Prisoner[] prisoners) {
		this.prisoners = prisoners;
	}

	public int getPrisonerCount() {
		return prisonerCount;
	}

	public void setPrisonerCount(int prisonerCount) {
		this.prisonerCount = prisonerCount;
	}
	
	public Prison(int size) {
		prisoners = new Prisoner[size];
		prisonerCount = 0;
	}

	@Override
	public void addPerson(Person person) {
		for (int i = 0 ; i < prisoners.length ; i++) {
			if(prisoners[i] == null) {
				prisoners[i] = (Prisoner)person;
				// Person 이 부모라서 자식으로 강제 형변환
				prisonerCount++;
				System.out.println("수감자가 추가되었습니다 - " + prisoners[i].getInfo());
				break;
			}
			if(prisonerCount == 10) {
				System.out.println("인원이 모두 충원되었습니다.");
			}
		}
	}

	@Override
	public void removePerson(String id) {
		for(int i = 0 ; i < prisonerCount ; i++) {
			if(prisoners[i].getId().equals(id)) {
				System.out.println("수감자가 삭제되었습니다 - " + prisoners[i].getInfo());
				prisoners[i] = null;
				
				// 뒤에 있는 애들 앞으로 쌓아야 count 가 맞음
				// 빈 i 부터 쭉 넣어줘야함
				for (int j = i ; j < prisonerCount ; j++) {
					if(j == prisoners.length - 1)break;
					// 배열 길이 10 배열 길이 다 찼을 때 호출되면 오류 발생
					prisoners[j] = prisoners[j+1];
					// 그럼 count 가 뒤에 하나 남음
					if(prisoners[j] == null) {
						break;
					}
				}
				prisonerCount--;
			}
		}
	}

	@Override
	public void displayAllPerson() {
		// 전체 명단 출력
		// 위에서 count 가 세지니까 가능할 수도
		System.out.println("전체 수감자 명단 :");
		for( int i = 0 ; i < prisonerCount ; i++) {
			System.out.println(prisoners[i].getInfo());
		}
	}
}
