package ver06;


public class PhoneUnivInfo extends PhoneInfor {
	
	String address; // 주소
	String email; // 이메일
	String major; // 전공
	int grade; // 학년
	
	// 데이터의 초기화
	PhoneUnivInfo(String name, String phoneNumber, String address, String email, String major, int grade){
		super(name, phoneNumber); // 상위 클래스의 생성자 호출 : 멤버변수의 초기화
		this.address = address;
		this.email = email;
		this.major = major;
		this.grade = grade;
				
	}
	
	@Override
	public void showData() {
		super.showData();
		System.out.println("주소	: "+address);
		System.out.println("이메일	: "+email);
		System.out.println("전공	: "+major);
		System.out.println("학년	: "+grade);
	}
	
	public void showBasicInfo() {
		System.out.println("대학친구 "+name+"의 정보입니다.");
		System.out.println("전화번호는 "+phoneNumber+"입니다");
	}
	
}
