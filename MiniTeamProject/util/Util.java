package util;

import java.util.Scanner;

public class Util {
	
	// ver01 or ver02에서도 사용할 수 있게 public으로 제어함.
	public static Scanner sc = new Scanner(System.in);
	
	// choice 메뉴를 변수로 처리해서 사용할 것임
	public static final int INSERT = 1;
	public static final int SEARCH = 2;
	public static final int DELETE = 3;
	public static final int ALLDATA = 4;
	public static final int QUIT = 5;
}
