package product;

public class Product {
	
	int price;
	int bonusPoint;
	
	// 생성자 초기화
	Product(int price){
		this.price = price;
		bonusPoint = (int)(price/10.0f);
	}
	
}


class Tv extends Product{
	Tv(){
		// product의 생성자를 super를 통해 반드시 초기화시켜야함. 
		super(100);
	}
	
	@Override // 어노테이션 : 추가적인 의미부여, 규칙 제약을 걸어줌. 오버라이딩 규칙에 어긋나면 알려줌
	public String toString() {
		
		// Object의 메소드를 오버라이딩
//		return super.toString();
		
		return "TV";
	}
	
}

class Computer extends Product{
	Computer(){
		super(200);
	}
	
	public String toString() {
		return "Computer";
	}
}


class Audio extends Product{
	Audio(){
		super(50);
	}
	public String toString() {
		return "Audio";
	}
}