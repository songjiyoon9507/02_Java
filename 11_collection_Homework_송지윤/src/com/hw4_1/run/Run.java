package com.hw4_1.run;

import com.hw4_1.model.service.ToyFactory;

public class Run {
	public static void main(String[] args) {
		
		ToyFactory factory = new ToyFactory();
		factory.displayMenu();
	}
}