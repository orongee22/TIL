package exam;

public class ChildMarble {
	// 구슬의 개수
	int numOfMarble; // 구슬의 개수를 저장할 변수
	
	
	// 플레이어 이름 정하기
	String pName;
	
	
	// 인스턴스 변수초기화를 위해 생성자로 처리할것
	// 인스턴스 생성 시에 반드시 한 번 실행함
	ChildMarble(String name, int num){
		numOfMarble = num;
		pName = name;
	}
	
	// 게임 승리할 때
	// 게임의 승패에 따른 구슬의 개수 증감.\
	// 게임 대상이 필요하고 반환은 필요없음
	
	void playing(int marble, ChildMarble child) {
		winGame(marble);
		child.loseGame(marble);
	}
	
	void winGame(int marble) {
		numOfMarble+= marble;
	}
	
	void loseGame(int marble) {
		numOfMarble-=marble;
	}

	void showResult() {
		System.out.println(pName+"의 구슬의 개수는 "+numOfMarble+"입니다.");
	}
}




