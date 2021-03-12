package ver04;

import util.Util;

public class PhoneInfoManage {
	
	// 1.객체 저장을 목적으로 배열을 생성
	// 배열 사이즈를 고정시키기 위해 final을 사용함.
	final PhoneInfor[] pb;
	int count;
	
	// 1. 생성자 접근 제한 : private 생성자
	// 2. 클래스 내부에서 인스턴스 생성 (인스턴스 접근 불가라 클래스 메소드로 static, 참조값 벼녕을 위해 private)
	// 3. 참조값을 반환하는 메소드를 생성한다. (static)
	
	private static PhoneInfoManage m = new PhoneInfoManage();
	// PhoneInfoManage.m = null 같이 객체의 값을 변경할 수 있음.
	// 그걸 방지하기 위해 private처리 해줌.
	
	public static PhoneInfoManage getInstance() {
		if(m==null) {
			m = new PhoneInfoManage();
		}
		return m;
	}
	
	// 외부에서의 인스턴스 생성을 금지함.
	private PhoneInfoManage() {
		//pb = new PhoneInfo[100];
		//count = 0;
		this(100);
	}
	
	// 
	private PhoneInfoManage(int size) {
		pb  = new PhoneInfor[size];
		count = 0;
	}
	
	// 2. 배열의 요소 컨트롤을 위한 메소드 구성
	
	// 친구정보 입력 메서드
		// 메소드는 PhoneInfo 타입의 배열에 저장할 목적임.
		// 사용자로부터 이름과 전화번호와 생일 정보를 입력 받아서 인스턴스를 생성해야함.
		// 그리고 생성된 인스턴스를 배열에 저장할 것임. 이게 핵심 목표!
		// 배열에 저장 -> index = count ->count++\
	
		public void insert() {
			
			System.out.println("1. 대학");
			System.out.println("2. 회사");
			System.out.println("3. 동호회");
			
			int select = Util.keyboard.nextInt();
			Util.keyboard.nextLine();
			
			insertMember(select);
		}
		
		public void insertMember(int select) {
//			1. 기본정보 받기 : 이름, 전화번호
//			2. 흐름 결정 : if(select)
//				1- 대학친구의 추가정보 받기
//				2- 회사친구의 추가정보 받기
//				3- 동호회 친구의 추가정보 받기
//			3. 인스턴스 생성
//			4. 배열 저장
			PhoneInfor pi = null;
			
			// 기본정보 받기
			System.out.println("친구의 이름을 입력해 주세요.");
			String name = Util.keyboard.nextLine();
			System.out.println("친구의 전화번호를 입력해주세요.");
			String phoneNumber = Util.keyboard.nextLine();
			
			// 흐름처리
			if(select == 1) {
				//대학친구 추가정보 받고
				System.out.println("주소를 입력해주세요.");
				String address = Util.keyboard.nextLine();
				System.out.println("메일주소를 입력해주세요.");
				String email = Util.keyboard.nextLine();
				System.out.println("전공을 입력해주세요.");
				String major = Util.keyboard.nextLine();
				System.out.println("학년을 입력해주세요.");
				int grade = Util.keyboard.nextInt();
				
				pi = new PhoneUnivInfo(name, phoneNumber, address, email, major, grade);
				
				
				//인스턴스 생성
			}else if(select == 2) {
				System.out.println("회사명을 입력해주세요");
				String company = Util.keyboard.nextLine();
				System.out.println("이메일을 입력해주세요.");
				String email = Util.keyboard.nextLine();
				
				pi = new PhoneCompanyInfo(name, phoneNumber, company, email);
						
				
			}else{
				System.out.println("닉네임을 입력해주세요.");
				String nickname = Util.keyboard.nextLine();
				
				pi = new PhoneCafeInfo(name, phoneNumber, nickname);
				
			}
			
			
			// 배열 저장
			pb[count++] = pi;
			
			
		}
		public void showAllData() {
			// 배열에 제대로 저장되었는지 출력해봄. 저장된 배열을 for문을 이용해서 들어간 모든 정보를 출력함. ㅇㅋㅇㅋㅇㅋ?
			
			System.out.println("======================");
			
			
			if(count>0) {
				for(int i=0;i<count;i++) {
					pb[i].showData();
					System.out.println("======================");
				}		
			} else {
				System.out.println("아직 등록된 정보가 없습니다.");
			}
			
			System.out.println("======================");
		}
		
		// 친구정보를 이름 기준으로 검색 후 정보를 출력하는 메소드
		// 배열 요소인 PhoneInfo 객체의 name의 문자열과 검색 키우드 문자열을 비교해서 출력해주는 메소드.
		// 1. 사용자에게 찾고자하는 이름 데이터 문자열을 받는다.
		// 2. 배열의 모든 요소에서 PhoneInfo 객체에 저장한 name과 문자열이 맞는지 비교를 함 (검색)
		// 3. 같은 문자열이 나온 index를 찾아서 저장함. : 저장할 변수가 필요함 ->변수를 선언 ㄱㄱ
		// 4. 찾은 index값의 배열 위치의 객체 데이터를 출력할것임.
		public void searchPrint() {
			
			System.out.println("검색할 사용자의 이름을 입력해주세요.");
			String name = Util.keyboard.nextLine();
			
//			// 검색 결과의 index : -1일 경우(검색의 결과가 없음 - 배열에는 -1 없으니까!)
//			int index = -1;
//			
//			
//			// 배열에서 문자열을 비교한 다음, 같은 값을 가지는 객체의 index값을 구하는 기능
//			for(int i=0;i<count;i++) {
//				if(pb[i].name.equals(name)) {
//					index = i;
//					break;
//				}
//			}
			
			int index = searchIndex(name);
			
			if(index<0) {
				System.out.println("검색한 이름의 정보가 없습니다.");
			} else {
				pb[index].showData();
			}
			
		}
		
		// 친구정보를 이름 기준으로 검색 후 정보를 삭제하는 메소드
		// 1. 삭제하고자 하는 사용자의 이름을 사용자로부터 받을 것임
		// 2. 배열에서 친구의 이름을 비교검색 ㄱㄱ -> index값을 찾아 저장함 
		// 3. 저장된 데이터를 삭제함. 배열의 요소에서 삭제하고자 하는 객체를 참조하지 않으면 됨. 나중에 참조하지 않는 데이터는 가비지컬렉터에 의해서 아예 삭제돼버림.
		// 내가 직접 삭제 하는 것이 아니고 객체를 다른 걸로 바꿔치기 하면 원래 있던 데이터가 수정된 것처럼 느낄 수 있다 이말임.
		// pb[3]을 삭제한다? -? pb[3] = null이 됨. 
		// 4. 배열에서 삭제한 index 기준으로 <- 왼쪽으로 인덱스 값을 시프트
		// pb[3] 삭제하면 pb[3] = pb[4] / pb[4] = pb[5] 하나씩 이동시킴.
		
		public void searchDelete() {
			
			System.out.println("삭제하고자 하는 사용자의 이름을 입력하세요.");
			String name = Util.keyboard.nextLine();
			
//			int index = -1;
//			
//			for(int i=0;i<count;i++) {
//				if(pb[i].name.equals(name)) {
//					index = i;
//				}
//			}
			int index = searchIndex(name);
			
			if(index<0) {
				System.out.println("검색하신 이름의 데이터가 존재하지 않습니다.");
			} else {
				// 삭제 : 검색한 index부터 저장된 위치까지 왼쪽으로 시프트 처리.
				// count-1을 한 이유는 null값이 들어간 인덱스는 제외시키려고 그럼. 아예 없애기
				for(int i=index;i<count-1;i++) {
					pb[i] = pb[i+1];				
				}
				
				// 저장된 사용자 정보의 개수가 감소
				count--;
				System.out.println("요청하신 이름의 정보를 삭제했습니다.");
			}
		}
		
		// keyword로 배열의 요소.name 문자열과 비교한 다음 검색되는 요소의 index값을 반환해줌.
		public int searchIndex(String keyword) {
			// 검색 결과의 index : -1일 경우(검색의 결과가 없음 - 배열에는 -1 없으니까!)
			int index = -1;
						
						
			// 배열에서 문자열을 비교한 다음, 같은 값을 가지는 객체의 index값을 구하는 기능
			for(int i=0;i<count;i++) {
				if(pb[i].name.equals(keyword)) {
					index = i;
					break;
				}
			}
			return index;
		}
		public int printMenu() {
			// static만 있어도 ㄱㅊㄱㅊ
			// int형 반환 타입인 이유는 사용자가 선택한 메뉴의 번호값을 나타내게 하고싶어서임
			System.out.println("---------------------------------");
			System.out.println("사용할 메뉴의 번호를 선택해 주세요.");
			System.out.printf("%d. 입력\n%d. 검색\n%d. 삭제\n%d. 전체 정보 출력\n5. 종료\n",Util.INSERT,Util.SEARCH,Util.DELETE,Util.ALLDATA);
			System.out.println("---------------------------------");
			
			int choice = Util.keyboard.nextInt();
			// util클래스 안에 스캐너 객체 있음 생성해옴.
			//	필요할 때마다 가지고 오면 됨
			
			// 콘솔 버그를 여러번 안쓰고 한번에 처리하기 위해서 넣어줌.
			// 현재 라인의 버퍼를 출력함. 콘솔 버그 있는데 그거 없애줌 clear의 목적
			Util.keyboard.nextLine();
			
			return choice;
		}
	
}
