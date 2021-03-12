package ver04;

public class PhoneInfor {

	// 정보 저장 클래스
	
	String name; // 친구의 이름 저장
	String phoneNumber; // 친구의 전화번호 저장
	
	// 생성자로 변수 초기화 해줌.
	// 생년월일을 받는 생성자.
	

	public PhoneInfor(String name, String phoneNumber) {
		super(); // Object의 생성자 호출(생략가능)
		this.name = name;
		this.phoneNumber = phoneNumber;
	}


	// 정보를 입력하면 입력된 정보를 출력시키게 하는 메소드.
	// main 메소드에서 호출시킬 거임.
	public void showData() {
		System.out.println("이름 	: "+name);
		System.out.println("전화번호	: "+phoneNumber);
	}
	
	
//	// getter메소드
//	// 직접 참조가 불가한 private 변수를 반환하도록 함.
//	String getName() {
//		return this.name;
//	}
//	
//	// setter 메소드
//	// 변수의 값을 대입하는 메소드
//	void setName(String name) {
//		this.name = name;
//	}
}
