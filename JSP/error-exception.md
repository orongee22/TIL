##### JSP

## error 처리

### 에러 처리란?

에러가 발생할 때의 페이지 흐름을 제어할 수 있음!

### 에러 페이지 흐름 제어

#### 디렉티브를 이용

디렉티브 위치에 지시어를 통해 에러 페이지 출력을 지정할 수 있음.
```java
// page1.jsp
<%@ page errorPage="errorPage.jsp" %>
// 에러가 뜬다면 errorPage.jsp로 이동!
```

해당 에러 페이지:
```java
// errorPage.jsp
<% page isErrorPage="true" %>
```
`isErrorPage`가 `true`값이어야 에러 페이지로 사용이 가능하다.

> !IE에서는 에러페이지의 크기가 513kb 이상이어야 출력이 가능함. 그 이하라면 브라우저에서 제공하는 기본 템플릿 페이지가 출력됨.

#### web.xml를 이용

에러페이지를 한꺼번에 처리하고 싶을 때 `web.xml` 내부에 에러관련 코드를 넣어 처리할 수도 있음.

1. 상태 코드로 처리
```xml
<error-page>
<error-code>에러코드</error-code>
<location>에러페이지의 URI</location>
</error-page>
```
2. 예외 클래스명으로 처리
```xml
<error-page>
	<exception-type>예외클래스명</exception-type>
	<location>에러페이지의 URI</location>
</error-page>
```

**errorpage의 우선순위**

`errorPage > exception-type > error-code`


#### 응답 상태 코드

- 2xx : 정상
- 4xx: 클라이언트 오류 
	- 403: 서버 요청 실패. 권한 없음.
	- 404: 경로를 찾을 수 없음. 페이지 존재 X
	- 405: get / post method방식으로 인한 문제.
- 5xx: 서버 오류




