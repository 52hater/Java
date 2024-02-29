package Homeworks;
//Test_ch08_연결리스트와배열
//과제3: 8장 내부클래스-배열과 리스트 차이 구현
//
//리스트: < 0,5,10, 15, 20> 순차적인 정수가 순서대로 저장된 것
//
//- 배열로 리스트 표현 + insert 구현
//
//- 연결 리스트로 리스트 표현 + insert 구현

class Node3 {//노드3클래스 > 연결리스트의 각 노드를 나타냄
	int data;//정수형 데이터를 저장하는 data 필드선언
	Node3 link;
	/*참조변수 link 선언, Node 클래스 타입의 참조를 저장할 수 있는 필드를 선언
	 Node3은 이 클래스 자체잖아
	즉 link 필드는 다음 노드를 가리키는 참조를 저장,
	그 다음 노드도 Node3 클래스의 인스턴스.
	그러니까 이 link 라는 필드는 다음 노드에 대한 참조를 저장하며,
	그 다음 노드도 동일한 클래스의 인스턴스임*/
	/* Node3 클래스는 다음 노드를 가리키는 link 필드를 가지고 있음, 
	  link 필드는 다음노드에대한 참조를 저장(다음노드의 주솟값을 말하는거겠지?)*/
	public Node3(int data) {//링크와 데이터를 참조변수로 가지고있다
		/*생성자, 생성자는 매개변수(정수형의 data 필드)를 받아서 노드를 초기화 
		 생성자가 매개변수와 함께 정의? 선언?되면 해당 매개변수를 사용해서 인스턴스 Node3가 
		 생성될때 호출, 호출될 때 전달된 매개변수로 인스턴스를 초기화할 수 있음*/
		this.data = data;
		/*인스턴스가 생성될때 생성자를 호출하잖아
		그 때 생성자 내부에서 매개변수로 전달된 값(우변)을 현재 객체의 data 필드에 할당
		"생성자가 호출될 때 매개변수로 전달받은 값을 현재 객체의(this) data 필드에 할당"*/
		link = null;
		/*생성자 내부에서, link 필드(다음 노드의 참조)를 null 로 초기화
		이는 새로운 노드가 생성, 초기화될 때는 다음 노드가 없다는 것을 나타냄(당연)
		새로운 노드의 link 필드는 기존의 첫번째 노드지
		연결리스트의 끝을 나타내는 방법 중 하나
		아예 없는거니까 0으로 초기화가 아니라 null 로 초기화지

		생성자를 호출하여 새로운 Node3 객체를 생성할 때 전달된 데이터로 노드를 초기화
		이렇게 함으로써 각각의 노드는 데이터를 저장하고 다음 노드에 대한 참조를 가질 수 있게 됨*/
	}
}
class LinkedList3 {//링크드리스트3 클래스 >> 연결리스트를 가리킴
	Node3 first;//첫번쨰 노드 first 필드를 선언(책에서얘기하는 헤드)

	public LinkedList3() {
		/*연결클래스3의 생성자, 첫번째노드 first 필드를 null 로 초기화 하여
	아무것도 없는 빈 연결리스트를 만듦*/
		first = null;
	}

	void append(int data) {//리스트의 끝에 새로운 노드를 추가하는 메소드
		Node3 p = first, q = null;//p 는 현재노드, q 는 이전노드를 가리키는 포인터역할
		//새로운 노드를 추가하는 메소드니까 현재노드는 첫노드고 이전노드는 없는걸로 초기화
		//5,null 이 되겠지 데이터는5 링크는 널
		Node3 newNode = new Node3(data);
		//새로운 노드를 하나 만들어 힙에 공간할당
		if (first == null) {//첫번째노드가 null >> 리스트가 비어있으면
			first = newNode;//새로운 노드를 첫번째 노드로 지정(대입)
		} else {//리스트에 뭐가 있으면 while 문으로
			while (p != null) {//현재노드가 있으면 루프
				q = p;//현재노드 p 가 있으면 q 는 현재노드 p 의 이전노드로 초기화
				//현재노드가 이전노드가 되는거지
				//근데 이 코드는 없어도 될 것 같은데??(여쭤볼 것)
				p = p.link;//link 필드를 참조해서 다음노드로 이동
				//손가락질(포인터 p)로 첫노드부터 하나하나 순서대로 가리켜서 찾아보는 느낌인듯
				//현재노드가 없을때까지(리스트의 끝을 포인터로 찾는거지)루프
			}
			p.link = newNode;
			//현재노드가 없으면 새로운 노드를 추가(append 메소드의 궁극적 역할 완료)
		}
	}

	void showList() {//리스트의 내용을 출력
		Node3 p = first;//현재노드 p 를 첫번쨰 노드로 초기화
		while (p != null) {
			System.out.println(p.data + " ");
			p = p.link;
		}
	}

	//	void showList() {
	//		Node3 p = first;
	//		for (Node p = first; p != null; /*증감식에 뭐가 들어가야?*/) {
	//			System.out.println(p.data + " ");
	//		}
	//	} //for 문을 쓴다면 증감식을 어떤식으로 써야하는지 찾아보기

	void insert(int data) {//연결리스트의 특정한 위치에 노드를 삽입하는 메소드(삽입위치)
		Node3 newNode = new Node3(data);//새로운노드 생성 공간할당
		Node3 p = first, q = null;//포인터초기화

		if (p == null) {//현재노드無 >>리스트에 아무것도 없으면
			first = newNode;//새로운 노드를 첫노드로 대입
			return;//메소드종료(반환값없으면 void 메소드에서도 return 가능(종료하고 돌아감)) 
		}
		while (p != null && p.data < data) {
			//현재노드 p 가 있고 p 의 데이터값이 뭐보다 작으면??루프
			//(뒤의 데이터는 뭐지)ll.insert(3); ll.insert(7); (이거네)

			q = p;//현재노드가 이전노드로
			p = p.link;//포인터는 다음노드로 이동
		}

		if (q == null) {//이전노드가 없으면(첫번쨰 노드만 있으면)
			newNode.link = first;
			//새로운노드의 다음노드를 첫번째 노드로 지정>새로운 노드가 q 가 되면서 맨앞으로 가겠지
			first = newNode;//맨앞으로 갔으니 새로운 노드가 첫번째 노드가 되지
		} else {//이전노드가 있으면
			newNode.link = p;//새로운 노드의 다음노드를 현재노드로 지정
			q.link = newNode;//이전노드의 다음노드를 새로운노드로 지정(뒤에 붙인다는거겠지?)
		}
		/*중간이나 끝에 새로운 노드를 추가할때는 앞 노드들의 연결이 끊어지면 안되니까
		 뒤에다 새로운 노드를 붙이는 것 같은데 노드가 하나만 있을때는 왜 굳이 새로운 노드를
		 앞에다 생성하는건지??
		 */

	}

	public class Test_ch08_연결리스트와배열 {
		static int getList(int[]data) {//이 메소드는 배열의 일정한 규칙에 따라 데이터를 채움
			int count = 0;
			int mid = data.length/2;
			for (int i = 0; i <= mid; i++) {
				data[i] = i * 5; count++;
			}
			return count;
		}
		static void showList(int[]data) {//이 메소드는 배열의 내용을 출력
			System.out.println();
			for (int i=0; i < data.length; i++)
				System.out.print(" " + i + " ");
			System.out.println();
			for (int i = 0; i < data.length; i++) {
				if (data[i] < 10)
					System.out.print(" ");
				System.out.print(data[i]+ " ");
			}
		}
		static int insertList(int[] data, int count, int x) {//배열에 요소 삽입
			if (count >= data.length) {
				return count;
			}
			int indx = 0;
			while (indx < count && data[indx] < x) {
				indx++;
			}
			for(int i = count; i > indx; i--) {
				data[i] = data[i - 1];
			}
			data[indx] = x;
			count++;
			return count;

		}

		public static void main(String[] args) {//배열로 리스트를 만들고, 해당 리스트 출력, 요소를 삽입, 배열의 변경내용 출력

			int[] list = new int[10];//리스트가 현재 10개짜리 배열로 되어있어 1~9
			int count = 0;//카운트용도 : 

			System.out.println("배열로 리스트::");
			count = getList(list);
			showList(list);
			count = insertList(list, count, 3);
			showList(list);
			count = insertList(list, count, 7);
			showList(list);

			LinkedList3 ll = new LinkedList3();//링크리스트(ll)
			//LinkedList3를 사용하여 연결 리스트를 만들고, 해당 리스트를 출력하고, 요소를 삽입하여 변경 내용을 출력합니다.

			ll.append(5);
			ll.append(10);
			ll.append(15);
			ll.append(20);
			ll.append(25);

			ll.showList();
			ll.insert(3);
			ll.showList();
			ll.insert(7);//링크의 참조변수가 바뀌는 것
			//양방향연결리스트 로직공부도
			ll.showList();
		}
	}

}
