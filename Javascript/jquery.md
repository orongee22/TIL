## jQuery

`$` = `jQuery` 제이쿼리 객체를 불러옴.

`$('selector')` 제이쿼리 객체로 감싸서 사용한다. 제이쿼리 객체로 감싸서 만든 변수는 앞에 `$` 표시를 넣어 차이를 두는 것이 관례임~!



### 제이쿼리 메소드

제이쿼리 메소드에 매개변수가 하나만 들어간다? => getter
두 개 이상일 땐 => setter

- css() 
css 요소를 제어할 수 있음.

```js
$('h1').css('color'); 
// getter메소드 : 현재 color값을 반환할거임
$('h1').css('color','blue'); 
// setter메소드 : color값을 blue로 지정
```

- each()
배열이나 객체를 반복하며 index와 item을 반환한다.
```js
// each( 배열or객체원본, index, item)

```
- end()
제이쿼리 메소드를 체이닝하는 역할. end()를 만나면 최초의 선택자로 돌아간다.

#### 속성값 처리하기

- attr() 
객체에 속성 제어.

- prop()
똑같이 속성에 관한 메소드임. 
`attr()`은 css의 속성 / `prop()`은 자바스크립트의 속성을 뜻함.

```js
// input이 현재 checked되어 있을 경우.
// <input type="checkbox">

var chk1 = $('input:checkbox').attr('checked');
var chk2 = $('input:checkbox').prop('checked');
                
console.log(chk1 + ' : '+chk2);
// 결과값은 undefined : true
```
html 태그에 직접적으로 명시가 되어있지 않았으나 상태값이 변화한 경우. `prop()`의 값은 `checked`상태를 읽어올 수 있음. 반면에 `attr()`로는 불가함. 이것이 둘의 차이점!
어떤 요소가 활성화가 되거나 input 요소를 체크 or 선택하는 경우가 생길 때는 `prop()`을 통해 제어하는 편이 좋음! 
일반적인 태그의 속성값을 가져올 경우엔 `attr()`을 쓰자
 
#### 요소 추가하기

- append() / appendTo()
기존에 있는 요소 뒤로 추가하기.

```js
// appendTo() 선택 대상 안으로 삽입. lastChild로 추가됨.
$('추가할 객체').appendTo('대상');

// append() 선택 대상안에 요소를 추가함. 
$('대상').append('추가할 객체');

```
- prepend() / prependTo()
요소를 앞에 추가시키기
```js
// prependTo()

```

#### 텍스트 요소

- text() / html()
`text()` - 요소 안에 있는 텍스트 요소 제어.
`html()` - 요소 안에 있는 또 다른 element 요소 제어 



#### xml
HTML 문서와 비슷한 구조를 가짐. 서로 알아볼 수 있는 단어로 태그를 구성한다는 점이 html과 다른 점! 데이터를 구조화하기 위해 사용하며 이걸로 데이터를 교환할 수 있음.

- parseXML() 
문자열을 XML문서 객체로 변환.





### 제이쿼리 이벤트

- on()
이벤트를 시작하는 메소드.
매개변수로 처리할 이벤트 메소드를 추가하면 됨

```js
$('h1').on('click',function(){});
$('h1').on('mouseover',function(){});
```


- e.stopPropagation()
이벤트의 캡쳐링과 버블링을 막아줌. 현재 이벤트만 처리되게 함.

- e.preventDefault()
기본 이벤트 처리를 막아줌.
a나 input태그 등이 원래 가지고 있는 이벤트 요소를 제거해줌으로써 창이 리셋되지 않음!!!

만약 둘 다 제거하고 싶다면 이벤트 함수 내에서 `return false;` 처리하면 가능가능. 제이쿼리만 가능가능.



**this**
클릭 이벤트가 발생한 객체를 가리킴.




