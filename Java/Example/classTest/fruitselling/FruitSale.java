package fruitselling;

public class FruitSale {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		FruitSeller seller = new FruitSeller();
//		FruitBuyer buyer = new FruitBuyer();
		
		// 사과장수 등록
		FruitSeller seller = new FruitSeller(20,0,1000);
		FruitSeller seller2 = new FruitSeller(10,0,1500);
		
		// 구매자 등록
		FruitBuyer buyer = new FruitBuyer(); // 매개변수가 없는 초기화된 생성자를 불러오는 거임. 얘는 고정값으로 지정해둔 5000이 들어옴
		FruitBuyer buyer2 = new FruitBuyer(3000); // 매개변수를 지정해놓은 생성자를 불러오는 거고
		
		// 판매 시작 전:
//		System.out.println("판매자 상황");
//		seller.showSaleResult();
//		System.out.println("구매자 상황");
//		buyer.showBuyResult();
		
		// 판매 시작 후:
//		buyer.buyApple(seller, 2000);
//		System.out.println("판매자 상황");
//		seller.showSaleResult();
//		System.out.println("구매자 상황");
//		buyer.showBuyResult();
	
		buyer.buyApple(seller, 2000);
		buyer.buyApple(seller2, 3000);
		
		buyer2.buyApple(seller, 3000);
		buyer2.buyApple(seller2, 6000);
		
		System.out.println("판매자 1의 현황");
		seller.showSaleResult();
		System.out.println("판매자 2의 현황");
		seller2.showSaleResult();
		
		System.out.println("구매자 1의 현황");
		buyer.showBuyResult();
		System.out.println("구매자 2의 현황");
		buyer2.showBuyResult();
	}

}
