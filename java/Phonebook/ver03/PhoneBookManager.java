
package ver03_1;

import java.util.Scanner;

import util.Util;

class PhoneBookManager {
	// PhoneInfor 배열 객체 인스턴스 생성. 사이즈는 100.
	PhoneInfor[] phoneinfor;
	int count;
	
	
	// 생성자 초기화
	// 사용자로부터 배열의 사이즈를 받을 예정.
	PhoneBookManager(int size){
		phoneinfor = new PhoneInfor[size];
		count = 0;
		
	}
	
	
	
	
	// 메소드
	// 친구 정보를 입력받기 위한 메소드.
	void insertInfo() {
		String name = null;
		String birth = null;
		String number = null;
		
		System.out.println("이름을 입력하세요");
		name = Util.keyboard.nextLine();
		
		System.out.println("전화번호를 입력하세요.");
		birth = Util.keyboard.nextLine();
		
		System.out.println("생년월일을 입력하세요.");
		number = Util.keyboard.nextLine();
		
		// 입력받은 정보를 PhoneInfor 객체에 저장.
		PhoneInfor pi = null;
		
		// 
		if(birth == null || birth.trim().length()<1) {
			 pi = new PhoneInfor(name, number);
		} else {
			pi = new PhoneInfor(name, number, birth);
		}
		phoneinfor[count] = pi;
		
		count++;
	}
	
	int searchIndex(String keyword) {
		int index = -1;
		for(int i=0;i<count;i++) {
			if(keyword.equals(phoneinfor[i].name)) {
				index = i;
				break;
			}
		}
		return index;
	}
	// 친구 정보를 검색할 메소드.
	void searchInfo() {
		String name = null;
		
		System.out.println("검색하실 이름을 입력하세요.");
		name = Util.keyboard.nextLine();
		
		int index = searchIndex(name);
		if(index<0) {
			System.out.println("해당하는 정보가 없습니다.");
		}else {
			phoneinfor[index].showInfo();
		}
 
		
		
	}
	
	void deleteInfo() {
		String name = null;
		System.out.println("삭제할 이름을 입력하세요.");
		name = Util.keyboard.nextLine();
		
		int index = searchIndex(name);
		if(index<0) {
			System.out.println("해당하는 정보가 없습니다");
		} else {
			phoneinfor[index].showInfo();
			System.out.println("해당 이름의 주소를 삭제하시겠습니까?");
			System.out.println("1. 삭제 2. 취소");
			int choice = Util.keyboard.nextInt();
			if(choice == 1) {
				phoneinfor[index] = phoneinfor[index+1];
				System.out.println("삭제했습니다.");
				count--;
			} else {
				System.out.println("취소했습니다.");
			}
		}
		
	}
	
	void printInfo() {		
		System.out.println("======================");
		
		
		if(count>0) {
			for(int i=0;i<count;i++) {
				phoneinfor[i].showInfo();
				System.out.println("======================");
			}		
		} else {
			System.out.println("아직 등록된 정보가 없습니다.");
		}
		
		System.out.println("======================");
	}
	
	
//	phoneinfor.showInfo();
}