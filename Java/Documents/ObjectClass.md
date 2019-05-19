### Object

#### equals() 메소드

`Object`의 `equals`는 값이 아닌 참조변수가 같은지 판별한다. 만약 같은 값을 가지더라도 다른 객체로 만들어져 값을 가지고 있다면 equals는 다른 값을 가진다며 false값을 반환할 것임.
그렇기 때문에 새로 정의되는 클래스에서 Object의 메소드를 오버라이딩을 적절하게 사용하여 다시 정의해주는 편이 좋다.
```java
public class Person {
	long id;
	
	Person(long id){
		this.id = id;
	}
}

public class EqualsEx2 {

	public static void main(String[] args) {
		
		Person p1 = new Person(8011081111222L);
		
		Person p2 = new Person(8011081111222L);
		if(p1==p2)
			System.out.println("p1과 p2는 같은 사람입니다.");
		else
			System.out.println("p1과 p2는 다른 사람입니다.");
		if(p1.equals(p2))
			System.out.println("p1과 p2는 같은 사람입니다.");
		else
			System.out.println("p1과 p2는 다른 사람입니다.");
	}
		
}
// p1과 p2는 다른 사람입니다.
// p1과 p2는 다른 사람입니다.
```

```java
class Person {
	long id;
	public boolean equals(Object obj) {
		if(obj!=null && obj instanceof Person)
		return id ==((Person)obj).id;
		// obj가 Object타입이므로 id값을 참조하기 위해서는 Person타입으로 형변환이 필요하다.
	else
		return false; // 타입이 Person이 아니면 값을 비교할 필요도 없다.
	}
	Person(long id) { this.id = id; }
}

public class EqualsEx2 {

	public static void main(String[] args) {
		
		Person p1 = new Person(8011081111222L);
		
		Person p2 = new Person(8011081111222L);
		if(p1==p2)
			System.out.println("p1과 p2는 같은 사람입니다.");
		else
			System.out.println("p1과 p2는 다른 사람입니다.");
		if(p1.equals(p2))
			System.out.println("p1과 p2는 같은 사람입니다.");
		else
			System.out.println("p1과 p2는 다른 사람입니다.");
	}
		
}
// p1과 p2는 같은 사람입니다.
// p1과 p2는 다른 사람입니다.
```
#### wrapper 클래스

기본형 변수를 클래스로 나타낸 것. 객체를 이용해서 처리를 해야할 경우 사용한다.
간단한 연산은 가능하지만 저장하기 위한 목적이 주가 되므로 복잡한 연산은 느려서 사용하기 힘들다.

객체가 필요한 경우 오토박싱 기능으로 자동으로 wrapper 인스턴스로 감싸진다.
객체를 기본형 타입으로 변환하는 언박싱 기능을 가지고 있기 때문에 굳이 사용XX

```java
class BoxingUnboxing
{
	public static void main(String[] args)
	{
		Integer iValue=new Integer(10); //
		Double dValue=new Double(3.14); //
		System.out.println(iValue);
		System.out.println(dValue);
		iValue=new Integer(iValue.intValue()+10);
		dValue=new Double(dValue.doubleValue()+1.2);
		System.out.println(iValue);
		System.out.println(dValue);
	}
}
```

- Integer.parseInt();
	문자열을 int형으로 변환해주는 static메소드.
	

#### Math 클래스

- abs() : 절대값 반환
- random() : 0~1사이의 double형 랜덤값을 반환한다. 
- round() : 반올림
- floor() : 소수점을 절삭함.


#### 문자열 토큰

- StringTokenizer("문자열", "구분자"(, true or false)) 
	어떠한 구분자를 기준으로 문자열을 토큰으로 나눈다.
	뒤에 boolean 값은 구분자를 출력할 건지 말건지 선택하는것.

```java
while(st3.hasMoreTokens())
	System.out.println(st3.nextToken());
// hasMoreTokens() = 반환값은 boolean
// nextToken() = 다음 토큰을 찾아 String으로 반환한다.
```
