# Debouncing

- 연이어 호출되는 함수들 중 마지막 함수(또는 제일 처음)만 호출하도록 하는 것


검색 자동완성 기능처럼 input에 onChange 이벤트를 발생시킬 경우, 값이 하나하나 달라질 때마다 api를 호출하기 때문에 엄청난 성능 문제를 야기할 수 있다.

이럴 때 이 디바운싱 이라는 것을 이용해서 해결할 수 있음.


### 리액트 적용
```js
// 검색 컴포넌트 debouncing timer
const [timer, setTimer] = useState(0); // 디바운싱 타이머
const [value, setValue] = useState('');

const handleChange = (value) => {
    
    setValue(value);
    
    if(timer){
        clearTimeout(timer); // 이전에 들어온 timer 값 
    }
    
    timer = setTimeout(api호출함수, 1000);
}

return (
    <input type="text" onChange={handleChange} />
)

```

`setTimeout`을 `timer`라는 변수에 담으면 이벤트가 실행될 때마다 1씩 증가함.
timer가 실행되기 전 이전에 timer 값이 있다면 이전 timer를 clear 시키고 실행시키므로 호출은 한번만 되는 것!

