package ver01;


public class PhoneBookMain {
	
	public static void main(String[] args) {
		// 데이터를 저장하고 출력하는 프로그램
		
		PhoneInfo pi1 = new PhoneInfo("홍길동", "01002150101", "19940429");
		
		PhoneInfo pi2 = new PhoneInfo("우왕", "0101541895");

		
		pi1.showInfo();
		System.out.println("----------------");
		pi2.showInfo();
	
	}

}
