package posprogram;

public class BuyIngredient {
	private int price; // 구매할 재료 원가격
	String name; // 구매할 재료 이름
	int num; // 구매할 재료 수량
	

	public BuyIngredient(String name, int price) {
		this.name = name;
		this.price = price;
	}

//	private void setPrice(int p) {
//		price = p;
//	}
//	
//	public int getPrice() {
//		return price;
//	}
	
	BuyIngredient id1 = new BuyIngredient("김", 500);
	BuyIngredient id2 = new BuyIngredient("쌀", 1000);
	
//	void buying(BuyIngredient id, int num) {
//		
//	}
	
}
