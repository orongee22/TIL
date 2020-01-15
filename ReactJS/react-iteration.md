# 컴포넌트 반복

###  map() 사용

map함수는 기존의 배열을 복사해서 새로운 배열을 만듦!

```js
const num = [1,2,3,4,5]

const processed = num.map((n) => {
	return n * n;
}

console.log(processed); // processed : [1,4,9,16,25]
```
배열 통해서 리스트 출력하려면 map함수를 이용해서 `<li>`태그를 반복 시킴.

### 이름 등록, 삭제 예제

```js

import React, { useState, Fragment } from "react";  
  
const App = () => {  
	  const [names, setNames] = useState([  
		{ 
			  idx: 1,  
			  name: "예리나"  
		  },  
		 {  
			 idx: 2,  
			  name: "레오"  
		  },  
		 {  
			 idx: 3,  
			  name: "리오"  
		  }  
		]);  
	  const [inputName, setInputName] = useState("");  
	  // const [idx, setIdx] = useState("");  
	  
	  const addItem = () => {  
		  const nextItem = [...names, { idx: names.length + 1, name: inputName }];  
	  
		  setNames(nextItem);  
		  setInputName("");  
		  console.log(nextItem);  
		  console.log(names);  
	 }; 
  
	  const onChange = e => {  
		  setInputName(e.target.value);  
		  console.log("inputName : " + inputName);  
	 };  
	 
	  const onPressEnter = e => {  
		  if (e.key === "Enter") {  
		  addItem();  
	 } };  
	 
	  const deleteItem = idx => {  
		  const nextItem = names.filter(item => {  
			  return item.idx !== idx;  
		 });  
		 console.log(nextItem);  
		  setNames(nextItem);  
	 };  
	 
	  const nameList = names.map(item => (  
			 <li key={item.idx}>  
			 {item.name}  
			 <button onClick={() => deleteItem(item.idx)}>X</button>  
			 </li>  
	 ));  
	 
	  return (  
		 <Fragment>  
			 <input  
			  type="text"  
			  onChange={onChange)}  
			  onKeyPress={onPressEnter}  
			 /> 
			 <button type="button" onClick={addItem}>  
			  추가  
			  </button>  
			 <ul>{nameList}</ul>  
		 </Fragment>  
	 );
	};  
  
export default App;
```

리액트에서 이벤트를 등록할 때는 반드시 **함수 객체**를 넣어야함.

```js
onClick={alert("안녕하세요");} // 불가!
onClick={ ()=>alert("안녕하세요"); } // 가능
```

그래서 `deleteItem(item.idx)`를 이벤트에 등록시킬 때도 화살표함수를 이용해서 `deleteItem`이라는 함수 객체로 넣어준거임! 이렇게 안하면 함수가 즉시 실행 된다.
만약 이벤트 객체를 인자값으로 받아서 이벤트 등록을 시켜야한다면?

```js
const onChange = e => {
	console.log(e.target);
}

onChange={(e)=> onChange(e)} // 이렇게 받아서 처리하면 댐ㅇㅇ
```
