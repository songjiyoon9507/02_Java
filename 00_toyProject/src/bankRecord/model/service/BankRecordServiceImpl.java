package bankRecord.model.service;

import java.util.List;

import bankRecord.model.dao.BankRecordDAO;
import bankRecord.model.dao.BankRecordDAOImpl;
import bankRecord.model.dto.BankRecord;

public class BankRecordServiceImpl implements BankRecordService {
	
	private BankRecordDAO dao = null;
	
	public BankRecordServiceImpl() throws Exception {
		dao = new BankRecordDAOImpl();
	}
	
	@Override
	public List<BankRecord> FullView() {
		return dao.FullView();
	}

}
