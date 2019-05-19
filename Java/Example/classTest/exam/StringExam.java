package exam;

public class StringExam {

	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 1. 문자열 역순으로 출력하기.
		
		String str = "ABCDEFGHIJKLMN";
		
		// 스트링으로만...
		
		
		
		
		// 스트링 버퍼 썼을때
		StringBuffer str1 = new StringBuffer(str);
		
		
//		String str3 = str1.charAt(0).toString();
		
		
		str = str1.reverse().toString();
		System.out.println(str);
		
		
		
		// 2. “990929-1010123” -빼고 숫자만 출력하기
		
		String perA = "990929-1010123";
		
		
		// 앞에 있는 문자열을 다음 문자열로 대체시키는 메소드
		// 스트링으로만
		String result = perA.replace("-","");
		System.out.println(result);
		
		
		// 스트링버퍼 썼을때
		StringBuffer perA1 = new StringBuffer(perA);
		String result2 = perA1.deleteCharAt(6).toString();
		
		System.out.println(result2);
		
		
	}

}
