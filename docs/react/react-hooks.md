# React Hooks

### useMemo
렌더링 과정에서 특정 값이 바뀔때만 연산을 실행한다든가, 혹은 결과를 다시 사용해야 할 때 씀.

```js
const [list, setList] = useState('');
const getAverage = num => {
	if(num.legnth === 0) return 0;
	
	const sum = num.reduce((a,b)=>{a+b});
	return sum / num.length;
}

const avg = useMemo(()=>getAverage(list), []); 
```
getAverage의 반환값을 첫 렌더링 시에만 계산하여 저장. 만약 두번째 매개변수로 `[list]`를 넣는다면 list의 값이 변할 때만 값을 연산하여 반환할 것임.

### useCallback

useMemo와 비슷한데, 이건 함수를 재사용할 때 이용함. 컴포넌트가 렌더링 될 때 마다 선언해둔 함수가 새로 생성됨. 예를 들어 `onChange`나 `onClick`같은 이벤트 함수. 렌더링이 될 때마다 생성하는 것은 비효율적이기 때문에 **useCallback** hooks를 이용하여 필요할 때만 새로 생성하도록 하자.

```js
const onChange = useCallback(e=>{
	setNumber(e.target.value);
}, []);
```

첫번째 파라미터엔 생성하고자 하는 함수, 두번째 파라미터엔 어떤 값이 바뀌었을 때 생성하고자 하는지 그 값을 배열 형식으로 넣으면 됨. `[]` 이렇게 빈 값을 넣으면 렌더링이 되는 딱 한번만 생성됨!
함수 내부에서 기존의 사용하던 참조값이 있다면 반드시 그 값들을 배열 안에 넣어줘야 함!



### 나만의 Hooks 만들기
컴포넌트끼리 비슷한 기능을 공유할 경우, 외부에서 hooks를 만들어두고 불러와서 사용할 수 있음. 

*useInput.js :*
```js  
import { useReducer } from "react";  
 
// 리듀서 함수 생성
function reducer(state, action) {  
  return {  
  ...state,  
 [action.name]: action.value  
  };  
}  
  
export default function useInputs(initialForm) {  
  const [state, dispatch] = useReducer(reducer, initialForm);  
  const onChange = e => {  
  dispatch(e.target);  
 };  return [state, onChange];  
}
```

*Info.js :*
```js
import React from "react";  
import useInput from "./useInput";  
import "./styles.css";  
  
const Info = () => {  
  const [state, onChange] = useInput({  
  name: '',  
  nickname: ''  
  });  
  
  const {name, nickname} = state;  
  
  return (  
	 <div>  
		 <div>  
			 <input name="name" onChange={onChange} />  
			 <input name="nickname" onChange={onChange} />  
		 </div>  
		 <div>  
			 <h3>이름 : {name}</h3>  
			 <h3>닉네임 : {nickname}</h3>  
		 </div>  
	 </div>  
  );
 };  
  
export default Info;
```

Info 컴포넌트 내에서 함수와 리듀서를 생성하지 않고 외부에서 작성한 useInput 컴포넌트를 가져다 사용할 수 있음. 이게 바로 커스텀 hooks!