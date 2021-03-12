## Dispatcher Servlet

**FrontController**의 역할을 하는 서블릿. 프로젝트를 생성할 때 스프링은 자동으로 `DispatcherServlet`을 등록시켜 실행한다.


### MVC와 Dispatcher Servlet
스프링의 MVC패턴을 구현하기 위해 dispatcher 서블릿을 통해 프론트 컨트롤러 패턴을 적용시켜 사용자의 요청과 그에 상응하는 응답을 주고 받게 도와줌. 

큰 흐름은 이러함 :
 
1. 사용자(클라이언트)가 요청을 보낸다.
	- `HandlerMapping`이 요청에 부합하는 컨트롤러를 찾아줌.
2. FrontController가 해당 요청을 처리할 또 다른 컨트롤러를 찾아 위임.
3. 또 다른 컨트롤러(어플리케이션 컨트롤러)는 실질적인 기능을 수행, 결과 데이터와 사용자에게 보여줄 **view**(사용자에게 보여줄 경로이름)를 반환 후, front컨트롤러에게 넘김.
	- `ModelAndView`라는 객체를 통해 데이터와 view이름을 `return`시킨다.
4. front컨트롤러는 클라이언트에게 view를 응답으로 전달.
	- 컨트롤러에게 전달받은 view이름을 토대로 `viewResolver`가 응답에 필요한 최종 뷰를 결정.
	- 최종적으로 생성된 view가 클라이언트에게 출력됨.


![enter image description here](https://raw.githubusercontent.com/orongee22/TIL/master/Spring/%EC%8A%A4%ED%94%84%EB%A7%81%20mvc%EA%B5%AC%EC%A1%B0.png)

스프링은 똑똑한 놈이기 때문에 개발자가 작성할 코드를 알아서 생성하고 기능까지 다 수행을 해준다. 우리가 직접적으로 처리해야 할 단계는 크게 4가지.

1. Dispatcher Servlet을 web.xml 등록
2. 클라이언트의 요청을 실질적으로 처리할 `Controller` & (`Model(Service & DAO)`)
3. 응답에 걸맞는 뷰를 결정할 viewResolver 설정
4. 페이지로 출력할 `View`


---------------
### 서블릿 등록

**web.xml :**
```xml
<servlet>
	<servlet-name>appServlet</servlet-name>
	<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
	<init-param>
		<param-name>contextConfigLocation</param-name>
		<param-value>/WEB-INF/spring/appServlet/servlet-context.xml</param-value>
	</init-param>
	<load-on-startup>1</load-on-startup>
</servlet>
<servlet-mapping>
	<servlet-name>appServlet</servlet-name>
	<url-pattern>/</url-pattern>
</servlet-mapping>
```

서블릿이 실행되면 최초로 `init()` 초기화 메소드를 이용해 `webApplicationContext` 인 스프링 컨테이너를 자동으로 호출(생성)한다. 스프링 컨테이너는 반드시 설정파일을 받아야 하는데 `<param-value>`의 값인 `servlet-context.xml`을 설정파일을 같이 지정해서 사용한다.

그리고 url이 `/`인, 사용자로부터 요청받는 모든 요청은 dispatcher 서블릿이 관리하도록 `<servlet-mapping>`

------------------

### 컨트롤러 구성
컨트롤러는 반드시 어노테이션 명시가 필요하다

- @Controller
해당 컨트롤러를 자동으로 빈 객체로 등록하기 위해 사용함.

- @RequestMapping(" /URL이름")
프론트 컨트롤러를 통해 위임받은 사용자 요청 URL을 객체에 매핑시킴.

```java
package com.bitcamp.mvc;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	// Model : 결과 데이터 저장
	// View : 사용자에게 보여줄 view 객체
	@RequestMapping("/hello")
	public ModelAndView hello() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("hello"); // => /WEB-INF/view/"hello".jsp
		modelAndView.addObject("userName", "Cool");
		modelAndView.addObject("greeting", "안녕하세요.");
		modelAndView.addObject("now", new Date());
		
		return modelAndView;
		// viewName & Model(추가한 Object)를 함께 반환함.
	}
	
}

```

사용자가 `/hello`라는 요청을 보내면 해당 컨트롤러는 `setViewName`속성을 통해 `hello`라는 경로이름을 반환한다.  데이터가 있다면 `addObject`라는 속성으로 객체에 데이터를 저장할 수 있음. 이건 최종적으로 서블릿에게 전해지게 될 데이터. 서블릿은 반환된 해당 view객체를 `viewResolve`에게 보낸다.

------

### viewResolve

스프링 프로젝트를 생성할 때 자동적으로 `servlet-context.xml` 설정파일에 viewResolve가 등록된다. 

```xml
<beans:bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
	<beans:property name="prefix" value="/WEB-INF/views/" />
	<beans:property name="suffix" value=".jsp" />
</beans:bean>

<!-- mvc 패키지 안에 있는 컴포넌트를 스캔해오는 코드... 이것도 xml에서 같이 설정해야함.-->
<context:component-scan base-package="com.bitcamp.mvc" />

```

프론트 컨트롤러는 `prefix`와 `suffix` 사이 전달받은 view이름을 끼워넣어 어떤 뷰 페이지를 응답으로 보여줄 지 결정한다. 

```xml
<mvc:view-resolvers>
<mvc:jsp prefix="/WEB-INF/view/" />
</mvc:view-resolvers>
```
 `suffix` 없이 속성값으로 `:jsp`를 사용한다면 확장자를 무조건 jsp만 받아올 수 있게도 가능함. 위의 코드보다 좀 더 간단하게 쓸 수 있음!

아무튼... 컨트롤러를 통해 만약 "home"이라는 이름을 전달받았다면?

```
/WEB-INF/views/home.jsp
```
라는 경로가 `viewResolve`를 통해 최종적으로 반환될 것임. 그럼 해당 경로를 통해 view페이지가 짜잔...하고 실행됨! 사용자에게 실질적으로 보여지는 경로는 
```
/mvc/home
```
라는 아주 깔끔하고 간단하고 명료한 그럼 URL이 전부일 것임. 파일이 들어있는 web-inf에는 접근 못하게 막는 방법임 암튼 대략적인 흐름은 이러하다....
 

