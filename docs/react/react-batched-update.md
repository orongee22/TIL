# React batched update

리액트는 기본적으로 batched update (일괄 업데이트) 방식을 따르고 있다. 
`setState` 메소드는 비동기로 작동하여 state를 변경시킨다. 그러므로 연속적으로 호출할 경우 두번 연속 state가 바뀌길 기대하겠지만 No!

```js
const [count, setCount] = useState(0);

function onClick() {
    setState(count +1);
    setState(count + 1);
}

return (
    <div>
        <h2>{count}</h2>
        <button onClick={onClick}>증가</button>
    </div>
)

```

위와 같이 `setState(count + 1)`을 두번이나 호출하였으니 당연히 count는 2가 나오길 기대할 것이다.
그러나 결과값은 1이 나온다.

이를 해결하기 위해 `setState`에 함수를 넣을 수 있다.

```js
const [count, setCount] = useState(0);

function onClick() {
    setState(v=> v + 1);
    setState(v=> v + 1);
}

return (
    <div>
        <h2>{count}</h2>
        <button onClick={onClick}>증가</button>
    </div>
)
```

이렇게 넣으면 v라는 인자에는 `prevState`가 매개변수로 들어와 처리되므로 원하는 값을 받을 수 있다.

그런데 지금처럼 현재 `onClick`이라는 메소드가 리액트의 `button` 요소 내부의 이벤트 핸들러로 등록되어 있지 않다면 어떨까??
현재 batch 처리는 리액트 내부에서 관리되는 경우에만 해당된다. 그러나 리액트 외부에서 동작하는 이벤트 핸들러라면 당연히 batch 방식으로 동작하지 않는 것이 당연할 것이다. 

그렇게 된다면 `setState`를 호출할 때마다 계속 상태가 변경될 것이고 예기치 않은 렌더링이 이어질 것이다. 

```js
function onClick(){
    setCount(v=> v+1);
    setCount(v=> v+1);
}

useEffect(()=>{
    window.addEventListener('click', onClick);
    return (()=> window.removeEventListener('click', onClick));
});


return (
    <div>
        <h2>{count}</h2>
        <button onClick={onClick}>증가</button>
    </div>
)
```

위와 같이 addEventListener를 통해 등록하여 사용했을 경우, onClick은 리액트 내부에서 관리되지 않는다.

이 때 외부에서 처리될 때도 batch로 처리할 수 있게하고 싶다면 `ReactDOM.unstable_batchedUpdates` 메소드를 사용하면 된다.


```js
function onClick(){
    // 
    ReactDOM.unstable_batchedUpdates(()=>{
        setCount(v=> v+1);
        setCount(v=> v+1);
    });
}

useEffect(()=>{
    window.addEventListener('click', onClick);
    return (()=> window.removeEventListener('click', onClick));
});
```

연결되는 이벤트 메소드 안에 unstable_batchedUpdates 함수를 넣어주기만 하면 된다.
참고로 concurrent mode로 동작할 미래의 리액트에서는 이러한 점을 개선하여 외부에서도 batch로 처리하도록 만들 예정이라고 한다.

