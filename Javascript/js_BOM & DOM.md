# javascipt

## Window 객체

최상단에 `window` 라는 전역객체가 있고 그 밑으로 `location`이나 `screen`, `document` 의 객체 등등이 있음. BOM 또한 윈도우 객체 안에 포함되어 있음. window는 전역객체이기 때문에 앞에 `window.`은 생략해서 사용한다.

-----------------------------------------------

### BOM?? 
브라우저 객체 모델.

#### window.location
현재 브라우저 창에 열려있는 URL주소를 나타낸다.

```js

console.log(location.toString(), location.href);
// location.href : location의 URL를 읽거나 URL을 지정할 수도 있다.
// href를 쓰지 않더라도 URL 변경이 가능하다.

```

#### window.onload

window가 로드된 후 실행하는 메소드. 문서가 채 완성되지 않은 상태로 스크립트를 불러오면 `undefined`가 담기게 된다. 그래서 .onload를 통해 그걸 방지하는 거임.

---------------------------------------------------------------------------



### DOM
문서 객체 모델. `window.document` 프로퍼티로 문서 객체에 접근이 가능하다. 웹페이지 내 로드되는 html문서를 동적으로 제어할 수 있음.

웹 브라우저가 웹 문서를 로드할 경우, DOM 트리 구조가 형성된다. 모두 node로 구성되어있음.

#### Node?

DOM타입들이 상속하고 있는 최상단의 인터페이스. 

```
// DOM 트리 구조

Node
ㄴ Document
	ㄴ HTMLDocument
ㄴ Element
	ㄴ HTMLElement
		ㄴ HTMLHeadElement
		ㄴ HTMLBodyElement
		ㄴ HTMLTitleElement
		ㄴ ...etc..
ㄴ Attr
ㄴCharacterData
	ㄴ Text
	ㄴ Comment
```
- document node : dom 트리의 시작점. 다른 노드에 접근하기 위해선 문서 노드를 통해야함.
- element node : HTML 요소를 표현함. 모든 요소 노드는 HTMLElement 라는 객체를 상속한 채로 구성됨.
- Attribute node : HTML 속성을 표현함. 요소 노드를 통해 속성을 참조하거나 수정할 수 있음.
- text node : HTML 텍스트 표현. 요소 노드의 자식이며, dom tree 가장 최하단에 위치함.

DOM을 통해 문서 조작을 하기 위해선 먼저 요소에 접근 -> 제어가 필요함.


#### 1. DOM에 접근하기

- **document.getElementsByTagName('태그명')**
태그명에 해당하는 모든 요소들을 찾아 HTMLCollection이라는 유사배열로 담아 반환함.

- **document.getElementsByClassName('클래스명')**
클래스명에 해당하는 모든 요소들을 찾아 반환. ie9 이상에서만 동작.

- **document.getElementById('아이디명')**
해당하는 아이디명을 가진 요소 하나를 찾아 반환한다. 어차피 아이디는 중복불가임.

- **document.querySelector('선택자')**
css 선택자 그대로 인자값에 던지면 해당하는 요소 중 첫번째 요소를 찾아 모두 반환함. nodeList로 반환쓰. 첫번째 요소가 아닌 모든 요소를 반환하고 싶다면 `querySelectorAll()` 을 이용하면 됨. ie8 이상에서만 동작. All은 ie9

nodeList를 반환하는 요소는 모두 `HTMLCollection` 객체를 상속한다. 단일 요소는 `HTMLElement`를 상속

참고로 `HTMLCollection`은 실시간으로 노드의 상태를 확인한 후 반영함. 제어할 때 주의가 필요함! 반면에 nodeList는 비실시간임. 둘의 차이점을 알아두자.

- **parentNode**
부모 노드 찾기

- **firstChild / lastChild**
자식 노드 찾기.

참고로 브라우저들은 요소 사이사이 공백을 텍스트 노드로 취급한다. 그렇기 때문에 공백을 제거하거나 그 다음요소를 선택해서 사용해야함!


```html
<ul id="parent">
    <li id="one" class="red">Seoul</li>
    <li id="two" class="red">London</li>
    <li id="three" class="red">Newyork</li>
    <li id="four">Tokyo</li>
</ul>
```
```js
const first = document.querySelector('ul');
first.firstChild.className = 'blue';
first.lastChild.className = 'blue';

// blue로 안나옴!
// 그래서 

first.firstElementChild.className = 'blue';
first.lastElementChild.className = 'blue';
// 를 사용해서 해결할 수 있음. ie9 이상에서만 사용가능.
```

- **hasChildNodes()**
자식 노드가 있는 지 확인 후, `boolean`값 반환.

- **childNodes**
자식 노드리스트를 반환함. 텍스트 요소 포함한 모든 자식 요소!

- **children**
자식 노드를 컬렉션으로 반환함. element 요소만 나옴.

- previousSibling, nextSibling
텍스트 노드 포함한 이전, 다음 요소 선택

- previousElementSibling, nextElementSibling
엘리먼트 요소만 포함하는 이전, 다음 요소 선택함.


#### 2. DOM 제어하기

문서 객체를 생성하는 법
- 정적으로 문서 객체를 생성함 :  기존 HTML문서에 접근해서 태그를 읽으면서 생성하기.
- 동적으로 문서 객체 생성 :  스크립트를 이용해 새로운 요소를 생성함.





