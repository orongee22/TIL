package posprogram;




// 거래처의 재료판매 아이템
public abstract class SupplierMenuItem{
	// String menuName; // 재료의 이름 
	private static int price; // 재료 원가격
	int num; // 구매할 재료 수량
	
	SupplierMenuItem(String name, int num){
		menuName = name;
		this.price = getPrice();
		this.num = num;
	}
	
	public void setName(String name) {
		this.menuName = name;
	}
	
	public String getName() {
		return menuName;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getPrice() {
		return price;
	}
	
	void showMenuData() {
	}
	
	
	

	
}
