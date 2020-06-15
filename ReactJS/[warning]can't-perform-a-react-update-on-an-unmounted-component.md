```console
Warning: Can't perform a React state update on an unmounted component. 
This is a no-op, but it indicates a memory leak in your application. 
To fix, cancel all subscriptions and asynchronous tasks in a useEffect cleanup function.
```

컴포넌트가 언마운트된 상태에서 state를 업데이트할 수 없다는 에러 내용임.

`일반적인 목록 페이지 → 상세정보에서 입력값 수정 or 삭제 or 생성 → 다시 목록 페이지로 이동`

이런 순서로 페이지 흐름이 이어지는데 다시 목록 페이지로 돌아왔을 때마다 에러가 발생했다.

```jsx
  const createInfoData = useCallback(()=>{
    const sendData = async () =>{
      setLoaded(false);

      try{
        const sendObject = {
          Name: dataList[PARTNER_INFO_DEFINE.NAME],
          Domain: dataList[PARTNER_INFO_DEFINE.DOMAIN],
          Phone: dataList[PARTNER_INFO_DEFINE.PHONE],
          Address: dataList[PARTNER_INFO_DEFINE.ADDRESS],
          Manager: dataList[PARTNER_INFO_DEFINE.MANAGER],
          Description: dataList[PARTNER_INFO_DEFINE.DESCRIPTION],
        };

        const sendStr = JSON.stringify(sendObject);

        const res = await axios.post(PARTNER_URL, sendStr, {
          headers: {
            'Content-Type': 'application/json'
          }
        });

        processResponse(PARTNER_URL, res);
      }
      catch(e){
        // 에러 데이터 셋팅
        const errorData = {
          URL: PARTNER_URL,
          MSG: e.toString(),
        };
        errorCallback(errorData);
      }
      finally{
        setLoaded(true);
      }
    };

    const valid = validateData();
    if(valid === true){
      sendData();
    }

  },[dataList, processResponse, validateData]);

```

이유를 알고보니 여기서 문제가 발생했음.....

일단 데이터가 성공적으로 응답을 받으면 `processResponse()`가 실행되는데

```jsx
const processResponse = useCallback((url, response)=>{

    // http response code
    const httpResponseCode = response.status;

    // back end response code
    const resultCode = response.data.iResultCode;

    // 응답코드가 0 작은 경우 에러 팝업 출력
    if(resultCode < 0){
      // 에러 데이터 셋팅
      const errorData = {
        URL: url,
        MSG: response.data.strMSG,
      };
      errorCallback(errorData);
    }
    else if(httpResponseCode !== 200){
      // 에러 데이터 셋팅
      const errorData = {
        URL: url,
        MSG: response.statusText,
      };
      errorCallback(errorData);
    }
    else {
      alert('Data Processing is Completed');
      goToList();
    }
  },[goToList]);

```

이 안에서 리스트 페이지로 돌아가는 `goToList()` 함수를 실행하게 만들었다.

이미 `try` 구문에서 리스트 페이지 이동 함수가 실행되었으니, 현재 컴포넌트는 언마운트가 된다. 그런데 문제는 마지막 `finally` 의 존재였다ㅠㅠㅠ

```jsx
finally{
   setLoaded(true);
}

```

이미 언마운트가 된 상태에서 `finally` 를 통해 `loaded` 를 변경하게 만들어서 생긴 에러였다. 그래서 이 구문을 지워버리므로써 에러가 간단히 해결 ㅎㅎㅎ,,,

서버 요청에서 중복되는 코드가 너무 많이 생기므로 이걸 커스텀 훅을 통해 바꿔보려고 함~!
