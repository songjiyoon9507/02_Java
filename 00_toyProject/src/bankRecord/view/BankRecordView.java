package bankRecord.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import bankRecord.model.service.BankRecordService;
import bankRecord.model.service.BankRecordServiceImpl;

public class BankRecordView {
	
	private BufferedReader br = null;
	private BankRecordService service = null;
	
	public BankRecordView() {
		try {
			
			service = new BankRecordServiceImpl();
			
			br = new BufferedReader(new InputStreamReader(System.in));
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void startView() {
		
		int input = 0;
		
		do {
			
			try {
				
				input = selectMenu();
				
				switch(input) {
				
				case 5 : break;
				case 0 : System.out.println("@@@ 프로그램 종료 @@@");
				default : System.out.println("### 메뉴에 작성된 번호만 입력해주세요 ###");
				}
				
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} while(input != 0);
	}
	
	public int selectMenu() throws Exception {
		System.out.println("\n==========  ==========\n");
		
		int input = Integer.parseInt(br.readLine());
		
		return input;
	}
	
}
