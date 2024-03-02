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
			return false;
		}
	}
	
	public boolean rightPassword(String accountNum, String password) {
		int index = -1;
		
		for(int i = 0 ; i < dao.FullView().size() ; i++) {
			if(dao.FullView().get(i).getAccountNum().equals(accountNum)) {
				index = i;
				break;
			}
		}
		
		if(dao.FullView().get(index).getPassword().equals(password)) {
			return true;
		}
		return false;
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
			if(list.getAccountNum().equals(accountNum)) {
				flag = true;
				break;			
			}
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

	@Override
	public String withdraw(String accountNum, long balance) throws Exception {
		int index = dao.withdraw(accountNum, balance);
		
		String name = "";
		long money = 0;
		
		for(BankRecord list : dao.FullView()) {
			if(list.getAccountNum().equals(accountNum)) {
				name = list.getName();
				money = list.getBalance();
				break;			
			}
		}
		
		if (index == -1) {
			return "### "+ name + "님 계좌에 잔액이 부족합니다. ###\n남은 잔액 : " + money + "원";
		} else {
			return "출금이 완료되었습니다.\n" + name + "님 계좌 출금 후 잔액 : " + money + "원"; 
		}

		
	}

	@Override
	public String searchBalance(String accountNum) {
		String name = "";
		long money = 0;
		
		for(BankRecord list : dao.FullView()) {
			if(list.getAccountNum().equals(accountNum)) {
				name = list.getName();
				money = list.getBalance();
				break;			
			}
		}
		
		return "[ " + name + " ] 님의 계좌번호 : " + accountNum + "\n통장 잔고는 " + money + "원 입니다.";
	}

	@Override
	public String updatePassword(String accountNum, String updatepw) throws Exception {
		return dao.updatePassword(accountNum,updatepw);
	}

	@Override
	public String deleteAccount(String accountNum) throws Exception {
		return dao.deleteAccount(accountNum);
	}

}
