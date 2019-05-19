package ver01;

public class PhoneInfo {
	String name; // 이름 저장
	String phoneNumber; // 전화번호 저장
	String birthday; // 생년월일 저장
	
	// 속성 = 변수 = 필드는 같다.
	
	
	
	// 생성자 : 기본 정보 초기화(이름,전화번호,생년월일)
	public PhoneInfo(String name, String phoneNumber, String birthday) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
	}

	// 생성자 : 이름과 전화번호 저장
	public PhoneInfo(String name, String phoneNumber) {
		this(name, phoneNumber, "저장된 데이터가 없습니다."); // 오버로딩 생성자
	}
	
	// 정보출력 메소드
	void showInfo() {
		System.out.println("이름: "+name);
		System.out.println("전화번호: "+phoneNumber);
		System.out.println("생년월일 : "+birthday);
		
//		if(birthday != null) {
//			System.out.println("생년월일: "+birthday);
//		} else { 
//			System.out.println("생년월일: 등록된 정보가 없습니다.");
//		}
		// 생성자에 오버로딩을 사용하면 if문 사용없이도 null값 입력받을 수있음 ㅇㅋㅇㅋ
	}
	
	
}
