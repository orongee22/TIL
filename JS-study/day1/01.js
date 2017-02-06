## STUDY 01차

/* 1.

 ***************** 성능 이슈 관련 *****************

*/

'use strict';

// TO DO LIST
// 성능 이슈와 관련된 문제점을 찾아보자

// 1-1. 리팩토링 된 함수와의 차이점을 설명해보세용
function addList(actionType, todoORnumber) {
    if(duplicateCheck(actionType, todoORnumber)){
        var parentBasketNode = document.querySelector(".basket > ol");
        var newNode = document.createElement("li");
        parentBasketNode.appendChild(newNode).textContent = todoORnumber;
        newNode.insertAdjacentHTML("beforeend","<button>X</button>");
        removeBtn();
        sortString();
    }
}

function addList(actionType, todoORnumber) {
    if( !duplicateCheck(actionType, todoORnumber )){  return; }
    // return 을 만나면 함수가 종료되면서 뒤에 코드를 읽지 않습니다!
    // 위의 코드랑 다른점이 뭘까?

    var parentBasketNode = document.querySelector(".basket > ol");
    var newNode = document.createElement("li");
    parentBasketNode.appendChild(newNode).textContent = todoORnumber;
    newNode.insertAdjacentHTML("beforeend","<button>X</button>");
    removeBtn();
    sortString();
    
}
// 둘의 차이점이 뭘까? if 안에 


// 1-2.
var basketOl = document.querySelector(".basket ol");
basketOl.addEventListener("click", function(event){
  var evtTarget = event.target;
  var liTarget = evtTarget.parentNode;

  if(event.target.tagName !== "BUTTON"){ return; }
  else{ liTarget.parentNode.removeChild(liTarget); }
});

//리팩토링 된 함수! 첫번째의 문제점을 찾아보자!
var basketOl = document.querySelector(".basket ol");
basketOl.addEventListener("click", function(event){
  var evtTarget = event.target;

  if( event.target.tagName !== "BUTTON" ){ return; }
  var liTarget = evtTarget.parentNode; 
      liTarget.parentNode.removeChild(liTarget);
});

////////////////////////////////////////////////////////////////////////

// 2-1.
// mainTextarea.parentElement 라고 일일히 작성한다? 성능 이슈의 문제점이 있다 왜일까?
mainTextarea.addEventListener("focusout",function(evt){
	var mainArea = evt.target;
	//evt.target 는 focusout된 타겟 자체  = mainTextarea 와 동일하다 = this와도 같다
	// mainArea 
	
	if(mainArea.tagName !== "TEXTAREA") return false;

	mainTextarea.setAttribute("style","background-color:white");
	//새로 만든 능을 / 삭제
	mainTextarea.parentElement.removeChild(mainTextarea.nextElementSibling);
	mainTextarea.parentElement.removeChild(mainTextarea.nextElementSibling);
	// 
	//입력한 글자값 삭제
	mainTextarea.value = "";
	//기존에 있던 버튼을 화면에 표시
	var deleteButton = mainTextarea.nextElementSibling.nextElementSibling;
	console.log(deleteButton);
	//deleteButton.previousElementSibling.setAttribute("style","display:block");
	deleteButton.previousElementSibling.style.display = "block";
	deleteButton.style.display = "";
	deleteButton.nextElementSibling.style.display = "";
});


// 2-2.
// 변수 저장 & style 지정
black_button.addEventListener("click",function(){
  document.querySelector("body").style.backgroundColor = "black";
});
white_button.addEventListener("click",function(){
  document.querySelector("body").style.backgroundColor = "#e9ebee";
});
// 

// DOM탐색
// if - else 탐색?
// setAttribute 는 인라인으로 들어가지 않는다
// 함수는 분리 & 모듈화 하면 좋다




////////////////////////////////////////////////////////////////////////

// 3.
 *** [To Do List] 해야할 것
 // 코드를 짜기 위해 체크리스트를 만들어 본다.
 // TASK라고 한다 ^ㅁ^
 * (진행중)event관련 코드 학습 및 설명자료 작성
 * (완료)JS 코드의 기능을 확인 한다.
 * (완료)html 코드를 확인한다.
 * (완료)css 코드를 확인한다.
 * (완료)버튼 클릭시 html코드에 append 하도록 한다.
 * (완료)버튼 클릭시 html코드에 remove 하도록 한다.
 * (완료)엘리먼트 create 펑션 만들기
 * (완료)엘리먼트 셀렉트 펑션 만들기
 * (완료)"input"값을 조작하는 방법 조회
 * (완료)버튼을 누른다.
 * (완료)새로운 Element 생성
 * (완료)newElement.innerText = input.value
 * (완료)node.appendChild(newElement)
 * (완료)append 펑션을 넣어서 값을 넣기
 * 
 * 다시 문제를 디자인 한다.
 * add는 문자로 받는다. 
 * remove는 숫자로 받는다.
 * 문자열 길이 내림차순 정열(실시간)
 * (예외처리) 삭제시 해당 번호가 없으면 "'message' 영역에서 적당한 메시지를 붉은색으로 표시됐다 3초뒤 사라집니다."
    -- setTimeout을 이용하여서 3초 동안 표시하도록 한다.
 * (예외처리) 추가시 해당 메세지가 있다면 "message영역에서 적당한 메시지를 붉은색으로 표시했다 3초뒤 사라집니다."
    -- setTimeout을 이용하여서 3초 동안 표시하도록 한다.
 * setTimeout 적용
 * string 조작
 * regularexpression 확인
 */


/* 

 ***************** 콜백 함수의 실행 순서 *****************

 */
// 4-1.
function a() {
		window.addEventListener('load', function(event) {
			console.log('콜백함수 결과: ', event.target);
		});
	}

	function b() {
		return console.log('b함수이다');
	}

	for ( var i = 0; i<10; i++ ) {
		console.log(i);
	}

	a();
	b();

// 실행결과?

// 0
// 1
// 2
// 3
// 4
// 5
// 6
// 7
// 8
// 9
// b함수이다
// undefined






// oop 객체지향이란?


