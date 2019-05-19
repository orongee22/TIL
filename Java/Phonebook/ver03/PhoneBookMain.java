package ver03_1;


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
		PhoneBookManager pbManager = new PhoneBookManager(20);
		// 메소드 호출
		while(true) {
			System.out.println("-------------------");
			System.out.println("메뉴를 선택하세요.");
			System.out.println("1. 입력\n2. 검색\n3. 삭제\n4. 전체 정보 출력\n5. 종료");
			System.out.println("-------------------");
			int choice = Util.keyboard.nextInt();
			Util.keyboard.nextLine();
			switch(choice) {
				case 1: 
					pbManager.insertInfo();
					break;
				case 2:
					pbManager.searchInfo();
					break;
				case 3: 
					pbManager.deleteInfo();
					break;
				case 4:
					pbManager.printInfo();
					break;
				case 5:
					System.out.println("프로그램을 종료합니다.");
					return;
				default:
					System.out.println("다시 입력해주세요.");
			}
		}
	}

}