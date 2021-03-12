package product;

public class Buyer {
	int money = 1000;
	int bonusPoint = 0;
	
	// 제품들을 배열을 통해 여러개 담을 것. 사이즈는 10
	Product[] cart = new Product[10];
	int cartCnt = 0;
	
	// buy(tv),buy(computer),buy(audio)를 일일히 넣지말고 상속을 통해 product로 한번에 받을 수 있게함
	void buy(Product p) {
		
//		if(money<p.price) {
//			System.out.println("잔액부족으로 구매할 수 없습니다.");
//			return;
//			
//		} else {
//			money -=p.price;
//			bonusPoint += p.bonusPoint;
//			System.out.println(p+"을(를) 구입하셨습니다.");
//		}
		
		if(!(money<p.price)) {
			
			money -=p.price;
			bonusPoint += p.bonusPoint;
			
//			cart[cartCnt] = p;
//			cartCnt++;
			
			cart[cartCnt++] = p;
			
			System.out.println(p+"을(를) 구입하셨습니다.");
			
		} else {
			System.out.println("금액이 부족합니다.");
		}
	}
	
	void summary() {
		
		int sum = 0;
		String itemList = "";
		
		for(int i=0;i<cartCnt;i++) {
			sum += cart[i].price;
			itemList += cart[i];
		}
		
		System.out.println("구입하신 제품들의 총 구매액은 "+sum+"만원 입니다.");
		System.out.println("구입하신 제품의 목록은 "+itemList+"입니다.");
	}
}
