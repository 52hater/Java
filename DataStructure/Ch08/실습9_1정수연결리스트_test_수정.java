package DataStructure.Ch08;
//단순한 linked list에서 insert, delete하는 알고리즘을 코딩: 1단계
//8장부터는 메뉴를 사용한 코딩을 함. 숙달
//실무적으로 메뉴를써서 프로그램 인터페이스를 만드는 것을 익히는 것 312~314 페이지의 내용들

import java.util.Random;
import java.util.Scanner;

class Node1 {
	int data;
	Node1 link;

	public Node1(int element) {//Node1 의 생성자
		data = element;
		link = null;
	}
}

class LinkedList1 {
	Node1 first;

	public LinkedList1() {//LinkedList1 의 생성자
		first = null;
	}

	public int Delete(int element) // delete the element
	//딜리트는 애드랑 반대야
	//Del(40) > 40을 삭제하고 q가 60으로(?)
	//여튼 핵심은 q변수를 만들어서 p를 따라가게
	{
		Node1 q, current = first;
		q = current;

		return -1;// 삭제할 대상이 없다.
	}

	public void Show() { // 전체 리스트를 순서대로 출력한다.
		Node1 p = first;
		System.out.println("*****리스트출력*****");

	}

	public void Add(int element) // 임의 값을 삽입할 때 리스트가 오름차순으로 정렬이 되도록 한다
	{
		Node1 newNode = new Node1(element);

	}

	public boolean Search(int data) { // 전체 리스트를 순서대로 출력한다.
		Node1 ptr = first;

		return false;
	}
}

public class 실습9_1정수연결리스트_test_수정 {
	enum Menu {//클래스와 같다
		Add("삽입"), Delete("삭제"), Show("인쇄"), Search("검색"), Exit("종료");
		//main 에서 Add를 썼다 > 하늘색 : enum의 값 // 컴퓨터내부에서는  0 1 2 이런식으로(add del show)
		//("한라봉") 이렇게 했던거 
		//Add : symbol, 0은 값
		//enum : 숫자화한다 (enable numbering)
		//숫자를 넣으면 symbol에 대한 값/반대인가?

		private final String message; // 표시할 문자열

		static Menu MenuAt(int idx) { // 순서가 idx 번째인 열거를 반환
			for (Menu m : Menu.values()) //메뉴 객체(add, del...)
				// 인덱스에 0을주면 메뉴객체 메뉴는클래스 >
				//클래스명. (자바라이브러리가 제공하는 메소드) > enum 자바라이브러리에서 제공하는 메소드
				//심볼이 여러개니까 리스트, 그중에 한놈을 하는게 Menu m
				if (m.ordinal() == idx) //ordinal 은 지수 > add 를하면 0 / 0이면 idx 와 같으니까 리턴 m;
					return m;//리턴
			return null;
		}
		//"Add" 상수가 정의될 때 Menu("삽입") 생성자(아래)가 호출되어 message 필드가 "삽입"으로 초기화
		//생성자는 각 상수가 정의될 때 호출되며, 해당 상수의 message 필드를 초기화하는 역할
		//enum 상수가 언제 정의되는가를 찾아 보아야 한다 
		Menu(String string) { // 생성자(constructor)가 언제 호출되는지 파악하는 것이 필요하다
			//생성자호출은 Menu m : Menu.values() 여기에서 호출됨
			//어려움 > 심볼객체들이 만들어질때(ex)Add가 만들어질때) 생성자가 호출이 되어서 ("삽입")이 전달되는 것
			//클래스이름(함수) > 생성자함수
			message = string;//메세지에 스트링을 넣어주네 //자바에있는게 아니라 내가만든필드
			//String 이름을 message 라고한거지 교수님이
			System.out.println("\nMenu 생성자 호출:: " + string);
		}

		String getMessage() { // 표시할 문자열을 반환
			return message;
		}
	}

	// --- 메뉴 선택 ---//
	static Menu SelectMenu() {
		Scanner sc = new Scanner(System.in);
		int key;
		do {
			for (Menu m : Menu.values()) {//Menu 생성자 호출됨 > 이걸 이해를 해야함
				//메뉴생성자호출을해서 메뉴벨류스이거는 심볼이 다섯개니까 다섯개객체를 만들어서
				//생성자호출이 없는데 왜 생성자호출이 된건지 파악, 
				//딱 하면 객체가 만들어지고 생성자호출이 돼서 string변수에 삽입, 삭제 등의 값들이 전달돼서 ~~~
				//여기는 생성자호출이 없는데 생기는걸 익숙해져라 이걸통해 배우고
				//바꿔가면서 호출이 되네? 왜 그렇지 왜 다섯번이나 호출이되는거지 > 를 파악
				System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
				//m->다섯개객체가있고 지수(), "삽입"을해서 던져주네
				//m 은 Menu m > Menu.values는 add,del...리스트를 갖고있따, m이라는변수가 add, del등 객체를 갖고있다
				if ((m.ordinal() % 3) == 2 && m.ordinal() != Menu.Exit.ordinal())
					System.out.println();
			}
			System.out.print(" : ");
			key = sc.nextInt();
		} while (key < Menu.Add.ordinal() || key > Menu.Exit.ordinal());
		return Menu.MenuAt(key);
	}

	public static void main(String[] args) {
		Menu menu; // 메뉴 참조 변수일 뿐이다 
		Random rand = new Random();
		LinkedList1 l = new LinkedList1();
		Scanner sc = new Scanner(System.in);
		int data = 0;
		l.Show();
		do {
			switch (menu = SelectMenu()) {//Menu 생성자 호출 - menu 객체를 리턴한다 
			case Add: 
				data = rand.nextInt(20);
				l.Add(data);
				System.out.print("삽입후 리스트: ");
				l.Show();
				break;
			case Delete: 
				data = sc.nextInt();
				int num = l.Delete(data);
				System.out.println("삭제된 데이터는 " + num);
				break;
			case Show: 
				l.Show();
				break;
			case Search: // 회원 번호 검색
				int n = sc.nextInt();
				boolean result = l.Search(n);
				if (!result)
					System.out.println("검색 값 = " + n + " 데이터가 없습니다.");
				else
					System.out.println("검색 값 = " + n + " 데이터가 존재합니다.");
				break;
			case Exit: 
				break;
			}
		} while (menu != Menu.Exit);
	}
}
