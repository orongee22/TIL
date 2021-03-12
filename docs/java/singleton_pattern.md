## 싱글톤 기법

인스턴스가 단 하나만 존재해야하는 경우, 무분별한 인스턴스 생성을 막기 위해 쓰는 방식.
`new`를 통해 계속해서 새로운 인스턴스를 만들어내는 게 아니라, 미리 생성한 객체 하나만을 참조하여 사용할 수 있기 때문에 메모리의 낭비를 줄일 수 있음.


*ex) 전화번호부*

새로운 `PhoneInfo` 객체를 만들게 되면 `PhoneInfo`의 배열 객체 또한 새로 생기게 된다.
배열 하나만을 이용하고자 하려면 새로운 객체가 아닌 기본 객체를 이용할 수 있게 해야함. 
객체 생성을 막기 위해 싱글톤을 사용해야한다!



외부에서 생성자와 인스턴스 접근을 못하게끔 `private`접근 지시자를 이용하여 클래스 내부에서만 처리할 수 있게 한다.

```java
class PhoneBookManager {
	
	// 생성자 접근 제한 : private
	private PhoneBookManager(){	};
	
	// 인스턴스를 내부에서 만들고
	// 인스턴스 생성을 하지 못하기 때문에 static으로 고정시킨다.
	private static PhoneInfoManage m = new PhoneInfoManage();
	
	// getInstance메소드는 외부에서 객체 반환을 목적으로 하기 때문에
	// private이 아닌 public으로
	// 객체 자체를 반환하여 오로지 외부에서는 해당 메소드를 통해야만 객체에 접근할 수 있다.
	public static PhoneBookManager getinstance() {
		return pbManager;
	}
}

class PhoneBookMain{
	public static void main(String args[]){
		PhoneBookManager[] pb = new PhoneBookManager[]();
		
```
