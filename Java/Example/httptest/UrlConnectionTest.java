package httptest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class UrlConnectionTest {

	public static void main(String[] args) throws IOException {
		// URLConnection = HTTP기반의 통신 처리, 연결해주는 클래스~! 
		// URL 클래스에 openConnection() 메소드로 URLConnection 객체 반환
		
		URL url = null;
		String urlStr = "http://www.ctware.net"; // / 뒤에 (index.html)가 생략되어있음. 디폴트 루트인 index.html로 접근
		
		url = new URL(urlStr);
		
		URLConnection conn = url.openConnection();
		BufferedReader in = null;
		
//		in = new BufferedReader(new InputStreamReader(url.openStream()));
		in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		
		String str = null;
		
		while(true) {
			str = in.readLine();
			
			if(str == null){
				break;
			}
			
			System.out.println(str);
		}
	
	}

}
