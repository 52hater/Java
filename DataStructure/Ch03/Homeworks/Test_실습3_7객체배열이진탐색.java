
//미완성.....

package DataStructure.Ch03.Homeworks;
//작성보다는 코드를 이해하는 능력
//람다식을보고 컴퍼레이터 객체를 이해해야???
//람다식을 보면 컴퍼레이터 객체가 만들어져서 전달이 되는구나 하는 이해가 되어야 한대
import java.util.Arrays;
import java.util.Comparator;
	
//3장 객체 배열 정렬 - binary search
/*
 * Comparator를 사용하는 방법
 * MyComparator implements Comparator<>
 * MyComparator myComparator = new MyComparator();
 * Arrays.sort(array, myComparator);
 * Collections.sort(list, myComparator);
 */

class Fruit4 {
	String name;
	int price;
	String expire;	

	public Fruit4(String name, int price, String expire) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.price = price;
		this.expire = expire;
	}
	public int getPrice() {
		return price;
	}
	public String getName() {
		return name;
	}
}


//교재 123~129 페이지 참조하여 구현
class FruitNameComparator2 implements Comparator<Fruit4>{ //Fruit4 > 비교연산자는 Fruit4 객체에 대해서 비교
	//이게 T면 comparator<T> { int compare<T a1, T a2); 다 T
}

public int compare(Fruit4 f1, Fruit4 f2) {
	//함수의 body 라고 하고 이것이 람다식의 함수본체다
	//람다식의 함수본체가 여기에 껴들어가서 클래스가 만들어짐
	//본체를가지고 여기에 넣어서 익명클래스를 자바가 만들어
	//클래스가 만들어지면 > 객체만듦
	//Comparator<Fruit4> cc_price2 = (a, b) -> a.getPrice() - b.getPrice();
	//치환문이니까 객체를 넣어야지
	//람다식을 쓰면 몇가지 스텝이 자동으로 일어난다
	//그 처리과정이 리액트/스프링할떄 기본이 됨 > 개념정리
}
public class Test_실습3_7객체배열이진탐색 {
	
	private static void showData(String message, Fruit4[] arr) {
		System.out.println(message);
		for (Fruit4 fruit : arr) {
			System.out.println("Fruit : " + fruit.getName() + ", Price : " + fruit.getPrice());
		}
	}
	
	//이거 다시 복습해
	private static void sortData(Fruit4[] arr, Comparator<Fruit4> cc_price) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (cc_price.compare(arr[i], arr[j]) > 0) {
					Fruit4 temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
	
	static void swap(Fruit4[]arr, int ind1, int ind2) {
		Fruit4 temp = arr[ind1];
		arr[ind1] = arr[ind2];
		arr[ind2] = temp;
	}
	
	static void sortData(Fruit4 []arr, FruitNameComparator2 cc) {
		//cc가 객체, cc.compare >> 솔트데이터에 파라미터를 던져준게 cc , cc. 없이 컴페어만 쓰면 안되지
		//필드없어도되고 메소드만 있어도되는데 인터페이스에 구현된 추상메소드는 구현해야돼
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++)
				if (cc.compare(arr[i],arr[j])> 0)
					swap(arr, i, j);
			//if 문의 컴페어는 FruitNameComparator2 cc여기에 구현되어있는것
		}
	}
	
	private static void reverse(Fruit4[] arr) {
		for (int i = 0; i < arr.length / 2; i++)
			swap(arr, i, arr.length - 1 - i);
	}
	
	private static int binarySearch(Fruit4[] arr, Fruit4 key, Comparator<Fruit4> comp) {
        int pl = 0;
        int pr = arr.length - 1; //0에서 시작하니까! 항상 생각

        while (pl <= pr) { //시작점이 끝점까지 올때까지 반복
            int pc = (pl + pr) / 2;
            int compResult = comp.compare(arr[pc], key); //가운데랑 키를 비교
            if (compResult < 0) { //arr 가운뎃값이랑 키랑 비교해서 가운뎃값이 작으면
                pl = pc + 1; // 오른쪽 검색
            } else if (compResult > 0) { //arr 가운뎃값이 키보다 크면
                pr = pc - 1; //왼쪽 검색
            } else {
                return pc; //검색성공, 해당 인덱스 리턴
            }
        }
        return -1; // 검색실패
    }

	

	public static void main(String[] args) {

		Fruit4[] arr = {new Fruit4("사과", 200, "2023-5-8"), 
				new Fruit4("감", 500, "2023-6-8"),
				new Fruit4("대추", 200, "2023-7-8"), 
				new Fruit4("복숭아", 50, "2023-5-18"), 
				new Fruit4("수박", 880, "2023-5-28"),
				new Fruit4("산딸기", 10, "2023-9-8") };

		System.out.println("\n정렬전 객체 배열: ");
		showData("정렬전 객체", arr);

		FruitNameComparator2 cc = new FruitNameComparator2();//객체 cc를 만들어서(2줄아래)
		System.out.println("\n comparator cc 객체를 사용:: ");
		Arrays.sort(arr, cc);//솔트한테 객체를 전달해준다
		showData("Arrays.sort(arr, cc) 정렬 후", arr);

		reverse(arr);
		showData("역순 재배치 후", arr);

		sortData(arr, cc);
		showData("sortData(arr,cc) 실행후", arr);

		// 람다식은 익명클래스 + 익명 객체이다 //람다식 = 익명함수(함수에 이름이 없다:생략했다), 익명 : 컴파일러가 알아서 관리함
		Comparator<Fruit4> cc_price2 = (a, b) -> a.getPrice() - b.getPrice();
		//주말에 람다식 컴퍼레이터써서 하는걸 찾아봐 >엄청나게 간단하게 된대
		//cc_price2 = 변수, 이 변수의 타입은Comparator<Fruit4> cc_price2인터페이스,
		//컴페어()메소드를 Fruit4 객체에 대해서 구현한것이 익명클래스
		//람다식=익명클래스를 만들고 > 익명객체
		//Comparator<Fruit4>를 구현한 클래스가 익명클래스
		//cc_price2는 변수는 객체를 가져야해, 객체가 만들어지려면 클래스가 있어야돼
		//클래스를 만들려면 
		//이렇게 거꾸로 뒤집어서 생각해도됨
		Arrays.sort(arr, cc_price2); // 람다식으로 만들어진 객체를 사용
		showData("람다식 변수 cc_price2을 사용한 Arrays.sort(arr, cc) 정렬 후", arr);

		Arrays.sort(arr, (a, b) -> a.getPrice() - b.getPrice()); // Fruit4에 compareTo()가 있어도 람다식 우선 적용
		//두번쨰 변수에다 람다식을 집어넣었음
		//sort니까 compare하는게 필요, 컴퍼레이터에 만들어서 쓴 것
		showData("람다식: (a, b) -> a.getPrice() - b.getPrice()을 사용한 Arrays.sort(arr, cc) 정렬 후", arr);

		System.out.println("\n익명클래스 객체로 정렬(가격)후 객체 배열: ");
		Arrays.sort(arr, new Comparator<Fruit4>() { //뉴니까 객체가 만들어지고,
			@Override
			public int compare(Fruit4 a1, Fruit4 a2) {//함수바디는 이렇게 되어있고
				return a1.getName().compareTo(a2.getName());//이렇게 쓸거를 위의 람다식으로 간단하게 쓴 것
			}//위에는 겟프라이스인데, 여기는 겟네임가지고 비교, > 어떻게?
			//Arrays.sort(arr, (a, b) -> a.getName().compareTo(b.getName())); //람다식으로 이런식으로
		});
		System.out.println("\ncomparator 정렬(이름)후 객체 배열: ");
		showData("comparator 객체를 사용한 정렬:", arr);

		Comparator<Fruit4> cc_name = new Comparator<Fruit4>() {// 익명클래스 사용

			@Override
			public int compare(Fruit4 f1, Fruit4 f2) {
				// TODO Auto-generated method stub
				return (f1.name.compareTo(f2.name));
			}

		};
		Comparator<Fruit4> cc_price = new Comparator<Fruit4>() {

			@Override
			public int compare(Fruit4 f1, Fruit4 f2) {
				return f1.getPrice() - f2.getPrice();
			}// 익명클래스 사용

		};

		Fruit4 newFruit4 = new Fruit4("수박", 880, "2023-5-18");
		/*
		 * 교재 115 Arrays.binarySearch에 의한 검색
		 */
		int result3Index = Arrays.binarySearch(arr, newFruit4, cc_name);
		System.out.println("\nArrays.binarySearch([수박,880,2023-5-18]) 조회결과::" + result3Index);

		result3Index = binarySearch(arr, newFruit4, cc_name);
		System.out.println("\nbinarySearch([수박,880,2023-5-18]) 조회결과::" + result3Index);

		sortData(arr, cc_price);
		System.out.println("\ncomparator 정렬(가격)후 객체 배열: ");
		showData("comparator를 사용한 정렬후:", arr);

		result3Index = Arrays.binarySearch(arr, newFruit4, cc_price);
		System.out.println("\nArrays.binarySearch([수박,880,2023-5-18]) 조회결과::" + result3Index);

		result3Index = binarySearch(arr, newFruit4, cc_price);
		System.out.println("\nbinarySearch() 조회결과::" + result3Index);

	}

}
