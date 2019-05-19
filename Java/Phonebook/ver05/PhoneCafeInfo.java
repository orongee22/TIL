package ver05;

public class PhoneCafeInfo extends PhoneInfor {
	String nickname;

	public PhoneCafeInfo(String name, String phoneNumber, String nickname) {
		super(name, phoneNumber);
		this.nickname = nickname;
	}

	@Override
	public void showData() {
		// TODO Auto-generated method stub
		super.showData();
		System.out.println("닉네임 : "+nickname);
	}

	
	
}
