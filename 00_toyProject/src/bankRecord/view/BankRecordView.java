package bankRecord.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import bankRecord.model.dto.BankRecord;
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
				case 1 : addAccount(); break;
				case 2 : deposit(); break;
				case 3 : withdraw(); break;
				case 4 : searchBalance(); break;
				case 5 : updatePassword(); break;
				case 6 : deleteAccount(); break;	
				case 7 : bankRecordList(); break;
				case 0 : System.out.println("@@@ 프로그램 종료 @@@"); break;
				default : System.out.println("### 메뉴에 작성된 번호만 입력해주세요 ###");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} while(input != 0);
	}
	
	public int selectMenu() throws Exception {
		System.out.println("\n========== 은행 계좌 프로그램 ==========\n");
		System.out.println("1. 계좌번호 생성");
		System.out.println("2. 입금하기");
		System.out.println("3. 출금하기");
		System.out.println("4. 잔액조회");
		System.out.println("5. 계좌 비밀번호 수정");
		System.out.println("6. 계좌 삭제");
		System.out.println("7. 고객 정보 전체 조회 (관리자 메뉴)");
		System.out.println("0. 프로그램 종료");
		
		System.out.print("메뉴 선택 >> ");
		
		int input = Integer.parseInt(br.readLine());
		
		return input;
	}
	
	public void bankRecordList() throws Exception {
		System.out.println("\n========== [계좌 전체 조회] ==========\n");
		
		System.out.print("관리자 비밀번호를 입력해주세요 : ");
		String manager = br.readLine();
		
		if(manager.equals("BankRecord")) {
			for(BankRecord list : service.FullView()) {
				System.out.println(list);
			}			
		} else {
			System.out.println("##### 관리자 비밀번호 오류 #####");
		}
		
	}
	
	public void addAccount() throws Exception {
		System.out.println("\n========== [신규 계좌번호 생성] ==========\n");
		
		String accountNum = service.randomAccount();
		
		if(accountNum.equals("중복")) {
			accountNum = service.randomAccount();
		}
		
		System.out.print("성함 : ");
		String name = br.readLine();
		
		boolean flag = false;
		
		String password = "";
		
		while(!flag) {
			
			System.out.print("비밀번호 입력 : ");
			password = br.readLine();
			
			System.out.print("비밀번호 확인 : ");
			String password2 = br.readLine();
			
			flag = service.checkPassword(password, password2);
			
			if(!flag) {
				System.out.println("입력하신 비밀번호가 일치하지 않습니다.");
			}
			
		}
		
		System.out.print("신규 계좌 개설시 입금할 금액 >> ");
		long balance = Long.parseLong(br.readLine());
		
		System.out.println(service.addAccount(accountNum, name, password, balance));
	}
	
	public void deposit() throws Exception {
		System.out.println("\n========== [입금] ==========\n");
		
		System.out.print("입금할 계좌번호 입력 (\"-\" 포함) : ");
		String accountNum = br.readLine();

		// 없으면 false 있으면 true
		boolean check = service.checkAccount(accountNum);

		if(check) {
			System.out.print("입금 금액 >> ");
			long balance = Long.parseLong(br.readLine());
			System.out.println(service.deposit(accountNum, balance));
			return;
		}
		
		while(!check) {
			System.out.println("존재하지 않는 계좌번호입니다.");
			System.out.println("계좌번호를 다시 입력해주세요.");
			System.out.print("입금하기를 종료하시겠습니까? (Y/N) : ");
			String exit = br.readLine();
			if(exit.toUpperCase().equals("Y")) {
				return;
			} else {
				check = true;
				deposit();
			}
		}
		
	}
	
	public void withdraw() throws Exception {
		System.out.println("\n========== [출금] ==========\n");

		System.out.print("출금할 계좌번호 입력 (\"-\" 포함) : ");
		String accountNum = br.readLine();
		
		boolean check = service.checkAccount(accountNum);
		
		if(check) {
			System.out.print("출금 금액 >> ");
			long balance = Long.parseLong(br.readLine());
			
			System.out.print("계좌 비밀번호 입력 : ");
			String password = br.readLine();
			
			boolean passCheck = service.rightPassword(accountNum,password);
			
			if(passCheck) {
				System.out.println(service.withdraw(accountNum, balance));
			} else {
				System.out.println("비밀번호가 일치하지 않습니다.");
				System.out.println("@@@ 출금 프로그램 종료 @@@");
			}
			
		}
		
		while(!check) {
			System.out.println("존재하지 않는 계좌번호입니다.");
			System.out.println("계좌번호를 다시 입력해주세요.");
			System.out.print("출금하기를 종료하시겠습니까? (Y/N) : ");
			String exit = br.readLine();
			if(exit.toUpperCase().equals("Y")) {
				return;
			} else {
				check = true;
				withdraw();
			}
		}
	}
	
	public void searchBalance() throws Exception {
		System.out.println("\n========== [잔액 조회] ==========\n");
		
		System.out.print("조회할 계좌번호 입력 (\"-\" 포함) : ");
		String accountNum = br.readLine();
		
		boolean check = service.checkAccount(accountNum);
		
		if(check) {
			System.out.print("계좌 비밀번호 입력 : ");
			String password = br.readLine();
			
			boolean passCheck = service.rightPassword(accountNum,password);
			
			while(!passCheck) {
				System.out.println("비밀번호 오류");
				System.out.print("비밀번호를 다시 입력해주세요. : ");
				String replay = br.readLine();
				
				boolean replayCheck = service.rightPassword(accountNum, replay);
				
				if(!replayCheck) {
					System.out.print("잔액 조회하기를 종료하시겠습니까? (Y/N) : ");
					String exit = br.readLine();
					
					if(exit.toUpperCase().equals("Y")) {
						return;
					}
				} else {
					passCheck = replayCheck;
				}
				
			}
			
			if(passCheck) {
				String answer = service.searchBalance(accountNum);
				System.out.println(answer);
			}
		}
	}
	
	public void updatePassword() throws Exception {
		System.out.println("\n========== [계좌 비밀번호 수정] ==========\n");
		
		System.out.print("비밀번호를 수정할 계좌 번호 입력 : ");
		String accountNum = br.readLine();
		
		boolean check = service.checkAccount(accountNum);
		
		if(check) {
			System.out.print("계좌 비밀 번호 입력 : ");
			String password = br.readLine();
			
			boolean passCheck = service.rightPassword(accountNum,password);
			
			String updatepw = "";
			
			if(passCheck) {
				boolean flag = false;
								
				while(!flag) {
					System.out.print("수정할 비밀번호 입력 : ");
					updatepw = br.readLine();
					
					System.out.print("수정할 비밀번호 확인 : ");
					String updatePw = br.readLine();
					
					flag = service.checkPassword(updatepw, updatePw);
					
					if(!flag) {
						System.out.println("비밀번호가 일치하지 않습니다.");
						System.out.println("수정을 종료하시겠습니까? (Y/N)");
						String exit = br.readLine();
						
						if(br.readLine().toUpperCase().equals("Y")) {
							System.out.println("@@@ 비밀번호 수정 종료 @@@");
							return;
						}
					}
				}
				
				System.out.print("정말 수정하시겠습니까? (Y/N) : ");
				String answer = br.readLine();
				
				if(answer.toUpperCase().equals("Y")) {
					String name = service.updatePassword(accountNum, updatepw);
					System.out.println(name + "님 계좌 비밀번호가 수정되었습니다.");
				} else {
					System.out.println("### 비밀번호 수정 종료 ###");
				}
			} else {
				System.out.println("\n계좌 비밀번호 불일치");
				System.out.println("@@@ 비밀번호 수정 프로그램 종료 @@@");
			}
			
		} else {
			System.out.println("존재하지 않는 계좌번호입니다.");
		}
		
	}
	
	public void deleteAccount() throws Exception {
		System.out.println("\n============= [계좌 삭제] =============\n");
		
		while(true) {
			
			System.out.print("삭제할 계좌번호 입력 : ");
			String accountNum = br.readLine();
		
			boolean check = service.checkAccount(accountNum);
			
			if(check) {
				
				System.out.print("비밀번호 입력 : ");
				String password = br.readLine();
				
				boolean passCheck = service.rightPassword(accountNum,password);
				
				String password2 = "";
				
				if(passCheck) {	
					
					System.out.print("비밀번호 확인 : ");
					password2 = br.readLine();
					
					boolean flag = service.checkPassword(password, password2);
					
					if(flag) {
						
						System.out.print("정말 삭제하시겠습니까? (Y/N) : ");
						String answer = br.readLine();
						
						if(answer.toUpperCase().equals("Y")) {
							String name = service.deleteAccount(accountNum);
							System.out.println( name + "님 계좌가 정삭적으로 삭제되었습니다.");
							return;
						} else {
							System.out.println("계좌 삭제가 취소되었습니다.");
							System.out.println("@@@ 계좌 삭제 프로그램 종료 @@@");
							return;
						}
						
					} else {
						
						System.out.println("비밀번호가 일치하지 않습니다.");
						System.out.print("계좌 삭제 프로그램을 종료하시겠습니까? (Y/N) : ");
						String exit = br.readLine();
						
						if(exit.toUpperCase().equals("Y")) {
							System.out.println("@@@ 계좌 삭제 프로그램 종료 @@@");
							return;
						}
					}
					
				} else {
					
					System.out.println("##### 계좌 비밀번호 불일치 #####");
					
					System.out.print("삭제를 계속 진행하시겠습니까? (Y/N) : ");
					String deleteRun = br.readLine();
					
					if(deleteRun.toUpperCase().equals("N")) {
						System.out.println("@@@ 계좌 삭제 프로그램 종료 @@@");
						return;
					}
					
				}
				
			} else {
				System.out.println("존재하지 않는 계좌번호입니다.");
				System.out.println("프로그램 종료");
				return;
			}
				
		}
	}
	
}
