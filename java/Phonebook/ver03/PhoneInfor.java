package ver03_1;

public class PhoneInfor {

	// 정보 저장 클래스
	
	String name;
	String phoneNum;
	String birthDay;
	
	// 생성자로 변수 초기화 해줌.
	// 생년월일을 받는 생성자.
	PhoneInfor(String name, String num, String birth){
		// this.name은 클래스 변수를 가리킴
		this.name = name;
		phoneNum = num;
		birthDay = birth;
	}
	
	// 생년월일을 받지 않는 생성자.
	PhoneInfor(String name, String num){
		// birth 매개변수를 적지 않아도 오버로딩을 통해서 자동으로 값을 넣도록 만들었음.
		this(name, num, "등록된 정보가 없습니다.");
	}
	
	// 정보를 입력하면 입력된 정보를 출력시키게 하는 메소드.
	// main 메소드에서 호출시킬 거임.
	void showInfo() {
		System.out.println("이름 : "+name);
		System.out.println("전화번호 : "+phoneNum);
		System.out.println("생년월일 : "+birthDay);
	}
	
	
}
