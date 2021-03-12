- 변경 불가능한 **원시 타입**
- 함수로 생성하기 때문에 실제론 함수 객체
- 프로퍼티로도 사용 가능
- 생성할 때마다 매번 다른 객체를 반환함

### symbol 생성
```js
let newSymbol = Symbol() // Symbol 함수로 생성
// typeof mySymbol = "symbol"

let symbolDesc = Symbol('description') // 문자열 전달 - description의 용도

const obj = {};

const symbolKey = Symbol('object key');
obj[symbolKey] = "new symbol";
```

### iterable






