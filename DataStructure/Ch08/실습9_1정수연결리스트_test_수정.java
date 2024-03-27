package DataStructure.Ch08;
//단순한 linked list에서 insert, delete하는 알고리즘을 코딩: 1단계
//8장부터는 메뉴를 사용한 코딩을 함. 숙달
//실무적으로 메뉴를써서 프로그램 인터페이스를 만드는 것을 익히는 것 312~314 페이지의 내용들

import java.util.Random;
import java.util.Scanner;

class Node1 { //연결리스트의 노드들의 클래스
	int data; //노드가 저장하는 데이터를 나타내는 변수
	Node1 link; //다음 노드를 가리키는 link 를 나타내는 변수
	
	//각 노드는 Node1 클래스의 객체인거지

	public Node1(int elem) {//Node1 의 생성자, 매개변수 elem 을 data 로 갖는 노드객체를 생성
		data = elem; //Node1 객체의 필드 data
		link = null; //Node1 객체의 필드 link, link 가 처음에는 다음 노드를 가리키지 않는다는 거지
		//Node1 의 객체 (각 노드들)는 link 필드를 통해 다음 노드를 가리킴
	}
}

class LinkedList1 { //연결리스트 클래스
	Node1 first; //연결리스트의 첫번째 노드를 가리키는 변수

	public LinkedList1() {//LinkedList1 의 생성자
		first = null; //연결리스트가 생성될때 첫번째 노드가 없게 초기화
	}

	public int Delete(int elem) // delete the element
	//딜리트는 애드랑 반대야
	//Del(40) > 40을 삭제하고 q가 60으로(?)
	//여튼 핵심은 q변수를 만들어서 p를 따라가게
	{
		Node1 p = first, q = null;
		q = current;
		//50을 딜리트 > if(p.data < element//(50)
		//q=p / p=p.link

		return -1;// 삭제할 대상이 없다.
	}

	public void Show() { // 전체 리스트를 순서대로 출력한다.
		Node1 p = first;
		System.out.println("*****리스트출력*****");

	}

	public void Add(int elem) // 임의 값을 삽입할 때 리스트가 오름차순으로 정렬이 되도록 한다
	{   
		/*element 10을 넘겨받았다
		l이 null이었잖아 > 새로운노드를 만들고 10/null을 줬다
		20이 왔다 > 새로운 노드를 만들어서 뒤에 붙임(오름차순으로 하랬으니까)
		5가만들어지면 새로운노드를 앞쪽에 붙임
		연결리스트는 내가 번호를 붙여서 뭐부터할지 생각해야해
		첨에 하나일땐 뒤로보내든 앞으로 보내든 되는데
		l이 10->20->40->60 이면 l.Add(50)을한다
		10보다 크네? p 뒤로이동 20보다 크네? p 뒤로이동
		쭉쭉 가다가 60앞에서 40-60 끊고 temp 50 들어가고
		l.Add(70) 이면? > 코딩하라
		맨처음 5들어가는것도 코딩
		연결리스트에서는 값이 정렬되게 하는데 첨에 들어가든 끝에 들어가든 중간에 들어가든 하는거 구현*/
		
		Node1 newNode = new Node1(elem);//파라미터 element : add 되는 값
		//Node1의 새로운 객체 newNode 
		//new Node1(elem); : elem 이라는 데이터를 가진 새로운 객체생성/공간할당
		//new Node1()로 생성한 객체를 newNode 변수에 대입
		//즉 newNode 는 elem 데이터를 가진 새로운 Node1의 객체
		if(first == null || first.data > newNode.data) {
			newNode.link = first; //first 가 null 일경우 어차피 link 도 null 이 되는것
			//first.data > newNode.data 조건일때는
			//새로운 노드의 link 를 '현재'의 first 로 설정
			first.data = newNode.data; //새로들어온놈이 작으니까 first 노드가 되는거지
			//first 가 바뀐 것
		} else { //first 노드가 있고(주의 &&) 새노드의 값이 first 노드의 값보다 크면
			Node1 p = first; //현재노드
			Node1 q = null; //이전노드
			while(p != null && p.data < elem) {
				//첫노드가 있고 첫노드의 데이터가 새노드의값보다 작으면 루프
				q = p;
				//temp2를 없애려면 비교연산자를 쓸때 temp.link.data를 하면
				//다음값의 데이터값을 비교하는거니까 temp2만들필요없지
				p = p.link;
			}
			q.link = newNode;
			newNode.link = p;
		}
		
//		Node1 temp = new Node1(element);
//		if (first == null) {
//			first = temp;
//			return;
//		} else { //null이 아니면 10하고 20하고 비교하는게 필요해 > 변수를 하나 써
//			Node1 p = first; // 10/p 하고 p가 따라다니는
//			Node1 q = null; //p가 따라다닐때 q 는  q = p; //q가 p를 따라다녀
//			//q가 p를 가리키고 p는 이동하고
//			while (p !=null) {
//				if (elem > p.data)
//					q = p;
//				p = p.link;
//				else {
//					//insert해야한다
//					temp.link = p;
//					q.link = temp;
//				}
//
//			}
//
//		}
	}

	public boolean Search(int data) { // 전체 리스트를 순서대로 출력한다.
		Node1 ptr = first;

		return false;
	}
}

public class 실습9_1정수연결리스트_test_수정 {
	enum Menu {//클래스와 같다
		//실무에서는 enum 을 많이 씀, 숙달
		//enum 은 클래스라고 봐도 되는데 값을 가지고있는
		Add("삽입"), Delete("삭제"), Show("인쇄"), Search("검색"), Exit("종료");
		//main 에서 Add를 썼다 > 하늘색 : enum의 값 // 컴퓨터내부에서는  0 1 2 이런식으로(add del show)
		//("한라봉") 이렇게 했던거 
		//Add : symbol, 0은 값
		//enum : 숫자화한다 (enable numbering)
		//숫자를 넣으면 symbol에 대한 값/반대인가?

		private final String message; // 표시할 문자열

		static Menu MenuAt(int idx) { // 순서가 idx 번째인 열거를 반환
			for (Menu m : Menu.values()) //메뉴 객체(add, del...)
				//메뉴가 이넘이잖아 벨류라는 함수는 자바에서 제공하는 함수고
				//이넘의 정의된 객체들 애드딜리트쇼서치를 이야기하는 것 리스트고
				//메뉴m은 객체고 오디널도 자바에서 제공하는 함수인데 인덱스를 준다? 인덱스같으면 m을 리턴한다
				
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
		Menu(String string) { // 생성자(constructor)
			// 생성자(constructor)가 언제 호출되는지 파악하는 것이 필요하다
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
	static Menu SelectMenu() {//얘는 스테틱메소드
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
				//m.ordinal() % 3 => 3으로 나눠 남은 나머지
				//enum 메뉴가 클래스라 생각하면 심볼객체들이 있는거지
				//다섯개를 리스트로 생각하고 확장형 포문을 이용해서
				//프린트라인 하면 안에는 스트링만 와야해
				//정수가있으면 스트링으로
				//근데 프린트포맷하면 앞이 포멧이고 뒤는 출력할 값
				//%d는정수 %s는 문자열스트링, 뒤에는 포멧(출력할양식)에다가 넣어서 출력
				//2%3 은 2?
				//한줄에 세개만 메뉴 넣으라는 코드
				//3으로 나눠서 2가되면 그다음줄로가라
				//메뉴를 포문으로 도는데 이프문을 통해서 3개를쓰고 밑으로 내리는거
				//메뉴가 늘어나면, 예를들어 8개면
				//3개쓰고 3개쓰고 두개내려가고
			}
			System.out.print(" : ");
			key = sc.nextInt();
		} while (key < Menu.Add.ordinal() || key > Menu.Exit.ordinal());
		return Menu.MenuAt(key);
	}

	public static void main(String[] args) {
		// 메뉴 //이넘클래스 메뉴를 사용해서 셀렉트메뉴를 사용해서 케이스문을 써서 순서대로 딱딱
		Menu menu; // 메뉴 참조 변수일 뿐이다
		Random rand = new Random();
		LinkedList1 l = new LinkedList1();
		Scanner sc = new Scanner(System.in);
		int data = 0;
		l.Show();
		do {
			switch (menu = SelectMenu()) {//Menu 생성자 호출 - menu 객체를 리턴한다 
			// 머리노드 삽입
			//처음이든 중간이든 마지막이든 관계없이 되도록 구현
			case Add:
				data = rand.nextInt(20);
				//double d = Math.random();
				//data = (int) (d * 50);
				l.Add(data);//난수를 읽어서 입력하라 //l은 생성자에 의해서 LinkedList1 객체를 만들어
				//데이터멤버가 헤드만 있어
				//생성자에의해서 만들어진 객체 > 값은 null 이고 힙에 공간할당, 주소는 참조변수 l이 갖고있다 (l =null)
				//10/null > 새로운 노드
				//Add데이터로 가야지 이제 
				System.out.print("삽입후 리스트: ");
				l.Show();
				break;
			case Delete: // 머리 노드 삭제
				//처음이든 중간이든 마지막이든 관계없이 되도록 구현
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
