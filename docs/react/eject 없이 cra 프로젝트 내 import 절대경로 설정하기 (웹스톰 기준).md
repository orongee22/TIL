# eject 없이 cra 프로젝트 내 import 절대경로 설정하기 (웹스톰 기준)

기존엔 `.env` 파일을 생성해 `NODE_PATH`를 설정하는 방식을 자주 사용했던 것 같은데, 프로젝트를 실행하고 나니

```
Setting NODE_PATH to resolve modules absolutely has been deprecated in favor of setting baseUrl in jsconfig.json (or tsconfig.json if you are using TypeScript) and will be removed in a future major release of crea
te-react-app.
```

라는 안내문이 뜨더라. 찾아보니 이 방식은 곧 없어질 방식이니 `jsconfig.json`을추천한다는 것 같다. 찾아보니 설정 방법은 간단했다


## jsconfig.json 사용하기

- 프로젝트 최상단 폴더에 `jsconfig.json` 파일 추가
  만일 타입스크립트를 사용하고 있다면 `tsconfig.json` 로 생성할 것!

```json
{  
  "compilerOptions": {  
  "baseUrl": "src"  
  },  
  "include": ["src"]  
}
```

- `src` 폴더 오른쪽 클릭 후, **Mark Directory as -> Resource Root** 설정


이렇게 하면 매우 간단하게 설정을 끝낼 수 있다!
