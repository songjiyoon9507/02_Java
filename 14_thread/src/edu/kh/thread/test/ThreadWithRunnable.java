package edu.kh.thread.test;

// Runnable 인터페이스 상속받아 쓰레드 생성하기
public class ThreadWithRunnable implements Runnable {
	// Runnable 인터페이스를 사용하는 방법은
	// 클래스 상속의 제약을 피하고 (단일상속의 제약)
	// 코드 재사용성을 높일 수 있기때문에 일반적으로 권장되는 방법
	// run() 메서드 하나만을 정의하고 있으므로,
	// 다른 클래스를 상속받은 상태에서도
	// Runnable 을 구현하여 쓰레드를 실행할 수 있음
	
	@Override
	public void run() {

		for(int i = 0 ; i < 5 ; i++) {
			System.out.println("Runnable : " + i);
			
			try {

				Thread.sleep(1000);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
