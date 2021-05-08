# 윈도우 창 사이즈를 구하는 custom hook

현재 브라우저 가로, 세로 사이즈를 구할 수 있는 속성인 `innerWidth`와 `innerHeight`를 사용한다.

- outerWidth, outerHeight
	브라우저 tab 전체 사이즈
	
- inenrWidth, innerHeight
	탭 상단바 제외 내부 사이즈만 (익스플로러는 스크롤 바 제외한 width만)

### UseWindowSize

```js
const UseWindowSize = () => {
	const [size, setSize] = useState([0, 0]);

	useLayoutEffect(()=> { 
		function updateSize() {
			setSize([window.innerWidth, window.innerHeight]);	
		}

	window.addEventListener('resize', updateSize);
	updateSize();

	return () => {
		window.removeEventListener('resize', updateSize)
	}
	return size;		
};
```

`useLayoutEffect` 는 화면이 렌더링되고 난 후 업데이트 되기 직전에 실행. 화면 내 요소를 바꿔야 하거나 일부 DOM을 조작해야 하는 경우엔 `useEffect` 가 아닌 `useLayoutEffect`를 사용하는 것이 좋다.
