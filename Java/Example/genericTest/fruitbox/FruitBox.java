package fruitbox;

// 제너릭타입의 경우 `<>` 식별자를 사용한다.
public class FruitBox<T> {
	T item;
	
	
	// 생성자 초기화 메소드 또한 해당 타입으로 받으면 됨.
	public FruitBox(T item) {
		this.item = item;
	}
	
	public void store(T item) {
		this.item = item;
	}
	
	public T pullOut() {
		return item;
	}
}
