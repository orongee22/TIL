package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class ReaderWriterTest {

	public static void main(String[] args) throws IOException {
		
		char c1 = 'A';
		char c2 = 'B';
		String str = "우왕쓰키ㅣ이키킼ㅋ";

		// test.txt가 없다면 새로 생성해서 이 파일 가지고 처리할고임
		Writer writer = new FileWriter("test.txt");
		
		writer.write(c1);
		writer.write(c2);
		writer.write(str);
		
		writer.close();
		
		System.out.println("파일이 생성되었습니다.");
		
		
		
		// test.txt 안에 있는 문자를 cBuf 배열에 하나하나 담아볼고임
		// 일단 reader 객체 생성
		Reader reader = new FileReader("test.txt");
		
		// 배열 사이즈 10인 cBuf 생성
		char[] cBuf = new char[10];
		// 몇번 읽을건지 확인확인
		int readCnt = 0;
		
		// for 반복문처럼 어디에, 몇번지부터, 어디까지 읽을건지 선택쓰
		readCnt = reader.read(cBuf, 0, cBuf.length);
		for(int i=0;i<readCnt;i++) {
			System.out.println(cBuf[i]);
		}
		
		reader.close();
		
		
		
		BufferedWriter out=new BufferedWriter(new FileWriter("String.txt"));
		out.write("손흥민 – 리버플전에 골을 넣는데 집중하겠다.");
		out.newLine();
		out.write("올 시즌은 나에게 있어 최고의 시즌이다.");
		out.newLine();
		out.write("팀이 승리하는 것을 돕기 위해 최선을 다하겠다.");
		out.newLine();
		out.write("환상적인 결승전이 될 것이다.");
		out.newLine();
		out.newLine();
		out.write("기사 제보 및 보도자료");
		out.newLine();
		out.write("press@goodnews.co.kr");
		out.close();
		System.out.println("기사 입력 완료.");
			
		System.out.println("기사 읽기 시작쓰");
			
		BufferedReader reader2 = new BufferedReader(new FileReader("String.txt"));
		
		String str1 = null;
		
		while(true) {
			str1 = reader2.readLine();
			if(str1 == null){
				break;
			}
			System.out.println(str1);
		}
		
		reader2.close();
		
	}
	
	

}
