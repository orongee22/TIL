package httptest;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
// Date 형식을 간단하게 처리해주는 객체
import java.text.SimpleDateFormat;
// Date관련은 util에서 가져옴쓰
import java.util.Date;

public class TcpIpServer {
	// 예외처리 해조야함? 
	public static void main(String[] args) throws IOException {
		
		// 서버소켓 생성
		ServerSocket serverSocket = null;
		
		// 서버소켓은 포트번호를 가지고 있음. 
		// 가장 먼저 생성되어서 클라이언트의 요청을 기다릴 준비를 해야함.
		serverSocket = new ServerSocket();
		
		System.out.println(getTime()+"서버가 준비되었습니다");

		int count = 0;
		while(true) {
			System.out.println(getTime()+"연결을 기 다 립 니 다 . . . . ."); // 연결이 없다면 여기서 기다리고 있슴
			
			// 서버소켓에 요청이 들어올 때까지 기다림.
			// 서버 소켓의 요청이 들어온다면
			Socket socket = serverSocket.accept();
			
			// 서버 소켓이 새로운 연결소켓을 생성하여 반환할 것임.
			// 소켓의 아이피주소 얻어와서 요청 메시지 띄우기
			System.out.println(getTime()+socket.getInetAddress()+"연결 요청이 들어왔습니다. 연결합니다.");
			
			// 연결이 요청되면 output스트림을 이용해서 밖으로 보낼거임.
			OutputStream out = socket.getOutputStream();
			// 필터 스트림 보내는 객체
			DataOutputStream dos = new DataOutputStream(out);
			
			dos.writeUTF("안녕하세요. 여긴 from server ("+count++ +")");
			System.out.println(getTime()+"메시지 전송");
			
			// 다 되면 닫아주기ㅣㅣ
			dos.close();
			socket.close();
					
		}
	}
	
	// 시간 출력
	public static String getTime() {
		SimpleDateFormat format = new SimpleDateFormat("[hh:mm:ss]");
		
		return format.format(new Date());
	}

}
