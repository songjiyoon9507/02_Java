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

	private final String FILE_PATH = "/io_tset/BankRecord.dat";
	
	private ObjectInputStream ois = null;
	private ObjectOutputStream oos = null;
	
	private List<BankRecord> accountList = null;
	
	public BankRecordDAOImpl() throws Exception {
		
		File file = new File(FILE_PATH);
		
		if(file.exists()) {
			
			try {
				
				ois = new ObjectInputStream(new FileInputStream(FILE_PATH));
				
				accountList = (ArrayList<BankRecord>)ois.readObject();
				
			} catch (Exception e) {
				e.printStackTrace();
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

}
