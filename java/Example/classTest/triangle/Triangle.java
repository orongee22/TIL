package triangle;

public class Triangle {
	float width; // 삼각형의 밑변 데이터, 단위는 cm, 초기화 값은 0
	float height; // 삼각형의 높이 데이터, 단위는 cm, 초기화 값은 0
	
	
	/*
	 * 삼각형의 밑변 데이터와 높이 데이터를 설정한다
	 * @w: 설정할 밑변 데이터
	 * @h: 설정할 높이 데이터
	 */
	void setData(float w, float h) {
		width = w;
		height = h;
	}
	
	
	
	/*
	 * 객체가 가지고 있는 높이 데이터와 밑변 데이터로 넓이를 계산해서 반환한다.
	 * @return : 삼각형의 넓이 계산 후 float형의 데이터를 반환함.
	 */
	float calArea() {
		float result = width*height/2f; // 만약 int형일 경우 소수점 표현이 안되기 때문에 f를 붙인다. 
		return result;
	}
}
