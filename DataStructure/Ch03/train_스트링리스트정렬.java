package DataStructure.Ch03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface Comparator<T> {
	int compare(T str1, T str2);
	boolean equals(Object obj);
}

public class train_스트링리스트정렬 {
	
	private static class Comp implements Comparator<String> {

		@Override
		public int compare(String str1, String str2) {
			// TODO Auto-generated method stub
			return str1.compareTo(str2);
		}

		@Override
		public boolean equals(Object obj) {
			// TODO Auto-generated method stub
			return super.equals(obj);
		}
		
	}
	
	public static String[] removeElement1(String[] arr, String item) {

	}

	static void getList(List<String> list) {//void>리턴 x >왜>값을전달해서 바꾸는게 아니라 이건 리스트자체를 바꾸는
		list.add("서울");	list.add("북경");
		list.add("상해");	list.add("서울");
		list.add("도쿄");	list.add("뉴욕");


		list.add("런던");	list.add("로마");
		list.add("방콕");	list.add("북경");
		list.add("도쿄");	list.add("서울");

		list.add(1, "LA");
	}
	static void showList(String topic, List<String> list) {
		//for (int i = 0; .... 이러지말고
		for (String cities : list) { //확장형 for 문을 사용해라
			System.out.println(topic + " ::");
		}
	}
	static void sortList(List<String> list) {//가나다순으로 정렬하고싶어
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(i).compareTo(list.get(j)) > 0) {
					String str = arr[ind1]; arr[ind1] = arr[ind2]; arr[ind2] = str;
				}
			}
		}
		}
		//방법2 리스트를 스트링배열로 전환 > 2장에서 한 배열정렬하는걸로 돌려 String cities[]=list.toArray() 밑에있네	

	static String[] removeDuplicateList(List<String> list) {//같은서울 제거하라 i, j써서 for문써서 i=0일때 j따라락, i=1일때 j따라락 그렇게
		String cities[] = new String[0];
		cities = list.toArray(cities);//리스트를 배열 cities[]로 변환했지
		//for 문으로 도시가 중복인 것을 체크 = 스트링이니까 comparaTo를 써서 중복있으면 
		removeElement1(arr, item); //메소드 호출해서 지워//arr를 asList로 배열로 주고/어레이리스트는 삭제하면 땡겨줌
		//list.remove(item)
		

		return cities;
	}
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();//일반적으로 두번째 <>는 안씀 -> 여기서는 String 생략된 것
		//좌변에 List<String> 참조변수list가 있다 > list가 객체ArrayList보다 상위 > 상관없는거?
		getList(list);
		showList("입력후", list);
		//sort - 오름차순으로 정렬, 내림차순으로 정렬, 중복 제거하는 코딩

		//		    Collections.sort(list);//컬렉션에 솔트메소드를 사용해서

		//배열의 정렬
		sortList(list);
		System.out.println();
		showList("정렬후", list);
		// 배열에서 중복제거
		System.out.println();
		System.out.println("중복제거::");

		String[] cities = removeDuplicateList(list);
		ArrayList<String> lst = new ArrayList<>(Arrays.asList(cities));//asList : 배열을 다시 리스트로 만들어줌 > 그런거 공부하는거지
		showList("중복제거후", lst);

		//자바 실무에서는 컬렉션 ArrayList 등등 컬렉션을 주로 사용함. 숙달훈련
	}
}

/*제너릭은 리액트 스프링할때도 필수. */
 */