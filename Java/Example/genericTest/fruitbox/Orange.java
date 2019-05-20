package fruitbox;

public class Orange {
	int sugarContent;
	
	public Orange(int sugar) {
		sugarContent = sugar;
	}
	
	public void showSugarContent() {
		System.out.println("당도 : "+sugarContent);
	}
}
