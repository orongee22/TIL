package exam;

public class MarblePlay {
	public static void main(String[] args) {
		ChildMarble child1 = new ChildMarble("이",20);
		ChildMarble child2 = new ChildMarble("김",5);

//		생성자로 변수 초기화 할거임
		//child1.numOfMarble = 15;
		//child2.numOfMarble = 9;
		
		
		
		
		child1.playing(2, child2);
		child2.playing(7, child1);
		
		child1.showResult();
		child2.showResult();
		
	}
	
}
