package ver01;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class PhoneBookCollectionMain {
	
	public static void main(String[] args) {
		// 데이터를 저장하고 출력하는 프로그램
		
		
//		testArrayList();
//		iteratorTest();
		
//		hashSetTest();
//		hashSetTest1();
		testHashSet();
	}

	
	
	static void testArrayList() {
ArrayList<PhoneInfo> pList = new ArrayList<PhoneInfo>();
		
		PhoneInfo pi1 = new PhoneInfo("홍길동", "01002150101", "19940429");
		
		PhoneInfo pi2 = new PhoneInfo("우왕", "0101541895");

		pList.add(pi1);
		pList.add(pi2);
		// 배열리스트에 객체 저장 가능
		
		pi1.showInfo();
		System.out.println("----------------");
		pi2.showInfo();
		
		
		for(int i=0;i<pList.size();i++) {
			pList.get(i).showInfo();
			if(pList.get(i).name.equals("홍길동")) {
				System.out.println("찾았다!");
				pList.remove(i);
			}
		}
		
		for(int i=0;i<pList.size();i++) {
			pList.get(i).showInfo();
		}
	}
	
	
	static void iteratorTest() {
		LinkedList<String> list = new LinkedList<String>();
		list.add("first");
		list.add("second");
		list.add("third");
		list.add("fourth");
		
		// 정렬을 위한 인터페이스 - iterator<E>
		// 이걸로 객체 얻으면 순차적으로 접근이 가능해진다
		Iterator<String> itr = list.iterator();
		
		// 
		while(itr.hasNext()) {
//			System.out.println(itr.next());
			System.out.println(itr.next().equals("first"));
//			System.out.println(itr.next());
//			String str = itr.next();
//			System.out.println(str);
//			if(str.compareTo("third")==0) {
//				itr.remove();
//			}
		}
		
		System.out.println("삭제 후 요소 참조");
		
		itr = list.iterator();
		while(itr.hasNext()) {
			String str = itr.next();
			System.out.println(str);
		}
	}

	static void hashSetTest() {
		
		HashSet<String> set = new HashSet<String>();
		
		set.add("first");
		set.add("second");
		set.add("third");
		// 중복 안됨
		set.add("first1");
		
		System.out.println("저장된 요소의 개수 : "+set.size());
		
		Iterator<String> itr = set.iterator();
		
		while(itr.hasNext()) {
			String str = itr.next();
			System.out.println(str);
		}
		
		
		System.out.println("배열 객체로 변환하고 참조하기?");
		
		
		Object[] strArr = set.toArray();
		for(int i=0;i<strArr.length;i++) {
			System.out.println(strArr[i]);
		}
		
		// 컬렉션 객체를 받을 수 있음 set에서 list로 바꾸기!
		ArrayList<String> list = new ArrayList<String>(set);
		
		System.out.println("리스트 요소의 개수 : "+list.size());
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		
	}
	
	static void hashSetTest1() {
		HashSet<SimpleNumber> set = new HashSet<SimpleNumber>();
		
		
		
		set.add(new SimpleNumber(10));
		set.add(new SimpleNumber(20));
		set.add(new SimpleNumber(20));
		System.out.println("저장된 요소의 개수 : "+set.size());
		
		Iterator<SimpleNumber> itr = set.iterator();
		
		
		while(itr.hasNext()) {
			System.out.println(itr.next());			
		}		
	}	
// SimpleNumber에 들어온 20의 중복값을 거르게 하고 싶다묜!?

	static void testHashSet() {
		HashSet<PhoneInfo> pSet = new HashSet<PhoneInfo>();
		
		
		
		PhoneInfo pi1 = new PhoneInfo("홍길동", "01002150101", "19940429");
		
		PhoneInfo pi2 = new PhoneInfo("우왕", "0101541895");
		PhoneInfo pi3 = new PhoneInfo("우우앵ㅇ", "01002154101", "19940429");
		PhoneInfo pi4 = new PhoneInfo("홍길동", "01002150101", "19940429");
		
		
		pSet.add(pi1);
		pSet.add(pi2);
		pSet.add(pi3);
		pSet.add(pi4);
		
		System.out.println("저장된 개수 : "+pSet.size());
		System.out.println("----------------------------");
		
		Iterator<PhoneInfo> itr = pSet.iterator();
		
		while(itr.hasNext()) {
			itr.next().showInfo();
			System.out.println("-------------------------");
		}
		
		
		
	}

	

	@Override
	public int hashCode() {
		//phoneNumber : String - > int로 바꿔줘야함
		// 01000001112 : 문자열 마지막 문자 추출해서 비교검색할 것임ㅁㅁ
		// charAt(index)메소드는 문자 하나 따로 떼는 거. 
		// index = length-1과 같아서 이렇게 넣은거임.
		return phoneNumber.charAt(phoneNumber.length()-1); 
	}



	@Override
	public boolean equals(Object obj) {
		
		// 다르다의 조건이 훨씬 넓을 것 같음
		// 그래서 일단 초기화를 false로... 기본값이 나음
		boolean result = false;
		
		
		// obj에는 null값이 들어오면 안됨! 
		// 들어오는 객체가 PhoneInfo객체 라서 형변환 가능한 지 물어보는것임쓰
		if(obj != null && obj instanceof PhoneInfo) {
			
			PhoneInfo pi = (PhoneInfo)obj;
			result = this.phoneNumber.equals(pi.phoneNumber);
			
		}
		return result;
	}

}


class SimpleNumber{
	int num;

	public SimpleNumber(int num) {
		this.num = num;
	}
	
	public String toString() {
		return String.valueOf(num);
//		return 
	}
	
	
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return num%3;
	}

	
	
	
	
	
	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		
		if(obj !=null && obj instanceof SimpleNumber) {
			SimpleNumber number = (SimpleNumber)obj;
			result = this.num == number.num;
		}
		
		
		return result;
	}
}




























