package com.hw2.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hw2.model.dto.Animal;

public class Zoo {
	private Scanner sc = new Scanner(System.in);
	private List<Animal> ani = new ArrayList<Animal>();
	
	public Zoo() {}
	
	public void addAnimal(Animal animal) {
		ani.add(animal);
	}
	
	public void showAnimals() {
		System.out.println("동물들의 울음소리를 들어보세요:");
		for(Animal list : ani) {
			list.sound();
		}
	}
	
	public void displayMenu() {
		
		int menuNum = 1;
		
		do {
			
			System.out.println("****** KH 동물원 ******");
			System.out.println("원하는 작업을 선택하세요 : ");
			System.out.println("1. 동물들의 울음소리 듣기");
			System.out.println("2. 종료");
			System.out.print("선택: ");
			
			menuNum = sc.nextInt();
			
			if(menuNum == 1) {
				showAnimals();
			} else {
				System.out.println("프로그램을 종료합니다.");
			}
			
		} while(menuNum != 2);
	}
	
}
