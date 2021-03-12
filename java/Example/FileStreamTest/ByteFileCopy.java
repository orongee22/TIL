import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


// 단순 카피하는 클래스 기능을 만들어보자자자자ㅏ자자아ㅏㅠㅏㅠㅓㅠㅠㅜㅠ
public class ByteFileCopy {
	public static void main(String[] args) throws IOException {
		// 파일의 대상은 직접적으로 명시 가능. 원래는 경로랑 포함해서 적어줘야함
		InputStream in = new FileInputStream("penguins.jpg");
		// 받은 파일은 내가 새로 생성해서 내보낼 수 있음.
		// 파일을 복사해서 내보내기 ㅇㅅㅇ
		OutputStream out = new FileOutputStream("copy.jpg");
		
		int copyByte = 0; // 전송된 사이즈를 카운트 몇바이트 전송됐는지 확인쓰
		int bData = 0; // 스트림을 통해서 전송 받은 데이터, 바이트임. 바이트로 오고가지만 연산은 int로 되기 때문에 int형으로 타입을 결정쓰
		int readLen = 0;
		// int로 하나하나 ㄴㄴ 배열로 바이트를 한꺼번에 가져와 처리가 가능하다.
		// 1kb가 1024바이트 rgrg?
		byte[] buf = new byte[1024];
		
		while(true) {
			// 파일 데이터 읽는 거
			// bData = in.read(); // 데이터 가져옴~! 바이트 사이즈의 데이터, 모두 전송된 후에는 -1이 됨. 더이상 받을 파일이 없다는 뜻임. 파일은 0과 1로 돼있는 거rgrg?
			
			// 바이트가 몇개 담기는지 읽어서 저장하는 기능을함.
			readLen = in.read(buf);
//			if(bData <0) {
//				break;
//				// -1되면 바로 while문 빠져나와서 끝냄.
//			}
			
			if(readLen==-1) {
				break;
			}
			
			// 파일 데이터 쓰는거
//			out.write(bData);
			
			
			
			out.write(buf,0,readLen);
//			copyByte++;
			
			copyByte = copyByte+readLen;
		}
		
		
		// 파일 입출력 처리가 완료되면
		// 스트림을 닫아줘야함
		in.close();
		out.close();
		
		
		System.out.println("복사가 완료되었습니다.");
		System.out.println("복사된 바이트의 크기는 : "+copyByte);
		
		
	}
}
