package exam;

public class Triangle {
	int triB;
	int triH;
	
	void setBottomHeight(int b, int h) {
		triB = b;
		triH = h;
	}
	
	int triArea() {
		int result = triB*triH / 2;
		return result;
		
	}
	
	public static void main(String[] args) {
		Triangle triangle = new Triangle();
		
		triangle.setBottomHeight(2,4);
		
		System.out.println("넓이는 "+triangle.triArea());
	}
}
