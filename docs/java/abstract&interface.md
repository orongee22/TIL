### 추상클래스 인터페이스

#### 추상클래스

`abstract` - 선언은 되었으나 구현부가 없는 메소드가 하나라도 있으면 추상클래스가 된다.
가이드 역할을 위해 사용하며 인스턴스 생성 불가.
자식클래스가 상위의 추상클래스를 상속받기 위해선 오버라이딩으로 추상메소드를 구현시켜야 사용가능하다.

```java
abstract class Player{
	abstract void play();
}

class AudioPlayer extends Player{
	void play{
		// ... 구현부 생략
	}
}
```

#### interface

상수와 추상메소드만 가진 추상클래스. 오로지 설계의 목적임. 

```java
interface PersonalNumberStorage
{	
	// 아무것도 구현하지 않음
	void addPersonalInfo(String perNum, String name);
	String searchName(String perNum);
}

class abstractInterface
{
	public static void main(String[] args)
	{
		PesonalNumberStorage storage = new (a사가 구현한 클래스 이름);
		storage.addPersnalInfor(“홍길동”,”991111-1111111”);
		system.out.println(storage.searchName(”991111-1111111”));
	}
}
```

일반 클래스에서 인터페이스를 상속할 시, extends가 아닌 `implements`를 사용함.


**인터페이스 간의 상속**

- `extends` 키워드를 통해 상속. 
- 다중상속이 가능하다.
- Object를 상속하지 않음. 미완성된 클래스기 때문에 다른 클래스 상속을 받지 않음. 최고 조상X

```java
// 다중 상속 가능.
interface Fightable extends Movable, Attackable { }
interface Movable { 
	void move(int x, int y); 
}
interface Attackable { 
	void attack(Unit u);
}

class Unit {
	int currentHP; // 유닛의 체력
	int x; // 유닛의 위치(x좌표)
	int y; // 유닛의 위치(y좌표)
}
// 상속과 동시에 구현이 가능함.
class Fighter extends Unit implements Fightable {
	public void move(int x, int y) { /* 내용 생략 */ }
	public void attack(Unit u) { /* 내용 생략 */ }
}
```

*interface를 통해 클래스의 특성을 표시할 수 있는 마킹 표현*
```java
/*
* 만약 UpperCasePrintable 클래스를 상속받는 경우
* 해당 클래스의 Uppercase를 하게 만드는 예시!
*/

// 보통 ~able로 나타낸다.
// 마킹 표시만 하기 떄문에 내용은 비워둠. 
interface UpperCasePrintable{
	// 비어 있음
}
class ClassPrinter {
	public static void print(Object obj){
		String org=obj.toString();
		if(obj instanceof UpperCasePrintable){
			org=org.toUpperCase();
		}
		System.out.println(org);
	}
}

class PointOne implements UpperCasePrintable{
	private int xPos, yPos;
	PointOne(int x, int y){
		xPos=x;
		yPos=y;
	}
	public String toString(){
		String posInfo="[x pos:"+xPos + ", y pos:"+yPos+"]";
		return posInfo;
	}
}

class PointTwo {
	private int xPos, yPos;
	PointTwo(int x, int y){
		xPos=x;
		yPos=y;
	}
	public String toString(){
		String posInfo="[x pos:"+xPos + ", y pos:"+yPos+"]";
		return posInfo;
	}
}

class InterfaceMark { 
	public static void main(String[] args) { 
		PointOne pos1=new PointOne(1, 1); 
		PointTwo pos2=new PointTwo(2, 2); 
		PointOne pos3=new PointOne(3, 3); 
		PointTwo pos4=new PointTwo(4, 4); 
		ClassPrinter.print(pos1); 
		ClassPrinter.print(pos2); 
		ClassPrinter.print(pos3); 
		ClassPrinter.print(pos4);
	}
}

// 결과 =>
// [X POS:1, Y POS:1]
// [x pos:2, y pos:2]
// [X POS:3, Y POS:3]
// [x pos:4, y pos:4]
```

