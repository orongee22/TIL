### 예외처리

- runtime 예외 : 실행 중에 발생하는 예외 / 프로그래머의 실수
- exception 예외 : 컴파일이 끝난 후 발생하는 예외 / 사용자의 실수

#### try - catch문
 `try`블럭 내에서 예외가 발생할 만한 문장이 생긴 경우 `catch`블럭에서 찾아내 해당 예외를 처리한다. 만약 예외를 찾지 못한다면 `catch`블럭은 무시됨.
```java
try {
	// 예외 상황이 발생할 문장
} catch (예외발생코드 e) {
	// 해당 예외상황을 처리하기 위한 문장
	System.out.println("예외발생 시 띄우는 문장");
} // try-catch의 끝
```

#### 예외 클래스
예외 클래스는 `Exception` 클래스라는 부모클래스를 상속함. 최고 조상임.
예외 클래스를 하나라도 만나면 메소드를 바로 빠져나와 다음 구문을 실행하지 못하기 때문에 가장 디테일한 클래스를 위쪽에 선언하는 것이 좋다.

- getMessage() : 예외가 발생한 원인 정보를 문자열 형태로 반환함. `Throwable`클래스에 정의된 메소드로 모든 예외 클래스가 상속하고 있음.

- ArithmeticException : 나눗셈 연산 시 0이 들어갈 경우.
```java
try{
	System.out.println("나눗셈 결과의 몫: "+(num1/num2));
	System.out.println("나눗셈 결과의 나머지: "+(num1%num2));
}
catch(ArithmeticException e){
	System.out.println("나눗셈 불가능");
	System.out.println(e.getMessage());
}

// 결과 =>
//	두 개의 정수 입력 : 7 0 
//	나눗셈 불가능 
//	by/ zero 
//	프로그램이 종료합니다.
```
- ArrayIndexOutofBoundsException : 배열에 접근할 때 잘못된 인덱스 값을 사용할 경우.
- NullPointException : 참조변수가 null의 값을 가질 때 참조변수.메소드를 호출할 경우 예외가 발생.

#### finally

예외 상관없이 **반드시** 실행됨.
선택적으로 사용.
중간에 오류가 나거나 return을 만나더라도 무조건 실행하고 메소드를 빠져나감.
`try - (catch) - finally`순으로 실행된다.

```java
try {
}catch {
// 예외가 없으면 무시하고 finally로 넘어감. 
}finally{
}
```

#### throw

논리적으로 예외 상황이 발생할 경우, 직접 예외 클래스를 정의하여 처리할 수 있음.

```java
import java.util.Scanner;

public class AgeInputException extends Exception {
	public AgeInputException() {
		super("유효하지 않은 나이가 입력되었습니다.");
	}
}

class ProgrammerDefineException
{
	public static void main(String[] args)	{
		System.out.print("나이를 입력하세요: ");
		try	{
			int age=readAge();
			// throws에 의해 이동된 예외처리 포인트
			System.out.println("당신은 "+age+"세입니다.");
		} catch(AgeInputException e){
			System.out.println(e.getMessage());
		}
	}
	
	// 예외 클래스를 만들어 throw를 사용해 Exception클래스로 던짐
	public static int readAge() throws AgeInputException {
		Scanner keyboard = new Scanner(System.in);
		int age=keyboard.nextInt();
		if(age<0){
			AgeInputException excpt=new AgeInputException();
			throw excpt; //예외상황을 알리는 문장!!!
	// 예외처리 메커니즘 작동!!!
		}
		return age;
	}
}

// 나이 : -10
// 유효하지 않은 나이가 입력되었습니다.
```
