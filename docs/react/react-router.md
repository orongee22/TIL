# react router

```
yarn add react-router-dom
```

router를 사용할 때는 상단에 `import {Route} from 'react-router-dom';`을 호출해서 씀.


### 링크 이동하기 

App.js :
```js
import React, {Fragment} from 'react';
import {Route, Link} from 'react-router-dom';
import Home from './components/Home';
import About from './components/About';

const App = () => {
render(
	<Fragment>
		<div>
			<ul>
				<li><Link to="/">메인</Link></li>
				<li><Link to="/about">소개</Link></li>
			</ul>
		</div>
		<Route path="/" component={Home} exact={true} />
		<Route path="/about" component={About} />
	</Fragment>
)
}
```

a 태그 대신 `Link`컴포넌트를 이용해서 링크주소를 달아줘야함. 
`Route` 컴포넌트는 해당 주소로 들어갈 시 보여주고 싶은 컴포넌트 설정함. 

`exact` 속성은 `/` path값의 중복현상을 막기 위해 설정함. 반드시 `/`로 들어갈 때만 Home화면이 뜨도록 true로 설정하는 것임!

### path 여러개 달기

```js
<Route path={['/about', '/info']} component={About} />
```

이렇게 path 속성에 배열로 주소 값을 넣어주면 됨!


### URL 파라미터 받아오기


Profile.js :
```js
const data = {  
  velopert : {  
	  name: '김',  
	  description: '개발자'  
  },  
  gildong: {  
	  name: '홍',  
	  description: '홍길동'  
  }  
};


const Profile = ({match}) => {  
	console.log(match); // 컴포넌트 정보  
	console.log(match.params); // 파라미터 정보  
	const {username} = match.params; //velopert 혹은 gildong  
	const profile = data[username]; // 파라미터 값과 data속 객체 이름을 매칭시켜 변수에 담음  
	if(!profile){  
		// 만약 파라미터 값이 잘못되어 data에서 찾지 못했다면 존재안함! 이라고 return  
		return <div>존재하지 않는 사용자</div>  
	}  
	return (  
		<div>  
			<h3>{username}({profile.name})</h3>  
			<p>{profile.description}</p>  
		</div>  
	);
};
```

App.js : 
```js
<li>  
 <Link to="/profile/velopert">velopert's profile</Link>  
</li>  
<li>  
  <Link to="/profile/gildong">gildong's profile</Link>  
</li>

<Route path="/profile/:username" component={Profile} />
```

`match`는 현재 컴포넌트가 가지고 있는 url의 정보등을 받아오는 객체. `.params`속성을 이용해서 사용자가 이동한 url 파라미터값을 가져와서 `data`객체와 비교! 프로필 데이터가 존재한다면 화면에 출력하고, 그게 아니라면 존재하지 않는 사용자를 출력하는 시스템임!

### URL 쿼리 받아오기

먼저 쿼리 스트링을 객체로 변환하기 위한 라이브러리를 설치하기!
```
yarn add qs
```

`http://localhost:3000/about?detail=true` 로 접속 시, `detail=true`의 값을 About.js에서 **location** 객체로 정보를 받아올 수 있음.

```
const location = {
	"pathname" : "/about",
	"search" : "?detail=true",
	"hash" : ""
}
```
받아온 객체 정보값을 `qs` 로 파싱하여 처리함.

About.js : 
```js
import React from 'react';  
import qs from 'qs';  
  
const About = ({location}) => {  
	  const qr = qs.parse(location.search, {  
		  ignoreQueryPrefix: true // 문자열 앞의 ? 물음표 생략하기  
	  });  
	  const showDetail = qr.detail === 'true';  
	  return (  
		 <div>  
			 <h1>소개</h1>  
			 <p>어바웃페이지</p>  
			 {showDetail ? <div>detail = true</div> : <div>detail : false</div>}  
		 </div>  
	  );
 };  
  
export default About;
```

localhost:3000/about/detail=true 로 들어갈 시에만 true 화면이 출력!됨!

### 라우터 기능
 
- history
라우트로 연결된 컴포넌트 안 메소드 등에서 사용.
페이지 뒤로가기, 화면 전환하기, 페이지 이탈방지 기능
```js
handleGoBack = () =>{
	this.props.history.goBack();
}
handlGoHome = () => {
	this.props.history.push('/'); // 홈으로 이동하기
}
```

- WithRouter
라우트 컴포넌트 밖에서도 라우트 관련 정보 객체에 접근 가능.

- Switch
일치하는 라우트만을 렌더링 할 수 있음. 만약 일치하지 않을 때 not found 페이지도 구현할 수 있음.
```js
<Switch>
	<Route path="/" component={Home} exact={true}/>
	<Route path="/about" component={About} />
	<Route render={({location}) => (<div><h2>존재하지 않는 페이지 입니다.</h2></div>)}/>
</Switch>
```

- NavLink
해당 페이지의 경로가 일치하는 경우 `activeClassName` 속성으로 클래스 이름을 추가하거나, `activeStyle` 속성으로 css를 입힐 수 있음.