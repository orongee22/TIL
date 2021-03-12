package httptest;
import java.net.*;
import java.io.*;
import java.util.Scanner;


// 소켓을 이용하여 채팅 실행
public class TcpIpServer5 {

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		serverSocket = new ServerSocket(7777);
		System.out.println("서버가 준비되었습니다.");
		
		// 연결 대기!
		socket = serverSocket.accept();
		
		Sender sender = new Sender(socket);
		Receiver receiver = new Receiver(socket);
		
		sender.start();
		receiver.start();
	}

}

class Sender extends Thread{
	Socket socket;
	DataOutputStream out;
	String name;
	
	
	public Sender(Socket socket) throws IOException {
		this.socket = socket;
		this.out = new DataOutputStream(socket.getOutputStream());
		this.name = "[" + socket.getInetAddress()+":"+socket.getPort()+"] ";
	}
	
	public void run() {
		
		Scanner sc = new Scanner(System.in);
		
		while(out!=null) {
			try {
				out.writeUTF(name+sc.nextLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}



class Receiver extends Thread{
	Socket socket;
	DataInputStream in;
	
	public Receiver(Socket socket) throws IOException{
		this.socket = socket;
		in = new DataInputStream(socket.getInputStream());
	}
	
	public void run() {
		while(in!=null) {
			try {
				System.out.println(in.readUTF());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
