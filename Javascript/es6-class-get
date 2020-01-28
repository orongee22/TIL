## getter - setter

ES6에서 나온 getter와 setter,,,
객체의 프로퍼티를 가져오거나 set할 때, 호출되는 함수를 프로퍼티로 바인딩함! 프로퍼티 값이 계산에 의해서 변동되거나 할 때 이 키워드를 사용하면 효율적임,,,,,,,,

`get` or `set` 키워드를 함수 앞에 붙이면 됨.

example : 
```js
// 클래스형에서 사용도 되고
class Counter{
	number = 0;
	get total(){
		return this.number * this.number;
	}
}


Counter counter = new Counter();

counter.total // 0
```
`total()`함수가 반환하는 값을 `total`이라는 이름의 객체 프로퍼티로 설정하는 것인듯,,

setter는 이런 식으로.,,,:
```
const lang = {
	set current(name){
		this.log.push(name);
	},
	log: []
}

lang.current = 'en';
lang.current = 'ko-KR';
// 이런 식으로...
	
```

- setter는 당연 매개변수 OK. 그러나 getter는 매개변수 X
