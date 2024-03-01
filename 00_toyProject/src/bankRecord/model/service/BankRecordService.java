package bankRecord.model.service;

import java.util.List;

import bankRecord.model.dto.BankRecord;

public interface BankRecordService {
	List<BankRecord> FullView();
	
	public String randomAccount();
	
	public boolean checkPassword(String password, String password2);

	public String addAccount(String accountNum, String name, String password, long balance) throws Exception;
	
	public boolean checkAccount(String accountNum);

	public String deposit(String accountNum, long balance) throws Exception;
}
