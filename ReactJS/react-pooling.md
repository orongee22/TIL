# 리액트 이벤트 풀링


리액트에서 사용하는 이벤트는 브라우저의 네이티브 이벤트가 아닌, `Synthetic Event` 객체로 감싸져있음.
이벤트 함수가 한 번 실행이 되면 받아온 이벤트는 `null`처리 돼서 객체가 비워짐. 그리고 이벤트가 또 들어오면 같은 이벤트 객체에 값이 할당되고 `null`처리 되고... 이걸 **event pooling** 이라고 함.

```js
const handleChange = useCallback((e) =>{  
  setLockFormData( prevLockFormData =>  ({...prevLockFormData, [e.target.name] : e.target.value}));  
},[]);
```
이벤트 함수 내에서 setter함수를 통해 비동기 작업을 하려고 할 때 이벤트 풀링으로 인해 `e` 객체가 null이 되니까 값을 못 받아옴. 그래서 `Synthetic~~`어쩌고 오류가 떴었음 ㅠㅠ


이걸 방지하려면 `setLockFormData()`를 실행하기 전에 이벤트 객체 값들을 변수로 미리 할당한 뒤에 할당한 변수를 삽입하면 돔

```js
// const value = e.target.value;  
// const name = e.target.name;  

const {value, name} = e.target;

setLockFormData( prevLockFormData =>  ({...prevLockFormData, [name] : value}));
```

혹은 `event.persist()` 하나로도 간단히 방지가 가능함. `event.persist()` 함수는 이벤트 객체를 유지시키는 함수. 기존에 이벤트를 비우는 방식과 다르기에 메모리를 많이 잡아먹기 때문에 성능상 문제가 생기므로 이 방법은 그닥 좋지 못함. 




### 참조

https://hyunseob.github.io/2018/06/24/debounce-react-synthetic-event/

https://reactjs.org/docs/events.html#event-pooling
