package prioritytest;

public class PriorityExMain {

	public static void main(String[] args) {
		
		
		for(int i=0;i<=10;i++) {
			Thread th = new CalcThread("Thread"+i);
			
			if(i != 10) {
				th.setPriority(Thread.MIN_PRIORITY);
			} else if(i==10){
				th.setPriority(Thread.MAX_PRIORITY);
			} else {
				
			}
			
			th.start();
			
			
	}
	}

}
