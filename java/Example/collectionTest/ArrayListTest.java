package collectiontest;

import java.util.ArrayList;

public class ArrayListTest {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		
		// 컬렉션(List->ArrayList) 객체에 요소를 저장함. 요소는 주소값으로 저장됨.
		list.add(new Integer(54321));
		
		// 자동 언박싱 기능이 있어서 정수형으로 입력가능
		list.add(new Integer("22"));
		
		// 오토박싱 기능으로 기본형 객체로 감싸줌
		list.add(3858);
		
		
		System.out.println("리스트에 저장된 요소들의 출력");
		// size()는 배열의 사이즈 반환
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		System.out.println("-------------------------------------");
		
		// 배열 삭제
		list.remove(1);
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		
	}
}
