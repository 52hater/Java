package DataStructure.Ch08;

//8장부터는 메뉴를 사용한 코딩을 함. 숙달
//실무적으로 메뉴를써서 프로그램 인터페이스를 만드는 것을 익히는 것 312~314 페이지의 내용들

public class 실습9_1정수연결리스트_test {


	//단순한 linked list에서 insert, delete하는 알고리즘을 코딩: 1단계

	import java.util.Random;
	import java.util.Scanner;

	class Node1 {
		int data;
		Node1 link;

		public Node1(int element) { //Node1 의 생성자
			data = element;
			link = null;
		}
	}
}
class LinkedList1 {
	Node1 first;

	public LinkedList1() { //LinkedList1 의 생성자
		first = null;
	}

	public int Delete(int element) // delete the element
	//딜리트는 애드랑 반대야
	//Del(40) > 40을 삭제하고 q가 60으로(?)
	//여튼 핵심은 q변수를 만들어서 p를 따라가게
	{

	}

	public void Show() { // 전체 리스트를 순서대로 출력한다.

	}

	public void Add(int element) {// 임의 값을 삽입할 때 리스트가 오름차순으로 정렬이 되도록 한다
	//element 10을 넘겨받았다
	//l이 null이었잖아 > 새로운노드를 만들고 10/null을 줬다
	//20이 왔다 > 새로운 노드를 만들어서 뒤에 붙임(오름차순으로 하랬으니까)
	//5가만들어지면 새로운노드를 앞쪽에 붙임
	//연결리스트는 내가 번호를 붙여서 뭐부터할지 생각해야해
	//첨에 하나일땐 뒤로보내든 앞으로 보내든 되는데
	//l이 10->20->40->60 이면 l.Add(50)을한다
	//10보다 크네? p 뒤로이동 20보다 크네? p 뒤로이동
	//쭉쭉 가다가 60앞에서 40-60 끊고 temp 50 들어가고
	//l.Add(70) 이면? > 코딩하라
	//맨처음 5들어가는것도 코딩
	//연결리스트에서는 값이 정렬되게 하는데 첨에 들어가든 끝에 들어가든 중간에 들어가든 하는거 구현
	
		Node1 temp = New Node1(element);
		if (first == null) {
			first = temp;
			return;
		} else { //null이 아니면 10하고 20하고 비교하는게 필요해 > 변수를 하나 써
			Node1 p = first; // 10/p 하고 p가 따라다니는
			Node1 q = null; //p가 따라다닐때 q 는  q = p; //q가 p를 따라다녀
			//q가 p를 가리키고 p는 이동하고
			while (p !=null) {
				if (elem > p.data)
					q = p;
				p = p.link;
				else {
					//insert해야한다
					temp.link = p;
					q.link = temp;
				}

			}
			//			if (elem > p.data) {
			//				p.link = temp; //크면 요거지
			//			} else {
			//				temp.link = p;
			//				first = temp;
			//			} 여기는 일반적이지 않으므로 주석처리하고

		}

	}

	public boolean Search(int data) { // 전체 리스트를 순서대로 출력한다.
		return true;
	}
}

public class 정수연결리스트 {
	enum Menu {//실무에서는 enum 을 많이 씀, 숙달
		//enum 은 클래스라고 봐도 되는데 값을 가지고있는
		Add("삽입"), Delete("삭제"), Show("인쇄"), Search("검색"), Exit("종료");

		private final String message; // 표시할 문자열

		static Menu MenuAt(int idx) { // 순서가 idx번째인 열거를 반환
			for (Menu m : Menu.values())
				//메뉴가 이넘이잖아 벨류라는 함수는 자바에서 제공하는 함수고
				//이넘의 정의된 객체들 애드딜리트쇼서치를 이야기하는 것 리스트고
				//메뉴m은 객체고 오디널도 자바에서 제공하는 함수인데 인덱스를 준다? 인덱스같으면 m을 리턴한다

				if (m.ordinal() == idx)
					return m;
			return null;
		}

		Menu(String string) { // 생성자(constructor)
			message = string;
		}

		String getMessage() { // 표시할 문자열을 반환
			return message;
		}
	}

	// --- 메뉴 선택 ---//
	static Menu SelectMenu() { //얘는 스테틱메소드
		Scanner sc = new Scanner(System.in);
		int key;
		do {
			for (Menu m : Menu.values()) {
				System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
				if ((m.ordinal() % 3) == 2 && m.ordinal() != Menu.Exit.ordinal())
					System.out.println();
			}
			System.out.print(" : ");
			key = sc.nextInt(); //입력받은 키를 받아서
		} while (key < Menu.Add.ordinal() || key > Menu.Exit.ordinal());//키는 정수라 생각하면되고 메뉴의 객체를 리턴
		return Menu.MenuAt(key); //0분준다면 0번에 해당하는 키를 리턴
	}

	public static void main(String[] args) {
		Menu menu; // 메뉴 //이넘클래스 메뉴를 사용해서 셀렉트메뉴를 사용해서 케이스문을 써서 순서대로 딱딱
		Random rand = new Random();
		System.out.println("Linked List");
		//l 이 링크드리스트
		LinkedList1 l = new LinkedList1();
		Scanner sc = new Scanner(System.in);
		int data = 0;
		System.out.println("inserted");
		l.Show();
		do {
			switch (menu = SelectMenu()) {
			case Add: // 머리노드 삽입
				//처음이든 중간이든 마지막이든 관계없이 되도록 구현
				data = rand.nextInt(20);
				//double d = Math.random();
				//data = (int) (d * 50);
				l.Add(data);//난수를 읽어서 입력하라 //l은 생성자에 의해서 LinkedList1 객체를 만들어
				//데이터멤버가 헤드만 있어
				//생성자에의해서 만들어진 객체 > 값은 null 이고 힙에 공간할당, 주소는 참조변수 l이 갖고있다 (l =null)
				//10/null > 새로운 노드
				//Add데이터로 가야지 이제 
				break;
			case Delete: // 머리 노드 삭제
				//처음이든 중간이든 마지막이든 관계없이 되도록 구현
				data = sc.nextInt();
				int num = l.Delete(data);
				System.out.println("삭제된 데이터는 " + num);
				break;
			case Show: // 꼬리 노드 삭제
				l.Show();
				break;
			case Search: // 회원 번호 검색
				int n = sc.nextInt();
				boolean result = l.Search(n);
				if (!result)
					System.out.println("검색 값 = " + n + "데이터가 없습니다.");
				else
					System.out.println("검색 값 = " + n + "데이터가 존재합니다.");
				break;
			case Exit: // 꼬리 노드 삭제
				break;
			}
		} while (menu != Menu.Exit);
	}
}
