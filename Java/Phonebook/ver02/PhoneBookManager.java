package ver02_1;

import java.util.Scanner;

import util.Util;

class PhoneBookManager {
	
	
	private PhoneBookManager(){	};
	
	private static PhoneBookManager pbManager = new PhoneBookManager();

	public static PhoneBookManager getinstance() {
		return pbManager;
	}
	void getInfo() {
		String name = null;
		String birth = null;
		String number = null;
		Util.keyboard.nextLine();
		
		System.out.println("이름을 입력하세요");
		name = Util.keyboard.nextLine();
		
		System.out.println("전화번호를 입력하세요.");
		birth = Util.keyboard.nextLine();
		
		System.out.println("생년월일을 입력하세요.");
		number = Util.keyboard.nextLine();
		
		PhoneInfor phoneinfor = null;
		
		if(birth == null || birth.trim().length()<1) {
			phoneinfor = new PhoneInfor(name, number);
		} else {
			phoneinfor = new PhoneInfor(name, number, birth);
		}
		
		phoneinfor.showInfo();
	}
}
