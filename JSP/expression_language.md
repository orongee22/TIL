## 표현 언어 EL

JSP에서 쓸 수 있는 다른 스크립트 언어. JSP 표현식 혹은 action보다 좀 더 간단하고 깔끔하고 가독성 좋게 값을 표현하고 출력할 수 있음. 컴파일할 때 코드를 한꺼번에 파싱하는 JSP와 달리 EL은 코드를 바로 읽고 실행함.

- jsp가 제공하는 기본 객체 속성 사용 가능
- 컬렉션을 통한 접근 방법을 제공함
- 자바 클래스 메소드 호출
- 표현언어 따로 객체를 제공함.

EL은 속성을 **Map방식**으로 저장하기 때문에 key값을 통해 그 value를 가져올 수 있음.

사용법은 이렇게:
```el
${ 표현언어 }
```
### EL 내장 객체

- pageScope 
- requestScope 
- sessionScope 
- applicationScope 

```jsp
<%
	request.setAttribute("name01", "requestData");
	session.setAttribute("name02", "sessionData");
	application.setAttribute("name03","applicationData");
	request.setAttribute("code", "zero");
%>

request 영역 : ${requestScope.name01}<br> //requestData
session 영역 : ${sessionScope.name02}<br> //sessionData
application 영역 : ${applicationScope.name03}<br> // application
```

속성 영역은 생략도 가능함.

`page -> request - > session -> application` 순서대로 내부적으로 탐색을 처리해서 해당 이름을 찾으면 가져오는 것!
 
```jsp 
request 영역 : ${name01}
session 영역 : ${name02}
application 영역 : ${name03}

code 파라미터 : ${param.code}
contextPath : ${pageContext.request.contextPath}
```
-----------------------
- param :  요청받은 파라미터값을 가져온다. `getParameter()` 와 동일한 역할을 함.


_form.jsp :_
```html
<form action="request.jsp" method="post">
		아이디<input type="text" name="userID">
		비밀번호<input type="password" name="userPW">
		<input type="submit" value="등록">
</form>
```

_request.jsp :_
```html
<h3>
	아이디 : ${param.userID}<br>
	비밀번호 : ${param.userPW}<br>
</h3>
```
-----------------------

- paramValues : 요청받은 파라미터를 배열값으로 한꺼번에 가져온다.
- cookie : 쿠키 객체. `new Cookie`를 선언 안해도 됨.

#### 객체에 접근하기

**.속성값을 통한 값**
```
member 객체 참조 1 - id:${requestScope.member.id}
member 객체 참조 2 - name : ${requestScope.member.name}
member 객체 참조 3 - phonenum : ${requestScope.member.pNum}
member 객체 참조 4 - num : ${requestScope.member.num }
```
`member`라는 객체가 있을 때, `.`을 통해 객체 메소드에 쉽게 접근할 수 있음. `member.id`는 변수 이름 `id`를 뜻하는것이 아니고 `getId()`라는 메소드에 접근한 것이니 혼동하지 말기!


### EL 데이터타입

```jsp
- boolean : ${true} / ${false}
- 정수 & 실수 : ${256} / ${2.113234}
- 문자열 : ${'문자열1'} / ${"문자열2"}
> 경로 표현도 가능 : <a href="${'www.naver.com/'}"></a>

- null : ${null}
```
만약 EL을 썼을 때 `null`값이 나온다면 출력 안함. 값이 아예 빈 값으로 나옴.

### 연산자
EL에서는 연산자를 약자나 키워드로 표현함.

- `eq` : **==** 같음
- `ne` : **!=** 같지 않음
- `and` : **&&**
- `or` : **||**
- `empty <값>` : 만약 값이 **null** 이 나온다면 `true`를 반환한다. 빈 문자열, 값의 길이가 0 이어도 `true값`!
```jsp
	${10 div 2} / ${10 div 3} , ${10 mod 2}
	${null}, ${empty null}
	${1 eq 1} , ${ 10 ne 10} , ${10 gt 1} , ${10 lt 1} , ${10 ge 10}
```
