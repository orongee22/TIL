package ver02_1;

import java.util.Scanner;

import util.Util;

public class PhoneBookMain {
	
	
	// 값을 입력받기 위해 스캐너 객체를 생성함.
	// static인 이유는 밑에서 getInfo를 static메소드로 만들기 때문임.
	// 객체를 생성하고 초기화 시켜둠. 일단.
	
	// 사용자 입력값을 통해 전화번호부 정보를 받는 기능을 할 메소드를 만들거임.
	// 메소드를 실행하기 위해선 인스턴스를 생성하거나 static을 사용하거나
	// 둘 중 하나임.
	// 여기선 static키워드를 붙여 멤버 메소드로 사용하자.
	public static void main(String[] args) {
		PhoneBookManager pbManager = PhoneBookManager.getinstance();
		// 메소드 호출
		while(true) {
			System.out.println("-------------------");
			System.out.println("메뉴를 선택하세요.");
			System.out.println("1. 입력, 2. 종료");
			System.out.println("-------------------");
			int choice = Util.keyboard.nextInt();
			if(choice == 1) {
					pbManager.getInfo();
			} else if(choice == 2) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}
	}

}