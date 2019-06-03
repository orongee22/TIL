package ver06;

public class PhoneCompanyInfo extends PhoneInfor {

	String company;
	String email;
	
	public PhoneCompanyInfo(String name, String phoneNumber, String company, String email) {
		super(name, phoneNumber);
		this.company = company;
		this.email = email;
	}
	
	public void showData() {
		super.showData();
		System.out.println("회사명 : "+company);
		System.out.println("이메일 : "+email);
		
	}
	
	public void showBasicInfo() {
		System.out.println("회사동료 "+name+"의 정보입니다.");
		System.out.println("전화번호는 "+phoneNumber+"입니다");
	}
}

