package posprogram;

import util.*;
import java.util.ArrayList;

public class SupplierManager {
	// 거래처 관리 클래스
	// 거래처 관리 기능 모음

	ArrayList<SupplierInfo> si = new ArrayList<SupplierInfo>();
	
	
	// 포스 메인에서 불러와야 하기 때문에 public이어야함.
	public void printMenu() {
		// 거래처관리 메뉴 출력.
		while(true) {
			System.out.println("[거래처 관리]\n메뉴를 선택해주세요.");
			System.out.println("1. 거래처 등록\n2. 거래처 삭제\n3. 거래처 수정\n4. 발주 관리\n5. 거래처 목록\n6. 메인으로 돌아가기");
			
			int choice = Util.sc.nextInt();
			Util.sc.nextLine();
			
			
			switch(choice) {
			case 1: 
				insertSupplier();
				break;
			case 2: 
				deleteSupplier();
				break;
			case 3: 
				modifySupplier();
				break;
			case 4:
				orderSupplier();
				break;
				case 5:
				showAllSupplier();
				break;
				case 6:
					System.out.println("메인으로 돌아갑니다.");
					return;
			//	String[] args = new String[] {"메인 메소드"}; //???
			//	posMain.main(args); // 포스 메인의 메인메소드 호출해서 메인으로 돌아가기
				
			}
		}
	}
	
	void insertSupplier() {
		// 거래처 등록 기능
		String name;
		String phoneNum;
		String address;
		String addinfo;
		si.add(new SupplierInfo("김 가게", "0299565214", "서울시 종로구 무슨동 어디", "김 파는 곳"));
		si.add(new SupplierInfo("쌀가게","01093211234","서울시 종로구 어디어디","경기 이천쌀 전문"));
		
		System.out.println("거래처 이름을 입력하세요.");
		name = Util.sc.nextLine();
		System.out.println("거래처 전화번호를 입력하세요.");
		phoneNum = Util.sc.nextLine();
		System.out.println("거래처 주소를 입력하세요.");
		address = Util.sc.nextLine();
		System.out.println("추가사항을 입력하세요. 없으면 생략");
		addinfo = Util.sc.nextLine();
		
		si.add(new SupplierInfo(name,phoneNum,address,addinfo));
		
		
	}
	void deleteSupplier() {
			
		System.out.println("삭제할 거래처 이름을 입력하세요.");
		String name = Util.sc.nextLine();
		
		int idx = searchIndex(name);
			
		if(idx>0) {
			si.remove(idx);
			System.out.println("삭제를 완료했습니다.");
		} else {
			System.out.println("다시 검색해주세요.");
		}
	
		// 거래처 삭제
	}
	void modifySupplier() {
		// 거래처 수정
		System.out.println("수정할 거래처 이름을 입력하세요.");
		String name = Util.sc.nextLine();
		
		int idx = searchIndex(name);
		
		if(idx>0) {
			insertSupplier();
			System.out.println("수정을 완료했습니다.");
		} else {
			System.out.println("다시 검색해주세요.");
		}
	}
	
	int searchIndex(String keyword) {
		int idx = -1;
		
		for(int i=0;i<si.size();i++) {
			if(si.get(i).name.equals(keyword)) {
				idx = i;
				break;
			}
		}
		
		return idx;
	}
	
	void showAllSupplier() {
		// 거래처 현황 출력
		System.out.println("현재 거래처 현황입니다.");
		for(int i=0;i<si.size();i++) {
			System.out.println("-----------");
			si.get(i).showData();
			System.out.println("-----------");
		}
		
	}
	
	void orderSupplier() {
		ArrayList<BuyIngredient> bi = new ArrayList<BuyIngredient>();
		bi.add(new BuyIngredient("김", 100));
		bi.add(new BuyIngredient("쌀", 1000));
		
		System.out.println("발주할 재료의 이름을 입력하세요");
		
		String name = Util.sc.nextLine();
		for(int i=0;i<bi.size();i++) {			
			if(name == bi.get(i).name) {
				System.out.println("구매할 수량을 입력하세요.");
				int num = Util.sc.nextInt();
				
				
			}
		}
		
		
		
		
		
		
	}

}
