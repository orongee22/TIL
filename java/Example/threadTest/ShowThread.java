// Thread 객체 직접 생성 방법
public class ShowThread implements Runnable {
	String name;
	
	ShowThread(String name){
		this.name = name;
	}
	public void run(){
		for(int i=0;i<5;i++) {
			System.out.println("안녕하세요. "+name+"입니다.");
			
			try {Thread.sleep(100);}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

// Thread 상속을 이용한 방법
class ShowThread1 extends Thread{
	String name;
	
	ShowThread1(String name){
		this.name = name;
	}
	
	public void run() {
		for(int i=0;i<5;i++) {
			System.out.println("안녕하세요. "+name+"입니다.");
			
			try {sleep(100);}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}