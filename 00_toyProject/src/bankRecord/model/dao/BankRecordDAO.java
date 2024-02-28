package bankRecord.model.dao;

import java.util.List;

import bankRecord.model.dto.BankRecord;

public interface BankRecordDAO {
	
	void saveFile() throws Exception;
	
	/** 전체 계좌 조회
	 * @return
	 */
	List<BankRecord> FullView();
	
}
