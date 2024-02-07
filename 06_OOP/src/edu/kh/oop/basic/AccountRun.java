package edu.kh.oop.basic;

public class AccountRun {
	public static void main(String[] args) {
		
		Account a1 = new Account();
		
		a1.setName("송지윤");
		a1.setAccountNumber("1234-56-7890");
		a1.setBalance(100000);
		a1.setPassword("7890");
		
		
		System.out.println( a1.getName());
		System.out.println( a1.getAccountNumber());
		System.out.println( a1.getBalance());
		System.out.println( a1.getPassword());
		
		a1.deposit(200000); // 입금
		a1.withdraw("1234", 100000);
		a1.withdraw("7890", 100000000);
		a1.withdraw("7890", 1000);
		
		Account a2 = new Account();
		
		a2.setAccountNumber("7777-777-77777");
		a2.setName("박수찬");
		a2.setBalance(1000);
		a2.setPassword("1111");
		
		a2.deposit(10000);
		a2.withdraw("2222", 1000);
		a2.withdraw("1111", 10000000);
		a2.withdraw("1111", 5000);
	}
}