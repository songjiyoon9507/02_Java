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

	@Override
	public String randomAccount() {
		int a = (int)(Math.random() * 888889  + 111111);
		int b = (int)(Math.random() * 99 + 1);
		int c = (int)(Math.random() * 888889  + 111111);
		
		String account = a + "-" + b + "-" + c;
		
		for(BankRecord list : dao.FullView()) {
			if (list.getAccountNum().equals(account)) {
				return "중복";
			}
		}
		
		return account;
	}
	
	@Override
	public boolean checkPassword(String password, String password2) {
		if(password.equals(password2)) return true;
		else {
			System.out.println("입력하신 비밀번호와 일치하지 않습니다. 비밀번호를 다시 입력해주세요.");
			return false;
		}
	}

	@Override
	public String addAccount(String accountNum, String name, String password, long balance) throws Exception {
		return dao.addAccount(accountNum, name, password, balance);
	}
	
	/**
	 * list 에 계좌번호 존재하면 true 반환
	 */
	@Override
	public boolean checkAccount(String accountNum) {
		boolean flag = false;
		
		for(BankRecord list : dao.FullView()) {
			list.getAccountNum().equals(accountNum);
			flag = true;
			break;
		}
		
		return flag;
	}

	/**
	 * index = -1이면 계좌 일치하는 거 없음
	 */
	@Override
	public String deposit(String accountNum, long balance) throws Exception {
		int index = -1;
		
		for(int i = 0 ; i < dao.FullView().size() ; i ++) {
			if(dao.FullView().get(i).getAccountNum().equals(accountNum)) {
				index = i;
				break;
			}
		}
		
		// index 존재하지 않으면 null
		// index 존재하면 계좌번호, 성함, 잔액 반환
		return dao.deposit(index,balance);
		
	}
	
	
	
	
}
