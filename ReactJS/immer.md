## immer 

배열이나 객체의 불변성을 유지하기 위해 사용하는 라이브러리. `map`이나 `filter`, `concat`과 같이 object를 복사하지 않고도 기존의 메소드로도 불변성 유지를 가능하게 만들어준다!

```js
import produce from 'immer';

const nextState = produce(originState, draft =>{
	draft.deep.inside = 5;
}
```
`produce()` 는 수정이 필요한 state와 `draft` 두 가지를 매개변수로 받음. `draft`는 기존의 수정이 필요한 `state`를 프록시함!

--------------------------------------------------------------------------------

### 예제 
*immer를 쓰기 전 :*
```js
import React,{useState, useRef, useCallback} from 'react';  
import logo from './logo.svg';  
import './App.css';  
  
function App() {  
	const nextIdx = useRef(1);  
	const [form, setForm] = useState({id:'',username:''});  
	const [data, setData] = useState({  
		array:[],  
		useLessValue:null  
	});  
  
	const onChange = useCallback(e=>{  
			const {name, value} = e.target;  
			setForm({  
				...form,  
				[name]:[value]  
			}); 
	},[form]);
	  
	const onSubmit = useCallback(e=>{  
		e.preventDefault();  
		const info = {  
			idx : nextIdx.current,  
			id : form.id,  
			username: form.username  
		}  
		setData({...data, array: data.array.concat(info)});  
		setForm({id:'',username:''});  
		nextIdx.current++;  
	},[form, data, nextIdx]);  
  
	const onRemove = useCallback((idx)=>{  
		setData({  
			...data,  
			array: data.array.filter(item=>item.idx !== idx)  
		}); 
	},[data]);  
  
	 return (  
		 <div>  
			 <form onSubmit={onSubmit}>  
				 <input name="id" placeholder="아이디" value={form.id} onChange={onChange} />  
				 <input name="username" placeholder="이름" value={form.username} onChange={onChange} />  
				 <button type="submit" onClick={onSubmit}>등록</button>  
			 </form>  
			 <ul>{  
			  data.array.map(item=>{  
				  return <li key={item.idx} onClick={()=>onRemove(item.idx)}>{item.id} : {item.username}</li>  
				 }) 
			 }</ul>  
		 </div>  
	 )
 ;}  
  
export default App;
```

*immer를 쓰고난 후 :*
```js
setForm(produce((form, draft)=>{  
  draft[name] = [value]  
}));

setData(produce((data, draft)=>{  
  draft.data.array.push(info);  
}));

// array의 배열 자르기
// 선택한 item의 idx와 현재 state item의 idx가 같다면 해당 item의 index를 찾아 배열에서 잘라내기!
setData(produce((data, draft)=>{  
  draft.array.splice(draft.array.findIndex(item=>item.idx === idx),1);  
}))
```

------------------------------------------
### useState 함수형 업데이트

```js
const onSubmit = useCallback(()=>{
	setNumber(number=> number+1);
}, []);
```
`useCallback`을 사용해 setState 할 때 직접 함수를 넣어 값을 업데이트 하면 `[]`배열을 빈 배열로 해도 ㄱㅊ.
이때 immer를 쓰면 더 편하게 작성이 가능하다는데,,,,,,,,,,,,,,,

`produce`의 매개변수를 하나만 넣어 사용하면 `produce`는 그 반환값 자체가 함수가 됨!
```js
const [obj, setObj] = useState({
	foo: '',
	bar: ''
});

// setNumber(prevNum=>prevNum+1);

const onSubmit = useCallback(()=>{
	setObj(produce(draft=> {
		draft.foo: '하이',
		draft.bar: '방가룽'
	}));
},[]);

```


### 참조
[https://hyeok999.github.io/2020/02/03/react-velo-21/#a6](https://hyeok999.github.io/2020/02/03/react-velo-21/#a6)
