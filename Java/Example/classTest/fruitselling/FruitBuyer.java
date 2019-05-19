package fruitselling;

public class FruitBuyer {
	// 구매자는 돈은 5000원 갖고있음.
//	int myMoney = 5000;
//	int numOfApple = 0;
	
	int myMoney;
	int numOfApple;
	
	
	/** 생성자
	 * @money : 사용자 보유 금액
	 */
	FruitBuyer(int money){
		myMoney = money;
		numOfApple = 0; // 최초 보유 개수는 0으로 한다.
	}
	
	FruitBuyer(){
//		myMoney = 5000;
		this(5000);
		// 5000을 매개변수로 받는 다른 생성자를 호출함.
		// 위에서 생성한 같은 클래스의 다른 생성자인 FruitBuyer를 호출해서 5000을 넣어 초기화.
		
	}
	void buyApple(FruitSeller seller, int money) {
		numOfApple += seller.saleApple(money);
		myMoney-=money;
	}
	public void showBuyResult() {
		System.out.println("현재 잔액"+myMoney);
		System.out.println("사과개수"+numOfApple);
		
	}
}
