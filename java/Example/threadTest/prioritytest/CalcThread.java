package prioritytest;

public class CalcThread extends Thread {
	public CalcThread(String name) {
		setName(name);
	}
	
	
	public void run() {
		// 20000000 를 출력하는 스레드의 이름을 가져옴
		for(int i=0;i<2000000;i++) {
		}
		System.out.println(getName());
	}
}
