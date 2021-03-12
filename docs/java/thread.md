## thread

스레드는 프로세스 내에서 실제 작업을 수행함. 별도의 실행 흐름을 갖는 대상으로 작업을 동시에 처리할 수 있다.

> 프로세스 : 현재 실행 중인 프로그램을 의미함.

### 스레드 생성

- Runnable 인터페이스 구현 

클래스 당 상속은 하나밖에 받지 못한다. 그러한 점으로 스레드 상속이 어려울 경우, 직접 스레드 객체를 생성하는 방법이 있음. `Runnable` 인터페이스는 스레드의 실행 메소드를 정의하고 있기 때문에 그걸 상속받아 구현해야 한다.

```java
class Task implements Runnable{
	@Override
	public void run(){
		// 실행 내용
	}
}

Runnable task = new Task();
// 스레드 객체를 직접 생성한다면, Runnable 인터페이스를 구현하는 객체를 생성자에 입력해야 한다.
// => Runnable task
Thread newThread = new Thread(task);

newThread.start();
```

- Thread 클래스를 상속

```java
class Task extends Thread{
	@Override
	public void run(){
		 // 실행 내용
	}
}

// 스레드 객체 생성
Thread thread = new Task();
```

 **start()** : 새로운 작업을 수행할 수 있게 흐름을 만들어 줌. start()가 호출이 되면 실행 대기 상태가 된다. 반드시 필요함.
- **run()** : 메인 메소드의 역할. start로 준비를 끝내면 가상머신이 스케줄링에 맞춰 자동으로 호출함.

```java

public class RunnableThreadMain {

	public static void main(String[] args) {
		// Runnable 객체를 이용한 쓰레드 생성
		// 1. runnable 인터페이스를 구현하는 클래스 기반의 객체를 생성함
		 AdderThread adderThread1 = new AdderThread(0,50);
		 AdderThread adderThread2 = new AdderThread(51,100);
		 
		 // 2. Thread 생성 - 해야할 일을 정의함.
		 Thread t1 = new Thread(adderThread1);
		 Thread t2 = new Thread(adderThread2);
		 
		 // 3. 스레드의 실행ㅇㅇ
		 t1.start();
		 t2.start();
		 
		 System.out.println("a1의 값 : "+adderThread1.getNum());
		 System.out.println("a2의 값 : "+adderThread2.getNum());
		 System.out.println("0-100까지의 합은 : "+(adderThread1.getNum()+adderThread2.getNum()));
		 System.out.println();
	}

}

// 결과는 5050이 나와야겠지만 0이 나올 수도 1275가 나올 수도 있음
// 스레드가 제대로 실행되지 않았다면 
// ㅜㅜ
```
- **sleep()** : 스레드 대기상태 메소드. sleep을 만나면 `blocked`상태가 되어 멈춤. blocked 상태의 스레드는 조건이 성립되면 다시 runnable 상태로 돌아감.  1/1000초 단위로 동작함 

- **join()** : 해당 스레드가 종료될 때까지 메인 메소드의 실행을 대기시키는 메소드임
스레드는 번갈아 cpu를 점유하기 때문에 어느 한쪽이 점유하고 있으면 스레드 작업을 완료하지 못하기 때문에 그 전에 값을 참조하면 유효하지 못한 값이 출력될 수도 있다. 그걸 방지함!



#### 우선순위

스레드에 우선순위를 나눠 작업시간을 더 많이 가질 수 있도록 한다.
1부터 10까지 순번을 정할 수 있으며 디폴트는 5

```java
Thread.setPriority(1);
```
작업 시간만 더 할당했다 뿐이지. 처리 결과는 우선순위와 같지 않을 수 있음. 그냥 처리 빈도만 높아짐.



### 동기화
한 번에 하나의 스레드만 접근할 수 있게 함. `synchronized` 키워드로 설정할 수 있음. 동기화가 걸린 객체는 잠금이 되고 작업을 실행하는 스레드만이 접근 가능함. 
메소드가 동기화 상태가 됐다면 전체가 잠금 상태가 된다. 그걸 방지하려면 동기화 블록을 사용하면 됨.

```java

```
