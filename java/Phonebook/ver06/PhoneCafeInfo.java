package ver06;

public class PhoneCafeInfo extends PhoneInfor {
	String nickname;

	public PhoneCafeInfo(String name, String phoneNumber, String nickname) {
		super(name, phoneNumber);
		this.nickname = nickname;
	}

	@Override
	public void showData() {
		super.showData();
		System.out.println("닉네임 : "+nickname);
	}

		 
	public void showBasicInfo() {
		System.out.println("동호회 친구 "+name+"의 정보입니다.");
		System.out.println("전화번호는 "+phoneNumber+"입니다");
	}
}