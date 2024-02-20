package com.hw2.run;

import com.hw2.model.dto.Monkey;
import com.hw2.model.dto.Tiger;
import com.hw2.model.service.Zoo;

public class Run {
	public static void main(String[] args) {
		Zoo service = new Zoo();
		
		service.addAnimal(new Tiger("호랑이"));
		service.addAnimal(new Monkey("원숭이"));
		
		service.displayMenu();
	}
}
