## 제네릭

자료형의 안전성과 구현의 편의성을 집계된 클래스 구조,
필요한 자료형 형식을 지정하여 해당 형식만 입력받을 수 있게 함.
`<>`식별자를 통해 자료형을 지정하면 된다. 
제네릭의 기본 대상은 클래스와 인스턴스기 때문에 (컬렉션 프레임워크가 제네릭의 기반) 기본 자료형의 이름은 제네릭에 사용할 수 없음.

```java
class FruitBox <T>{
	T item;
	public void store(T item) { this.item=item; }
	public T pullOut( ) { return item; }
}
```

메소드의 경우 메소드의 반환형 타입은 생략해도 된다. 생략하더라도 제너릭타입이 어떤 건지 결정되어 있기 때문임.

```java
public <T> pullOut(<T> item) { return item; }

public pullOut(<T< item) { return item; }
```

매개변수 자료형을 제한하는 용도로도 사용한다.

```java
public static <T extends AAA> void myMethod(T param) { . . . . . }
```

AAA 클래스를 상속하고 있는 T 자료형이어야 함을 명시하는 것임. 여기서 `extends` 키워드는 상속한다는 용도가 아닌, 제한을 두고자 하는 경우에 사용하는 거임. 마킹의 효과! `ex)UpperCasePrintable`

제네릭은 자료형을 명시하여 사용하는 곳에서는 다 가능하다 이말임!~! 배열이건 인터페이스건,,, 여러곳에서도 다 사용가능쓰...

**?**
자료형 상관없이 입력받을 수 있음.  

```java

FruitBox<? extends Fruit> box1 = new FruitBox<Orange>();
FruitBox<? extends Fruit> box1 = new FruitBox<Apple>();

// Fruit 객체를 상속받는 어느 객체든 다 받을 수 있게 처리함.
```


