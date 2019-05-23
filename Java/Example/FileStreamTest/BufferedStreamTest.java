package test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


// 보조 스트림 사용하기
// 스트림은 여러개 사용해도 ㄱㅊㄱㅊ
public class BufferedStreamTest {

	public static void main(String[] args) throws IOException {
		InputStream in = new FileInputStream("penguins.jpg");
		BufferedInputStream bIn = new BufferedInputStream(in);
		
		// 기본 스트림 생성
		OutputStream out = new FileOutputStream("copy1.jpg");
		// 필터 스트림 생성
		BufferedOutputStream bOut = new BufferedOutputStream(out);
		
		int copyByte = 0;
		int bData = 0;
		
		while(true) {
			bData = bIn.read();
			if(bData == -1) {
				break;
			}
			bOut.write(bData);
			copyByte++;
			
		}
		bIn.close();
		bOut.close();
			
		System.out.println("복사가 완료되었습니다.");
		System.out.println("복사된 사이즈 : "+copyByte);
	}

}
