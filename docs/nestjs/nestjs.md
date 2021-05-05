# NestJS

## 
마치라잌 node.js의 Spring같은 웹 프레임워크임. 백엔드 어플리케이션 구성을 위한 초석이 된다.

- 타입스크립트로 작성
- express 위에서 작동함


## 설치
### 1. insomnia 설치 

REST api 테스팅 클라이언트 - ex) POSTMAN

> [설치](https://insomnia.rest/download)

### 2. NestJS 설치
```bash
npm i -g @nestjs/cli4
npm new 프로젝트 이름

// cli 로 설치해서 생성
```

## 시작
### 실행
```
npm run start:dev
// :dev 옵션은 --watch와 동일
```
실행시키면 localhost 로 접속할 수 있음.  nodejs 환경이기에 기본 포트는 3000번

### 구조

`src` 폴더에 들어가면 각 기능을 하는 파일들이 생성되어 있음

#### main.ts 
어플리케이션의 시작점으로 리액트로 따져보면 `index.js` 같은 기능.

```ts
import { NestFactory } from  '@nestjs/core';
import { AppModule } from  './app.module';

  
async  function  bootstrap() {
	const  app = await  NestFactory.create(AppModule);
	await  app.listen(3000);
}

bootstrap();
```


#### app.module.ts
app.js 같은 애... 실질적으론 여기서 실행됨 ㅎㅎ
app.controller랑 app.service 연결 지점.

```ts
import { Module } from  '@nestjs/common';
import { AppController } from  './app.controller';
import { AppService } from  './app.service';

@Module({
	imports: [],
	controllers: [AppController],
	providers: [AppService],
})

export  class  AppModule {}
```
 

#### app.service.ts
비즈니스 로직을 담당함. 


### 생성
`@nestjs/cli`를 사용하므로 생성할 때도 cli를 이용할 수 있음.

```bash
nest generate|g contorller|co 컨트롤러이름  // 컨트롤러 생성
nest generate|g service|s 서비스이름        // 서비스 생성
```

이렇게 하면 자동으로 파일이 생성되어 모듈에 연결됨

### @Decorator
클래스나 함수 바로 위에 데코레이터를 붙여 기능을 부여한다.

#### @Controller
컨트롤러 클래스 앞머리에 `@Controller('컨트롤러이름')` 이렇게 붙여서 사용
컨트롤러 이름에 따른 라우터가 생성됨.

#### @Injectable
의존성 주입 데코레이터. 주로 service에 붙임.
service는 모듈에서 `provider`로 연결시켜 놓는데, 이건 Service 를 Provider로 사용한다는 의미임.

controller 파일에서

```ts
constructor(private  readonly  moviesService: MoviesService)
```
이렇게 생성자에 service의 이름만 정의하고도  내부에서 service의 메소드를  사용할 수 있게 한다.
그 이유가 바로 의존성 주입 덕분임. 다른 클래스에서 있는 내용을 사용하고 싶을 때, 그 내부에 있는 코드를 현재 코드 내에서 다시 재정의하여 꺼내쓰지 않고도 제어가 가능 ok

#### @Get, Post, Delete, Patch, Put
CRUD를 위한 데코레이터 path variable 안에 넣고 사용할 수 있음
```ts
@Get('/:id')
@Delete('/:id')
```

#### @Param 
pathVariable로 받아온 변수를 parameter로 넘길 때 사용

```ts
@Get('/:id')
getOneMovie(@Param("id") moiveId: string)

// pathvariable에서 받아온 변수 이름과 Param 안에 넣는 변수 이름은 동일해야함
```

#### @Body
requestBody 의미

#### @Query
검색할 때 query 값 정의

```ts
@Get('search') 
	searchMovie(@Query('title') title: string){
	return `We are searching Movie to Title: ${title}`;
}
```


