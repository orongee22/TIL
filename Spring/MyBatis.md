## MyBatis

마이바티스는 중복되는 DB SQL구문등을 좀 더 깔끔하고 쉽게 처리할 수 있게 만든다. SQL문을 xml 외부 설정파일로 따로 처리하기 때문에 자바 코드 내에 섞어 쓰지 않아도 된다. jdbc를 기반으로 사용하기 때문에 jdbc 추가는 항상 필수!

### 라이브러리 추가하기
mybatis를 사용하기 위해선 기본적으로 `spring-jdbc`와 `spring-tx`는 필수. 그런 다음 **mybatis**, **mybatis-spring** 라이브러리를 추가해야 한다. mybatis-spring은 스프링과 마이바티스를 연동하기 위한 라이브러리임.

*pom.xml :*
```xml
<!-- https://mvnrepository.com/artifact/org.mybatis/mybatis --> 
<dependency> 
	<groupId>org.mybatis</groupId> 
	<artifactId>mybatis</artifactId> 
	<version>3.4.1</version> 
</dependency> 
<!-- https://mvnrepository.com/artifact/org.mybatis/mybatis-spring --> 
<!-- mybatis-spring은 spring 에 연동하기 위함. -->
<dependency> 
	<groupId>org.mybatis</groupId> 
	<artifactId>mybatis-spring</artifactId> 
	<version>1.3.0</version> 
</dependency>
```

------------------------

### SqlSessionFactory

마이바티스는 내부적으로 `SqlSessionFactory`라는 인스턴스를 사용함. 모든 기능들이 이 안에 다 들어있다고 보면됨. 해당 인스턴스 객체를 bean 객체로 매핑 시킨 후 사용해야 하니 xml 설정파일 혹은 자바 클래스 `@Configuration`을 통해 빌드 시켜야 한다. 

*servlet.xml :*
```xml
<beans:bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean"> 
	<!-- DB사용을 위해 datasource를 반드시 주입 -->
	<beans:property name="dataSource" ref="dataSource" />
	<!-- String value값 : classpath 경로 이름을 주입. -->
	<beans:property name="mapperLocations" value="classpath:com/bitcamp/openproject/mapper/mybatis/*.xml" /> 
</beans:bean>
```

`sqlSessionFactory` 는 반드시 `dataSource` 객체를 주입받아야 한다.
dataSource는 DB 연동 할 때 필요한 드라이버를 추가 클래스.
```xml
// DataSource Bean
// DB 연동을 위한 기능 - DB 드라이버 관련
<beans:bean id="dataSource"
		class="org.apache.commons.dbcp2.BasicDataSource"
		p:driverClassName="oracle.jdbc.driver.OracleDriver" 		
		p:url="jdbc:oracle:thin:localhost:1521:orcl"
		p:username="SCOTT"
		p:password="tiger" />
```
`mapperLocations`는 sql문을 따로 설정해둔 xml파일을 mapping시키는 역할을 한다.
```xml
<beans:property name="mapperLocations" value="classpath:com/bitcamp/openproject/mapper/mybatis/*.xml" /> 
</beans:bean>
```
#### SqlSessionTemplate

`SqlSessionTemplate`은 sql문을 실행하기 위한 메소드들의 집합임. `sqlSession`이라는 이름으로 클래스를 객체화 시켜 사용한다. `sqlSessionFactory`를 주입받기 위해 template내부에 있는 여러 생성자 중에 가장 첫번째 생성자를 `index=0`으로 선택하여 주입시킨다.
```xml
<beans:bean id="sqlSession" class="org.mybatis.spring.SqlSessionTemplate">
	<!-- index="0" : sqlSessionTemplate.class 속 0번째 생성자 찾아서 주입하기. -->
	<beans:constructor-arg index="0" ref="sqlSessionFactory"/>
</beans:bean>
```


-----------------------------------------

### Mapper.xml

SQL구문을 매핑하는 방법은 두가지.

- 어노테이션으로 매핑
- xml 외부 설정 파일로 매핑

**어노테이션 매핑 방법**


간단한 코드라면 어노테이션으로 사용하는 것이 깔끔하겠지만 복잡할 수록 xml을 사용하는 것이 좀 더 효과적이다!
이렇게 외부에 따로 빼어 결과값만을 받아오는 방식은 동적으로 변하는 SQL문을 제어하기에도 아주 탁월하다.

*guestMapper.xml :*
```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<!-- @ namespace : DAO에서 식별하기 위한 이름. 필수 속성 -->
<!-- DAO - com.bitcamp.guest.mapper.mybatis.guestMapper.insertMessage(str, id) / 이런 식으로 메소드를 연결지음 -->
<mapper namespace="com.bitcamp.guest.mapper.mybatis.guestMapper">
<!--  -->
<insert id="insertMessage" parameterType="com.bitcamp.guest.domain.Message">
	insert into guestbook_message(message_id, guest_name, password, message) values (gm_mid_seq.nextval, #{guestName},#{password},#{message})
</insert>
<select id="selectCount">
	select count(*) from guestbook_message
</select>

<select id="select" resultType="com.bitcamp.guest.domain.Message">
	select * from guestbook_message where message_id=#{id}
</select>

<select id="selectList" parameterType="map"
resultType="com.bitcamp.guest.domain.Message"
resultMap="messageResultmap">

<![CDATA[
select message_id, guest_name, password, message from (select rownum rnum, message_id, guest_name, password, message from (select * from guestbook_message m order by m.message_id desc ) where rownum <= #{endRow} ) where rnum >= #{firstRow}
]]>
</select>
<delete id="deleteMessage">
	delete from guestbook_message where message_id=#{id}
</delete>
```

- parameterType : 바인딩할 매개변수의 타입을 설정 기본형은 `int`. `String` or `int`인 기본형 타입은 파라미터타입값을 생략할 수 있다.

sql구문에 파라미터는 `#{}`로 표기한다. 
만약 파라미터값이 많을 경우 변수이름을 하나하나 지정하지 않고 임의로 `param0`, `param1`... 식으로 순차 기입하는 것도 가능하다.
```xml
<select id="select" parameterType="int" resultType="com.bitcamp.guest.domain.Message">
	select * from guestbook_message where message_id=#{id}
</select>
```

- resultType : 결과값의 타입을 설정.  설정은`parameterType` 과 동일함.  만약 클래스 객체를 파라미터로 받아야하는 경우. 패키지명까지 전부 작성해주어야함. 
```java
parameterType="com.bitcamp.guest.domain.Message"
resultType="com.bitcamp.guest.domain.MessageListView"
```

**ResultMap?**

DB에서 설정한 필드값과 객체에서 설정한 변수명이 다를 경우 사용한다. 
```xml
<resultMap id="messageResultmap"
			   type="com.bitcamp.guest.domain.Message" >
		<!--id : DB에서 PK를 뜻함-->
		<id property="id" column="message_id"/>
		<result property="guestName" column="guest_name"/>
		<result property="password" column="password"/>
		<result property="message" column="message"/>
	</resultMap>
</mapper>
```

```xml
<select id="selectList" parameterType="map" resultType="com.bitcamp.guest.domain.Message"
resultMap="messageResultmap">
```

-----------------------------------------------

### Mapper 연결
위에서 설정한 mapper를 연결하는 방법도 두가지

- Mapper namespace와 id 값을 이용
- Interface 클래스를 이용

#### namespace로 호출하기

*guestMapper.xml :*
```xml
<mapper namespace="com.bitcamp.guest.mapper.mybatis.guestMapper">

<select id="selectCount">
	select count(*) from guestbook_message
</select>
```

*MessageSessionTemplateDao.class :*
```java
// sql문을 실행하는 template 객체를 주입받아 생성한다.
@Autowired
private SqlSessionTemplate template;

// mapper의 namespace를 통해 객체의 이름을 저장한다.
private String nameSpace = "com.bit.camp.guest.mapper.mybatis.guestMapper";

public selectCount(){
	return template.selectOne(nameSpace+".selectCount");
}
```
namespace 속성은 클래스를 구별하기 위한 식별값임.  네임스페이스를 통해 mapper클래스의 이름을 등록하고, `네임스페이스(mapper).메소드` 를 String으로 저장해서 SqlSessionTemplate에게 매개변수로 전달한다.

**SqlSessionTemplate.selectOne()** : template이 제공하는 select 메소드. 하나의 매개변수를 이용해 select해야 하는 경우 사용한다. 만약 매개변수가 많을 경우?
**SqlSessionTemplate.selectList(Map<T>)** 메소드를 통해 매개변수를 map형식의 리스트로 묶어 전달해야한다.

모든 처리는 template이 혼자 뚝딱! mapper에서 설정한 resultType값으로 반환시킴.






