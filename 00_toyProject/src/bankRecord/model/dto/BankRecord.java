package bankRecord.model.dto;

import java.io.Serializable;

public class BankRecord implements Serializable {
	// 필드
	private String accountNum; // 계좌번호
	private String name; // 이름
	private long balance; // 잔액
	private String password; // 비밀번호
	
	public BankRecord() {}
	
	public BankRecord(String name, long balance, String password) {
		super();
		this.name = name;
		this.balance = balance;
		this.password = password;
	}

	public BankRecord(String accountNum, String name, long balance, String password) {
		this.accountNum = accountNum;
		this.name = name;
		this.balance = balance;
		this.password = password;
	}

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "[계좌번호] : " + accountNum + " / [성함] : " + name + " / [잔액] : " + balance + "원";
	}
	
}
