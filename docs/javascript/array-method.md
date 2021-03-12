## Array.reduce()

배열 속 특정 항목 수 가져오기, 배열을 다른 자료 구조등으로 변환시키는 등 새로운 데이터로 만들어야 할 때 탁월함.

- 배열 길이 혹은 데이터 형태 변환이 쉬움
- 배열을 리턴하지 않아도 됨

1. *객체에 특정 속성의 값만 모아 배열로 만들고 싶은 경우*

```jsx
const dogs = [
    {
        name: 'max',
        weight : '13kg',
        color : 'black',
        breed : 'boston terrier',
    },
    {
        name: 'doni',
        weight : '28kg',
        color : 'black',
        breed : 'retriever',
    },
    {
        name: 'bori',
        weight : '23kg',
        color : 'brown',
        breed : 'retriever',
    }
];

// color 속성만 저장
const colors = dogs.reduce((colors, dog) =>{
	if (colors.includes(dog['color'])) {
		return colors; // 이미 colors 안에 존재한다면 바로 반환
	}
	
	// 존재하지 않는다면 새로 값 넣고 반환
	return [...colors, dog['color']];
}, []); // 초깃값은 빈 배열

// 결과 : [ 'black', 'brown' ]
```

reduce는 콜백함수의 반환값을 계속 누적해서 최종 결과값을 반환함. 

```jsx
reduce((accumulator, currentValue, currentIndex, array)⇒{}, [initialValue])
```

- accumulator

    callback 함수에서 반환한 값. 반환값을 계속 누적해서 사용함. 초기값을 지정했다면 처음엔 초깃값을 사용한다

- currentValue

    현재 순환 중인 처리 요소

- currentIndex

    현재 순환 중인 요소의 인덱스 값. 초깃값이 지정되어 있다면 0, 아니면 1부터 시작

- array

    원본 배열

- initialValue

    최초 실행 시 제공할 초깃값. 없을 경우 배열 첫번째 요소부터 시작함. 빈 배열을 초깃값 없이 사용하면 에러 발생!! 안전성을 위해 초깃값 넣어주는 것이 좋음

## Array.concat()

배열 요소를 사용해서 새로운 배열 만들거나 배열 요소 추가할 때 사용

- 인수 갯수 제한 X

```jsx
array.concat(arr1, arr2);
```

## Array.some() / Array.every()

### some()

배열 요소 중에 하나라도 특정 조건을 만족하는 지 판별 

만족하면 `true` 아니면 `false` 반환

### every()

배열 요소가 모두 특정 조건을 만족하는 지 판별. 얘도  `true` or `false` 반환.

## Array.filter() / Array.find()

### find()

특정 연산을 거쳐 조건에 부합하는 요소를 반환. 함수가 `true`를 반환하면 그 즉시 break처리 되어 해당 요소를 반환하며 종료됨.

만약 `true`가 없을 경우 `undefined`를 반환하며 종료

### filter()

조건에 부합하는 모든 요소를 배열로 만들어 return 시킴.
