package bankRecord.model.dao;

import java.io.File;
import java.io.FileInputStream;
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
			
			
		}
	}
	
	@Override
	public void saveFile() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<BankRecord> FullView() {
		// TODO Auto-generated method stub
		return null;
	}

}
