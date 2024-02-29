package com.ruby.java.ch10;
//10.2.3  Linked List - 실습대상 
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Test05 {

	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<>();//생성자
		//리스트가 더 상위, 리스트로해도 상관x

		list.add("서울");
		list.add("북경");
		list.add("상해");
		//요 순서로 끝에

		for (String element : list) {//반복for문;커서의 개념 있음 그걸 가지고 이해
			System.out.print(element + "\t");
		}

		System.out.println();
		//서울이 0번이고 LA가 끼어들어갔어(?)
		list.add(1, "LA");
		//list. 찍고 봐봐
		print(1, list);
		list.addFirst("런던");
		print(2, list);
		list.addLast("서울");
		print(3, list);

		list.offer("파리");
		print(4, list);//offer와 add 뭐 거의 같대
		list.offerFirst("로마");
		print(5, list);
		list.offerLast("베른");
		print(6, list);

		System.out.println("7 : " + list.peek());//peek : 맨앞 / 피크 오퍼 이런거 외우진x
		System.out.println("8 : " + list.peekFirst());
		System.out.println("9 : " + list.peekLast());
		//list. 찾아서 쓸수는 있어야함
		list.poll();
		print(10, list);
		list.pollFirst();
		print(11, list);
		list.pollLast();
		print(12, list);
		System.out.println(list.toString());
		list.push("제주");
		print(13, list);
		System.out.println("14 : " + list.pop());

		System.out.println("15 : " + list.get(3));
		System.out.println("16 : " + list.getFirst());
		System.out.println("17 : " + list.getLast());

		System.out.println("18 : " + list.indexOf("서울"));
		System.out.println("19 : " + list.lastIndexOf("서울"));

		list.removeFirst();
		print(20, list);
		list.removeLast();
		print(21, list);
		list.remove(3);
		print(22, list);
		list.remove("LA");
		print(23, list);

		List<String> list2 = Arrays.asList("북경", "상해");//asList : 어레이;배열을 리스트로 만들어주는거
		list.addAll(list2);
		//list.sort();/Linked List의 sort는 지원되지 않음
		Object obj[] = list.toArray();
		System.out.println("24 : " + Arrays.toString(obj));

		String cities[] = new String[0];
		cities = list.toArray(cities);
		System.out.println("25 : " + Arrays.toString(cities));
		
		list.removeAll(list2);
		print(26, list);
		
		LinkedList<String> list3 = new LinkedList<String>(list2);//생성자인데 
		print(27, list3);
		
	}

	static void print(int n, List<String> list) {
		System.out.println(n + " : " + list);//list.toString() 호출
		//어레이리스트에 재정의된 투스트링으로 [ , , , ]이런식으로
	}
}