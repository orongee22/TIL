package ver06;

public abstract class PhoneInfor implements showPhoneInfo {
	// 정보 저장 클래스
	 
	 String name; // 친구의 이름 저장
	 String phoneNumber; // 친구의 전화번호 저장
	 
	 PhoneInfor(String name, String phoneNumber) {
		 this.name = name;
		 this.phoneNumber = phoneNumber;
	 }

	 // 정보를 입력하면 입력된 정보를 출력시키게 하는 메소드.
	 // main 메소드에서 호출시킬 거임.
	 public void showData() {
		 System.out.println("이름 : "+name);
		 System.out.println("전화번호 : "+phoneNumber);
	 }
	 
}
