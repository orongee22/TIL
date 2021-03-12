package fruitselling;

public class FruitSeller {
	// 현재 판매원은 사과를 20개 팔고 있음
//	int numOfApple = 20; 
//	int myMoney = 0;
//	final int APPLE_PRICE = 1000;
	
	private int numOfApple; 
	private int myMoney;
	final int APPLE_PRICE;
	
	
	/*
	 * 생성자
	 * @appleNum : 사과의 개수
	 * @money : 보유 금액
	 * @price : 사과의 가격
	 */
	FruitSeller(int appleNum, int money, int price){
		numOfApple = appleNum; 
		myMoney = money;
		APPLE_PRICE = price;
	}
	
	public int saleApple(int money) {
		int num = money/APPLE_PRICE;
		numOfApple -= num;
		myMoney+=money;
		return num;
	}
	public void showSaleResult() {
		System.out.println("남은사과"+ numOfApple);
		System.out.println("판매수익"+myMoney);
	}
	
}
