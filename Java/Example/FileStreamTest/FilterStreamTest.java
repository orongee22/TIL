package test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FilterStreamTest {
	public static void main(String[] args) throws IOException {
		
		
		OutputStream out = new FileOutputStream("data.bin");
		// 기본형 데이터 형식으로 저장 : DataOutputStream 필터 스트림 생성
		// 필터 스트림의 생성자에 기본 스트림 객체 전달ㄹㄹ
		DataOutputStream dOut = new DataOutputStream(out);
		dOut.writeInt(275);
		dOut.writeDouble(45.79);
		dOut.writeBoolean(true);
	
		dOut.close();
		System.out.println("머라??");
		
		// 기본 스트림 생성하고 
		InputStream in = new FileInputStream("data.bin");
		
		// 필터스트림 생성해서 객체 전달해줘야댐
		DataInputStream dIn = new DataInputStream(in);
		int num1 = dIn.readInt();
		double num2 = dIn.readDouble();
		boolean check = dIn.readBoolean();
		
		dIn.close();
		
		System.out.println("첫번째 데이터 : "+num1);
		System.out.println("두번째 데이터 : "+num2);
		System.out.println("세번째 데이터 : "+check);
		
	
	}
}
