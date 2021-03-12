## 메소드

특정 기능의 처리를 해주는 코드들의 집합임. 
기본적으로는 데이터를 입력 받아 처리하고 결과값을 돌려줌. (때에 따라 입력값이나 결과값이 없을 수도 있음.)

```java
// 메소드명도 소문자로 하는 것이 관례임
// 입력값으로 받는 매개변수를 정의
리턴타입 메소드명 ((데이터타입 변수명1,데이터타입 변수명2,...))
// 매개변수는 지역변수 사용됨. 입력값을 받기 위해 메소드 내에서 변수를 지정해줌.
// 매개변수가 필요없다면 `()` 비우고 사용
{
	// 코드 ~~
	// return 값;
}
```

## main 메소드 

메소드의 호출을 하는 메인 메소드. 자바는 제일 처음 메인메소드를 실행한다.

```java
public static void main(String[] args){}
```

#### static
선언한 변수나 메소드의 스코프를 프로그램 실행 시부터 프로그램 종료시까지 유지되게 함.


#### return
값을 **반환** 하거나 메소드를 **종료**시킴.


#### void
값을 반환하지 않을 경우 리턴타입 대신`void` 쓴다.

```java
void power(){
	power = !power;
}
```


## 객체 지향

### 클래스 
객체를 **정의**만 해놓은 상태. 변수(필드)를 선언, 메소드를 정의한다.

```java
class 클래스이름 {
	//...
}
```

클래스는 파일 하나 당 하나의 클래스가 선언된다. 두 개 이상도 가능은 하지만 그럴 경우 파일명과 같은 클래스 하나만 `public` 키워드를 쓸 수 있음.

### 객체 인스턴스
실제로 **생성**해놓은 클래스.  
`new` 키워드를 붙여 클래스를 인스턴스화하여 생성시킨다. 하나의 클래스로 여러 개의 고유 값을 가진 다른 객체를 생성시킬 수 있다.

```java
class First{
}

First f1rst = new First();
// Class의이름 변수이름 = new Class이름();
// 변수이름에 new를 통해 생성한 인스턴스의 주소값(객체 자신 ㄴㄴ)을 저장하는 거임. 
// 참조변수, Class 변수는 4byte의 메모리를 저장해둠.
// 이걸 클래스의 인스턴스화라고함.
```
생성된 클래스를 `main` 메소드에서 호출시켜 사용하면 `참조변수이름.메소드()`or `참조변수.변수` 로 접근이 가능하다.


*ex) 인스턴스 생성과 변수와 메소드 참조 예시*

```java
// Number.java
// 변수와 메소드만 정의하는 클래스.
package classtest;
public class Number{
	int num; // 인스턴스 초기화. 자동으로 0이 대입됨.
	
	void addNum(int n){
		num = num+n;
	}
	int getNum(){
		return num;
	}
}

//InstanceMain.java
package classtest;

public class InstanceMain {
	public static void main(String[] args){
		// 인스턴스 생성
		Number nInst = new Number();
		
		// 인스턴스를 생성만 하고 호출하지 않은 상태
		System.out.println("인스턴스의 메소드 호출 전 : num의 값  = "+nInst.num);
		// 결과는 0
		System.out.println("인스턴스의 메소드 호출 전 : num의 값  = "+nInst.getNum());
		// 결과는 0

		// nInst 참조변수를 전달받아 addNum()이라는 메소드를 호출시킴.
		// 메소드 선언부에서 10이라는 값을 전달했으므로 현재 num은 10.
		simpleMethod(nInst);
		
		System.out.println("인스턴스의 addNum 메소드를 실행 후 : num의 값  = "+nInst.getNum());
		// 결과는 10

		static void simpleMethod(Number number){
			number.addNum(10);
		}		
	}
}

```


#### 클래스 멤버

`static` 키워드가 붙은 변수와 메소드.

클래스에 고정되어 있는 멤버기 때문에 인스턴스와 별개의 메모리에 저장된다. 로딩 시 먼저 선언되기 때문에 인스턴스화하지 않더라도 바로 사용 가능.

주로 공용적으로 사용할 데이터라면 클래스 멤버를 이용해 사용하는 것이 좋다.

클래스 멤버를 사용할 땐 `클래스이름.변수` `클래스이름.메소드명()`으로 접근한다.

```java
public class Calculator{
	String color; // 객체마다 각자 다른 색상의 데이터를 가진다.
	static double PI = 3.14159; // 객체는 항상 같은 PI값을 가진다.
}
```

클래스 메소드 내에서는 인스턴스 변수나 메소드 접근이 불가하다.

```java
class AAA{
	int num1;
	static int num2;
	static void changeNum(){
		num1++; // 인스턴스 변수 사용 불가 X
		num2++; // static 변수기 때문에 가능 O
	}
}
```

#### 인스턴스 멤버

인스턴스를 생성 시에 선언되는 변수와 메소드. `참조변수.인스턴스변수명`를 통해서 접근한다. 

참조변수가 없을 시 자동으로 제거됨. (가비지컬렉터에 의해)
	
```java
	class Tv{
		int channel;

		void channelUp(){
			++channel;
		}
		void channelDown(){
			--channel;
		}
	}
	
	class TvTest{
		Tv tv1 = new Tv();\
		
		tv1.channel = 7;
		tv1.channelDown();
		
		// Tv.channel = 7 //은 접근 불가. 인스턴스 변수는 참조변수를 통해 접근해야함.
		
		Tv tv2 = new Tv();
		t2 = t1;
		// t2는 t1의 주소값으로 대치됨.
		// t2가 원래 가르키고 있던 주소값이 가지고 있던 인스턴스 변수는 사라짐.
	}
```


#### 생성자

인스턴스 생성될 때마다 호출되는 인스턴스 초기화 메소드. 변수들을 초기화할 때 사용한다. 
- 생성자는 반환형 타입 없이 오로지 실행의 목적. 
- 생성자는 모든 클래스에 반드시 있어야함. 생성자를 만들지 않더라도 인스턴스 생성될 때 자동으로 생성됨.

생성자 이름  = 클래스 이름

```java
// 생성자의 default형 - 디폴트기 때문에 생략 가능
클래스이름(){}

class Card{ }
Card c = new Card();

// Card() 는 생성자. 생성자 이름은 클래스로 지정해야 함.

```
생성자 내에서는 `final`상수를 쓰더라도 값 변경이 가능하다. 생성자 내에서만 허용한다.




#### this

`this` - 참조변수는 현재 인스턴스 자신을 가리킴.
```java
class Car {
	String color;
	}
	Car(String c){
		// 인스턴스 변수인 color값에 c를 대입.
		this.color = c;
	}
	
```

#### this()
`this()` : 생성자를 가리킴. 매개변수의 타입이 같은 생성자를 찾아감.
```java
class Car {
	String color; // 색상
	String gearType; // 변속기 종류 - auto(자동), manual(수동)
	int door; // 문의 개수
	
	Car() {
		this("white", "auto", 4);
	}
	Car(String color) {
		this(color, "auto", 4);
	}
	Car(String color, String gearType, int door) {
		this.color = color;
		this.gearType = gearType;
		this.door = door;
	}
}
```


#### 메소드 오버로딩

같은 이름의 메소드를 여러 개 만들 수 있음.
매개변수의 **타입**이 다르거나 혹은 매개변수의 **개수**가 다를 경우 구분되어 동작한다.

```java
class Car{
	String color;
	}
	Car(){
		color = "blue";
	}
	Car(String c){
		this.color = c;
	}
	// Car()라는 메소드가 두개 정의되었지만 매개변수의 개수가 다르기 때문에 오버로딩이 성립되어 사용가능
```

#### String 클래스

String str1 = "인스턴스 생성"

`new` 키워드를 생성하지 않아도 자동으로 인스턴스가 생성되는 클래스임. 바로 참조값을 넣어 사용함.
string 클래스에 한해서는 " "같은 문자열을 다룰 시, 같은 참조변수를 반환한다. 메모리 아낄라고
근데 문자열 변경은 안됨. 다른 값을 넣어도 변경이 된 것이 아님
```java
String s = "Java";
String ss = "Java";
// 같은 문자열을 참조하기 때문에 s와 ss는 같은 주소값을 참조하고 있는거임.


```
 

