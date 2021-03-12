package collectiontest;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeSet<Person> tSet = new TreeSet<Person>();
		
		tSet.add(new Person("이름",30));
		tSet.add(new Person("이름1",20));
		tSet.add(new Person("이름2",10));
		
		Iterator<Person> itr = tSet.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}

	}
	
	
}


class Person implements Comparable<Person>{

	String name;
	int age;
	
	Person(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	@Override
	public int compareTo(Person p) {
		// 비교하는 데이터가 현재 데이터보다 작으면 양수를 반환
		// 크면 음수 반환
		// 같다면 0 반환
		// 이걸로 오름차순할 건지 내림차순 할 건지 결정.
		int result = 0;
		
		if(this.age>p.age) {
			result = -1;
		} else if(this.age<p.age) {
			result = 1;
		}
		
		// return this.age-p.age;
		// 같음!
		// age의 순서가 바뀐다면 반대로 출력ㄱㄱ
		
		return result;
	}
	
	void showData() {
//		System.out.println("이름은 "+name+", 나이는 "+age);
	}

		
	// object의 toString? 
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Person [name=" +name+", age="+age+"]";
	}
	
	
	
	
}

