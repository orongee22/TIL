# Mobx

## 설치

```
yarn add mobx react-mobx
```

## mobx의 기본!

### 1. observable

 관찰을 받고 있는 상태. mobx에서의 state는 전부 관찰대상임! 리덕스와 달리 불변성을 지킬 필요가 없는게 얘는 어떤 부분이 어떻게 바뀐 건지 다 앎 객체든 배열이든 객체 속 객체이든 어떻든,,,

### 2. computed value

이벤트 발생으로 인해서 어떤 연산에 필요로 하는 state값이 바뀌면? 그 state 변화에 따라 새로운 연산작업을 수행함. 주로 최적화를 위해 사용함 ㅇㅋ

### 3. reactions

연산된 값이랑 비슷한 느낌인데 얘는 값이 바뀔 때 특정 작업을 실행하는 것을 의미함.

### 4. actions

리덕스의 액션하고 같음. 상태에 변화를 일으킴. 따로 액션 객체 생성 X

### 5. decorate

컴포넌트와 mobx를 연결지어주는 함수. 

```js
decorate(컴포넌트, {object});
```
첫번째 파라미터는 적용할 컴포넌트, 두번째 파라미터는 mobx를 적용할 변수나 함수 등등, 근데 decorator(애노테이션)을 이용하면 이거 일일히 안해도 됨. 근데 이거 사용할라면 babel설정 필수임.



### babel 설정

데코레이터를 사용하기 위한 babel 설정! cra로 만든 앱은 설정파일이 숨겨져 있으니 `yarn eject`를 해서 꺼내주자. 혹은 `npm run eject`
eject를 할 땐 반드시 `git init` 하고 `commit`이 먼저 실행되어야 함. 

*package.json*에 추가해줌.
```json
"babel": { 
	"presets": [ 
		"react-app" 
	], 
	"plugins": [ 
		[ "@babel/plugin-proposal-decorators", { "legacy": true } ], 
		[ "@babel/plugin-proposal-class-properties", { "loose": true } ] 
	] 
}
```

### mobx 사용하기

리덕스처럼 global하게 사용하기 위해서 `stores` 폴더에서 action과 store 컴포넌트를 따로 분리해서 필요한 곳에 불러올 것임! 

stores/counter.js
```js
import { observable, computed, action, decorate } from "mobx";

export default class CounterStore{
	// 관찰하고자 하는 state
    @observable number = 0;
	
	// 액션이 발생할 함수에 선언
    @action
    increase = () => {
        this.number++;
    };
    @action
    decrease = () => {
        this.number--;
    };
}
```
기본적으로 mobx는 `this.state` 식으로 상태를 관리하지 않는듯... `state={number:0}` 이렇게 선언 안하고 그냥 `number:0` 으로 바로 선언함. 
리덕스는 액션, 스토어, 리듀서 모두 분리해서 사용하지만, mobx에서는 store와 action, state값만 한데 묶어 생성해줌.

그리고 데코레이터를 사용하면 자동으로 mobx의 상태값들과 컴포넌트가 연결되는 방식.


이렇게 새로 생성한 store를 컴포넌트에 적용하기 위해선 `Provider`라는 것이 필요한데, index.js에서 App컴포넌트를 Provider로 감싸주면 됨.

index.js
```js
// mobx의 provider를 불러오고!
import {Provider} from 'mobx-react';

// ....생략

ReactDOM.render(
	<Provider counter={counter}>
		<App />
	</Provider>
	//...이하생략
)
```

그럼 이제 App에 있는 하위 컴포넌트에서 counter 스토어를 사용할 수 있음. 스토어의 것들을 props로 전달받기 위해선 `@inject` 데코레이터를 사용함.

src/Counter.js

```js
import React, {Component} from 'react';
import {observer, inject} from 'react-mobx';

@inject('counter') // 스토어명을 기입
@observer
class Counter extends Component{
	render(){
		const {counter} = this.props;
		return(
			<div>
				<h1>{counter.number}</h1>
				<button onClick={counter.increase}>+1</button>
				<button onClick={counter.decrease}>-1</button>
			</div>
		)
	}
}
```
`@inject`로 counter를 주입시키고, class에서 주입받은 counter를 `this.props`로 내려받아 사용 가능! 만약 counter의 특정 부분만 가져와서 사용한다면?

```js
@inject((store)=>({
	number: stores.counter.number,
	increase: store.counter.increase,
	decrease: store.counter.decrease
}))

@observer
class Counter extends Component{
	render(){
		const { number, increase, decrease } = this.props;
		//....이하생략
	}
}
```

이렇게 필요한 부분만 객체로 선언해서 가져오면 된다.
