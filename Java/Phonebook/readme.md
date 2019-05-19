# 전화번호 관리 프로그램 project


### [PhoneBook ver 01.](https://github.com/orongee22/TIL/tree/master/Java/Phonebook/ver01)

`PhoneInfor` 라는 이름의 클래스를 정의. <br>
클래스는 다음의 데이터들의 문자열 형태로 저장이 가능 해야 하며, 저장된 데이터의 적절한 출력이 가능하도록 메소드 정의.

- 이름            name              String
- 전화번호       phoneNumber     String
- 생년월일       birthday            String 

단, 생년월일 정보는 저장할 수도 있고, 저장 않을 수도 있게끔 생성자 생성.


---------------------------------------------------------

### [PhoneBook ver 02.](https://github.com/orongee22/TIL/tree/master/Java/Phonebook/ver02)


`Scanner 객체`를 이용하여 프로그램 사용자로부터 데이터 입력받기
프로그램 사용자로부터 데이터를 입력 받아 클래스의 인스턴스를 생성하는 것이 핵심.
단 반복문을 이용해서 프로그램의 흐름을 계속 유지하도록 한다.
프로그램 종료를 하지 않으면, 다음과 같은 과정이 반복적으로 이루어짐.

- 키보드로부터 데이터 입력 
- 입력 받은 데이터로 인스턴스 생성
- 생성된 인스턴스의 메소드 호출



---------------------------------------------------------
### [PhoneBook ver 03.](https://github.com/orongee22/TIL/tree/master/Java/Phonebook/ver03)


**배열**을 이용해서 프로그램 사용자가 입력하는 정보가 최대 100개까지 유지되도록 프로그램을 변경. 

아래기능 삽입

- 저장 : 이름, 전화번호, 생년월일 정보를 대상으로 하는 저장
- 검색 : 이름을 기준으로 데이터를 찾아서 해당 데이터의 정보를 출력
- 삭제 : 이름을 기준으로 데이터를 찾아서 해당 데이터를 삭제

데이터 삭제 후 남아있는 데이터 처리는 데이터를 빈 공란이 없이 순차적으로
재정리 2번이 삭제되었다면 3번 이후 데이터들의 주소 값이 -1 처리되어 재저장.

----------------------------------------------------

### [PhoneBook ver 04.](https://github.com/orongee22/TIL/tree/master/Java/Phonebook/ver04)


다음 두 클래스를 추가로 삽입. 상속 구조로 구성하기
*PhoneUnivInfor, PhoneCompaanyInfor*

각 클래스에 정의되어야 하는 인스턴스 변수.

```
**PhoneUnivInfor**
이름             name                  String
전화번호       phoneNumber      String
주소             address              String
이메일          email                  String
전공             major                  String
학년             year                   String
```
```
**PhoneCompaanyInfor**
이름             name                  String
전화번호       phoneNumber      String

이메일          email                  String
회사             company             String
```

**+추가**

[추가 사항]
1. 입력    --> 1. 일반  2. 대학  3. 회사  4. 동호회 --> 입력 형태로 구성


------------------------------------------
### [PhoneBook ver 05.](https://github.com/orongee22/TIL/tree/master/Java/Phonebook/ver05)


PhoneBookManager 클래스의 인스턴스수가 `최대 하나를 넘지 않도록` 코드를 변경.

‘interface’기반의 상수 표현을 바탕으로 메뉴 선택과 그에 따른 처리가, 이름에 부여된 상수를 기반으로 진행되도록 변경.

현재의 기본 클래스를 interface와 추상클래스를 사용하는 구조로 변경.

- interface : 필수 메서드 정의
- 추상클래스 : 인터스 변수와 interface를 상속 받지만 구현하지 않은 클래스

