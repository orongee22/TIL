## JSP 기본 요소

jsp가 가지고 있는 기본 속성들이 있음! `<% %>` 속에 자바 코드를 넣어 사용. 웹컨테이너(톰캣)이 실행할 때 처리할 추가 속성이며, 서블릿 클래스로 변환돼서 사용할 거임.

| 종류 | 용도 | 사용법 |
|--|--|--|
| 스크립트릿 | 자바 코드 삽입 |<% %>|
|선언식	|변수와 메소드 선언	|<%! %>	|
|표현식	|문자열 형태로 출력	|<%= %>	|
|지시자	|jsp페이지 속성 지정	|<%@ %>	|

### 스크립트식

#### 선언식

선언식 안에서 선언된 변수와 메소드는 `static` 클래스 멤버로 선언된다. 전역변수기 때문에 페이지내 어디서나 접근 가능.
```jsp
<%! String str = "하이하이!" %>
```

#### 스크립트릿 

함수나 if문 등등.. 일반적인 자바 코드를 사용할 때 쓰면 됨. 변수, 메소드 호출할 때는 이곳에서.

#### 표현식

HTML과 함께 출력할 때는 이 곳에 기술하면 됨. 서블릿으로 변환될 때 자동으로 `out.print()`로 바뀌는 형태임. `<%= %>`대신 `out.print()`를 써도된다는 뜻임 ㅇㅋ?

<hr>

### 지시자

jsp 페이지에 대한 전체 속성을 지정하므로 문서 제일 윗부분에 위치해야함.

#### page 

jsp페이지 전반적인 환경을 설정. 

```jsp
// 기본 템플릿에 항상 고정된 값. utf-8 인코딩으로 반드시 설정하자!
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

// import 설정
<%@ page import="java.util.Date" %>

// session을 사용할 것인지 설정 가능. 기본값은 true / 사용 안한다면 false로 바꾸기.
<%@ page session="true" %>

// 만약 에러발생 시 지정해놓은 에러페이지로 이동. 
// isErrorPage는 현재 페이지가 에러 페인지 아닌지 설정하는 건데
// error.jsp 상단에 선언해놓으면 됨.
// 기본값은 false.
<%@ page isErrorPage="true" %>
<%@ page errorPage="error.jsp" %>
```

#### include

현재 페이지에 다른 페이지나 코드를 삽입. HTML코드를 모듈화 시키거나 공통적으로 사용해야할 부분이 있다면 `include`를 통해 삽입하면 됨! URL은 바뀌지 않음. 
