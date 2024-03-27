package Chap8_List;
/*
 * 정수 리스트 > 객체 리스트: 2번째 실습 대상
 */
import java.util.Comparator;
import java.util.Scanner;


class SimpleObject5 {
	static final int NO = 1; // 번호를 읽어 들일까요?
	static final int NAME = 2; // 이름을 읽어 들일까요?
	//final -> 상수, 변경하지않고 계속 쓰겠다

	private String no; // 회원번호
	private String name; // 이름
	String expire;//  유효기간 필드를 추가
	//이걸 찾아서 삭제할떄 회원번호를 찾아서 삭제할거냐 이름을 찾아서 삭제할거냐
		//컴퍼레이터 (딜리트, 애드, 서치할때)
		//복습차원

	// --- 문자열 표현을 반환 ---//
	public String toString() {
		return "(" + no + ") " + name;
	}
	public SimpleObject5() {//생성자
		no = null;name = null;
	}
	// --- 데이터를 읽어 들임 ---//
	void scanData(String guide, int sw) {//sw가 3이면 11 비트 연산 >  NO, NAME을 모두 입력받는다 
		Scanner sc = new Scanner(System.in);
		System.out.println(guide + "할 데이터를 입력하세요."+ sw);

		if ((sw & NO) == NO) { //& 는 bit 연산자임 sw가 3이면 &는 비트 연산이므로 결과는 1
			System.out.print("번호: ");
			no = sc.next();
			//sw는 스캔데이터에서 가이드하고 sw를 넘겨받았네
			//저 스캔데이터를 부르는것은 메인에있다
			//이프문에서 ((sw & NO) == NO)
			//여기서 &은 비트연산 and
			//3이 1로 됨 -> 넘버에 해당이 됨 > 3이면 회원번호 입력
			//011(3) 010(2) 001(1)
		}
		if ((sw & NAME) == NAME) {//sw가 3이고 NAME과 비트 & 연산하면 결과는 2
			System.out.print("이름: ");
			name = sc.next();
			//3은 회원번호도 입력받고 이름으로도 입력받아라
			//ScanData( # , 1)회원번호만
			//ScanData( # , 2)이름만
			//ScanData( # , 3)둘 다
			//ScanData( # , 0)아무것도
		}
	}

	// --- 회원번호로 순서를 매기는 comparator ---//
	public static final Comparator<SimpleObject5> NO_ORDER = new NoOrderComparator();

	private static class NoOrderComparator implements Comparator<SimpleObject5> {
		public int compare(SimpleObject5 d1, SimpleObject5 d2) {
			return (d1.no.compareTo(d2.no) > 0) ? 1 : (d1.no.compareTo(d2.no)<0) ? -1 : 0;
		}
	}

	// --- 이름으로 순서를 매기는 comparator ---//
	public static final Comparator<SimpleObject5> NAME_ORDER = new NameOrderComparator();

	private static class NameOrderComparator implements Comparator<SimpleObject5> {
		public int compare(SimpleObject5 d1, SimpleObject5 d2) {
			return d1.name.compareTo(d2.name);
		}
	}
}
class Node2 {
	SimpleObject5 data;
	Node2 link;
	public Node2(SimpleObject5 element) {
		data = element;
		link = null;
	}
}

class LinkedList2 {
	Node2 first;
	public LinkedList2() {
		first = null;
		//first만 공간할당
				//first 참조변수를 힙에 할당하고
				//값을 넣어주라니까 넣어주고 끝
				//근데 객체 원형리스트에오면
				//
	}

	public int Delete(SimpleObject5 element, Comparator<SimpleObject5> cc)
	//전달된 element를 찾을 때 comparator 객체를 사용한다 
	{
		Node2 q, current = first;
		q = current;

		return -1;// 삭제할 대상이 없다.
	}
	public void Show() { // 전체 리스트를 순서대로 출력한다.
		Node2 p = first;
		SimpleObject5 so;

	}
	public void Add(SimpleObject5 element, Comparator<SimpleObject5> cc) 
	//임의 값을 삽입할 때 리스트가 오름차순으로 정렬이 되도록 한다
	{
		Node2 newNode = new Node2(element);
		if (first == null) //insert into empty list
		{
			first = newNode;
			return;
		}

	}
	public boolean Search(SimpleObject5 element, Comparator<SimpleObject5> cc) { 
		// 전체 리스트를 올림차순 순서대로 출력한다.
		Node2 q, current = first;
		q = current;

		return false;
	}
	void Merge(LinkedList1 b) {
		/*
		 * 연결리스트 a,b에 대하여 a = a + b
		 * merge하는 알고리즘 구현으로 in-place 방식으로 합병/이것은 새로운 노드를 만들지 않고 합병하는 알고리즘 구현
		 * 난이도 등급: 최상급
		 * 회원번호에 대하여 a = (3, 5, 7), b = (2,4,8,9)이면 a = (2,3,4,5,8,9)가 되도록 구현하는 코드
		 * 
		 *새로운노드리스트 c를 만드는게 아니라 in-place방식으로 합병
		 *a가 l, b가 l2 라고 생각하고
		 *이거는 완전히 알고리즘 코딩의 레벨로 들어감
		 *이거는 선택사항
		 */
	}
}
public class 실습9_2객체연결리스트 {

	enum Menu {
		Add( "삽입"), Delete( "삭제"), Show( "인쇄"), Search( "검색"), Merge("합병"), Exit( "종료");

		private final String message;                // 표시할 문자열

		static Menu MenuAt(int idx) {                // 순서가 idx번째인 열거를 반환
			for (Menu m : Menu.values())
				if (m.ordinal() == idx)
					return m;
			return null;
		}

		Menu(String string) {                        // 생성자(constructor)
			message = string;
		}

		String getMessage() {                        // 표시할 문자열을 반환
			return message;
		}
	}

	//--- 메뉴 선택 ---//
	static Menu SelectMenu() {
		Scanner sc = new Scanner(System.in);
		int key;
		do {
			for (Menu m : Menu.values()) {
				System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
				if ((m.ordinal() % 3) == 2 &&
						m.ordinal() != Menu.Exit.ordinal())
					System.out.println();
			}
			System.out.print(" : ");
			key = sc.nextInt();
		} while (key < Menu.Add.ordinal() ||key > Menu.Exit.ordinal());
		return Menu.MenuAt(key);
	}

	public static void main(String[] args) {
		Menu menu;                               
		LinkedList2 l = new LinkedList2();
		LinkedList2 l2 = new LinkedList2();
		Scanner sc = new Scanner(System.in);
		int count = 3; //3개의 객체 입력 개수
		SimpleObject5 data;
		do {
			switch (menu = SelectMenu()) {
			case Add :   // 머리노드 삽입                       
				data = new SimpleObject5();//객체를하나만들고
				data.scanData("입력", 3);//입력을한다 //입력이라하고 3을 넘겨줬어
				//왜? 왜 3을 전달하는가
           	 //스캔데이터를가봐 > sw가 3
				l.Add(data, SimpleObject5.NO_ORDER);//회원번호 순서로 정렬 입력
				//컴퍼레이터를 써서 해라
				//첫번째 리스트 l
				//이거는 회원번호로 비교하겠다는거지
   	         //네임오더는 이름으로 비교하겠다는 것
				break;
			case Delete :  // 머리 노드 삭제                       
				data = new SimpleObject5();
				data.scanData("삭제", SimpleObject5.NO);
				int num = l.Delete(data, SimpleObject5.NO_ORDER);//회원번호 조건 비교하여 삭제 
				System.out.println("삭제된 데이터 성공은 " + num);
				break;
			case Show :                           
				l.Show();
				break;
			case Search : // 회원 번호 검색
				data = new SimpleObject5();
				data.scanData("탐색", SimpleObject5.NO);
				boolean result = l.Search(data, SimpleObject5.NO_ORDER);//회원번호로 검색
				if (result)
					System.out.println("검색 성공 = " + result );
				else
					System.out.println("검색 실패 = " + result);
				break;
			case Merge://난이도 상
				//두개로나눠서 합치는//자신있는사람만구현
//           	 방법1 > 새로운노드를만들어서 합병 카피(l, t는 손대지않고) > 쉬워
//           	 방법2 > 새로운 노드를 만들지 않고 기존노드를 이용해서 하는 방법 > 까다로워
//           	 l -> 10-20-30
//           	 t -> 15-25-40-50-60
//           	 이런식으로 있다치고 생각해봐
//           	 삼성같은데서는 가전제품내의 프로그램이 가벼워야해서 방법2로 해보라할거야
				for (int i = 0; i < count; i++) {//3개의 객체를 연속으로 입력받아 l2 객체를 만든다 
					data = new SimpleObject5();
					data.scanData("병합", 3);
					l2.Add(data, SimpleObject5.NO_ORDER );//머지에서 두번째리스트를 만든다			
				}
				l.Merge(l2);//그걸 이용해서 l2 머지
				break;

				

			case Exit :                           // 꼬리 노드 삭제
				break;
			}
		} while (menu != Menu.Exit);
	}
}


