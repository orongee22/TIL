## 제어자

### 제어자

#### static
클래스 멤버가 되어 공통적으로 사용할 수 있는 변수와 메소드.

#### final
한 번 선언하면 값을 더 이상 변경할 수 없게 된다. 주로 static과 함께 선언되어 상수로 표현함.
상속과 오버라이딩 불가. 그러나 유일하게 생성자 내에서는 초기화로 값을 변경할 수 있게 한다.

```java
class Card(){
	final int NUMBER;
	final String KIND;
	
	Card(String kind, int num){
		// 생성자에서 단 한번 초기화 가능.
		this.KIND = kind;
		this.NUMBER = num;
	}
}
```

#### abstract
아직 구현이 안된 메소드 혹은 클래스의 의미. 추상메소드가 하나라도 있는 클래스는 추상클래스가 된다.
미완성이기 때문에 인스턴스 생성이 불가하지만 상속을 하게 된다면 자손클래스가 메소드를 구현시켜 인스턴스 생성을 할 수 있다.

### 접근제어지시자
클래스, 멤버변수, 메소드, 생성자에 붙여 사용하며 외부 클래스로부터의 접근을 제한할 수 있음.

#### public
접근 제한 없이 모든 곳에서 공용으로 사용 가능함. 어디서나 전부 참조할 수 있다.
만약 하나의 클래스 파일에 두 개 이상의 클래스가 들어갈 경우 파일명과 같은 class만 public을 붙일 수 있다.
주로 static과 같이 쓰이는 경우가 많음.

#### protected
상속받은 자손 클래스 내까지 접근이 가능함. 

#### default
같은 패키지 내에서만 접근 가능. 지시자 선언을 따로 하지 않은 경우 모두 default 상태. (생략가능)

#### private
같은 클래스 내에서만 접근 가능. 외부에서 값을 함부로 참조할 수 없기 때문에 정보 은닉이 필요할 경우 사용한다 `ex)싱글톤 패턴`

```java
/*
* private를 이용해 직접 참조를 불가능하게 만들 수 있다.
* 이럴 경우 getter와 setter메소드를 통해 간접적으로 값에 접근하게 만든다.
*/
값을 직접 참조가 불가능하게 private 상태로 만들고
getter와 setter 메소드를 통해서만 값을 변경하고 참조할 수 있게 만들어주는 상태.

// 정보 저장 클래스
public class PhoneInfo{

	// 외부에서 접근 불가능 하도록 private를 선언함.
	private String name; // 친구의 이름 저장
	private String phoneNumber; // 친구의 전화번호 저장
	

	// getter메소드
	// 직접 참조가 불가한 private 변수를 반환하도록 함.
	String getName() {
		return this.name;
	}
	
	// setter 메소드
	// 변수의 값을 대입하는 메소드
	void setName(String name) {
		this.name = name;
	}
}

// 외부 클래스

class PhoneBookMain{
	public static void main(String args[]){
		PhoneInfo pi = new PhoneInfo();
		// pi.name = "이름"; // => 접근 불가
		
		pi.setName("이름");
		pi.getName();
	}
}		
```

**접근권한의 범위**
public > protected > default > private

- 생성자와 클래스의 접근지시자는 서로 맞춰주는 것이 좋다. class가 default 라면 생성자도 default로. 그러나 예외는 있음.

```java
// class 선언은 default지만 생성자는 private 상태.
final class Singleton{
	private static Singleton s = new Singleton();
	private Singleton(){}
	public static Singleton getInstance(){
		if(s==null){
			s = new Singleton();
		}
		return s;
	}
}

class SingletonTest{
	public static void main(String args[]){
		// private을 걸었기 때문에 접근 불가.
		Singleton s = new Singleton();
		// 클래스 자체는 default로 선언했으니 클래스 내 getInstance 메소드에 접근 가능
		Singleton s1 = Singleton.getInstance();
	}
}
```

