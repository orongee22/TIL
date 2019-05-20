package fruitbox;

public class FruitBoxTest {

	public static void main(String[] args) {
		FruitBox<Apple> fb1 = new FruitBox<Apple>();
		fb1.store(new Apple(100));
		Apple apple = fb1.pullOut();
		apple.showAppleWeight();
		
		
		
		
		FruitBox<Orange> fb2 = new FruitBox<Orange>(new Orange(50));
		// fb2.store(new Apple(10)); // 는 오류가 생김. Orange타입만 들어갈 수 있음.
//		fb2.store(new Orange(50));
		Orange orange = fb2.pullOut();
		orange.showSugarContent();
	}

}
