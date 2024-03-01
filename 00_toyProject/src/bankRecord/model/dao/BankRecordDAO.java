package bankRecord.model.dao;

import java.util.List;

import bankRecord.model.dto.BankRecord;

public interface BankRecordDAO {
	
	void saveFile() throws Exception;
	
	/** 전체 계좌 조회
	 * @return
	 */
	List<BankRecord> FullView();

	String addAccount(String accountNum, String name, String password, long balance) throws Exception;

	String deposit(int index, long balance) throws Exception;

}
