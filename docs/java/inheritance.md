## 상속
원래 있는 클래스를 활용해서 재구성하여 **새로운 클래스**를 만들 수 있음
공통적인 규칙이 필요하다면  상위클래스 하나를 통해 상속시켜 여러 곳에 적용하는 것이 큰 목적임.

```java
// class 자손클래스 extends 조상클래스 
class Point{
	int x;
	int y;
}

class Point3D extends Point{
	int z;
	// int x,y,z 모두 사용 가능
}
```

#### super()

상위 클래스의 생성자 호출을 위해 사용함.
만약 부모 클래스에서 생성자로 변수를 초기화 했다면, 자손 클래스에서는 부모 클래스의 변수를 초기화할 데이터까지 매개변수 인자로 전달받아 같이 초기화 시켜줘야함. 
`super()`는 반드시 생성자 내에서 가장 상단에 호출되어야 한다.

```
class AAA{
	int x;
	AAA(int x){
		this.x = x;
	}
}

class BBB extends AAA{
	int y;
	BBB(int x, int y){
		super(x);
		this.y = y;
	}
}
```

#### super 
`super`는 상위 클래스의 지역변수 or 메소드를 가져옴

```java
class Parent {
	int x =10;
}
class child extends Parent{
	void method(){
		super.x = 30;
		// => Parent.x = 30;
	}
}
```


### 오버라이딩

**@Overriding**
상속받은 상위클래스의 메소드를 재정의함.
메소드의 이름, 매개변수의 값, 반환하는 타입의 값 **모두 똑같은 상태로 처리연산의 결과만** 바꾼다.
예시로 `Object.toString()`이 있음.

하위클래스에서 오버라이딩 한 경우, 상위클래스의 메소드는 하위클래스의 메소드로 대체된다. 

*오버라이딩과 오버로딩의 차이??*
- 오버로딩 : 이름과 타입이 같은 메소드일 경우 **매개변수의 개수와 타입이 다르다면** 다른 메소드로 구성됨.
- 오버라이딩 :  이름과 반환 타입, 매개변수의 값이 모두 같은 상태지만 처리연산의 결과만 재정의하여 사용하는 것.


```java
class Speaker
{
	private int volumeRate;
	public void showCurrentState()
	{
		System.out.println("볼륨 크기: "+ volumeRate);
	}
}
class BaseEnSpeaker extends Speaker
{
	private int baseRate;
	
	@Overriding
	public void showCurrentState()
	{
		// 상위 클래스의 처리 연산을 super키워드로 호출하여 가지고 옴.
		// 그렇지 않으면 결과는 베이스크기만 나옴.
		super.showCurrentState();
		System.out.println("베이스 크기: "+baseRate);
	}
}

public static void main(String[] args)
{
// base is a speaker 관계기 때문에 참조변수 bs안에 인스턴스 생성 가능! 성립가능함! 
	Speaker bs= new BaseEnSpeaker();
	bs.setVolume(10);
	// 스피커 안에는 존재하지 않는 변수기 때문에 에러가 남
	bs.setBaseRate(20); //컴파일 에러
	// 근데 show~ 메소드는 베이스로 인해 오버라이딩 되므로 스피커속 show~가 아니고 베이스 속 메소드로 호출된다.
	bs.showCurrentState();
}
// 결과 =>

// 볼륨 크기 : 10
// 베이스 크기 : 20
```

### 다형성

서로 상속 관계일 경우, 하위 클래스가 상위 클래스의 타입의 인스턴스 생성을 할 수 있다.
타입은 서로 다르지만 자식은 부모의 타입으로 자동으로 형변환 할 수 있기 때문임.

```java
// BaseEnSpeaker가 Speaker를 상속받고 있기 때문에 자동으로 Speaker객체로 형변환이 가능.
Speaker bs= new BaseEnSpeaker();
```

- 하위->상위 가능
- 상위->하위 불가능

같은 의미로 조상타입의 배열에 자손들의 객체를 담을 수도 있다.

```java
class Product{
	int price;
	
	Product(int price){
		this.price = price;
	}
}

class Tv extends Product{
	Tv(){
		// price를 100만원으로 초기화시킴
		super(100)
	}
	
	public String toString(){
		return "TV";
}

class Computer extends Product{
	Computer(){
		// price를 100만원으로 초기화시킴
		super(150)
	}
	
	public String toString(){
		return "Computer";
}

public static void main(Stiring args[]){
	Product p[] = new Product[2];
	p[0] = new Tv();
	p[1] = new Computer();
}
```


