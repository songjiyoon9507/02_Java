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
	
	public Prison(int size) {}

	@Override
	public void addPerson(Person person) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removePerson(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayAllPerson() {
		// TODO Auto-generated method stub
		
	}

	
}
