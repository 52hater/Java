package DataStructure.Ch03;
//리스트를 배열로, 배열을 리스트로 변환하는 훈련

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

	public static String[] removeElement1(String[] arr, String item) {//여기선 중복체크만? 하고?(???)
		//현재 배열에서 중복 제거할려면 코드가 길어짐
		//배열을 리스트로 다시 변환, 변환한 list.remove();를 사용하면
		//리스트는 삭제하면 땡겨줌
		//삭제된 리스트를 배열로 변환해서 리턴
		List<String> list = new Arraylist<>();
		list.remove(item);
		return list.toArray(String[]::new); //스트링 뉴 하면 스트링에 대한 뉴를 한다,
		//뉴는 메소드잖아 스트링에 대한 뉴 : 공간할당한다
		//결과적으로 스트링배열을 만든다는말이지
		//String[]::new >> 메소드 레퍼런스 (메소드 참조) > 스트링배열을 생성하는 메소드
		//람다식에보면 함수형 인터페이스가 있는데 String[]::new 가 그거임 /어려움/찾아서 공부
		//(a, b) -> a - b / 이런형태가 아니라 함수형 인터페이스

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
	
	static void swap(List<String> list, int ind1, int ind2) {
	      String swapArr = arr[ind1]; arr[ind1] = arr[ind2]; arr[ind2] = swapArr;
	   }
	
	static void sortList(List<String> list) {//가나다순으로 정렬하고싶어
		//방법1:list.sort(null);
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(i).compareTo(list.get(j)) > 0) {
					swap (list, i , j);
				}
			}
		}
	}
	//방법2 리스트를 스트링배열로 전환 > 2장에서 한 배열정렬하는걸로 돌려 String cities[]=list.toArray() 밑에있네	

	static String[] removeDuplicateList(List<String> list) {//여기서 중복제거
		//같은서울 제거하라 i, j써서 for문써서 i=0일때 j따라락, i=1일때 j따라락 그렇게
		//리스트에서 중복찾을수도있지만 리스트를 배열로 변환해서 찾는것도 연습해야지(훈련목표 : 리스트<->배열 변환 숙달)
		String cities[] = new String[list.size()];//리스트를 배열로 만들려고 배열선언 및 초기화(크기결정?)
		cities = list.toArray(cities);//여기서 리스트를 배열 cities[]로 변환(근데 왜 [] 안쓰지), 그 다음에 배열에서 중복을 찾는 것 
		//for 문으로 도시가 중복인 것을 체크 = 스트링이니까 comparaTo를 써서 중복있으면
		//toArray > 1.list 를 배열로 바꾸고 2.배열 사이즈를 체크해서 사이즈가 부족하면 공간할당까지 함
		//따라서 String cities[] = new String[list.size()]; 말고 new String[0]으로 해도 됨!
		int count = cities.length;//도시몇개냐고
		for (int i = 0; i < count; i++ ) {
			int j = i + 1;
			while (j <= count) {//참이면 루프 거짓이면 빠져나와//컴페어투 써야된다시는데
				if (cities[i].equals(cities[j])) {//같은게 있으면
					cities = removeElement1(cities, cities[j]);//리무브엘리먼트1 메소드로 삭제
					count --;
				}
				//j 수정하고 나머지 작업
			}
		}
		//removeElement1(cities, city); //메소드 호출해서 지워//arr를 asList로 배열로 주고/어레이리스트는 삭제하면 땡겨줌
		//list.remove(item)


		return cities;
	}
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();//일반적으로 두번째 <>는 안씀 -> 여기서는 String 생략된 것
		//좌변에 List<String> 참조변수list가 있다 > list가 객체ArrayList보다 상위 > 상관없는거?
		getList(list);//여기서 리스트를 또로로록 받고
		showList("입력후", list);
		//sort - 오름차순으로 정렬, 내림차순으로 정렬, 중복 제거하는 코딩

		//		    Collections.sort(list);//컬렉션에 솔트메소드를 사용해서

		//배열의 정렬
		sortList(list);
		System.out.println();
		showList("정렬 후", list);
		System.out.println();
		// 배열에서 중복제거
		System.out.println("중복 제거 :: ");

		String[] cities = removeDuplicateList(list);//중복 제거
		ArrayList<String> lst = new ArrayList<>(Arrays.asList(cities));//asList : 배열을 다시 리스트로 만들어줌 > 그런거 공부하는거지
		showList("중복 제거 후", lst);

		//자바 실무에서는 컬렉션 ArrayList 등등 컬렉션을 주로 사용함. 숙달훈련
	}
}

/*제너릭은 리액트 스프링할때도 필수. */
*/