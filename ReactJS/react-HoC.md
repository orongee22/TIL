# HoC

Higher-order Component(HoC)
컴포넌트끼리 반복되는 코드를 함수로 매핑하여 중복 최소화하는 것을 의미함.

주로 `with~~` 이름으로 작성한다고 함.
axios로 통신하는 경우, state와 데이터를 받아오는 구조가 동일할 수도 있음. 그럴 경우 같은 컴포넌트 내부의 코드가 상당히 비슷함.
그런 중복을 막아주는 것이 좋단 말씀!

```js
const withExam = (url) => { 	
	(WrappedComponent) => {
		return class extends Component{
			state = {
				data: null;
			}
			// ... 중복되는 함수 처리....
			render(){
				retrun {
					<WrappedComponent {...this.props} />
				)
			}
		}
	}
}

export default withRequest;
```
중복이 되는 기능들을 `withExam`이라는 함수에 넣음. 이 함수는 앞으로 다른 곳에서도 중복하여 사용할 것임! 일단 파라미터로 중복된 기능을 사용하는 컴포넌트를 받을거임!
일단 함수 내에서 새로운 컴포넌트를 선언하고 그 안에서 return값으로 파라미터로 받아온 `wrappedComponent`를 반환하게 함. 만약 `withExam`에서의 props를 처리해야한다묜 return처리하는 `wrappedComponent`에 props를 주입시키먄됨.

만들어둔 HOC를 이용해서 다른 컴포넌트에 사용 가능쓰.

```js
class Post extends Component{
	///.......
}
export  default  withExam('[https://jsonplaceholder.typicode.com/posts/1](https://jsonplaceholder.typicode.com/posts/1)')(Post);
```
컴포넌트를 내보낼때 HOC를 통해 내보냐면됨!
파라미터는 두개를 받는데 아까 url 선언한거,,, 넣어줌,,,
