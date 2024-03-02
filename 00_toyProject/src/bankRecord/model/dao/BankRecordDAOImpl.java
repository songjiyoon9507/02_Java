package bankRecord.model.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import bankRecord.model.dto.BankRecord;

public class BankRecordDAOImpl implements BankRecordDAO {

	private final String FILE_PATH = "/io_test/BankRecord.dat";
	
	private ObjectInputStream ois = null;
	private ObjectOutputStream oos = null;
	
	private List<BankRecord> accountList = null;
	
	public BankRecordDAOImpl() throws Exception {
		
		File file = new File(FILE_PATH);
		
		if(file.exists()) {
			
			try {
				
				ois = new ObjectInputStream(new FileInputStream(FILE_PATH));
				
				accountList = (ArrayList<BankRecord>)ois.readObject();
				
			} finally {
				if(ois != null) ois.close();
			}
			
		} else {
			
			File directory = new File("/io_test");
			if(!directory.exists()) directory.mkdir();
			
			accountList = new ArrayList<BankRecord>();
			
			accountList.add(new BankRecord("111111-11-111111", "홍길동", 1000000, "pass01"));
			accountList.add(new BankRecord("222222-22-222222", "이순신", 1500000, "pass02"));
			accountList.add(new BankRecord("333333-33-333333", "유관순", 2000000, "pass03"));
			accountList.add(new BankRecord("444444-44-444444", "연개소문", 2500000, "pass04"));
			accountList.add(new BankRecord("555555-55-555555", "신사임당", 3000000, "pass05"));
			
			try {
				oos= new ObjectOutputStream(new FileOutputStream(FILE_PATH));
				oos.writeObject(accountList);
			} finally {
				if(oos != null) oos.close();
			}
			System.out.println("*** accountList.dat 파일 생성 완료 ***");
		}
	}
	
	@Override
	public void saveFile() throws Exception {
		try {
			oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
			oos.writeObject(accountList);
		} finally {
			oos.close();
		}
	}

	@Override
	public List<BankRecord> FullView() {
		return accountList;
	}

	@Override
	public String addAccount(String accountNum, String name, String password, long balance) throws Exception {
		
		if (accountList.add(new BankRecord(accountNum, name, balance, password))) {	
			saveFile();
			return name + "님 신규 계좌 개설되었습니다.\n계좌번호 : " + accountNum;
		} else {
			return "계좌 개설 실패";
		}
	}

	@Override
	public String deposit(int index, long balance) throws Exception {
		if(index != -1) {
			long money = accountList.get(index).getBalance();
			long result = money + balance;
			accountList.get(index).setBalance(result);
			saveFile();
			return accountList.get(index).getName() + "님 계좌에 " + balance + "원이 입금되었습니다.";
		} else {
			return "존재하지 않는 계좌번호입니다.";
		}
	}

	/**
	 * 잔액 부족이면 -1
	 * 아니면 balance 출금하고 saveFile return index number
	 */
	@Override
	public int withdraw(String accountNum, long balance) throws Exception {
		int index = -1;
		
		for(int i = 0 ; i < accountList.size() ; i++) {
			if(accountList.get(i).getAccountNum().equals(accountNum)) {
				index = i;
			}
		}
		
		if(accountList.get(index).getBalance() >= balance) {
			long money = accountList.get(index).getBalance();
			accountList.get(index).setBalance(money - balance);
			saveFile();
			return index;	
		} else {
			index = -1;
			return index;
		}
		
	}

	@Override
	public String updatePassword(String accountNum, String updatepw) throws Exception {
		
		String name = "";
		
		for(BankRecord list : accountList) {
			if(list.getAccountNum().equals(accountNum)) {
				name = list.getName();
				list.setPassword(updatepw);
				saveFile();
				break;
			}
		}
		
		return name;
	}

	@Override
	public String deleteAccount(String accountNum) throws Exception {

		String name = "";
		int index = 0;
		
		for(int i = 0 ; i < accountList.size() ; i++) {
			if(accountList.get(i).getAccountNum().equals(accountNum)) {
				index = i;
				name = accountList.get(index).getName();
				accountList.remove(index);
				saveFile();
				break;
			}
		}
		
		return name;
	}

}
