package httptest;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

// 미리 준비해놓은 소켓과 지정해놓은 포트로 요청 ㄱㄱ
public class TcpIpClient {

	
	// UnknownHostException - 호스트 ㄴㄴ없는거임 하고 알려줌
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// 로컬 호스트 - 현재 나의 주소 아이피를 얘기함 내부 아이피 주소. port는 내가 갈 포트번호
		Socket socket = new Socket("127.0.0.1", 7777);
		
		// 소켓에도 인풋 아웃풋 다있음. 
		// 서버에서 아웃풋스트림으로 보내는 데이터 받을 준비하려면 새로 인풋 스트림 생성해서 받을 준비 ㄱㄱ
		InputStream in = socket.getInputStream();
		DataInputStream din = new DataInputStream(in);
		
		// 인코딩 타입으로 UTF형식 읽겠다는 뜻임
		
		System.out.println("[server]"+din.readUTF());
		
		din.close();
		socket.close();
		
		
	}

}
