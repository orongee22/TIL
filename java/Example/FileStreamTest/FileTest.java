package test;

import java.io.File;


// 디렉토리 새로 생성해서 파일 이동시키기
public class FileTest {

	public static void main(String[] args) {
		
		// 디렉토리에 있는 파일의 경로를 객체에 담는다
		File f = new File("c:\\myjava\\penguins.jpg");
		// 만약 디렉토리 안에 파일이 없다면 메세지 띄우기
		if(!f.exists()) {
			System.out.println("파일 없음!");
			return;
		}
		
		System.out.println(f.getAbsolutePath());
		
		File reDir = new File("c:\\yourjava");
		// 해당 디렉토리에 새로운 폴더 생성하는 메소드
		reDir.mkdir();
		
		// 디렉토리에 새로운 파일 지정
		File newFile = new File(reDir, "myBin.jpg");
		// 파일 바꾸기
		f.renameTo(newFile);
		
		if(newFile.exists()) {
			System.out.println("이동성공!");
		} else {
			System.out.println("이동실패 ㅠ");
		}

	}

}
