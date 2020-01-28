## mobx

### computed

observable 값이 변경될 때마다 자동으로 연산처리 시키는 것이 `@computed`

stores/counter.js :
```js
@observable
number = 0;

@computed
get total(){
	return this.number * this.number;
}
```
number의 값이 변경될 때마다 computed에 의해 `total()` 함수가 실행됨!
갑자기 튀어나온 `get`에 대한 정보는 [여기서](https://github.com/orongee22/TIL/Javascript/es6-class-get) 확인쓰


### 여러 개의 store 사용하기

Store는 여러 개를 생성할 수 있고 스토어들끼리 연결지어서 사용할 수 도 있음. 헌데 스토어는 반드시 `RootStore` 하나만을 가지고 하나로만 관리한다. 그러기 위해선 store를 싱글톤으로 유지해야함쓰.

#### RootStore 생성
stores/index.js
```js
import CounterStore from './counter';
import ResetStore from './reset';

class RootStore{
	constructor(){
		this.counter = new  CounterStore(this);
		this.reset = new  ResetStore(this);
	}
}
export  default  RootStore;
```

RootStore는 말했듯이 싱글톤임! 이 싱글톤으로 유지될 스토어를 다른 데서 인스턴스로 생성해서 만들지 않기 위해 생성자를 이용해서 기존의 스토어를 공유하는 것임!
인스턴스를 생성하면서 RootStore를 가리키는 `this`값을 넣어줬기 때문에, 서브 스토어에서는 `RootStore`를 가리키는 this를 통해 root를 get할 수 있음.ㅠㅠㅠㅠ

#### ResetStore 생성
stores/reset.js
```js
import {action} from  "mobx";
export  default  class  ResetStore{
	constructor(root){
		this.root = root;
	}

	@action
	reset = () => {
		this.root.counter.number = 0;
	}
}
```

생성자에서 받아온 root를 통해 `RootStore`와 연결함! reset액션이 발생하면 root를 통해 root가 가지고 있는 다른 서브스토어인 counter 스토어의 number값을 0으로 변경시키기!

`counter.js`에도 똑같이 생성자로 root값을 받아오자

stores/counter.js
```js
export  default  class  CounterStore{
	constructor(root){
		this.root = root;
	}
	///..... 이하생략
}
```

설정 끝났으니 `src/index.js`에서 RootStore를 Provider로 받아오면됨.

#### RootStore Provider 설정
src/index.js
```js
import RootStore from './stores';

const root = new RootStore();

ReactDOM.render(
	<Provider {...root}>
		<App />
	</Provider>
	//....생략
}
```
현재 `RootStore`속에 들어있는 두가지의 store를 한번에 적용시키기 위해서 `{...root}` 전개연산자를 사용함.

#### inject로 주입하기
src/Counter.js
```js
import  React, {Component} from  'react';
import {observer, inject} from  'mobx-react';  

@inject((root)=>({
	counter:  root.counter,
	reset:  root.reset
}))
@observer
class  Counter  extends  Component{
	render(){
		const {counter, reset} = this.props;

		return(
			<div>
				<h1>제곱 값?? {counter.total}</h1>
				<h1>현재 값??{counter.number}</h1>
				<button  onClick={counter.increase}>+1</button>
				<button  onClick={counter.decrease}>-1</button>
				<button  onClick={reset.reset}>reset</button>
			</div>
		)
	}
}

export  default  Counter;
```
Provider를 통해 가져온 RootStore는 여러 개의 스토어 값을 가지므로 `@inject`의 파라미터는 객체형식으로 받아와야 함.
객체의 `key`값이 props로 전해져서 `this.props.counter` 혹은 `this.props.reset`으로 접근 가능.

또한 `counter.total`은 함수 객체를 넣어주는데,,, computed를 통해서 number 상태 값이 변할 때마다 자동적으로 함수가 실행돼서 return 값을 출력시켜줌,,,
