
public class ShowThreadMain {

	public static void main(String[] args) {
		// ShowThread 객체 생성
		Runnable show = new ShowThread("주주주");
		Thread t1 = new Thread(show);
		
		// ShowThread1 객체 생성
		ShowThread1 t2 = new ShowThread1("예예예");
		
		t1.start();
		t2.start();
		
		
		
//		결과
//		안녕하세요. 예예예입니다.
//		안녕하세요. 주주주입니다.
//		안녕하세요. 예예예입니다.
//		안녕하세요. 주주주입니다.
//		안녕하세요. 예예예입니다.
//		안녕하세요. 주주주입니다.
//		안녕하세요. 주주주입니다.
//		안녕하세요. 예예예입니다.
//		안녕하세요. 예예예입니다.
//		안녕하세요. 주주주입니다.

	}

}
